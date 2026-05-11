/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FRONTEND.GESTOR;

import BACKEND.CentroVacinacao;
import BACKEND.Sistema;
import SERIALIZACAO.Serializacao;
import javax.swing.JOptionPane;

/**
 *
 * @author Gonçalo
 */
public class GestorGerirCentroVacinacao extends javax.swing.JFrame {

    private Serializacao serializacao;
    private Sistema sistema;
    private CentroVacinacao centro;

    public GestorGerirCentroVacinacao(Sistema sistema, Serializacao serializacao, CentroVacinacao centro) {
        initComponents();
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.sistema = sistema;
        this.serializacao = serializacao;
        this.centro = centro;
    }

    public void atualizarPostos() {
        try {
            int postos = Integer.parseInt(jTextFieldNumeroPostos.getText().trim());
            if (postos <= 0) {
                JOptionPane.showMessageDialog(this, "O número de postos tem de ser maior que zero.");
                return;
            }
            centro.setNumeroPostosAtendimento(postos);
            serializacao.guardar(sistema);
            JOptionPane.showMessageDialog(this, "O número de postos disponíveis foi atualizado com sucesso!");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Introduza um número de postos válido.");
        }
    }

    public void atualizarMaxMarcacoes() {
        try {
            int maxMarcacoes = Integer.parseInt(jTextFieldMaxMarcacoes.getText().trim());
            if (maxMarcacoes <= 0) {
                JOptionPane.showMessageDialog(this, "O máximo de marcações tem de ser maior que zero.");
                return;
            }
            centro.setMaxVacinasPorDia(maxMarcacoes);
            serializacao.guardar(sistema);
            JOptionPane.showMessageDialog(this, "O número máximo de marcações diárias foi atualizado com sucesso!");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Introduza um máximo de marcações válido.");
        }
    }

    public void monitorizarStockVacinas() {
        CentroVacinacao centroGestor = sistema.getRepositorioCentrosVacinacao().procurarCentro(sistema.getUtilizadorligado().getUsername());
        if (centroGestor == null) {
            JOptionPane.showMessageDialog(this, "Este gestor não tem centro associado!");
            return;
        }
        new MonitorizarStockVacinas(sistema, serializacao).setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonVoltar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButtonMonitorizarStock = new javax.swing.JButton();
        jTextFieldCodigo = new javax.swing.JTextField();
        jTextFieldMorada = new javax.swing.JTextField();
        jTextFieldLocalidade = new javax.swing.JTextField();
        jTextFieldNumeroPostos = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButtonMostrarDados = new javax.swing.JButton();
        jButtonOcultar = new javax.swing.JButton();
        jButtonLimitarMarcacoes = new javax.swing.JButton();
        jTextFieldMaxMarcacoes = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButtonVoltar.setText("Voltar");
        jButtonVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVoltarActionPerformed(evt);
            }
        });

        jButton1.setText("Alterar Número de Postos");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButtonMonitorizarStock.setText("Monitorizar Stock de Vacinas");
        jButtonMonitorizarStock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMonitorizarStockActionPerformed(evt);
            }
        });

        jLabel1.setText("Código:");

        jLabel2.setText("Morada:");

        jLabel3.setText("Localidade:");

        jLabel4.setText("Número de Postos:");

        jButtonMostrarDados.setText("Revelar Dados do Centro");
        jButtonMostrarDados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMostrarDadosActionPerformed(evt);
            }
        });

        jButtonOcultar.setText("Ocultar");
        jButtonOcultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonOcultarActionPerformed(evt);
            }
        });

        jButtonLimitarMarcacoes.setText("Limitar Marcações Diárias");
        jButtonLimitarMarcacoes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLimitarMarcacoesActionPerformed(evt);
            }
        });

        jLabel5.setText("Máximo de Marcações Diárias:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(77, 77, 77)
                .addComponent(jButtonMonitorizarStock, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(jButtonLimitarMarcacoes)
                        .addGap(32, 32, 32)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(61, 61, 61)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jButtonMostrarDados))
                                .addGap(26, 26, 26))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextFieldMaxMarcacoes)
                            .addComponent(jTextFieldCodigo)
                            .addComponent(jTextFieldMorada)
                            .addComponent(jTextFieldLocalidade)
                            .addComponent(jTextFieldNumeroPostos, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                            .addComponent(jButtonOcultar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(115, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(72, 72, 72)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonMostrarDados)
                    .addComponent(jButtonOcultar))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldMorada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldLocalidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldNumeroPostos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldMaxMarcacoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonLimitarMarcacoes)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButtonVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButtonMonitorizarStock, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVoltarActionPerformed
        dispose();
    }//GEN-LAST:event_jButtonVoltarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        atualizarPostos();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButtonMonitorizarStockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMonitorizarStockActionPerformed
        monitorizarStockVacinas();
    }//GEN-LAST:event_jButtonMonitorizarStockActionPerformed

    private void jButtonMostrarDadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMostrarDadosActionPerformed
        jTextFieldCodigo.setText(centro.getCodigo()); //erro aqui GERIR CENTRO DE MARCACOES baixo
        jTextFieldMorada.setText(centro.getMorada());
        jTextFieldLocalidade.setText(centro.getLocalidade());
        jTextFieldCodigo.setEditable(false);
        jTextFieldMorada.setEditable(false);
        jTextFieldLocalidade.setEditable(false);
        String postos = String.valueOf(centro.getNumeroPostosAtendimento());
        jTextFieldNumeroPostos.setText(postos);
        String maxVacinacoesDia = String.valueOf(centro.getMaxVacinasPorDia());
        jTextFieldMaxMarcacoes.setText(maxVacinacoesDia);
    }//GEN-LAST:event_jButtonMostrarDadosActionPerformed

    private void jButtonOcultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonOcultarActionPerformed
        jTextFieldCodigo.setText(null);
        jTextFieldMorada.setText(null);
        jTextFieldLocalidade.setText(null);
        jTextFieldNumeroPostos.setText(null);
        jTextFieldMaxMarcacoes.setText(null);
    }//GEN-LAST:event_jButtonOcultarActionPerformed

    private void jButtonLimitarMarcacoesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLimitarMarcacoesActionPerformed
        atualizarMaxMarcacoes();
    }//GEN-LAST:event_jButtonLimitarMarcacoesActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonLimitarMarcacoes;
    private javax.swing.JButton jButtonMonitorizarStock;
    private javax.swing.JButton jButtonMostrarDados;
    private javax.swing.JButton jButtonOcultar;
    private javax.swing.JButton jButtonVoltar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField jTextFieldCodigo;
    private javax.swing.JTextField jTextFieldLocalidade;
    private javax.swing.JTextField jTextFieldMaxMarcacoes;
    private javax.swing.JTextField jTextFieldMorada;
    private javax.swing.JTextField jTextFieldNumeroPostos;
    // End of variables declaration//GEN-END:variables
}
