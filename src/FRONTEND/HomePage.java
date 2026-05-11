package FRONTEND;

import BACKEND.Administrador;
import BACKEND.CentroVacinacao;
import BACKEND.Gestor;
import BACKEND.RepositorioCentrosVacinacao;
import BACKEND.Sistema;
import BACKEND.Utente;
import javax.swing.JFrame;
import FRONTEND.ADMIN.GerirCentroVacinacao;
import FRONTEND.ADMIN.GerirGestores;
import FRONTEND.ADMIN.GerirVacinas;
import FRONTEND.ADMIN.InformacaoVacinacao;
import FRONTEND.GESTOR.EstatisticasCentroVac;
import FRONTEND.GESTOR.GestorGerirCentroVacinacao;
import FRONTEND.GESTOR.GerirMarcacoes;
import FRONTEND.GESTOR.ListaUtentes;
import FRONTEND.UTENTE.AgendarMarcacao;
import FRONTEND.UTENTE.ConsultarCentroVacinacao;
import FRONTEND.UTENTE.DadosUtente;
import SERIALIZACAO.Serializacao;
import javax.swing.JOptionPane;

/**
 *
 * @author Gonçalo
 */
public class HomePage extends javax.swing.JFrame {

    private Sistema sistema;
    private Serializacao serializacao;
    private CentroVacinacao centro;

    /**
     * Creates new form HomePage
     */
    public HomePage(Sistema sistema, Serializacao serializacao) {
        initComponents();

        this.sistema = sistema;
        this.serializacao = serializacao;
        if (sistema.getUtilizadorligado() instanceof Gestor) {
            this.centro = sistema.getRepositorioCentrosVacinacao().procurarCentro(sistema.getUtilizadorligado().getUsername());
        }
        this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        this.setResizable(false);
        menuAdministrador.setVisible(sistema.getUtilizadorligado() instanceof Administrador);
        menuGestor.setVisible(sistema.getUtilizadorligado() instanceof Gestor);
        menuUtente.setVisible(sistema.getUtilizadorligado() instanceof Utente);
        jLabel1.setText("Utilizador Ligado: " + sistema.getUtilizadorligado().getUsername());
    }


    private CentroVacinacao centroDoGestorOuAviso() {
        if (!(sistema.getUtilizadorligado() instanceof Gestor)) {
            return null;
        }
        centro = sistema.getRepositorioCentrosVacinacao().procurarCentro(sistema.getUtilizadorligado().getUsername());
        if (centro == null) {
            JOptionPane.showMessageDialog(this, "Este gestor ainda não tem centro de vacinação associado.", "CENTRO EM FALTA", JOptionPane.WARNING_MESSAGE);
        }
        return centro;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        exitButton = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuAdministrador = new javax.swing.JMenu();
        AjMenuGerirGestores = new javax.swing.JMenuItem();
        AjMenuGerirVacinas = new javax.swing.JMenuItem();
        AjMenuGerirCentrosVacinacao = new javax.swing.JMenuItem();
        AjMenuInfoVacinacao = new javax.swing.JMenuItem();
        menuGestor = new javax.swing.JMenu();
        GjMenuCentroVacinacao = new javax.swing.JMenuItem();
        GjMenuGerirMarcacoes = new javax.swing.JMenuItem();
        GjMenuEstatisticaCentroVac = new javax.swing.JMenuItem();
        GjMenuConsultarUtentes = new javax.swing.JMenuItem();
        menuUtente = new javax.swing.JMenu();
        UjMenuDadosUtente = new javax.swing.JMenuItem();
        UjMenuAgendarMarcacao = new javax.swing.JMenuItem();
        UjMenuConsultarCentroVac = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 340, 249, 64));

        exitButton.setFont(new java.awt.Font("Eras Bold ITC", 1, 14)); // NOI18N
        exitButton.setText("Sair");
        exitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitButtonActionPerformed(evt);
            }
        });
        getContentPane().add(exitButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(907, 6, 77, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/FRONTEND/images/PaginaInicial.png"))); // NOI18N
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 560));

        menuAdministrador.setText("ADMINISTRADOR");
        menuAdministrador.setFont(new java.awt.Font("Eras Bold ITC", 0, 18)); // NOI18N

        AjMenuGerirGestores.setText("Gerir Gestores");
        AjMenuGerirGestores.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AjMenuGerirGestoresMouseClicked(evt);
            }
        });
        AjMenuGerirGestores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AjMenuGerirGestoresActionPerformed(evt);
            }
        });
        menuAdministrador.add(AjMenuGerirGestores);

        AjMenuGerirVacinas.setText("Gerir Vacinas");
        AjMenuGerirVacinas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AjMenuGerirVacinasActionPerformed(evt);
            }
        });
        menuAdministrador.add(AjMenuGerirVacinas);

        AjMenuGerirCentrosVacinacao.setText("Gerir Centros de Vacinação");
        AjMenuGerirCentrosVacinacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AjMenuGerirCentrosVacinacaoActionPerformed(evt);
            }
        });
        menuAdministrador.add(AjMenuGerirCentrosVacinacao);

        AjMenuInfoVacinacao.setText("Informação de Vacinação");
        AjMenuInfoVacinacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AjMenuInfoVacinacaoActionPerformed(evt);
            }
        });
        menuAdministrador.add(AjMenuInfoVacinacao);

        jMenuBar1.add(menuAdministrador);

        menuGestor.setText("GESTOR");
        menuGestor.setFont(new java.awt.Font("Eras Bold ITC", 1, 18)); // NOI18N

        GjMenuCentroVacinacao.setText("Gerir Centro de Vacinação");
        GjMenuCentroVacinacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GjMenuCentroVacinacaoActionPerformed(evt);
            }
        });
        menuGestor.add(GjMenuCentroVacinacao);

        GjMenuGerirMarcacoes.setText("Gerir Marcações");
        GjMenuGerirMarcacoes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GjMenuGerirMarcacoesActionPerformed(evt);
            }
        });
        menuGestor.add(GjMenuGerirMarcacoes);

        GjMenuEstatisticaCentroVac.setText("Estatísticas do Centro de Vacinação");
        GjMenuEstatisticaCentroVac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GjMenuEstatisticaCentroVacActionPerformed(evt);
            }
        });
        menuGestor.add(GjMenuEstatisticaCentroVac);

        GjMenuConsultarUtentes.setText("Consultar Lista de Utentes");
        GjMenuConsultarUtentes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GjMenuConsultarUtentesActionPerformed(evt);
            }
        });
        menuGestor.add(GjMenuConsultarUtentes);

        jMenuBar1.add(menuGestor);

        menuUtente.setText("UTENTE");
        menuUtente.setFont(new java.awt.Font("Eras Bold ITC", 1, 18)); // NOI18N

        UjMenuDadosUtente.setText("Dados de Utente");
        UjMenuDadosUtente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UjMenuDadosUtenteActionPerformed(evt);
            }
        });
        menuUtente.add(UjMenuDadosUtente);

        UjMenuAgendarMarcacao.setText("Agendar Marcação");
        UjMenuAgendarMarcacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UjMenuAgendarMarcacaoActionPerformed(evt);
            }
        });
        menuUtente.add(UjMenuAgendarMarcacao);

        UjMenuConsultarCentroVac.setText("Consultar Centro de Vacinação");
        UjMenuConsultarCentroVac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UjMenuConsultarCentroVacActionPerformed(evt);
            }
        });
        menuUtente.add(UjMenuConsultarCentroVac);

        jMenuBar1.add(menuUtente);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AjMenuGerirGestoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AjMenuGerirGestoresActionPerformed
        new GerirGestores(sistema, serializacao).setVisible(true);
    }//GEN-LAST:event_AjMenuGerirGestoresActionPerformed

    private void exitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitButtonActionPerformed

        serializacao.guardar(sistema);
        if (JOptionPane.showConfirmDialog(null, "Deseja terminar sessão?", "SAIR", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            serializacao.guardar(sistema);
            LoginForm LF = new LoginForm(sistema, serializacao);
            LF.setVisible(true);
            LF.setLocationRelativeTo(null);
            LF.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            dispose();

        }


    }//GEN-LAST:event_exitButtonActionPerformed

    private void GjMenuGerirMarcacoesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GjMenuGerirMarcacoesActionPerformed
        if (centroDoGestorOuAviso() != null) {
            new GerirMarcacoes(sistema, serializacao).setVisible(true);
        }
    }//GEN-LAST:event_GjMenuGerirMarcacoesActionPerformed

    private void AjMenuGerirGestoresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AjMenuGerirGestoresMouseClicked

    }//GEN-LAST:event_AjMenuGerirGestoresMouseClicked

    private void AjMenuGerirVacinasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AjMenuGerirVacinasActionPerformed
        JFrame janela = new JFrame("Gerir Vacinas");
        janela.setContentPane(new GerirVacinas(sistema, serializacao));
        janela.pack();
        janela.setLocationRelativeTo(this);
        janela.setVisible(true);
    }//GEN-LAST:event_AjMenuGerirVacinasActionPerformed

    private void AjMenuGerirCentrosVacinacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AjMenuGerirCentrosVacinacaoActionPerformed
        new GerirCentroVacinacao(sistema, serializacao).setVisible(true);
    }//GEN-LAST:event_AjMenuGerirCentrosVacinacaoActionPerformed

    private void AjMenuInfoVacinacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AjMenuInfoVacinacaoActionPerformed
        new InformacaoVacinacao(sistema).setVisible(true);
    }//GEN-LAST:event_AjMenuInfoVacinacaoActionPerformed

    private void GjMenuCentroVacinacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GjMenuCentroVacinacaoActionPerformed
        CentroVacinacao centroGestor = centroDoGestorOuAviso();
        if (centroGestor != null) {
            new GestorGerirCentroVacinacao(sistema, serializacao, centroGestor).setVisible(true);
        }
    }//GEN-LAST:event_GjMenuCentroVacinacaoActionPerformed

    private void GjMenuEstatisticaCentroVacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GjMenuEstatisticaCentroVacActionPerformed
        if (centroDoGestorOuAviso() != null) {
            new EstatisticasCentroVac(sistema, serializacao).setVisible(true);
        }
    }//GEN-LAST:event_GjMenuEstatisticaCentroVacActionPerformed

    private void GjMenuConsultarUtentesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GjMenuConsultarUtentesActionPerformed
        
        if (centroDoGestorOuAviso() != null) {
            new ListaUtentes(sistema, serializacao).setVisible(true);
        }
    }//GEN-LAST:event_GjMenuConsultarUtentesActionPerformed

    private void UjMenuDadosUtenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UjMenuDadosUtenteActionPerformed
        new DadosUtente(sistema, serializacao).setVisible(true);
    }//GEN-LAST:event_UjMenuDadosUtenteActionPerformed

    private void UjMenuAgendarMarcacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UjMenuAgendarMarcacaoActionPerformed
        new AgendarMarcacao(sistema, serializacao).setVisible(true);
    }//GEN-LAST:event_UjMenuAgendarMarcacaoActionPerformed

    private void UjMenuConsultarCentroVacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UjMenuConsultarCentroVacActionPerformed
        new ConsultarCentroVacinacao(sistema, serializacao).setVisible(true);
    }//GEN-LAST:event_UjMenuConsultarCentroVacActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem AjMenuGerirCentrosVacinacao;
    private javax.swing.JMenuItem AjMenuGerirGestores;
    private javax.swing.JMenuItem AjMenuGerirVacinas;
    private javax.swing.JMenuItem AjMenuInfoVacinacao;
    private javax.swing.JMenuItem GjMenuCentroVacinacao;
    private javax.swing.JMenuItem GjMenuConsultarUtentes;
    private javax.swing.JMenuItem GjMenuEstatisticaCentroVac;
    private javax.swing.JMenuItem GjMenuGerirMarcacoes;
    private javax.swing.JMenuItem UjMenuAgendarMarcacao;
    private javax.swing.JMenuItem UjMenuConsultarCentroVac;
    private javax.swing.JMenuItem UjMenuDadosUtente;
    private javax.swing.JButton exitButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu menuAdministrador;
    private javax.swing.JMenu menuGestor;
    private javax.swing.JMenu menuUtente;
    // End of variables declaration//GEN-END:variables
}
