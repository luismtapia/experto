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
        //tratamientos();
        //contraindicaciones();
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
    
    private void tratamientos() throws IOException{
        
    }
    
    private void contraindicaciones() throws IOException{
        
    }
}
