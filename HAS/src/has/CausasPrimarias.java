/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package has;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author Erick Yael Ortiz
 */
public class CausasPrimarias {
   int llave,n;
    String nombre;
    
    public void crear() throws FileNotFoundException, IOException {
        StringBuffer buffer = null;
        System.out.println("creando Archivo maestro");
        RandomAccessFile archivo=new RandomAccessFile("CausasPrimarias", "rw");
        llave=1;
        //Scanner entrada = new Scanner(System.in);
        do {
            //System.out.print("Llave: ");
            //llave=entrada.nextInt();
            archivo.writeInt(llave);
            //System.out.println("CausaPrimaria");
            nombre=JOptionPane.showInputDialog("Nombre de la causa: ");
            //nombre=entrada.next();
            buffer=new StringBuffer(nombre);
            buffer.setLength(25);
            archivo.writeChars(buffer.toString());
            n=Integer.parseInt(JOptionPane.showInputDialog("Desea ingresar otra Causa? : si= 1, NO=0"));
            //System.out.println("Desea ingresar otra Causa? : si= 1, NO=0");
            //n=entrada.nextInt();
            llave++;
        } while (n==1);
        archivo.close();
    }
    
    public void insertar() throws FileNotFoundException, IOException {
        StringBuffer buffer = null;
        System.out.println("creando Archivo maestro");
        RandomAccessFile archivo=new RandomAccessFile("CausasPrimarias", "rw");
        Scanner entrada = new Scanner(System.in);
        do {            
            System.out.print("Llave: ");
            llave=entrada.nextInt();
            archivo.writeInt(llave);
            System.out.println("CausaPrimaria");
            nombre=entrada.next();
            buffer=new StringBuffer(nombre);
            buffer.setLength(25);
            archivo.writeChars(buffer.toString());
            System.out.println("Desea ingresar otra Causa? : si= 1, NO=0");
            n=entrada.nextInt();
        } while (n==1);
        archivo.close();
    }
    
    public void leer_causas_primarias() throws FileNotFoundException, IOException{
        long ap_actual, ap_final;
        
        
        RandomAccessFile leer_archivo= new RandomAccessFile("CausasPrimarias", "r");
        while ((ap_actual=leer_archivo.getFilePointer())!=(ap_final=leer_archivo.length())) {            
            llave=leer_archivo.readInt();
            System.out.println(llave);
            char nombre[]=new char[25],temp;
            for (int c = 0; c < nombre.length; c++) {
                temp=leer_archivo.readChar();
                nombre[c]=temp;
            }
            new String(nombre).replace("\0", "");
            System.out.println(nombre);
            
        }//fin de while
        leer_archivo.close();
    }    
}