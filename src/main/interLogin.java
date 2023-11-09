package main;

import DAO.GerenteDAO;
import javax.swing.JOptionPane;
import model.Gerente;

public class interLogin extends javax.swing.JFrame {

    
    public interLogin() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        entrar = new javax.swing.JButton();
        escEmail = new javax.swing.JTextField();
        senhaLogin = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Arial Black", 2, 36)); // NOI18N
        jLabel1.setText("Login");

        entrar.setText("ENTRAR");
        entrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                entrarActionPerformed(evt);
            }
        });

        escEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                escEmailActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(136, 136, 136))
            .addGroup(layout.createSequentialGroup()
                .addGap(105, 105, 105)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(senhaLogin)
                    .addComponent(escEmail, javax.swing.GroupLayout.DEFAULT_SIZE, 247, Short.MAX_VALUE)
                    .addComponent(entrar, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(116, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jLabel1)
                .addGap(52, 52, 52)
                .addComponent(escEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(senhaLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 101, Short.MAX_VALUE)
                .addComponent(entrar, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void entrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_entrarActionPerformed
        String usuario = this.escEmail.getText();
        String password = new String(this.senhaLogin.getPassword());
         
        if(!usuario.isEmpty() || !password.isEmpty()){
            //IR NO BANCO E BUSCAR USUARIO POR EMAIL
            Gerente gerente = new GerenteDAO().buscarGerentePorEmail(usuario);
            if(gerente == null){
                JOptionPane.showMessageDialog(null, "GERENTE NAO EXISTE!");
                return;
            }
            
            if(gerente.getSenha().equals(password)){
                JOptionPane.showMessageDialog(null, "Senha incorreta");
            }
            //VERIFICAR SE A SENHA ESTA CORRETA
            //SE TIVER - VOU PARA HOME
            //SE NAO ESTIVER - ERRO
            
            
            
            this.dispose();
            new Home().setVisible(true);
        }
        JOptionPane.showMessageDialog(null, "As credenciais não foram preenchidas corretamente");
    }//GEN-LAST:event_entrarActionPerformed

    private void escEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_escEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_escEmailActionPerformed

   
    public static void main(String args[]) {
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new interLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton entrar;
    private javax.swing.JTextField escEmail;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPasswordField senhaLogin;
    // End of variables declaration//GEN-END:variables
}
