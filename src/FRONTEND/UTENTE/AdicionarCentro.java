
package FRONTEND.UTENTE;

import BACKEND.CentroVacinacao;
import BACKEND.Gestor;
import BACKEND.RepositorioDoencas;
import BACKEND.Sistema;
import BACKEND.Utente;
import BACKEND.Utilizador;
import SERIALIZACAO.Serializacao;
import javax.swing.JOptionPane;

public class AdicionarCentro extends javax.swing.JFrame {
    private Sistema sistema;
    private Serializacao serializacao;
    private Utente utente;
    /**
     * Creates new form AdicionarCentro
     */
    public AdicionarCentro(Sistema sistema, Serializacao serializacao) {
        initComponents();
        this.sistema = sistema;
        this.serializacao = serializacao;
        for (CentroVacinacao cv : sistema.getRepositorioCentrosVacinacao().todos()){
                jComboBoxCentrosVac.addItem(cv.getLocalidade()); //para saber o centro de vacinacao como "key" através de localidade            
        }
    }
    

 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jComboBoxCentrosVac = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButtonVoltar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jComboBoxCentrosVac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxCentrosVacActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBoxCentrosVac, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 150, 150, -1));

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Centros de Vacinação Disponíveis:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 150, 200, -1));

        jButton1.setText("Selecionar Centro");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(119, 208, 145, -1));

        jButtonVoltar.setText("Voltar");
        jButtonVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVoltarActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonVoltar, new org.netbeans.lib.awtextra.AbsoluteConstraints(282, 208, 94, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/FRONTEND/images/escolherCentro.png"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, 490, 370));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVoltarActionPerformed
        dispose();
        
    }//GEN-LAST:event_jButtonVoltarActionPerformed

    private void jComboBoxCentrosVacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxCentrosVacActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxCentrosVacActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String localidade = (String) jComboBoxCentrosVac.getSelectedItem();
        if (localidade == null) {
            JOptionPane.showMessageDialog(this, "Não existem centros disponíveis.", "CENTRO EM FALTA", JOptionPane.WARNING_MESSAGE);
            return;
        }
        CentroVacinacao cv = sistema.getRepositorioCentrosVacinacao().getCentroVacinacaoLocalidade(localidade); //cv vai receber o valor de um centro de vacinacao que tenha a mesma localidade que pedimos
        Utente u = (Utente) sistema.getUtilizadores().getUtilizador(sistema.getUtilizadorligado().getUsername());
        if (u == null || cv == null) {
            JOptionPane.showMessageDialog(this, "Não foi possível associar o centro.", "ERRO", JOptionPane.ERROR_MESSAGE);
            return;
        }
        u.setCentrovacinacao(cv);
        serializacao.guardar(sistema);
        JOptionPane.showMessageDialog(this, "Centro selecionado com sucesso: " + cv.getLocalidade());
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonVoltar;
    private javax.swing.JComboBox<String> jComboBoxCentrosVac;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
