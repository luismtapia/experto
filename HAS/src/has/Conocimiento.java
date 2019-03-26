package has;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 *
 * @author luis
 */
public class Conocimiento {
    RandomAccessFile archivo_maestro = null;
    RandomAccessFile archivo_indice = null;
    StringBuffer buffer = null;
    int llave=1;
    
    public void crear() throws IOException{
        sintomas();
        causas_primarias();
        causas_secundarias();
        farmacos();
        contraindicaciones();
        clasificacion();
    }
    
    private int sintomas() throws IOException{
        try {
            //se abre el archivo para lectura y escritura
            archivo_maestro = new RandomAccessFile("archivos/maestro", "rw");
            archivo_indice = new RandomAccessFile("archivos/indice", "rw");
            
            //INDICE
            archivo_indice.writeInt(llave);
            archivo_indice.writeLong(archivo_maestro.getFilePointer());
            //MAESTRO
            archivo_maestro.writeInt(llave);
            archivo_maestro.writeInt(1);
            buffer=new StringBuffer("Acufenos");
            buffer.setLength(50);
            archivo_maestro.writeChars(buffer.toString());
            llave++;
            
            //INDICE
            archivo_indice.writeInt(llave);
            archivo_indice.writeLong(archivo_maestro.getFilePointer());
            //MAESTRO
            archivo_maestro.writeInt(llave);
            archivo_maestro.writeInt(1);
            buffer=new StringBuffer("Fosfenos");
            buffer.setLength(50);
            archivo_maestro.writeChars(buffer.toString());
            llave++;
            
            //INDICE
            archivo_indice.writeInt(llave);
            archivo_indice.writeLong(archivo_maestro.getFilePointer());
            //MAESTRO
            archivo_maestro.writeInt(llave);
            archivo_maestro.writeInt(1);
            buffer=new StringBuffer("Disnea");
            buffer.setLength(50);
            archivo_maestro.writeChars(buffer.toString());
            llave++;
            
            //INDICE
            archivo_indice.writeInt(llave);
            archivo_indice.writeLong(archivo_maestro.getFilePointer());
            //MAESTRO
            archivo_maestro.writeInt(llave);
            archivo_maestro.writeInt(1);
            buffer=new StringBuffer("Cefalea_pulsatil");
            buffer.setLength(50);
            archivo_maestro.writeChars(buffer.toString());
            llave++;
            
            //INDICE
            archivo_indice.writeInt(llave);
            archivo_indice.writeLong(archivo_maestro.getFilePointer());
            //MAESTRO
            archivo_maestro.writeInt(llave);
            archivo_maestro.writeInt(1);
            buffer=new StringBuffer("Angina");
            buffer.setLength(50);
            archivo_maestro.writeChars(buffer.toString());
            llave++;
            
            //INDICE
            archivo_indice.writeInt(llave);
            archivo_indice.writeLong(archivo_maestro.getFilePointer());
            //MAESTRO
            archivo_maestro.writeInt(llave);
            archivo_maestro.writeInt(1);
            buffer=new StringBuffer("Estado_nauseoso");
            buffer.setLength(50);
            archivo_maestro.writeChars(buffer.toString());
            llave++;
            
            //INDICE
            archivo_indice.writeInt(llave);
            archivo_indice.writeLong(archivo_maestro.getFilePointer());
            //MAESTRO
            archivo_maestro.writeInt(llave);
            archivo_maestro.writeInt(0);
            buffer=new StringBuffer(" ");
            buffer.setLength(50);
            archivo_maestro.writeChars(buffer.toString());
            llave++;
            
            //INDICE
            archivo_indice.writeInt(llave);
            archivo_indice.writeLong(archivo_maestro.getFilePointer());
            //MAESTRO
            archivo_maestro.writeInt(llave);
            archivo_maestro.writeInt(0);
            buffer=new StringBuffer(" ");
            buffer.setLength(50);
            archivo_maestro.writeChars(buffer.toString());
            llave++;
            
            System.out.println("registro actualizado");
            
            
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } finally {
            if (archivo_maestro != null) {
                archivo_maestro.close();
                archivo_indice.close();
            }
        }
        return llave;
    }
    
    private void causas_primarias() throws IOException{
        try {
            //se abre el archivo para lectura y escritura
            archivo_maestro = new RandomAccessFile("archivos/maestro", "rw");
            archivo_indice = new RandomAccessFile("archivos/indice", "rw");
            archivo_indice.seek(archivo_indice.length());
            archivo_maestro.seek(archivo_maestro.length());
            llave=100;
            
            //INDICE
            archivo_indice.writeInt(llave);
            archivo_indice.writeLong(archivo_maestro.getFilePointer());
            //MAESTRO
            archivo_maestro.writeInt(llave);
            archivo_maestro.writeInt(1);
            buffer=new StringBuffer("Antecedentes_hereditarios_de_HAS");
            buffer.setLength(50);
            archivo_maestro.writeChars(buffer.toString());
            llave++;
            
            //INDICE
            archivo_indice.writeInt(llave);
            archivo_indice.writeLong(archivo_maestro.getFilePointer());
            //MAESTRO
            archivo_maestro.writeInt(llave);
            archivo_maestro.writeInt(1);
            buffer=new StringBuffer("Sobrepeso_y_obesidad");
            buffer.setLength(50);
            archivo_maestro.writeChars(buffer.toString());
            llave++;
            
            //INDICE
            archivo_indice.writeInt(llave);
            archivo_indice.writeLong(archivo_maestro.getFilePointer());
            //MAESTRO
            archivo_maestro.writeInt(llave);
            archivo_maestro.writeInt(1);
            buffer=new StringBuffer("Sedentarismo");
            buffer.setLength(50);
            archivo_maestro.writeChars(buffer.toString());
            llave++;
            
            //INDICE
            archivo_indice.writeInt(llave);
            archivo_indice.writeLong(archivo_maestro.getFilePointer());
            //MAESTRO
            archivo_maestro.writeInt(llave);
            archivo_maestro.writeInt(1);
            buffer=new StringBuffer("Estres_mental");
            buffer.setLength(50);
            archivo_maestro.writeChars(buffer.toString());
            llave++;
            
            //INDICE
            archivo_indice.writeInt(llave);
            archivo_indice.writeLong(archivo_maestro.getFilePointer());
            //MAESTRO
            archivo_maestro.writeInt(llave);
            archivo_maestro.writeInt(1);
            buffer=new StringBuffer("Habitos_alimenticios");
            buffer.setLength(50);
            archivo_maestro.writeChars(buffer.toString());
            llave++;
            
            //INDICE
            archivo_indice.writeInt(llave);
            archivo_indice.writeLong(archivo_maestro.getFilePointer());
            //MAESTRO
            archivo_maestro.writeInt(llave);
            archivo_maestro.writeInt(1);
            buffer=new StringBuffer("Uso_de_Medicamentos");
            buffer.setLength(50);
            archivo_maestro.writeChars(buffer.toString());
            llave++;
            
            //INDICE
            archivo_indice.writeInt(llave);
            archivo_indice.writeLong(archivo_maestro.getFilePointer());
            //MAESTRO
            archivo_maestro.writeInt(llave);
            archivo_maestro.writeInt(1);
            buffer=new StringBuffer("Diabetes_mellitus");
            buffer.setLength(50);
            archivo_maestro.writeChars(buffer.toString());
            llave++;
            
            //INDICE
            archivo_indice.writeInt(llave);
            archivo_indice.writeLong(archivo_maestro.getFilePointer());
            //MAESTRO
            archivo_maestro.writeInt(llave);
            archivo_maestro.writeInt(1);
            buffer=new StringBuffer("Sindrome cardiometabolico");
            buffer.setLength(50);
            archivo_maestro.writeChars(buffer.toString());
            llave++;
            
            //INDICE
            archivo_indice.writeInt(llave);
            archivo_indice.writeLong(archivo_maestro.getFilePointer());
            //MAESTRO
            archivo_maestro.writeInt(llave);
            archivo_maestro.writeInt(0);
            buffer=new StringBuffer(" ");
            buffer.setLength(50);
            archivo_maestro.writeChars(buffer.toString());
            llave++;
            
            //INDICE
            archivo_indice.writeInt(llave);
            archivo_indice.writeLong(archivo_maestro.getFilePointer());
            //MAESTRO
            archivo_maestro.writeInt(llave);
            archivo_maestro.writeInt(0);
            buffer=new StringBuffer(" ");
            buffer.setLength(50);
            archivo_maestro.writeChars(buffer.toString());
            llave++;
            
            //INDICE
            archivo_indice.writeInt(llave);
            archivo_indice.writeLong(archivo_maestro.getFilePointer());
            //MAESTRO
            archivo_maestro.writeInt(llave);
            archivo_maestro.writeInt(0);
            buffer=new StringBuffer(" ");
            buffer.setLength(50);
            archivo_maestro.writeChars(buffer.toString());
            llave++;
            
            System.out.println("registro actualizado");
            
            
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } finally {
            if (archivo_maestro != null) {
                archivo_maestro.close();
                archivo_indice.close();
            }
        }
    }
    
    private void causas_secundarias() throws IOException{
        try {
            //se abre el archivo para lectura y escritura
            archivo_maestro = new RandomAccessFile("archivos/maestro", "rw");
            archivo_indice = new RandomAccessFile("archivos/indice", "rw");
            archivo_indice.seek(archivo_indice.length());
            archivo_maestro.seek(archivo_maestro.length());
            llave=200;
            
            //INDICE
            archivo_indice.writeInt(llave);
            archivo_indice.writeLong(archivo_maestro.getFilePointer());
            //MAESTRO
            archivo_maestro.writeInt(llave);
            archivo_maestro.writeInt(1);
            buffer=new StringBuffer("Apnea_del_sueño");
            buffer.setLength(50);
            archivo_maestro.writeChars(buffer.toString());
            llave++;
            
            //INDICE
            archivo_indice.writeInt(llave);
            archivo_indice.writeLong(archivo_maestro.getFilePointer());
            //MAESTRO
            archivo_maestro.writeInt(llave);
            archivo_maestro.writeInt(1);
            buffer=new StringBuffer("Insuficiencia_renal_cronica");
            buffer.setLength(50);
            archivo_maestro.writeChars(buffer.toString());
            llave++;
            
            //INDICE
            archivo_indice.writeInt(llave);
            archivo_indice.writeLong(archivo_maestro.getFilePointer());
            //MAESTRO
            archivo_maestro.writeInt(llave);
            archivo_maestro.writeInt(1);
            buffer=new StringBuffer("Aldosteronismo_primario");
            buffer.setLength(50);
            archivo_maestro.writeChars(buffer.toString());
            llave++;
            
            //INDICE
            archivo_indice.writeInt(llave);
            archivo_indice.writeLong(archivo_maestro.getFilePointer());
            //MAESTRO
            archivo_maestro.writeInt(llave);
            archivo_maestro.writeInt(1);
            buffer=new StringBuffer("Enfermedad_renovascular");
            buffer.setLength(50);
            archivo_maestro.writeChars(buffer.toString());
            llave++;
            
            //INDICE
            archivo_indice.writeInt(llave);
            archivo_indice.writeLong(archivo_maestro.getFilePointer());
            //MAESTRO
            archivo_maestro.writeInt(llave);
            archivo_maestro.writeInt(1);
            buffer=new StringBuffer("Feocromocitoma");
            buffer.setLength(50);
            archivo_maestro.writeChars(buffer.toString());
            llave++;
            
            //INDICE
            archivo_indice.writeInt(llave);
            archivo_indice.writeLong(archivo_maestro.getFilePointer());
            //MAESTRO
            archivo_maestro.writeInt(llave);
            archivo_maestro.writeInt(1);
            buffer=new StringBuffer("Sindrome_de_Cushing");
            buffer.setLength(50);
            archivo_maestro.writeChars(buffer.toString());
            llave++;
            
            //INDICE
            archivo_indice.writeInt(llave);
            archivo_indice.writeLong(archivo_maestro.getFilePointer());
            //MAESTRO
            archivo_maestro.writeInt(llave);
            archivo_maestro.writeInt(1);
            buffer=new StringBuffer("Tiroides o paratiroides");
            buffer.setLength(50);
            archivo_maestro.writeChars(buffer.toString());
            llave++;
            
            //INDICE
            archivo_indice.writeInt(llave);
            archivo_indice.writeLong(archivo_maestro.getFilePointer());
            //MAESTRO
            archivo_maestro.writeInt(llave);
            archivo_maestro.writeInt(1);
            buffer=new StringBuffer("Coartacion_de_la_aorta");
            buffer.setLength(50);
            archivo_maestro.writeChars(buffer.toString());
            llave++;
            
            //INDICE
            archivo_indice.writeInt(llave);
            archivo_indice.writeLong(archivo_maestro.getFilePointer());
            //MAESTRO
            archivo_maestro.writeInt(llave);
            archivo_maestro.writeInt(0);
            buffer=new StringBuffer(" ");
            buffer.setLength(50);
            archivo_maestro.writeChars(buffer.toString());
            llave++;
            
            //INDICE
            archivo_indice.writeInt(llave);
            archivo_indice.writeLong(archivo_maestro.getFilePointer());
            //MAESTRO
            archivo_maestro.writeInt(llave);
            archivo_maestro.writeInt(0);
            buffer=new StringBuffer(" ");
            buffer.setLength(50);
            archivo_maestro.writeChars(buffer.toString());
            llave++;
            
            //INDICE
            archivo_indice.writeInt(llave);
            archivo_indice.writeLong(archivo_maestro.getFilePointer());
            //MAESTRO
            archivo_maestro.writeInt(llave);
            archivo_maestro.writeInt(0);
            buffer=new StringBuffer(" ");
            buffer.setLength(50);
            archivo_maestro.writeChars(buffer.toString());
            llave++;
            
            System.out.println("registro actualizado");
            
            
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } finally {
            if (archivo_maestro != null) {
                archivo_maestro.close();
                archivo_indice.close();
            }
        }
    }
    
    private void farmacos() throws IOException{
        try {
            //se abre el archivo para lectura y escritura
            archivo_maestro = new RandomAccessFile("archivos/maestro", "rw");
            archivo_indice = new RandomAccessFile("archivos/indice", "rw");
            archivo_indice.seek(archivo_indice.length());
            archivo_maestro.seek(archivo_maestro.length());
            llave=300;
            
            //INDICE
            archivo_indice.writeInt(llave);
            archivo_indice.writeLong(archivo_maestro.getFilePointer());
            //MAESTRO
            archivo_maestro.writeInt(llave);
            archivo_maestro.writeInt(1);
            buffer=new StringBuffer("Diuréticos tiacidicos");
            buffer.setLength(50);
            archivo_maestro.writeChars(buffer.toString());
            llave++;
            
            //INDICE
            archivo_indice.writeInt(llave);
            archivo_indice.writeLong(archivo_maestro.getFilePointer());
            //MAESTRO
            archivo_maestro.writeInt(llave);
            archivo_maestro.writeInt(1);
            buffer=new StringBuffer("Betabloquedores");
            buffer.setLength(50);
            archivo_maestro.writeChars(buffer.toString());
            llave++;
            
            //INDICE
            archivo_indice.writeInt(llave);
            archivo_indice.writeLong(archivo_maestro.getFilePointer());
            //MAESTRO
            archivo_maestro.writeInt(llave);
            archivo_maestro.writeInt(1);
            buffer=new StringBuffer("Calcioantagonistas (dihidropirinas)");
            buffer.setLength(50);
            archivo_maestro.writeChars(buffer.toString());
            llave++;
            
            //INDICE
            archivo_indice.writeInt(llave);
            archivo_indice.writeLong(archivo_maestro.getFilePointer());
            //MAESTRO
            archivo_maestro.writeInt(llave);
            archivo_maestro.writeInt(1);
            buffer=new StringBuffer("Calcioantagonistas (verapamil)");
            buffer.setLength(50);
            archivo_maestro.writeChars(buffer.toString());
            llave++;
            
            //INDICE
            archivo_indice.writeInt(llave);
            archivo_indice.writeLong(archivo_maestro.getFilePointer());
            //MAESTRO
            archivo_maestro.writeInt(llave);
            archivo_maestro.writeInt(1);
            buffer=new StringBuffer("Inibidores de ECA");
            buffer.setLength(50);
            archivo_maestro.writeChars(buffer.toString());
            llave++;
            
            //INDICE
            archivo_indice.writeInt(llave);
            archivo_indice.writeLong(archivo_maestro.getFilePointer());
            //MAESTRO
            archivo_maestro.writeInt(llave);
            archivo_maestro.writeInt(1);
            buffer=new StringBuffer("Antagonistas de los receptores de angiotensina");
            buffer.setLength(50);
            archivo_maestro.writeChars(buffer.toString());
            llave++;
            
            //INDICE
            archivo_indice.writeInt(llave);
            archivo_indice.writeLong(archivo_maestro.getFilePointer());
            //MAESTRO
            archivo_maestro.writeInt(llave);
            archivo_maestro.writeInt(1);
            buffer=new StringBuffer("Antagonistas de aldosterona");
            buffer.setLength(50);
            archivo_maestro.writeChars(buffer.toString());
            llave++;
            
            //INDICE
            archivo_indice.writeInt(llave);
            archivo_indice.writeLong(archivo_maestro.getFilePointer());
            //MAESTRO
            archivo_maestro.writeInt(llave);
            archivo_maestro.writeInt(0);
            buffer=new StringBuffer(" ");
            buffer.setLength(50);
            archivo_maestro.writeChars(buffer.toString());
            llave++;
            
            //INDICE
            archivo_indice.writeInt(llave);
            archivo_indice.writeLong(archivo_maestro.getFilePointer());
            //MAESTRO
            archivo_maestro.writeInt(llave);
            archivo_maestro.writeInt(0);
            buffer=new StringBuffer(" ");
            buffer.setLength(50);
            archivo_maestro.writeChars(buffer.toString());
            llave++;
            
            System.out.println("registros farmacos creados");
            
            
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } finally {
            if (archivo_maestro != null) {
                archivo_maestro.close();
                archivo_indice.close();
            }
        }
    }
    
    private void contraindicaciones() throws IOException{
        try {
            //se abre el archivo para lectura y escritura
            archivo_maestro = new RandomAccessFile("archivos/maestro", "rw");
            archivo_indice = new RandomAccessFile("archivos/indice", "rw");
            archivo_indice.seek(archivo_indice.length());
            archivo_maestro.seek(archivo_maestro.length());
            llave=400;
            
            //INDICE
            archivo_indice.writeInt(llave);
            archivo_indice.writeLong(archivo_maestro.getFilePointer());
            //MAESTRO
            archivo_maestro.writeInt(llave);
            archivo_maestro.writeInt(1);
            buffer=new StringBuffer("Gota");
            buffer.setLength(50);
            archivo_maestro.writeChars(buffer.toString());
            llave++;
            
            //INDICE
            archivo_indice.writeInt(llave);
            archivo_indice.writeLong(archivo_maestro.getFilePointer());
            //MAESTRO
            archivo_maestro.writeInt(llave);
            archivo_maestro.writeInt(1);
            buffer=new StringBuffer("Asma");
            buffer.setLength(50);
            archivo_maestro.writeChars(buffer.toString());
            llave++;
            
            //INDICE
            archivo_indice.writeInt(llave);
            archivo_indice.writeLong(archivo_maestro.getFilePointer());
            //MAESTRO
            archivo_maestro.writeInt(llave);
            archivo_maestro.writeInt(1);
            buffer=new StringBuffer("Bloqueo A-V de segundo y tercer grado");
            buffer.setLength(50);
            archivo_maestro.writeChars(buffer.toString());
            llave++;
            
            //INDICE
            archivo_indice.writeInt(llave);
            archivo_indice.writeLong(archivo_maestro.getFilePointer());
            //MAESTRO
            archivo_maestro.writeInt(llave);
            archivo_maestro.writeInt(1);
            buffer=new StringBuffer("Insuficiencia cardiaca");
            buffer.setLength(50);
            archivo_maestro.writeChars(buffer.toString());
            llave++;
            
            //INDICE
            archivo_indice.writeInt(llave);
            archivo_indice.writeLong(archivo_maestro.getFilePointer());
            //MAESTRO
            archivo_maestro.writeInt(llave);
            archivo_maestro.writeInt(1);
            buffer=new StringBuffer("Embarazo");
            buffer.setLength(50);
            archivo_maestro.writeChars(buffer.toString());
            llave++;
            
            //INDICE
            archivo_indice.writeInt(llave);
            archivo_indice.writeLong(archivo_maestro.getFilePointer());
            //MAESTRO
            archivo_maestro.writeInt(llave);
            archivo_maestro.writeInt(1);
            buffer=new StringBuffer("Edema angioneurótico");
            buffer.setLength(50);
            archivo_maestro.writeChars(buffer.toString());
            llave++;
            
            //INDICE
            archivo_indice.writeInt(llave);
            archivo_indice.writeLong(archivo_maestro.getFilePointer());
            //MAESTRO
            archivo_maestro.writeInt(llave);
            archivo_maestro.writeInt(1);
            buffer=new StringBuffer("Hipercaliemia");
            buffer.setLength(50);
            archivo_maestro.writeChars(buffer.toString());
            llave++;
            
            //INDICE
            archivo_indice.writeInt(llave);
            archivo_indice.writeLong(archivo_maestro.getFilePointer());
            //MAESTRO
            archivo_maestro.writeInt(llave);
            archivo_maestro.writeInt(1);
            buffer=new StringBuffer("Estenosis bilateral de la arteria renal");
            buffer.setLength(50);
            archivo_maestro.writeChars(buffer.toString());
            llave++;
            
            //INDICE
            archivo_indice.writeInt(llave);
            archivo_indice.writeLong(archivo_maestro.getFilePointer());
            //MAESTRO
            archivo_maestro.writeInt(llave);
            archivo_maestro.writeInt(1);
            buffer=new StringBuffer("Estenosis de la arteria renal");
            buffer.setLength(50);
            archivo_maestro.writeChars(buffer.toString());
            llave++;
            
            //INDICE
            archivo_indice.writeInt(llave);
            archivo_indice.writeLong(archivo_maestro.getFilePointer());
            //MAESTRO
            archivo_maestro.writeInt(llave);
            archivo_maestro.writeInt(1);
            buffer=new StringBuffer("Insuficiencia renal");
            buffer.setLength(50);
            archivo_maestro.writeChars(buffer.toString());
            llave++;
            
            //INDICE
            archivo_indice.writeInt(llave);
            archivo_indice.writeLong(archivo_maestro.getFilePointer());
            //MAESTRO
            archivo_maestro.writeInt(llave);
            archivo_maestro.writeInt(0);
            buffer=new StringBuffer(" ");
            buffer.setLength(50);
            archivo_maestro.writeChars(buffer.toString());
            llave++;
            
            //INDICE
            archivo_indice.writeInt(llave);
            archivo_indice.writeLong(archivo_maestro.getFilePointer());
            //MAESTRO
            archivo_maestro.writeInt(llave);
            archivo_maestro.writeInt(0);
            buffer=new StringBuffer(" ");
            buffer.setLength(50);
            archivo_maestro.writeChars(buffer.toString());
            llave++;
            
            //INDICE
            archivo_indice.writeInt(llave);
            archivo_indice.writeLong(archivo_maestro.getFilePointer());
            //MAESTRO
            archivo_maestro.writeInt(llave);
            archivo_maestro.writeInt(0);
            buffer=new StringBuffer(" ");
            buffer.setLength(50);
            archivo_maestro.writeChars(buffer.toString());
            llave++;
            
            //INDICE
            archivo_indice.writeInt(llave);
            archivo_indice.writeLong(archivo_maestro.getFilePointer());
            //MAESTRO
            archivo_maestro.writeInt(llave);
            archivo_maestro.writeInt(0);
            buffer=new StringBuffer(" ");
            buffer.setLength(50);
            archivo_maestro.writeChars(buffer.toString());
            llave++;
            
            System.out.println("registro actualizado");
            
            
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } finally {
            if (archivo_maestro != null) {
                archivo_maestro.close();
                archivo_indice.close();
            }
        }
    }
    
    private void clasificacion() throws IOException{
        try {
            //se abre el archivo para lectura y escritura
            archivo_maestro = new RandomAccessFile("archivos/maestro", "rw");
            archivo_indice = new RandomAccessFile("archivos/indice", "rw");
            archivo_indice.seek(archivo_indice.length());
            archivo_maestro.seek(archivo_maestro.length());
            llave=500;
            
            //INDICE
            archivo_indice.writeInt(llave);
            archivo_indice.writeLong(archivo_maestro.getFilePointer());
            //MAESTRO
            archivo_maestro.writeInt(llave);
            archivo_maestro.writeInt(1);
            buffer=new StringBuffer("Óptima");
            buffer.setLength(50);
            archivo_maestro.writeChars(buffer.toString());
            llave++;
            
            //INDICE
            archivo_indice.writeInt(llave);
            archivo_indice.writeLong(archivo_maestro.getFilePointer());
            //MAESTRO
            archivo_maestro.writeInt(llave);
            archivo_maestro.writeInt(1);
            buffer=new StringBuffer("Normal");
            buffer.setLength(50);
            archivo_maestro.writeChars(buffer.toString());
            llave++;
            
            //INDICE
            archivo_indice.writeInt(llave);
            archivo_indice.writeLong(archivo_maestro.getFilePointer());
            //MAESTRO
            archivo_maestro.writeInt(llave);
            archivo_maestro.writeInt(1);
            buffer=new StringBuffer("Normal Alta");
            buffer.setLength(50);
            archivo_maestro.writeChars(buffer.toString());
            llave++;
            
            //INDICE
            archivo_indice.writeInt(llave);
            archivo_indice.writeLong(archivo_maestro.getFilePointer());
            //MAESTRO
            archivo_maestro.writeInt(llave);
            archivo_maestro.writeInt(1);
            buffer=new StringBuffer("Hipertensión grado 1");
            buffer.setLength(50);
            archivo_maestro.writeChars(buffer.toString());
            llave++;
            
            //INDICE
            archivo_indice.writeInt(llave);
            archivo_indice.writeLong(archivo_maestro.getFilePointer());
            //MAESTRO
            archivo_maestro.writeInt(llave);
            archivo_maestro.writeInt(1);
            buffer=new StringBuffer("Hipertension grado 2");
            buffer.setLength(50);
            archivo_maestro.writeChars(buffer.toString());
            llave++;
            
            //INDICE
            archivo_indice.writeInt(llave);
            archivo_indice.writeLong(archivo_maestro.getFilePointer());
            //MAESTRO
            archivo_maestro.writeInt(llave);
            archivo_maestro.writeInt(1);
            buffer=new StringBuffer("Hipertensión grado 3");
            buffer.setLength(50);
            archivo_maestro.writeChars(buffer.toString());
            llave++;
            
            //INDICE
            archivo_indice.writeInt(llave);
            archivo_indice.writeLong(archivo_maestro.getFilePointer());
            //MAESTRO
            archivo_maestro.writeInt(llave);
            archivo_maestro.writeInt(1);
            buffer=new StringBuffer("Hipertensi{on sistólica aislada");
            buffer.setLength(50);
            archivo_maestro.writeChars(buffer.toString());
            llave++;
            
            //INDICE
            archivo_indice.writeInt(llave);
            archivo_indice.writeLong(archivo_maestro.getFilePointer());
            //MAESTRO
            archivo_maestro.writeInt(llave);
            archivo_maestro.writeInt(0);
            buffer=new StringBuffer(" ");
            buffer.setLength(50);
            archivo_maestro.writeChars(buffer.toString());
            llave++;
            
            //INDICE
            archivo_indice.writeInt(llave);
            archivo_indice.writeLong(archivo_maestro.getFilePointer());
            //MAESTRO
            archivo_maestro.writeInt(llave);
            archivo_maestro.writeInt(0);
            buffer=new StringBuffer(" ");
            buffer.setLength(50);
            archivo_maestro.writeChars(buffer.toString());
            llave++;
            
            System.out.println("registro actualizado");
            
            
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } finally {
            if (archivo_maestro != null) {
                archivo_maestro.close();
                archivo_indice.close();
            }
        }
    }
    
}
