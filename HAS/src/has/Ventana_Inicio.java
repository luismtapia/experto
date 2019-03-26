/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package has;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author luis
 */
public class Ventana_Inicio extends javax.swing.JFrame {

    Archivo manejo_archivo=new Archivo();
     String lectura;
    public Ventana_Inicio() {
        initComponents();
        setTitle("INICIO");
        ind.setVisible(false);
        lla.setVisible(false);
        tod.setVisible(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btn_sintomas = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        salida = new javax.swing.JTextArea();
        jButton5 = new javax.swing.JButton();
        mensajes = new javax.swing.JLabel();
        lla = new javax.swing.JButton();
        tod = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        ind = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        btn_sintomas.setText("SINTOMAS");
        btn_sintomas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_sintomasActionPerformed(evt);
            }
        });
        getContentPane().add(btn_sintomas);
        btn_sintomas.setBounds(10, 101, 180, 23);

        jButton2.setText("CAUSAS PRIMARIAS");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(10, 142, 180, 23);

        jButton3.setText("CAUSAS SECUNDARIAS");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(10, 183, 180, 23);

        jButton4.setText("MOSTRAR TODO");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4);
        jButton4.setBounds(550, 10, 150, 23);

        jButton1.setText("CREAR ARCHIVOS");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(10, 11, 141, 23);

        salida.setColumns(20);
        salida.setRows(5);
        jScrollPane1.setViewportView(salida);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(260, 70, 480, 489);

        jButton5.setText("BUSCAR POR LLAVE");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton5);
        jButton5.setBounds(360, 10, 160, 23);

        mensajes.setText("MENSAJES");
        getContentPane().add(mensajes);
        mensajes.setBounds(10, 570, 780, 14);

        lla.setBackground(new java.awt.Color(204, 204, 204));
        lla.setText("BUSCAR POR LLAVE");
        getContentPane().add(lla);
        lla.setBounds(360, 40, 160, 23);

        tod.setBackground(new java.awt.Color(204, 204, 204));
        tod.setText("MOSTRAR TODO");
        tod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                todActionPerformed(evt);
            }
        });
        getContentPane().add(tod);
        tod.setBounds(550, 40, 150, 23);

        jLabel1.setText("MAESTRO");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(280, 10, 70, 14);

        ind.setText("INDICE");
        getContentPane().add(ind);
        ind.setBounds(280, 40, 60, 14);

        jButton6.setText("TRATAMIENTO");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton6);
        jButton6.setBounds(10, 220, 180, 23);

        jButton7.setText("CONTRAINDICACIONES");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton7);
        jButton7.setBounds(10, 260, 180, 23);

        jButton8.setText("CLASIFICACIÓN DEL HAS");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton8);
        jButton8.setBounds(10, 300, 180, 23);

        setBounds(0, 0, 816, 639);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_sintomasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_sintomasActionPerformed
        Ventana_Sintomas ventanasintomas= new Ventana_Sintomas();
        ventanasintomas.setVisible(true);
    }//GEN-LAST:event_btn_sintomasActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        Ventana_Causas_Primarias ventanacausasprimarias= new Ventana_Causas_Primarias();
        ventanacausasprimarias.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        try {
            manejo_archivo.crear_archivo();
            mensajes.setText("ARCHIVO CREADO");
        } catch (IOException ex) {
            Logger.getLogger(Ventana_Inicio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        try {
            lectura = manejo_archivo.consultar_archivo_maestro_secuencial();
            salida.setText(lectura);
            mensajes.setText("LECTURA");
        } catch (IOException ex) {
            Logger.getLogger(Ventana_Sintomas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        Ventana_Causas_Secundarias ventanasecundarias= new Ventana_Causas_Secundarias();
        ventanasecundarias.setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        try {
            lectura = manejo_archivo.leer_aleatorio_maestro();
            salida.setText(lectura);
            mensajes.setText(manejo_archivo.mensajes);
        } catch (IOException ex) {
            Logger.getLogger(Ventana_Sintomas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void todActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_todActionPerformed
        try {
            lectura = manejo_archivo.consultar_archivo_indice_secuencial();
            salida.setText(lectura);
            mensajes.setText("LECTURA");
        } catch (IOException ex) {
            Logger.getLogger(Ventana_Sintomas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_todActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        Ventana_Tratamiento ventana= new Ventana_Tratamiento();
        ventana.setVisible(true);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        Ventana_Contraindicaciones ventana= new Ventana_Contraindicaciones();
        ventana.setVisible(true);
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        Ventana_Clasificacion ventana= new Ventana_Clasificacion();
        ventana.setVisible(true);
    }//GEN-LAST:event_jButton8ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Ventana_Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ventana_Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ventana_Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ventana_Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ventana_Inicio().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_sintomas;
    private javax.swing.JLabel ind;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton lla;
    private javax.swing.JLabel mensajes;
    private javax.swing.JTextArea salida;
    private javax.swing.JButton tod;
    // End of variables declaration//GEN-END:variables
}
