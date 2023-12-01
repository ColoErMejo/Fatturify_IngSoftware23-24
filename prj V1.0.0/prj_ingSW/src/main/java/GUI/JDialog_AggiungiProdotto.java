/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package GUI;

/**
 *
 * @author Merlo
 */
public class JDialog_AggiungiProdotto extends javax.swing.JDialog {

    /**
     * Creates new form JDialog_AggiungiProdotto
     */
    public JDialog_AggiungiProdotto(java.awt.Frame parent, boolean modal) {
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

        jPanel1 = new javax.swing.JPanel();
        jComboBox_Categoria_POP = new javax.swing.JComboBox<>();
        jTextFieldPrezzo_POP = new javax.swing.JTextField();
        jTextField_Nome_POP = new javax.swing.JTextField();
        jButton_Aggiungi_Prod_POP = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel_Categoria_POP = new javax.swing.JLabel();
        jLabel_Prezzo_POP = new javax.swing.JLabel();
        jLabel_Nome_POP = new javax.swing.JLabel();
        jLabel_Aggiungi_Prodotto_POP = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Add_Product");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jComboBox_Categoria_POP.setBackground(new java.awt.Color(255, 255, 255));
        jComboBox_Categoria_POP.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jComboBox_Categoria_POP.setForeground(new java.awt.Color(51, 51, 51));
        jComboBox_Categoria_POP.setMaximumRowCount(200);
        jComboBox_Categoria_POP.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel1.add(jComboBox_Categoria_POP, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 190, -1, -1));

        jTextFieldPrezzo_POP.setBackground(new java.awt.Color(255, 255, 255));
        jTextFieldPrezzo_POP.setForeground(new java.awt.Color(51, 51, 51));
        jPanel1.add(jTextFieldPrezzo_POP, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 140, 190, -1));

        jTextField_Nome_POP.setBackground(new java.awt.Color(255, 255, 255));
        jTextField_Nome_POP.setForeground(new java.awt.Color(51, 51, 51));
        jPanel1.add(jTextField_Nome_POP, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 90, 190, -1));

        jButton_Aggiungi_Prod_POP.setBackground(new java.awt.Color(255, 255, 255));
        jButton_Aggiungi_Prod_POP.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jButton_Aggiungi_Prod_POP.setForeground(new java.awt.Color(51, 51, 51));
        jButton_Aggiungi_Prod_POP.setText("Aggiungi");
        jPanel1.add(jButton_Aggiungi_Prod_POP, new org.netbeans.lib.awtextra.AbsoluteConstraints(265, 250, 100, -1));

        jPanel2.setBackground(new java.awt.Color(0, 153, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel_Categoria_POP.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jLabel_Categoria_POP.setForeground(new java.awt.Color(51, 51, 51));
        jLabel_Categoria_POP.setText("categoria");
        jPanel2.add(jLabel_Categoria_POP, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, -1, -1));

        jLabel_Prezzo_POP.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jLabel_Prezzo_POP.setForeground(new java.awt.Color(51, 51, 51));
        jLabel_Prezzo_POP.setText("prezzo unitario");
        jPanel2.add(jLabel_Prezzo_POP, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, -1, -1));

        jLabel_Nome_POP.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jLabel_Nome_POP.setForeground(new java.awt.Color(51, 51, 51));
        jLabel_Nome_POP.setText("nome");
        jPanel2.add(jLabel_Nome_POP, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 90, -1, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 130, 300));

        jLabel_Aggiungi_Prodotto_POP.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        jLabel_Aggiungi_Prodotto_POP.setForeground(new java.awt.Color(51, 51, 51));
        jLabel_Aggiungi_Prodotto_POP.setText("aggiungi prodotto");
        jPanel1.add(jLabel_Aggiungi_Prodotto_POP, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 10, 200, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/lineaBlu4.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 40, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 300));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(JDialog_AggiungiProdotto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JDialog_AggiungiProdotto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JDialog_AggiungiProdotto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JDialog_AggiungiProdotto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JDialog_AggiungiProdotto dialog = new JDialog_AggiungiProdotto(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton jButton_Aggiungi_Prod_POP;
    private javax.swing.JComboBox<String> jComboBox_Categoria_POP;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel_Aggiungi_Prodotto_POP;
    private javax.swing.JLabel jLabel_Categoria_POP;
    private javax.swing.JLabel jLabel_Nome_POP;
    private javax.swing.JLabel jLabel_Prezzo_POP;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField jTextFieldPrezzo_POP;
    private javax.swing.JTextField jTextField_Nome_POP;
    // End of variables declaration//GEN-END:variables
}