package FRONTEND.ADMIN;

import BACKEND.Administrador;
import BACKEND.CentroVacinacao;
import BACKEND.Sistema;
import SERIALIZACAO.Serializacao;
import javax.swing.JOptionPane;

/**
 *
 * @author gabri
 */
public class AlocarVacinas extends javax.swing.JFrame {

    private Sistema sistema;
    private Serializacao serializacao;
    private CentroVacinacao centrovacinacao;

    public AlocarVacinas(Sistema sistema, Serializacao serializacao, CentroVacinacao centrovacinacao) {
        initComponents();
        this.setResizable(false);
        this.sistema = sistema;
        this.serializacao = serializacao;
        this.centrovacinacao = centrovacinacao;

        //Administrador admin = (Administrador)sistema.getUtilizadorligado();
        for (int i = 0; i < sistema.getRepositoriovacinas().size(); i++) {
            jComboBox1.addItem(sistema.getRepositoriovacinas().get(i).getNome());

        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTextFieldQuantidade = new javax.swing.JTextField();
        jToggleButtonAlocar = new javax.swing.JToggleButton();
        jLabel2 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jToggleButtonCancelar = new javax.swing.JToggleButton();
        jButtonVoltar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Quantidade da Vacina:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 160, 130, 22));
        getContentPane().add(jTextFieldQuantidade, new org.netbeans.lib.awtextra.AbsoluteConstraints(171, 160, 120, -1));

        jToggleButtonAlocar.setText("Alocar");
        jToggleButtonAlocar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButtonAlocarActionPerformed(evt);
            }
        });
        getContentPane().add(jToggleButtonAlocar, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 200, 80, -1));

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Nome da Vacina:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, 115, 21));

        getContentPane().add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(161, 120, 130, -1));

        jToggleButtonCancelar.setText("Cancelar");
        jToggleButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButtonCancelarActionPerformed(evt);
            }
        });
        getContentPane().add(jToggleButtonCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 200, 90, -1));

        jButtonVoltar.setText("Voltar");
        jButtonVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVoltarActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonVoltar, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 240, 80, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/FRONTEND/images/AlocarVacina.png"))); // NOI18N
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jToggleButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButtonCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_jToggleButtonCancelarActionPerformed

    private void jToggleButtonAlocarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButtonAlocarActionPerformed
        if (centrovacinacao == null) {
            JOptionPane.showMessageDialog(this, "Centro inválido.", "ERRO", JOptionPane.ERROR_MESSAGE);
            return;
        }
        String nomevacina = jComboBox1.getItemAt(jComboBox1.getSelectedIndex());
        long quantidade;
        try {
            quantidade = Long.parseLong(jTextFieldQuantidade.getText().trim());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Introduza uma quantidade numérica.", "VALOR INVÁLIDO", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (quantidade <= 0) {
            JOptionPane.showMessageDialog(this, "A quantidade tem de ser maior que zero.", "VALOR INVÁLIDO", JOptionPane.WARNING_MESSAGE);
            return;
        }
        centrovacinacao.getStockVacinas().AdicionarVacinas(sistema.getRepositoriovacinas().get(nomevacina), quantidade);
        serializacao.guardar(sistema);
        JOptionPane.showMessageDialog(this, "Vacinas alocadas com sucesso.");

    }//GEN-LAST:event_jToggleButtonAlocarActionPerformed

    private void jButtonVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVoltarActionPerformed
        dispose();
    }//GEN-LAST:event_jButtonVoltarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonVoltar;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField jTextFieldQuantidade;
    private javax.swing.JToggleButton jToggleButtonAlocar;
    private javax.swing.JToggleButton jToggleButtonCancelar;
    // End of variables declaration//GEN-END:variables
}
