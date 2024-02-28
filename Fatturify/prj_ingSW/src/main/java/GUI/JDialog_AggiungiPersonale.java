/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Merlo
 */
public class JDialog_AggiungiPersonale extends javax.swing.JDialog {
	public boolean flag=false;

    /**
     * Creates new form JDialog_AggiungiPersonale
     */
    public JDialog_AggiungiPersonale(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        
        jButton_Aggiungi_Pers_POP.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	flag=true;
            }
        });
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
        jLabel_PagaOraria_POP = new javax.swing.JLabel();
        jLabel_Mansione_POP = new javax.swing.JLabel();
        jLabel_Nome_POP = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jTextField_PagaOraria_POP = new javax.swing.JTextField();
        jTextField_Nome_POP = new javax.swing.JTextField();
        jButton_Aggiungi_Pers_POP = new javax.swing.JButton();
        jLabel_Aggiungi_Personale_POP = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jTextField_Mansione_POP = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(0, 153, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel_PagaOraria_POP.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jLabel_PagaOraria_POP.setForeground(new java.awt.Color(51, 51, 51));
        jLabel_PagaOraria_POP.setText("Paga Oraria");
        jPanel2.add(jLabel_PagaOraria_POP, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, -1, 40));

        jLabel_Mansione_POP.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jLabel_Mansione_POP.setForeground(new java.awt.Color(51, 51, 51));
        jLabel_Mansione_POP.setText("Mansione");
        jPanel2.add(jLabel_Mansione_POP, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, -1, 40));

        jLabel_Nome_POP.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jLabel_Nome_POP.setForeground(new java.awt.Color(51, 51, 51));
        jLabel_Nome_POP.setText("Nome-Cognome");
        jPanel2.add(jLabel_Nome_POP, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, -1, 40));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 130, 300));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextField_PagaOraria_POP.setBackground(new java.awt.Color(255, 255, 255));
        jTextField_PagaOraria_POP.setForeground(new java.awt.Color(51, 51, 51));
        jPanel1.add(jTextField_PagaOraria_POP, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 190, 190, -1));

        jTextField_Nome_POP.setBackground(new java.awt.Color(255, 255, 255));
        jTextField_Nome_POP.setForeground(new java.awt.Color(51, 51, 51));
        jPanel1.add(jTextField_Nome_POP, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 90, 190, -1));

        jButton_Aggiungi_Pers_POP.setBackground(new java.awt.Color(255, 255, 255));
        jButton_Aggiungi_Pers_POP.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jButton_Aggiungi_Pers_POP.setForeground(new java.awt.Color(51, 51, 51));
        jButton_Aggiungi_Pers_POP.setText("Aggiungi");
        jButton_Aggiungi_Pers_POP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_Aggiungi_Pers_POPActionPerformed(evt);
            }
        });
        
        jPanel1.add(jButton_Aggiungi_Pers_POP, new org.netbeans.lib.awtextra.AbsoluteConstraints(265, 250, 100, -1));

        jLabel_Aggiungi_Personale_POP.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        jLabel_Aggiungi_Personale_POP.setForeground(new java.awt.Color(51, 51, 51));
        jLabel_Aggiungi_Personale_POP.setText("Aggiungi Personale");
        jPanel1.add(jLabel_Aggiungi_Personale_POP, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 10, 200, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/lineaBlu4.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 40, -1, -1));

        jTextField_Mansione_POP.setBackground(new java.awt.Color(255, 255, 255));
        jTextField_Mansione_POP.setForeground(new java.awt.Color(51, 51, 51));
        jPanel1.add(jTextField_Mansione_POP, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 140, 190, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 300));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_Aggiungi_Pers_POPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Aggiungi_Pers_POPActionPerformed
        dispose();
    }//GEN-LAST:event_jButton_Aggiungi_Pers_POPActionPerformed

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
            java.util.logging.Logger.getLogger(JDialog_AggiungiPersonale.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JDialog_AggiungiPersonale.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JDialog_AggiungiPersonale.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JDialog_AggiungiPersonale.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JDialog_AggiungiPersonale dialog = new JDialog_AggiungiPersonale(new javax.swing.JFrame(), true);
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
    
    public javax.swing.JTextField getjTextField_Nome_POP() {
		return jTextField_Nome_POP;
	}
    public javax.swing.JTextField getjTextField_Paga_POP() {
 		return jTextField_PagaOraria_POP;
 	}
    public javax.swing.JTextField getjTextField_Mansione_POP() {
 		return jTextField_Mansione_POP;
 	}
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_Aggiungi_Pers_POP;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel_Aggiungi_Personale_POP;
    private javax.swing.JLabel jLabel_PagaOraria_POP;
    private javax.swing.JLabel jLabel_Nome_POP;
    private javax.swing.JLabel jLabel_Mansione_POP;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField jTextField_Mansione_POP;
    private javax.swing.JTextField jTextField_Nome_POP;
    private javax.swing.JTextField jTextField_PagaOraria_POP;
    // End of variables declaration//GEN-END:variables
}