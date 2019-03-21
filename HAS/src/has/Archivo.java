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
    
    Scanner sc = new Scanner(System.in);
    RandomAccessFile archivo_maestro = null;
    RandomAccessFile archivo_indice = null;
    StringBuffer buffer = null;
    
    int llave=0,marca=0;

    public void crear_archivo() throws IOException {
        Conocimiento todo_conocimiento=new Conocimiento();
        todo_conocimiento.crear();
    }
    
    public int encuentra_ultima_llave(int bloque){
        llave=1;
        return 1;
    }
    
    public long encuentra_primer_llave(String bloque) throws FileNotFoundException, IOException{
        long posicion=0;
        archivo_indice = new RandomAccessFile("archivos/indice", "r");
            
        switch(bloque){
            case "sintomas":
                //que_registro=0; //desde el inicio sintomas
                archivo_indice.seek(0);
                archivo_indice.readInt();
                posicion=archivo_indice.readLong(); //tiene la posicion en el archivo maestro de dicha llave
                break;
            case "causas primarias":
                //que_registro=8; //posicion inicial del siguiente grupo de registros en el indice primarias
                archivo_indice.seek(64);
                archivo_indice.readInt();
                posicion=archivo_indice.readLong();
                break;
                default:
        }
        archivo_indice.close();
        return posicion;
    }
    
    public long encuentra_llave_vacia(long comienzo_registro) throws FileNotFoundException, IOException{
        long posicion=0;
        int marquita,n=0;
        
        archivo_maestro = new RandomAccessFile("archivos/maestro", "r");
        archivo_maestro.seek(comienzo_registro);
        
        do {
            archivo_maestro.readInt();
            marquita=archivo_maestro.readInt();
            archivo_maestro.seek(archivo_maestro.getFilePointer()+100);
            if (marquita==0) {
                n=1;
                posicion=archivo_maestro.getFilePointer()-108;
            }
        } while (n==0);
        if (n==0) {
            JOptionPane.showMessageDialog(null, "YA NO HAY DESBORDAMIENTO DE MEMORIA PARA MAS REGISTROS");
        }
        
        return posicion;
    }
    
    public void insertar_registro(String bloque) {
        String nombre;
        long comienzo_registro,registro_vacio,final_archivo;
        
        try {
            //se abre el archivo_maestro para lectura y escritura
            archivo_maestro = new RandomAccessFile("archivos/maestro", "rw");
            
            comienzo_registro=encuentra_primer_llave(bloque);
            registro_vacio=encuentra_llave_vacia(comienzo_registro);
            archivo_maestro.seek(registro_vacio); //se mueve al final del archivo
            //cambio marca
            long b= archivo_maestro.getFilePointer();
            System.out.print("posicion "+b+" --------------");
            int aa=archivo_maestro.readInt();
            System.out.println("leyo: "+aa);
            long a= archivo_maestro.getFilePointer();
            System.out.println(a);
            archivo_maestro.write(0);
            long c= archivo_maestro.getFilePointer();
            System.out.println(c);
            nombre=JOptionPane.showInputDialog("INTRODUZCA EL NOMBRE DE "+bloque+": ");
            buffer=new StringBuffer(nombre);
            buffer.setLength(50);
            archivo_maestro.writeChars(buffer.toString());
            System.out.println("registro actualizado");
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                if (archivo_maestro != null) {
                    archivo_maestro.close();
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }
    
    public void modificar_registro() {
        int numero;
        try {
            //se abre el archivo_maestro para lectura y escritura
            archivo_maestro = new RandomAccessFile("archivos/maestro", "rw");
            archivo_indice = new RandomAccessFile("archivos/indice", "rw");
            
            //modifica
            /*
            mostrarFichero(); //muestra el contenido original del archivo_maestro
            System.out.print("Introduce un número entero para añadir al final del archivo_maestro: ");
            numero = sc.nextInt(); //se lee el entero a añadir en el archivo_maestro
            archivo_maestro.seek(archivo_maestro.length()); //nos situamos al final del archivo_maestro
            archivo_maestro.writeInt(numero);       //se escribe el entero
            mostrarFichero();//muestra el contenido del archivo_maestro después de añadir el número
*/
            
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                if (archivo_maestro != null) {
                    archivo_maestro.close();
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }
    
    public void eliminar_registro() {
        int numero;
        try {
            //se abre el archivo_maestro para lectura y escritura
            archivo_maestro = new RandomAccessFile("archivos/maestro", "rw");
            archivo_indice = new RandomAccessFile("archivos/indice", "rw");
            
            /*
            mostrarFichero(); //muestra el contenido original del archivo_maestro
            System.out.print("Introduce un número entero para añadir al final del archivo_maestro: ");
            numero = sc.nextInt(); //se lee el entero a añadir en el archivo_maestro
            archivo_maestro.seek(archivo_maestro.length()); //nos situamos al final del archivo_maestro
            archivo_maestro.writeInt(numero);       //se escribe el entero
            mostrarFichero();//muestra el contenido del archivo_maestro después de añadir el número
*/
            
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                if (archivo_maestro != null) {
                    archivo_maestro.close();
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }
    
    public void consultar_archivo_maestro_secuencial() throws FileNotFoundException, IOException {
        long ap_actual, ap_final;
        archivo_maestro = new RandomAccessFile("archivos/maestro", "r");
            
        
        while ((ap_actual=archivo_maestro.getFilePointer())!=(ap_final=archivo_maestro.length())) {            
            llave=archivo_maestro.readInt();
            System.out.print(llave+" ");
            marca=archivo_maestro.readInt();
            System.out.print(marca+" ");
            char nombre[]=new char[50],temp;
            for (int c = 0; c < nombre.length; c++) {
                temp=archivo_maestro.readChar();
                nombre[c]=temp;
            }
            new String(nombre).replace("\0", "");
            System.out.print(nombre);
            System.out.println("");
            
        }//fin de while
        archivo_maestro.close();
    }
    
    public void consultar_archivo_indice_secuencial() throws FileNotFoundException, IOException {
        long ap_actual, ap_final, direccion;
        archivo_indice = new RandomAccessFile("archivos/indice", "r");
        
        while ((ap_actual=archivo_indice.getFilePointer())!=(ap_final=archivo_indice.length())) {            
            llave=archivo_indice.readInt();
            System.out.print(llave+" ");
            direccion=archivo_indice.readLong();
            System.out.print(direccion+" ");
            
            System.out.println("");
            
        }//fin de while
        archivo_indice.close();
    }

}