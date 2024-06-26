/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JComboBox;

import fatturify_controller.Return_Avalaible_Data;
import fatturify_database.DB;

/**
 *
 * @author Merlo
 */
public class JDialog_ModificaCategoria extends javax.swing.JDialog {
	private static String nomeUtente;
	private DB db;
	private Return_Avalaible_Data Avalaible_Data;
	public boolean flag=false;

    /**
     * Creates new form NewJDialog
     */
    public JDialog_ModificaCategoria(java.awt.Frame parent, boolean modal, String nomeUtente) {
        super(parent, modal);
        this.nomeUtente=nomeUtente;
        this.db= new DB(nomeUtente);
        this.Avalaible_Data= new Return_Avalaible_Data();
        initComponents();
        
        jButton_ModificaCat_POP.addActionListener(new ActionListener() {
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
        jLabel_NuovoNome_POP = new javax.swing.JLabel();
        jLabel_Nome_POP = new javax.swing.JLabel();
        jPanel_Right_NuovoUtente = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel_ModificaCat_POP = new javax.swing.JLabel();
        jTextField_NomeCategoria_POP = new javax.swing.JTextField();
        jButton_ModificaCat_POP = new javax.swing.JButton();
        jComboBox_Categoria_POP = new javax.swing.JComboBox<>();
        jCheckBox1_Elimina = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(0, 153, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel_NuovoNome_POP.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jLabel_NuovoNome_POP.setForeground(new java.awt.Color(51, 51, 51));
        jLabel_NuovoNome_POP.setText("Nuovo Nome");
        jPanel2.add(jLabel_NuovoNome_POP, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, -1, -1));

        jLabel_Nome_POP.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jLabel_Nome_POP.setForeground(new java.awt.Color(51, 51, 51));
        jLabel_Nome_POP.setText("Categoria");
        jPanel2.add(jLabel_Nome_POP, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, -1, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 130, 300));

        jPanel_Right_NuovoUtente.setBackground(new java.awt.Color(255, 255, 255));
        jPanel_Right_NuovoUtente.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/lineaBlu4.png"))); // NOI18N
        jPanel_Right_NuovoUtente.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-30, 50, -1, -1));

        jLabel_ModificaCat_POP.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        jLabel_ModificaCat_POP.setForeground(new java.awt.Color(51, 51, 51));
        jLabel_ModificaCat_POP.setText("Modifica Categoria");
        jPanel_Right_NuovoUtente.add(jLabel_ModificaCat_POP, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 200, 30));

        jTextField_NomeCategoria_POP.setBackground(new java.awt.Color(255, 255, 255));
        jTextField_NomeCategoria_POP.setForeground(new java.awt.Color(51, 51, 51));
        jPanel_Right_NuovoUtente.add(jTextField_NomeCategoria_POP, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, 190, -1));

        jButton_ModificaCat_POP.setBackground(new java.awt.Color(255, 255, 255));
        jButton_ModificaCat_POP.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jButton_ModificaCat_POP.setForeground(new java.awt.Color(51, 51, 51));
        jButton_ModificaCat_POP.setText("Modifica");
        jButton_ModificaCat_POP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_ModificaCat_POPActionPerformed(evt);
            }
        });
        jPanel_Right_NuovoUtente.add(jButton_ModificaCat_POP, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 250, 100, -1));

        jComboBox_Categoria_POP.setBackground(new java.awt.Color(255, 255, 255));
        jComboBox_Categoria_POP.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jComboBox_Categoria_POP.setForeground(new java.awt.Color(51, 51, 51));
        jComboBox_Categoria_POP.setMaximumRowCount(200);
        jComboBox_Categoria_POP.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {}));
        jComboBox_Categoria_POP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_Categoria_POPActionPerformed(evt);
            }
        });
        jPanel_Right_NuovoUtente.add(jComboBox_Categoria_POP, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 190, -1));

        jCheckBox1_Elimina.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jCheckBox1_Elimina.setForeground(new java.awt.Color(51, 51, 51));
        jCheckBox1_Elimina.setText("Eliminare prodotti vecchia categoria?");
        jCheckBox1_Elimina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });
        jPanel_Right_NuovoUtente.add(jCheckBox1_Elimina, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, -1, -1));

        getContentPane().add(jPanel_Right_NuovoUtente, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 0, 270, 300));

        pack();
        setLocationRelativeTo(null);
        
        try {
			populatejComboBox(jComboBox_Categoria_POP, Avalaible_Data.ReadDataByListOfArrayToComboBoxCat(db.SelectCategoria()));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }// </editor-fold>//GEN-END:initComponents
    
    public void populatejComboBox(JComboBox<String> comboBox,String[] items)
    {
    	for (String item : items) {
            comboBox.addItem(item);
        }
    }

    private void jButton_ModificaCat_POPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_ModificaCat_POPActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jButton_ModificaCat_POPActionPerformed

    private void jComboBox_Categoria_POPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_Categoria_POPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox_Categoria_POPActionPerformed

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox1ActionPerformed

    public javax.swing.JCheckBox getjCheckBox1_Elimina() {
		return jCheckBox1_Elimina;
	}

	public void setjCheckBox1_Elimina(javax.swing.JCheckBox jCheckBox1_Elimina) {
		this.jCheckBox1_Elimina = jCheckBox1_Elimina;
	}

	public javax.swing.JComboBox<String> getjComboBox_Categoria_POP() {
		return jComboBox_Categoria_POP;
	}

	public void setjComboBox_Categoria_POP(javax.swing.JComboBox<String> jComboBox_Categoria_POP) {
		this.jComboBox_Categoria_POP = jComboBox_Categoria_POP;
	}

	public javax.swing.JTextField getjTextField_NomeCategoria_POP() {
		return jTextField_NomeCategoria_POP;
	}

	public void setjTextField_NomeCategoria_POP(javax.swing.JTextField jTextField_NomeCategoria_POP) {
		this.jTextField_NomeCategoria_POP = jTextField_NomeCategoria_POP;
	}

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
            java.util.logging.Logger.getLogger(JDialog_ModificaCategoria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JDialog_ModificaCategoria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JDialog_ModificaCategoria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JDialog_ModificaCategoria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JDialog_ModificaCategoria dialog = new JDialog_ModificaCategoria(new javax.swing.JFrame(), true, nomeUtente);
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
    private javax.swing.JButton jButton_ModificaCat_POP;
    private javax.swing.JCheckBox jCheckBox1_Elimina;
    private javax.swing.JComboBox<String> jComboBox_Categoria_POP;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel_Nome_POP;
    private javax.swing.JLabel jLabel_ModificaCat_POP;
    private javax.swing.JLabel jLabel_NuovoNome_POP;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel_Right_NuovoUtente;
    private javax.swing.JTextField jTextField_NomeCategoria_POP;
    // End of variables declaration//GEN-END:variables
}
