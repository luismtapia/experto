package has;

import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author luis
 */
public class Archivo {
    
    RandomAccessFile archivo_maestro = null;
    RandomAccessFile archivo_indice = null;
    StringBuffer buffer = null;
    
    int llave=0,marca=0,identificador_de_bloque=0;
    boolean existe_llave=false;
    String mensajes;

    public void crear_archivo() throws IOException {
        Conocimiento todo_conocimiento=new Conocimiento();
        todo_conocimiento.crear();
    }
    
    public long encuentra_llave_indice(int llave) throws FileNotFoundException, IOException{
        int llave_actual=-1;
        long posicion=-1;
        archivo_indice = new RandomAccessFile("archivos/indice", "rw");
        
        do {
            llave_actual=archivo_indice.readInt();
            posicion=archivo_indice.readLong();//guarda direccion logica de ubicacion de la llave en el archivo maestro
            if (llave_actual==llave) {
                //posicion=archivo_indice.getFilePointer()-8;//regresa a donde encontro la llave
                llave_actual=0;
                mensajes="LLAVE ENCONTRADA";
                existe_llave=true;
            }else{
                llave_actual=-1;
            }
            if (archivo_indice.getFilePointer()==archivo_indice.length()) {//condicion para salir del ciclo si no encuentra la llave buscada
                llave_actual=0;
                mensajes="LLAVE NO SE ENCUENTRA EN EL ARCHIVO";
                existe_llave=false;
            }
        } while (llave_actual==-1);
        
        return posicion;
    }
    
    public long encuentra_primer_llave(String bloque) throws FileNotFoundException, IOException{//del bloque 0-99 o 100-199
        long posicion=0;
        archivo_indice = new RandomAccessFile("archivos/indice", "rw");
        int tamaño_registro=12,numero_registros=0;
        switch(bloque){
            case "sintomas"://desde el inicio sintomas
                archivo_indice.seek(0);
                archivo_indice.readInt();
                posicion=archivo_indice.readLong(); //tiene la posicion en el archivo maestro de dicha llave
                identificador_de_bloque=0;
                break;
            case "causas primarias"://posicion inicial del siguiente grupo de registros en el indice primarias
                //mientras llave/100 sea=1
                numero_registros=8;//SE REFIERE ANTERIOR
                archivo_indice.seek(tamaño_registro*numero_registros);
                archivo_indice.readInt();
                posicion=archivo_indice.readLong();
                identificador_de_bloque=1;
                break;
            case "causas secundarias":
                //posicion inicial del siguiente grupo de registros en el indice 
                //mientras llave/100 sea=3
                numero_registros=8+11;//SE REFIERE ANTERIOR
                archivo_indice.seek(tamaño_registro*numero_registros);
                archivo_indice.readInt();
                posicion=archivo_indice.readLong();
                identificador_de_bloque=2;
                break;
            case "farmacos":
                //posicion inicial del siguiente grupo de registros en el indice 
                //mientras llave/100 sea=4
                numero_registros=8+11+11;//SE REFIERE ANTERIOR
                archivo_indice.seek(tamaño_registro*numero_registros);
                System.out.println(tamaño_registro*numero_registros);
                archivo_indice.readInt();
                posicion=archivo_indice.readLong();
                System.out.println("lee: "+archivo_indice.getFilePointer()+" tiene : "+posicion);
                identificador_de_bloque=3;
                break;
            case "contraindicaciones":
                //posicion inicial del siguiente grupo de registros en el indice seundarias
                //mientras llave/100 sea=2
                numero_registros=8+11+11+9;//SE REFIERE ANTERIOR
                archivo_indice.seek(tamaño_registro*numero_registros);
                archivo_indice.readInt();
                posicion=archivo_indice.readLong();
                System.out.println("lee: "+archivo_indice.getFilePointer()+" tiene : "+posicion);
                identificador_de_bloque=4;
                break;
            case "clasificacion":
                //posicion inicial del siguiente grupo de registros en el indice seundarias
                //mientras llave/100 sea=2
                numero_registros=8+11+11+9+14;//SE REFIERE ANTERIOR
                archivo_indice.seek(tamaño_registro*numero_registros);
                archivo_indice.readInt();
                posicion=archivo_indice.readLong();
                System.out.println("lee: "+archivo_indice.getFilePointer()+" tiene : "+posicion);
                identificador_de_bloque=5;
                break;
                default:
        }
        archivo_indice.close();
        return posicion;
    }
    
    public long encuentra_llave_vacia(long comienzo_registro) throws FileNotFoundException, IOException{
        long posicion=0;
        int marquita,n=0,bloque,bloque1=0,bloque2=0;
        boolean vacia=false;
        
        archivo_maestro = new RandomAccessFile("archivos/maestro", "rw");
        archivo_maestro.seek(comienzo_registro);
        bloque1=archivo_maestro.readInt();
        archivo_maestro.seek(comienzo_registro);
        
        do {
            bloque2=archivo_maestro.readInt();
            marquita=archivo_maestro.readInt();
            archivo_maestro.seek(archivo_maestro.getFilePointer()+100);
            bloque=bloque2-bloque1;
            if (marquita==0) {
                n=1;
                posicion=archivo_maestro.getFilePointer()-108;
            }
            if(bloque<99)
                vacia=true;
        } while (n==0);
        if (n==0 && vacia) {
            JOptionPane.showMessageDialog(null, "YA NO HAY DESBORDAMIENTO DE MEMORIA PARA MAS REGISTROS");
        }
        
        return posicion;
    }
    
    public void insertar_registro(String bloque) throws FileNotFoundException, IOException {
        String nombre;
        long comienzo_registro,registro_vacio;
        
            //se abre el archivo_maestro para lectura y escritura
            archivo_maestro = new RandomAccessFile("archivos/maestro", "rw");
            
            comienzo_registro=encuentra_primer_llave(bloque);
            registro_vacio=encuentra_llave_vacia(comienzo_registro);
            archivo_maestro.seek(registro_vacio);
            llave=archivo_maestro.readInt();
            archivo_maestro.seek(registro_vacio);
            //cambio todos los datos
            archivo_maestro.writeInt(llave);//lave
            archivo_maestro.writeInt(1);
            
            nombre=JOptionPane.showInputDialog("LLAVE: "+llave+" INTRODUZCA EL NOMBRE DE "+bloque+": ");
            buffer=new StringBuffer(nombre);
            buffer.setLength(50);
            archivo_maestro.writeChars(buffer.toString());
            mensajes="Registro Actualizado";
        
            try {
                if (archivo_maestro != null) {
                    archivo_maestro.close();
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        
    }
    
    public void modificar_registro() {
        long posicion_llave;
        String nombre,cadena="";
        try {
            archivo_maestro = new RandomAccessFile("archivos/maestro", "rw");
            archivo_indice = new RandomAccessFile("archivos/indice", "rw");
            
            //modifica
            llave = Integer.parseInt(JOptionPane.showInputDialog("INGRESE LA LLAVE: "));
            posicion_llave=encuentra_llave_indice(llave);
            archivo_maestro.seek(posicion_llave);
            System.out.print("posicion llave: "+posicion_llave);
            System.out.println("modi_posicion_file: "+archivo_maestro.getFilePointer());
            
            //LECTURA DEL ARCHIVO
            int llave_recuperada=archivo_maestro.readInt();
            int marca_recuperada=archivo_maestro.readInt();
            char nomb[]=new char[50],temp;
            for (int c = 0; c < nomb.length; c++) {
                temp=archivo_maestro.readChar();
                cadena+=temp;
            }
            
            archivo_maestro.seek(posicion_llave);
            System.out.println("posicion_file a modificar: "+archivo_maestro.getFilePointer());
            //ESCRITURA DEL ARCHIVO
            archivo_maestro.writeInt(llave_recuperada);
            archivo_maestro.writeInt(marca_recuperada);
            nombre=JOptionPane.showInputDialog("INTRODUZCA EL NOMBRE : ",""+cadena);
            buffer=new StringBuffer(nombre);
            buffer.setLength(50);
            archivo_maestro.writeChars(buffer.toString());
            mensajes="REGISTRO ACTUALIZADO CORRECTAMENTE";
            System.out.println("despues de modificar: "+archivo_maestro.getFilePointer());
            System.out.println(mensajes);
            
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                if (archivo_maestro != null) {
                    archivo_maestro.close();
                    archivo_indice.close();
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }
    
    public void eliminar_registro() {
        long posicion_llave;
        try {
            archivo_maestro = new RandomAccessFile("archivos/maestro", "rw");
            archivo_indice = new RandomAccessFile("archivos/indice", "rw");
            
            llave = Integer.parseInt(JOptionPane.showInputDialog("INGRESE LA LLAVE: "));
            posicion_llave=encuentra_llave_indice(llave);
            archivo_maestro.seek(posicion_llave);
            
            if (existe_llave) {
                archivo_maestro.readInt();
                archivo_maestro.writeInt(0);
                buffer=new StringBuffer(" ");
                buffer.setLength(50);
                archivo_maestro.writeChars(buffer.toString());
                mensajes="REGISTRO ELIMINADO CORRECTAMENTE";
            }else{
                JOptionPane.showMessageDialog(null, "NO EXISTE LLAVE");
                mensajes="NO EXISTE LLAVE";
            }
            
            
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                if (archivo_maestro != null) {
                    archivo_maestro.close();
                    archivo_indice.close();
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }
    
    public String consulta_bloque(String bloque) throws FileNotFoundException, IOException{
        long ap_actual, ap_final;
        String lectura="",cadena="";
        archivo_maestro = new RandomAccessFile("archivos/maestro", "r");
        
        long posicion_primer_llave=encuentra_primer_llave(bloque);
        archivo_maestro.seek(posicion_primer_llave);
        
        //identificar_llave
        while ((ap_actual=archivo_maestro.getFilePointer())!=(ap_final=archivo_maestro.length())) {            
            llave=archivo_maestro.readInt();
            marca=archivo_maestro.readInt();
            char nombre[]=new char[50],temp;
            for (int c = 0; c < nombre.length; c++) {
                temp=archivo_maestro.readChar();
                cadena+=temp;
            }
            
            int nuevo_identificador=llave/100;//tomar el entero
            if(identificador_de_bloque!=nuevo_identificador){
                archivo_maestro.seek(archivo_maestro.length());
            }else{
                lectura+=llave+" : "+marca+" : "+cadena+"\n";
                cadena="";
                mensajes="LECTURA CORRECTA";
            }
        }//fin de while
        archivo_maestro.close();
        return lectura;
    }
    
    //CONSULTAR TODOS LOS BLOQUES DE REGISTROS
    public String consultar_archivo_maestro_secuencial() throws FileNotFoundException, IOException {
        long ap_actual, ap_final;
        String lectura="",cadena="";
        archivo_maestro = new RandomAccessFile("archivos/maestro", "r");
        
        while ((ap_actual=archivo_maestro.getFilePointer())!=(ap_final=archivo_maestro.length())) {            
            //System.out.print(archivo_maestro.getFilePointer()+":");
            llave=archivo_maestro.readInt();
            //System.out.print(llave+" ");
            //System.out.print(archivo_maestro.getFilePointer()+":");
            marca=archivo_maestro.readInt();
            //System.out.print(marca+" ");
            //System.out.print(archivo_maestro.getFilePointer()+":");
            char nombre[]=new char[50],temp;
            for (int c = 0; c < nombre.length; c++) {
                temp=archivo_maestro.readChar();
                cadena+=temp;
            }
            
            lectura+=llave+" : "+marca+" : "+cadena+"\n";
            cadena="";
        }//fin de while
        archivo_maestro.close();
        return lectura;
    }
    
    public String consultar_archivo_indice_secuencial() throws FileNotFoundException, IOException {
        long ap_actual, ap_final, direccion;
        String lectura="";
        archivo_indice = new RandomAccessFile("archivos/indice", "r");
        
        while ((ap_actual=archivo_indice.getFilePointer())!=(ap_final=archivo_indice.length())) {            
            llave=archivo_indice.readInt();
            System.out.print("llave: "+llave+" ");
            direccion=archivo_indice.readLong();
            System.out.print("dir: "+direccion+" ");
            System.out.println("pos: "+archivo_indice.getFilePointer());
            
            lectura+=llave+" : "+direccion+"\n";
        }//fin de while
        archivo_indice.close();
        return lectura;
    }
    
    public void leer_aleatorio_indice()throws IOException{
        int n,dl;
        long primer_registro,desplaza;
        
        archivo_indice = new RandomAccessFile("archivos/indice", "rw");
        Scanner entrada = new Scanner(System.in);
        archivo_indice.readInt();
        archivo_indice.readInt();
        char nomb[]=new char[50];
        for (int c = 0; c < nomb.length; c++)
            nomb[c]=archivo_indice.readChar();
        primer_registro=archivo_indice.getFilePointer();
        do{
            System.out.println("Introduce la direccion logica del registro: ");
            dl=entrada.nextInt();
            desplaza=(dl-1)*primer_registro;
            archivo_indice.seek(desplaza);
            llave=archivo_indice.readInt();
            System.out.println("Los datos del registro son:     ");
            System.out.println(llave);
            char nombre[] = new char[50],temp;
            for (int c = 0; c < nombre.length; c++) {
                temp=archivo_indice.readChar();
                nombre[c]=temp;
            }
            new String(nombre).replace("\0", "");
            System.out.println(nombre);
            System.out.println("Otro libro?: SI=1 NO=2");
            n=entrada.nextInt();
        }while(n==1);
        archivo_indice.close();
    }
    
    public String leer_aleatorio_maestro()throws IOException{
        long posicion_llave;
        String lectura="",cadena="";
        archivo_maestro = new RandomAccessFile("archivos/maestro", "rw");
        
        llave=Integer.parseInt(JOptionPane.showInputDialog("INTRODUCE LLAVE:"));
        posicion_llave=encuentra_llave_indice(llave);
        archivo_maestro.seek(posicion_llave);
            
        llave=archivo_maestro.readInt();
        marca=archivo_maestro.readInt();
        char nombre[]=new char[50],temp;
            for (int c = 0; c < nombre.length; c++) {
                temp=archivo_maestro.readChar();
                //nombre[c]=temp;
                cadena+=temp;
            }
            int nuevo_identificador=llave/100;//tomar el entero
            if(existe_llave && identificador_de_bloque==nuevo_identificador){
                lectura+=llave+" : "+marca+" : "+cadena+"\n";
                cadena="";
                mensajes="LECTURA CORRECTA";
                
            }else
                if(existe_llave){
                    archivo_maestro.seek(archivo_maestro.length());
                    mensajes="LECTURA INCORRECTA NO ESTA EN ESTE BLOQUE";
                }else{
                    archivo_maestro.seek(archivo_maestro.length());
                    mensajes="LLAVE NO SE ENCUENTRA";
                }
            
        archivo_indice.close();
        return lectura;
    }
    
    public String nivel_presion() throws IOException{
        int nivel_sistolico,nivel_diastolico;
        String lectura="",cadena="";
        long posicio;
        llave=500; //PORQUE ES DEL BLOQUE DE CLASIFICACION (500)
        nivel_sistolico=Integer.parseInt(JOptionPane.showInputDialog("INGRESE EL NIVEL DE PRESIÓN SISTÓLICA LEIDO:"));
        nivel_diastolico=Integer.parseInt(JOptionPane.showInputDialog("INGRESE EL NIVEL DE PRESIÓN DIASTÓLICA LEIDO:"));
        posicio=encuentra_llave_indice(llave);
        System.out.println("pocicion: "+posicio);
        if(nivel_sistolico<120 && nivel_diastolico<80){
            System.out.println("pointer: "+archivo_maestro.getFilePointer());
            archivo_maestro.seek(posicio);
            System.out.println("pointer: "+archivo_maestro.getFilePointer());
            llave=archivo_maestro.readInt();
            marca=archivo_maestro.readInt();
            char nombre[]=new char[50],temp;
            for (int c = 0; c < nombre.length; c++) {
                temp=archivo_maestro.readChar();
                cadena+=temp;
            }
        }else
            if (nivel_sistolico>=120 && nivel_sistolico<=129 && nivel_diastolico>=80 && nivel_diastolico<=84) {
                archivo_maestro.seek(posicio+108);//recorre un registro cada suma de 108
                llave=archivo_maestro.readInt();
                marca=archivo_maestro.readInt();
                char nombre[]=new char[50],temp;
                for (int c = 0; c < nombre.length; c++) {
                    temp=archivo_maestro.readChar();
                    cadena+=temp;
                }
            }else
                if (nivel_sistolico>=120 && nivel_sistolico<=129 && nivel_diastolico>=80 && nivel_diastolico<=84) {
                    archivo_maestro.seek(posicio+108+108);//recorre un registro cada suma de 108
                    llave=archivo_maestro.readInt();
                    marca=archivo_maestro.readInt();
                    char nombre[]=new char[50],temp;
                    for (int c = 0; c < nombre.length; c++) {
                        temp=archivo_maestro.readChar();
                        cadena+=temp;
                    }
                }
        
        lectura+=llave+" : "+marca+" : "+cadena+" es la clasificacion correcta\n";
        cadena="";
        if(!lectura.equals(""))
            mensajes="MOSTRANDO CLASIFICACIÓN ";
        return lectura;
    }
}