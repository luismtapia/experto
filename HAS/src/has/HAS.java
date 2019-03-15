/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package has;

import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author luis
 */
public class HAS {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        Scanner entrada= new Scanner(System.in);
        
        System.out.println("\t\tMenu principal");
        System.out.println("*********************************************************");
        System.out.println("*\t\t\t\t\t\t\t*\n*\t1.- Sintomas\t\t\t\t\t*\n*\t2.- Tratamientos\t\t\t\t*\n*\t3.- Causas Primarias\t\t\t\t*\n*\t4.- Causas Secundarias\t\t\t\t*\n*\t5.- Contraindicaciones\t\t\t\t*");
        System.out.println("*\t\t\t\t\t\t\t*\n*********************************************************");
        System.out.print("=============>\t");
        int menu=entrada.nextInt();
        System.out.println("\n\n\n\n\n\n");
        System.out.println("*********************************************************");
        System.out.println("\n\n\n\n\n\n");
        switch(menu){
            case 1:
                Sintomas sintoma=new Sintomas();
                System.out.println("\tElija la operacion a realizar");
                System.out.println("*********************************************************");
                System.out.println("\n\t1.- INSERTAR\n\t2.- MOSTRAR");
                System.out.println("*\t\t\t\t\t\t\t*\n*********************************************************");
                System.out.print("=============>\t");
                int operacion=entrada.nextInt();
                if (operacion==1) {
                    sintoma.insertar();
                }else
                    if (operacion==2) {
                        System.out.println("Lectura del archivo maestro:\n");
                        sintoma.leer_sintomas();
                    }
                break;
            default: 
        }
        System.out.println("*********************************************************");
        
        
        
        
        
        Tratamientos tratamiento = new Tratamientos();
        /*tratamiento.insertar();
        tratamiento.buscar();
        tratamiento.getLlave();*/
        
        Contraindicaciones contraindicacion = new Contraindicaciones();
//        contraindicacion.buscar(farmaco);
    }
    
}
