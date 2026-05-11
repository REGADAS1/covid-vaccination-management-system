package FRONTEND;

import BACKEND.Sistema;
import SERIALIZACAO.Serializacao;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class LoginForm extends javax.swing.JFrame {

    private Sistema sistema;
    private Serializacao serializacao;

    public LoginForm(Sistema sistema, Serializacao serializacao) {
        initComponents();

        //Não permite o redimensionamento da janela
        this.setResizable(false);

        //Mostra a centralização da janela
        this.setLocationRelativeTo(null);

        //O processo de fecho da janela será controlado pelo programa
        this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);

        this.sistema = sistema;
        this.serializacao = serializacao;

        txtUsername.requestFocus();
    }

    private void autenticar() {
        //CASO O USERNAME/NUMERO SNS ESTEJA VAZIO 
        if (Username.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Introduza um username!", "UTILIZADOR EM FALTA", JOptionPane.WARNING_MESSAGE);
            Username.requestFocus();
            return;
        }
        //CASO A PASSWORD ESTEJA VAZIA
        if (PasswordField.getPassword().length == 0) {
            JOptionPane.showMessageDialog(this, "Introduza a sua password!");
            PasswordField.requestFocus();
            return;
        }
        //CASO AS CREDENCIAIS NAO CORRESPONDAM A UM UTILIZADOR VÁLIDO
        if (!sistema.autenticarUtilizador(Username.getText(), new String(PasswordField.getPassword()))) {
            JOptionPane.showMessageDialog(this, "As credenciais introduzidas não correspondem a um utilizador válido.",
                    "Autenticação", JOptionPane.WARNING_MESSAGE);
            Username.requestFocus();
        } else {
            //AUTENTICACAO
            dispose();
            JOptionPane.showMessageDialog(this, "Bem-vindo " + sistema.getUtilizadorligado().getUsername() + "!");
            HomePage hp = new HomePage(sistema, serializacao);
            hp.setVisible(true);

        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtUsername = new javax.swing.JLabel();
        Username = new javax.swing.JTextField();
        txtPassword = new javax.swing.JLabel();
        Login = new javax.swing.JButton();
        Terminar = new javax.swing.JButton();
        PasswordField = new javax.swing.JPasswordField();
        jLabelEfetuarRegisto = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(78, 205, 196));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtUsername.setBackground(new java.awt.Color(255, 255, 255));
        txtUsername.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        txtUsername.setForeground(new java.awt.Color(255, 255, 255));
        txtUsername.setText("Username:");
        getContentPane().add(txtUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 200, 102, -1));

        Username.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        Username.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UsernameActionPerformed(evt);
            }
        });
        getContentPane().add(Username, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 200, 220, -1));

        txtPassword.setBackground(new java.awt.Color(255, 255, 255));
        txtPassword.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        txtPassword.setForeground(new java.awt.Color(255, 255, 255));
        txtPassword.setText("Password:");
        getContentPane().add(txtPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 290, 102, -1));

        Login.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        Login.setText("Login");
        Login.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LoginMouseClicked(evt);
            }
        });
        Login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoginActionPerformed(evt);
            }
        });
        getContentPane().add(Login, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 350, 120, -1));

        Terminar.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        Terminar.setText("Terminar");
        Terminar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TerminarMouseClicked(evt);
            }
        });
        Terminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TerminarActionPerformed(evt);
            }
        });
        getContentPane().add(Terminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(709, 350, 120, -1));

        PasswordField.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        PasswordField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PasswordFieldActionPerformed(evt);
            }
        });
        getContentPane().add(PasswordField, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 290, 220, -1));

        jLabelEfetuarRegisto.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabelEfetuarRegisto.setForeground(new java.awt.Color(255, 255, 255));
        jLabelEfetuarRegisto.setText("Clique aqui para efetuar Registo");
        jLabelEfetuarRegisto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelEfetuarRegistoMouseClicked(evt);
            }
        });
        getContentPane().add(jLabelEfetuarRegisto, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 430, 307, 38));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/FRONTEND/images/loginBackground.png"))); // NOI18N
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 942, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void UsernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UsernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UsernameActionPerformed

    private void PasswordFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PasswordFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PasswordFieldActionPerformed

    private void LoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoginActionPerformed
        autenticar();
    }//GEN-LAST:event_LoginActionPerformed

    private void TerminarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TerminarMouseClicked

    }//GEN-LAST:event_TerminarMouseClicked

    private void LoginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LoginMouseClicked

    }//GEN-LAST:event_LoginMouseClicked

    private void jLabelEfetuarRegistoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelEfetuarRegistoMouseClicked
        RegisterForm rf = new RegisterForm(sistema, serializacao);
        rf.setVisible(true);
        rf.setLocationRelativeTo(null);
        rf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.dispose();
    }//GEN-LAST:event_jLabelEfetuarRegistoMouseClicked

    private void TerminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TerminarActionPerformed
        serializacao.guardar(sistema);
        if (JOptionPane.showConfirmDialog(null, "Deseja encerrar o programa?", "SAIR", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            serializacao.guardar(sistema);
            System.exit(0);

        }
    }//GEN-LAST:event_TerminarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Login;
    private javax.swing.JPasswordField PasswordField;
    private javax.swing.JButton Terminar;
    private javax.swing.JTextField Username;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelEfetuarRegisto;
    private javax.swing.JLabel txtPassword;
    private javax.swing.JLabel txtUsername;
    // End of variables declaration//GEN-END:variables
}
