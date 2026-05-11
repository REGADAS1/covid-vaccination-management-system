/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FRONTEND.ADMIN;

import BACKEND.Gestor;
import BACKEND.Sistema;
import SERIALIZACAO.Serializacao;
import javax.swing.JOptionPane;

/**
 *
 * @author Gonçalo
 */
public class EditarGestor extends javax.swing.JFrame {
    private Sistema sistema;
    private Serializacao serializacao;
    private Gestor gestor;
            

    /**
     * Creates new form EditarGestor
     */
    public EditarGestor(Sistema sistema, Serializacao serializacao, Gestor gestor) {
        initComponents();
        this.serializacao = serializacao;
        this.sistema = sistema;
        this.gestor = gestor;
        
        jTextFieldNome.setText(gestor.getNome());
        jTextFieldUsername.setText(gestor.getUsername());
        jTextFieldEmail.setText(gestor.getEmail());
        jTextFieldPassword.setText(gestor.getPassword());
                
    }
    
    public void guardar(){
        if (jTextFieldNome.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Nome não pode ficar vazio!", "NOME EM FALTA", JOptionPane.WARNING_MESSAGE);
            jTextFieldNome.requestFocus();
            return;
        }
        
        if (jTextFieldEmail.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Email não pode ficar vazio!", "EMAIL EM FALTA", JOptionPane.WARNING_MESSAGE);
            jTextFieldEmail.requestFocus();
            return;
        }

        if (jTextFieldPassword.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Password não pode ficar vazio!", "PASSWORD EM FALTA", JOptionPane.WARNING_MESSAGE);
            jTextFieldPassword.requestFocus();
            return;
        }
        gestor.setNome(jTextFieldNome.getText().trim());
        gestor.setEmail(jTextFieldEmail.getText().trim());
        gestor.setPassword(jTextFieldPassword.getText());
        serializacao.guardar(sistema);
        JOptionPane.showMessageDialog(this, "Gestor atualizado com sucesso.");
        dispose();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jTextFieldNome = new javax.swing.JTextField();
        jTextFieldUsername = new javax.swing.JTextField();
        jTextFieldEmail = new javax.swing.JTextField();
        jTextFieldPassword = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabelEDITAR = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("Voltar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Guardar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jTextFieldUsername.setEditable(false);

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Nome:");

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Username:");

        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Email:");

        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Password:");

        jLabelEDITAR.setForeground(new java.awt.Color(255, 255, 255));
        jLabelEDITAR.setText("EDITAR:::::");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(134, 134, 134)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(75, 75, 75))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(412, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9))
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextFieldNome, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)
                    .addComponent(jTextFieldUsername)
                    .addComponent(jTextFieldEmail)
                    .addComponent(jTextFieldPassword))
                .addGap(304, 304, 304))
            .addGroup(layout.createSequentialGroup()
                .addGap(181, 181, 181)
                .addComponent(jLabelEDITAR, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addComponent(jLabelEDITAR)
                .addGap(86, 86, 86)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTextFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(jTextFieldUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(jTextFieldEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addComponent(jTextFieldPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(44, 44, 44)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(jLabel8)
                        .addGap(44, 44, 44)
                        .addComponent(jLabel9)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 135, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(35, 35, 35))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addGap(49, 49, 49))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        guardar();
    }//GEN-LAST:event_jButton2ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelEDITAR;
    private javax.swing.JTextField jTextFieldEmail;
    private javax.swing.JTextField jTextFieldNome;
    private javax.swing.JTextField jTextFieldPassword;
    private javax.swing.JTextField jTextFieldUsername;
    // End of variables declaration//GEN-END:variables
}
