//FALTA FAZER O BOTÃO GUARDAR COM O GESTOR
package FRONTEND.ADMIN;

import BACKEND.CentroVacinacao;
import BACKEND.Gestor;
import BACKEND.RepositorioCentrosVacinacao;
import BACKEND.Sistema;
import BACKEND.Utilizador;
import javax.swing.JOptionPane;
import SERIALIZACAO.Serializacao;

/**
 *
 * @author Gonçalo
 */
public class CriarCentroVacinacao extends javax.swing.JFrame {

    private Sistema sistema;
    private Serializacao serializacao;
  

    public CriarCentroVacinacao(Sistema sistema, Serializacao serializacao) {
        initComponents();

        this.setResizable(false);
        this.sistema = sistema;
        this.serializacao = serializacao;
        for (Utilizador u : sistema.getUtilizadores().getListaUtilizador()){
            if (u instanceof Gestor){
                jComboBoxGestor.addItem(u.getUsername());
            }
        }
    }

    public void guardar() {
        if (jTextFieldCodigo.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Introduza, por favor, o Código!", "CÓDIGO EM FALTA", JOptionPane.WARNING_MESSAGE);
            jTextFieldCodigo.requestFocus();
            return;
        }
        if (jTextFieldMorada.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Introduza, por favor, a Morada!", "MORADA EM FALTA", JOptionPane.WARNING_MESSAGE);
            jTextFieldMorada.requestFocus();
            return;
        }

        if (jTextFieldLocalidade.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Introduza, por favor, a Localidade!", "LOCALIDADE EM FALTA", JOptionPane.WARNING_MESSAGE);
            jTextFieldLocalidade.requestFocus();
            return;
        }

        if (jTextFieldNumeroPostosAtendimento.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Introduza, por favor, o Número de Postos de Atendimento!", "POSTOS DE ATENDIMENTO EM FALTA", JOptionPane.WARNING_MESSAGE);
            jTextFieldNumeroPostosAtendimento.requestFocus();
            return;
        }
        if (jComboBoxGestor.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(this, "Selecione um gestor para o centro.", "GESTOR EM FALTA", JOptionPane.WARNING_MESSAGE);
            return;
        }

        int postos;
        try {
            postos = Integer.parseInt(jTextFieldNumeroPostosAtendimento.getText().trim());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "O número de postos tem de ser numérico.", "VALOR INVÁLIDO", JOptionPane.WARNING_MESSAGE);
            jTextFieldNumeroPostosAtendimento.requestFocus();
            return;
        }
        if (postos <= 0) {
            JOptionPane.showMessageDialog(this, "O número de postos tem de ser maior que zero.", "VALOR INVÁLIDO", JOptionPane.WARNING_MESSAGE);
            return;
        }

        String codigo = jTextFieldCodigo.getText().trim();
        if (sistema.getRepositorioCentrosVacinacao().getCentroVacinacao(codigo) != null) {
            JOptionPane.showMessageDialog(this, "Já existe um centro com esse código.", "CENTRO EXISTENTE", JOptionPane.WARNING_MESSAGE);
            return;
        }

        String usernameGestor = (String) jComboBoxGestor.getSelectedItem();
        Utilizador gestor = sistema.getUtilizadores().getGestor(usernameGestor);
        if (gestor == null) {
            JOptionPane.showMessageDialog(this, "Gestor inválido.", "GESTOR INVÁLIDO", JOptionPane.WARNING_MESSAGE);
            return;
        }

        CentroVacinacao novo = new CentroVacinacao(codigo, jTextFieldMorada.getText().trim(), jTextFieldLocalidade.getText().trim(), gestor, postos);
        sistema.getRepositorioCentrosVacinacao().adicionarCentro(novo);
        serializacao.guardar(sistema);
        JOptionPane.showMessageDialog(this, "O centro " + novo.getCodigo() + " foi criado com sucesso.");
        dispose();
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jButtonVoltar = new javax.swing.JButton();
        jButtonLimparCentroVac = new javax.swing.JButton();
        jTextFieldCodigo = new javax.swing.JTextField();
        jTextFieldMorada = new javax.swing.JTextField();
        jTextFieldNumeroPostosAtendimento = new javax.swing.JTextField();
        jComboBoxGestor = new javax.swing.JComboBox<>();
        jTextFieldLocalidade = new javax.swing.JTextField();
        jButtonGuardarCentroVac = new javax.swing.JButton();
        jButtonCancelarCentroVac = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Código:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 220, 90, -1));

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Morada:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 260, -1, -1));

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Localidade:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 300, -1, -1));

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Gestor:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 340, 60, -1));

        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Número de Postos de Atendimento:");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 380, -1, -1));

        jButtonVoltar.setText("Voltar");
        jButtonVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVoltarActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonVoltar, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 540, 110, -1));

        jButtonLimparCentroVac.setText("Limpar");
        jButtonLimparCentroVac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLimparCentroVacActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonLimparCentroVac, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 480, 100, -1));
        getContentPane().add(jTextFieldCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 220, 270, -1));
        getContentPane().add(jTextFieldMorada, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 260, 270, -1));
        getContentPane().add(jTextFieldNumeroPostosAtendimento, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 380, 190, -1));

        jComboBoxGestor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxGestorActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBoxGestor, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 340, 270, -1));
        getContentPane().add(jTextFieldLocalidade, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 300, 270, -1));

        jButtonGuardarCentroVac.setText("Guardar");
        jButtonGuardarCentroVac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGuardarCentroVacActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonGuardarCentroVac, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 480, 100, -1));

        jButtonCancelarCentroVac.setText("Cancelar");
        jButtonCancelarCentroVac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarCentroVacActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonCancelarCentroVac, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 480, 100, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/FRONTEND/images/CriarCentroVacicanao.png"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 590));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonGuardarCentroVacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGuardarCentroVacActionPerformed
        guardar();
    }//GEN-LAST:event_jButtonGuardarCentroVacActionPerformed

    private void jButtonCancelarCentroVacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarCentroVacActionPerformed
        dispose();
    }//GEN-LAST:event_jButtonCancelarCentroVacActionPerformed

    private void jButtonLimparCentroVacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLimparCentroVacActionPerformed
        jTextFieldCodigo.setText(null);
        jTextFieldMorada.setText(null);
        jTextFieldLocalidade.setText(null);
        jComboBoxGestor.setSelectedItem(null);
        jTextFieldNumeroPostosAtendimento.setText(null);
      
    }//GEN-LAST:event_jButtonLimparCentroVacActionPerformed

    private void jButtonVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVoltarActionPerformed
        dispose();
    }//GEN-LAST:event_jButtonVoltarActionPerformed

    private void jComboBoxGestorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxGestorActionPerformed
       
    }//GEN-LAST:event_jComboBoxGestorActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCancelarCentroVac;
    private javax.swing.JButton jButtonGuardarCentroVac;
    private javax.swing.JButton jButtonLimparCentroVac;
    private javax.swing.JButton jButtonVoltar;
    private javax.swing.JComboBox<String> jComboBoxGestor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JTextField jTextFieldCodigo;
    private javax.swing.JTextField jTextFieldLocalidade;
    private javax.swing.JTextField jTextFieldMorada;
    private javax.swing.JTextField jTextFieldNumeroPostosAtendimento;
    // End of variables declaration//GEN-END:variables
}
