/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FRONTEND;

import BACKEND.CentroVacinacao;
import BACKEND.RepositorioDoencas;
import BACKEND.RepositorioUtilizador.UtilizadorJaExisteException;
import BACKEND.Sistema;
import BACKEND.Utente;
import BACKEND.Vacina;
import SERIALIZACAO.Serializacao;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import BACKEND.RepositorioUtilizador;

/**
 *
 * @author Gonçalo
 */
public class RegisterForm extends javax.swing.JFrame {

    private Sistema sistema;
    private Serializacao serializacao;

    /**
     * Creates new form RegisterForm
     */
    public RegisterForm(Sistema sistema, Serializacao serializacao) {
        initComponents();
        this.sistema = sistema;
        this.serializacao = serializacao;

    }

    private void registar() {
        if (jtxtNome.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Introduza o seu Nome!", "NOME EM FALTA", JOptionPane.WARNING_MESSAGE);
            jtxtNome.requestFocus();
            return;
        }
        if (jtxtNumeroSNS.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Introduza o seu Número de SNS!", "NUMERO DE SNS EM FALTA", JOptionPane.WARNING_MESSAGE);
            jtxtNumeroSNS.requestFocus();
            return;
        }
        if (jtxtPassword.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Introduza a sua Password!", "PASSWORD EM FALTA", JOptionPane.WARNING_MESSAGE);
            jtxtPassword.requestFocus();
            return;
        }
        if (jtxtMorada.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Introduza uma morada válida!", "MORADA EM FALTA", JOptionPane.WARNING_MESSAGE);
            jtxtMorada.requestFocus();
            return;
        }
        if (jtxtLocalidade.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Introduza uma localidade válida!", "LOCALIDADE EM FALTA", JOptionPane.WARNING_MESSAGE);
            jtxtLocalidade.requestFocus();
            return;
        }
        if (jtxtNumeroTelemovel.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Introduza um número de telemóvel válido!", "NUMERO DE TELEMOVEL EM FALTA", JOptionPane.WARNING_MESSAGE);
            jtxtNumeroTelemovel.requestFocus();
            return;
        }
        if (jtxtEmail.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Introduza um email válido!", "EMAIL EM FALTA", JOptionPane.WARNING_MESSAGE);
            jtxtEmail.requestFocus();
            return;
        }
        if (jDateChooser.getDate() == null) {
            JOptionPane.showMessageDialog(this, "Introduza a sua data de nascimento!", "DATA EM FALTA", JOptionPane.WARNING_MESSAGE);
            jDateChooser.requestFocus();
            return;
        }

        String numSNS = jtxtNumeroSNS.getText().trim();
        String email = jtxtEmail.getText().trim();
        if (sistema.getUtilizadores().existeUtilizador(numSNS)) {
            JOptionPane.showMessageDialog(this, "Já existe um utilizador com esse número SNS.", "UTILIZADOR EXISTENTE", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (sistema.getUtilizadores().verificarEmail(email)) {
            JOptionPane.showMessageDialog(this, "Já existe um utilizador com esse email.", "EMAIL EXISTENTE", JOptionPane.WARNING_MESSAGE);
            return;
        }

        Date input = jDateChooser.getDate();
        Instant instant = input.toInstant();
        ZonedDateTime zdt = instant.atZone(ZoneId.systemDefault());
        LocalDate data_nascimento = zdt.toLocalDate();

        String nome = jtxtNome.getText().trim();
        String morada = jtxtMorada.getText().trim();
        String localidade = jtxtLocalidade.getText().trim();
        String numTelemovel = jtxtNumeroTelemovel.getText().trim();
        String username = numSNS;
        String password = jtxtPassword.getText();

        sistema.getUtilizadores().adicionar(new Utente(numSNS, morada, localidade, data_nascimento, numTelemovel, null, null, null, new RepositorioDoencas(), 0, username, password, email, nome));
        serializacao.guardar(sistema);

        JOptionPane.showMessageDialog(this, "O Utente " + numSNS + " foi criado com sucesso!");
        dispose();
        LoginForm login = new LoginForm(sistema, serializacao);
        login.setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jtxtPassword = new javax.swing.JTextField();
        jtxtNome = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jtxtMorada = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jtxtLocalidade = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jDateChooser = new com.toedter.calendar.JDateChooser();
        jLabel6 = new javax.swing.JLabel();
        jtxtNumeroTelemovel = new javax.swing.JTextField();
        jtxtEmail = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        BLimpar = new javax.swing.JButton();
        BCancelar = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jtxtNumeroSNS = new javax.swing.JTextField();
        BRegistar1 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jtxtPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxtPasswordActionPerformed(evt);
            }
        });
        getContentPane().add(jtxtPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 220, 270, -1));

        jtxtNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxtNomeActionPerformed(evt);
            }
        });
        getContentPane().add(jtxtNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 120, 270, -1));

        jLabel1.setBackground(new java.awt.Color(78, 205, 196));
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Password:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 220, 96, 24));

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Número SNS:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 180, 96, -1));

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Data de Nascimento:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 270, 117, 24));

        jtxtMorada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxtMoradaActionPerformed(evt);
            }
        });
        getContentPane().add(jtxtMorada, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 320, 270, -1));

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Morada:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 320, 96, 24));

        jtxtLocalidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxtLocalidadeActionPerformed(evt);
            }
        });
        getContentPane().add(jtxtLocalidade, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 360, 270, -1));

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Localidade:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 360, 123, 24));
        getContentPane().add(jDateChooser, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 270, 240, -1));

        jLabel6.setBackground(new java.awt.Color(78, 205, 196));
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Número de Telemóvel:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 410, 135, 24));

        jtxtNumeroTelemovel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxtNumeroTelemovelActionPerformed(evt);
            }
        });
        getContentPane().add(jtxtNumeroTelemovel, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 410, 230, -1));

        jtxtEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxtEmailActionPerformed(evt);
            }
        });
        getContentPane().add(jtxtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 450, 270, -1));

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("E-mail:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 450, 96, 24));

        BLimpar.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        BLimpar.setText("Limpar");
        BLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BLimparActionPerformed(evt);
            }
        });
        getContentPane().add(BLimpar, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 510, 100, -1));

        BCancelar.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        BCancelar.setText("Cancelar");
        BCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BCancelarActionPerformed(evt);
            }
        });
        getContentPane().add(BCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 510, 141, -1));

        jLabel8.setBackground(new java.awt.Color(78, 205, 196));
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Nome:");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 120, 96, 24));

        jtxtNumeroSNS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxtNumeroSNSActionPerformed(evt);
            }
        });
        getContentPane().add(jtxtNumeroSNS, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 170, 270, -1));

        BRegistar1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        BRegistar1.setText("Registar");
        BRegistar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BRegistar1ActionPerformed(evt);
            }
        });
        getContentPane().add(BRegistar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 510, 140, -1));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/FRONTEND/images/registerBackground.png"))); // NOI18N
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 940, 590));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtxtPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtPasswordActionPerformed

    private void jtxtNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtNomeActionPerformed

    private void jtxtMoradaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtMoradaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtMoradaActionPerformed

    private void jtxtLocalidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtLocalidadeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtLocalidadeActionPerformed

    private void jtxtNumeroTelemovelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtNumeroTelemovelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtNumeroTelemovelActionPerformed

    private void jtxtEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtEmailActionPerformed

    private void BLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BLimparActionPerformed
        jtxtNome.setText(null);
        jtxtNumeroSNS.setText(null);
        jtxtLocalidade.setText(null);
        jtxtNumeroTelemovel.setText(null);
        jDateChooser.setDate(null);
        jtxtEmail.setText(null);
        jtxtPassword.setText(null);
        jtxtMorada.setText(null);

    }//GEN-LAST:event_BLimparActionPerformed

    private void BCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BCancelarActionPerformed
        LoginForm LF = new LoginForm(sistema, serializacao);
        LF.setVisible(true);
        LF.setLocationRelativeTo(null);
        LF.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        dispose();
    }//GEN-LAST:event_BCancelarActionPerformed

    private void jtxtNumeroSNSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtNumeroSNSActionPerformed

    }//GEN-LAST:event_jtxtNumeroSNSActionPerformed

    private void BRegistar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BRegistar1ActionPerformed
        registar();
        dispose();
    }//GEN-LAST:event_BRegistar1ActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BCancelar;
    private javax.swing.JButton BLimpar;
    private javax.swing.JButton BRegistar1;
    private com.toedter.calendar.JDateChooser jDateChooser;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField jtxtEmail;
    private javax.swing.JTextField jtxtLocalidade;
    private javax.swing.JTextField jtxtMorada;
    private javax.swing.JTextField jtxtNome;
    private javax.swing.JTextField jtxtNumeroSNS;
    private javax.swing.JTextField jtxtNumeroTelemovel;
    private javax.swing.JTextField jtxtPassword;
    // End of variables declaration//GEN-END:variables
}
