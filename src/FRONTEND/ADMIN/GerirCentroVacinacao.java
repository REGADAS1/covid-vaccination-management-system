package FRONTEND.ADMIN;

import BACKEND.Sistema;
import BACKEND.RepositorioCentrosVacinacao;
import BACKEND.CentroVacinacao;
import BACKEND.Gestor;
import FRONTEND.UTENTE.ConsultarCentroVacinacao;
import SERIALIZACAO.Serializacao;
import java.awt.List;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import javax.swing.JOptionPane;

public class GerirCentroVacinacao extends javax.swing.JFrame {

    private CriarCentroVacinacao janela;
    private Sistema sistema;
    private Serializacao serializacao;
    private AbstractTableModel modeloTabela;
   

    public GerirCentroVacinacao(Sistema sistema, Serializacao serializacao) {
        initComponents();
        this.sistema = sistema;
        this.serializacao = serializacao;
        this.modeloTabela = criarModeloTabela();
        jTableCentros.setModel(modeloTabela);     
    }

    private AbstractTableModel criarModeloTabela() {
        String[] nomeColunas = {"Código de Centro", "Morada", "Localidade","Gestor","Número de Postos"};
        

        return new AbstractTableModel() {
            
            @Override
            public String getColumnName(int column) {
                return nomeColunas[column];
            }
            
            @Override
            public int getRowCount() { //CONTA AS LINHAS ---> RETURN AO NUMERO DE CENTROS DE VAC
                return sistema.getRepositorioCentrosVacinacao().sizeRepositorio();
            }

            @Override
            public int getColumnCount() { //CONTA AS COLUNAS -->NUMERO DE VARIABEIS DE CADA CENTRO DE VAC
                return nomeColunas.length;
            }
            
            @Override
            public Object getValueAt(int rowIndex, int columnIndex) {
                switch (columnIndex) {
                    case 0:
                        return sistema.getRepositorioCentrosVacinacao().todos().get(rowIndex).getCodigo();
                    case 1:
                        return sistema.getRepositorioCentrosVacinacao().todos().get(rowIndex).getMorada();
                    case 2:
                        return sistema.getRepositorioCentrosVacinacao().todos().get(rowIndex).getLocalidade();
                    case 3:
                        try{
                          return sistema.getRepositorioCentrosVacinacao().todos().get(rowIndex).getGestor().getNome();
                        }catch(NullPointerException e){
                            return "Sem gestor";
                        }
                        
                    case 4:
                        return sistema.getRepositorioCentrosVacinacao().todos().get(rowIndex).getNumeroPostosAtendimento();
                    
                        
                    default:
                        
                        return "";

                }
                
                
                
            }
            private ArrayList<Object> data = new ArrayList<Object>();           

            public void addRow(List rowData) {
                data.add(rowData);
                fireTableRowsInserted(data.size() - 1, data.size() - 1);
            }

            public void removeRow(List rowData) {
                data.add(rowData);
                fireTableRowsInserted(data.size() - 1, data.size() - 1);
            }



        };
    }
       public void atualizar() {
        //Informa o modelo que foram efetuadas alteracoes, o modelo informa a tabela e os dados são redesenhados
       modeloTabela.fireTableDataChanged(); 
    } 
       
       private void apagar()  {

           int rowIndex = jTableCentros.getSelectedRow();
           if (rowIndex == -1) {
               JOptionPane.showMessageDialog(this, "Selecione um centro para remover.");
               return;
           }
           String codigo = (String) modeloTabela.getValueAt(rowIndex, 0);
           sistema.getRepositorioCentrosVacinacao().removerCentro(codigo);
           serializacao.guardar(sistema);
           atualizar();

    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTableCentros = new javax.swing.JTable();
        jButtonAdicionarCentro = new javax.swing.JButton();
        jButtonVoltar = new javax.swing.JButton();
        jButtonEditarCentro = new javax.swing.JButton();
        jButtonRemoverCentro = new javax.swing.JButton();
        jButtonAtualizar = new javax.swing.JButton();
        jButtonAlocarVacina = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTableCentros.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Código de Centro", "Morada", "Localidade", "Gestor", "Número de Postos"
            }
        ));
        jScrollPane1.setViewportView(jTableCentros);

        jButtonAdicionarCentro.setText("Adicionar");
        jButtonAdicionarCentro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAdicionarCentroActionPerformed(evt);
            }
        });

        jButtonVoltar.setText("Voltar");
        jButtonVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVoltarActionPerformed(evt);
            }
        });

        jButtonEditarCentro.setText("Editar");
        jButtonEditarCentro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditarCentroActionPerformed(evt);
            }
        });

        jButtonRemoverCentro.setText("Remover");
        jButtonRemoverCentro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRemoverCentroActionPerformed(evt);
            }
        });

        jButtonAtualizar.setText("Atualizar");
        jButtonAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAtualizarActionPerformed(evt);
            }
        });

        jButtonAlocarVacina.setText("Alocar Vacina");
        jButtonAlocarVacina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAlocarVacinaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1268, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(204, 204, 204)
                .addComponent(jButtonAlocarVacina)
                .addGap(41, 41, 41)
                .addComponent(jButtonAdicionarCentro, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(jButtonEditarCentro, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(jButtonRemoverCentro, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(72, 72, 72)
                .addComponent(jButtonAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(68, 68, 68))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAdicionarCentro)
                    .addComponent(jButtonVoltar)
                    .addComponent(jButtonEditarCentro)
                    .addComponent(jButtonRemoverCentro)
                    .addComponent(jButtonAtualizar)
                    .addComponent(jButtonAlocarVacina))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 408, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(204, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAdicionarCentroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAdicionarCentroActionPerformed
        CriarCentroVacinacao janela = new CriarCentroVacinacao(sistema, serializacao);
        janela.setVisible(true);     
    }//GEN-LAST:event_jButtonAdicionarCentroActionPerformed

    private void jButtonVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVoltarActionPerformed
        dispose();
    }//GEN-LAST:event_jButtonVoltarActionPerformed

    private void jButtonAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAtualizarActionPerformed
        atualizar();
    }//GEN-LAST:event_jButtonAtualizarActionPerformed

    private void jButtonRemoverCentroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRemoverCentroActionPerformed
        apagar();
    }//GEN-LAST:event_jButtonRemoverCentroActionPerformed

    private void jButtonAlocarVacinaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAlocarVacinaActionPerformed
        if (jTableCentros.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(this, "Selecione um centro para alocar vacinas.");
            return;
        }
        CentroVacinacao cv = sistema.getRepositorioCentrosVacinacao().getCentroVacinacao(jTableCentros.getModel().getValueAt(jTableCentros.getSelectedRow(), 0).toString());
        AlocarVacinas alocarvacinas = new AlocarVacinas(sistema, serializacao, cv);
        alocarvacinas.setVisible(true);
    }//GEN-LAST:event_jButtonAlocarVacinaActionPerformed

    private void jButtonEditarCentroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditarCentroActionPerformed
            int rowIndex = jTableCentros.getSelectedRow();
            if (rowIndex == -1) {
                JOptionPane.showMessageDialog(this, "Selecione um centro para editar.");
                return;
            }
            String codigo = (String) modeloTabela.getValueAt(rowIndex, 0);
            CentroVacinacao cv = (CentroVacinacao) sistema.getRepositorioCentrosVacinacao().getCentroVacinacao(codigo);
            if (cv != null) {
                new EditarCentroVac(sistema, serializacao, cv).setVisible(true);
            }
    }//GEN-LAST:event_jButtonEditarCentroActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAdicionarCentro;
    private javax.swing.JButton jButtonAlocarVacina;
    private javax.swing.JButton jButtonAtualizar;
    private javax.swing.JButton jButtonEditarCentro;
    private javax.swing.JButton jButtonRemoverCentro;
    private javax.swing.JButton jButtonVoltar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableCentros;
    // End of variables declaration//GEN-END:variables
}
