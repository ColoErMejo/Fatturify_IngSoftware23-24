/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package GUI;

/**
 *
 * @author Merlo
 */
public class JDialog_ModificaProdotto extends javax.swing.JDialog {

    /**
     * Creates new form JDialog_ModificaProdotto
     */
    public JDialog_ModificaProdotto(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel_Categoria_POP = new javax.swing.JLabel();
        jLabel_Prezzo_POP = new javax.swing.JLabel();
        jLabel_Nome_POP = new javax.swing.JLabel();
        jLabel_Nome_POP2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jComboBox_Prodotto_POP = new javax.swing.JComboBox<>();
        jTextField_NuovoNome_POP = new javax.swing.JTextField();
        jButton_Modifica_Prod_POP = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel_Categoria_POP1 = new javax.swing.JLabel();
        jLabel_Prezzo_POP1 = new javax.swing.JLabel();
        jLabel_Nome_POP1 = new javax.swing.JLabel();
        jLabel_Modifica_Prodotto_POP = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jComboBox_Categoria_POP = new javax.swing.JComboBox<>();
        jTextField_NuovoPrezzo_POP = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(0, 153, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel_Categoria_POP.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jLabel_Categoria_POP.setForeground(new java.awt.Color(51, 51, 51));
        jLabel_Categoria_POP.setText("categoria");
        jPanel2.add(jLabel_Categoria_POP, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, -1, 30));

        jLabel_Prezzo_POP.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jLabel_Prezzo_POP.setForeground(new java.awt.Color(51, 51, 51));
        jLabel_Prezzo_POP.setText("Prodotto");
        jPanel2.add(jLabel_Prezzo_POP, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, -1, 30));

        jLabel_Nome_POP.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jLabel_Nome_POP.setForeground(new java.awt.Color(51, 51, 51));
        jLabel_Nome_POP.setText("Nuovo Nome");
        jPanel2.add(jLabel_Nome_POP, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, -1, 30));

        jLabel_Nome_POP2.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jLabel_Nome_POP2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel_Nome_POP2.setText("Nuovo Costo");
        jPanel2.add(jLabel_Nome_POP2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 198, -1, 30));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 130, 300));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jComboBox_Prodotto_POP.setBackground(new java.awt.Color(255, 255, 255));
        jComboBox_Prodotto_POP.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jComboBox_Prodotto_POP.setForeground(new java.awt.Color(51, 51, 51));
        jComboBox_Prodotto_POP.setMaximumRowCount(200);
        jComboBox_Prodotto_POP.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox_Prodotto_POP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_Prodotto_POPActionPerformed(evt);
            }
        });
        jPanel1.add(jComboBox_Prodotto_POP, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 110, 190, -1));

        jTextField_NuovoNome_POP.setBackground(new java.awt.Color(255, 255, 255));
        jTextField_NuovoNome_POP.setForeground(new java.awt.Color(51, 51, 51));
        jPanel1.add(jTextField_NuovoNome_POP, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 160, 190, -1));

        jButton_Modifica_Prod_POP.setBackground(new java.awt.Color(255, 255, 255));
        jButton_Modifica_Prod_POP.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jButton_Modifica_Prod_POP.setForeground(new java.awt.Color(51, 51, 51));
        jButton_Modifica_Prod_POP.setText("Modifica");
        jButton_Modifica_Prod_POP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_Modifica_Prod_POPActionPerformed(evt);
            }
        });
        jPanel1.add(jButton_Modifica_Prod_POP, new org.netbeans.lib.awtextra.AbsoluteConstraints(265, 250, 100, -1));

        jPanel3.setBackground(new java.awt.Color(0, 153, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel_Categoria_POP1.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jLabel_Categoria_POP1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel_Categoria_POP1.setText("categoria");
        jPanel3.add(jLabel_Categoria_POP1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, -1, -1));

        jLabel_Prezzo_POP1.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jLabel_Prezzo_POP1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel_Prezzo_POP1.setText("prezzo unitario");
        jPanel3.add(jLabel_Prezzo_POP1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, -1, -1));

        jLabel_Nome_POP1.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jLabel_Nome_POP1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel_Nome_POP1.setText("nome");
        jPanel3.add(jLabel_Nome_POP1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 90, -1, -1));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 130, 300));

        jLabel_Modifica_Prodotto_POP.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        jLabel_Modifica_Prodotto_POP.setForeground(new java.awt.Color(51, 51, 51));
        jLabel_Modifica_Prodotto_POP.setText("Modifica Prodotto");
        jPanel1.add(jLabel_Modifica_Prodotto_POP, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 10, 200, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/lineaBlu4.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 40, -1, -1));

        jComboBox_Categoria_POP.setBackground(new java.awt.Color(255, 255, 255));
        jComboBox_Categoria_POP.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jComboBox_Categoria_POP.setForeground(new java.awt.Color(51, 51, 51));
        jComboBox_Categoria_POP.setMaximumRowCount(200);
        jComboBox_Categoria_POP.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox_Categoria_POP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_Categoria_POPActionPerformed(evt);
            }
        });
        jPanel1.add(jComboBox_Categoria_POP, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 70, 190, -1));

        jTextField_NuovoPrezzo_POP.setBackground(new java.awt.Color(255, 255, 255));
        jTextField_NuovoPrezzo_POP.setForeground(new java.awt.Color(51, 51, 51));
        jPanel1.add(jTextField_NuovoPrezzo_POP, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 200, 190, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 300));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox_Prodotto_POPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_Prodotto_POPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox_Prodotto_POPActionPerformed

    private void jButton_Modifica_Prod_POPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Modifica_Prod_POPActionPerformed
        dispose();
    }//GEN-LAST:event_jButton_Modifica_Prod_POPActionPerformed

    private void jComboBox_Categoria_POPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_Categoria_POPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox_Categoria_POPActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JDialog_ModificaProdotto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JDialog_ModificaProdotto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JDialog_ModificaProdotto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JDialog_ModificaProdotto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JDialog_ModificaProdotto dialog = new JDialog_ModificaProdotto(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_Modifica_Prod_POP;
    private javax.swing.JComboBox<String> jComboBox_Categoria_POP;
    private javax.swing.JComboBox<String> jComboBox_Prodotto_POP;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel_Categoria_POP;
    private javax.swing.JLabel jLabel_Categoria_POP1;
    private javax.swing.JLabel jLabel_Modifica_Prodotto_POP;
    private javax.swing.JLabel jLabel_Nome_POP;
    private javax.swing.JLabel jLabel_Nome_POP1;
    private javax.swing.JLabel jLabel_Nome_POP2;
    private javax.swing.JLabel jLabel_Prezzo_POP;
    private javax.swing.JLabel jLabel_Prezzo_POP1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField jTextField_NuovoNome_POP;
    private javax.swing.JTextField jTextField_NuovoPrezzo_POP;
    // End of variables declaration//GEN-END:variables
}
