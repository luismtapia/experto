/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package has;

/**
 *
 * @author luis
 */
public class HAS {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Sintomas sintoma=new Sintomas();
        
        //sintoma.insertar();
        System.out.println("Lectura del archivo maestro:\n");
        sintoma.leer_sintomas();
        
        Tratamientos tratamiento = new Tratamientos();
        tratamiento.insertar();
        tratamiento.buscar();
        tratamiento.getLlave();
        
        Contraindicaciones contraindicacion = new Contraindicaciones();
        contraindicacion.buscar(farmaco);
    }
    
}
