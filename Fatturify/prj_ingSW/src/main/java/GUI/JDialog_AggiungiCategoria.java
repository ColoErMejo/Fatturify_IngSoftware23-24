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
public class JDialog_AggiungiCategoria extends javax.swing.JDialog {
	public boolean flag=false;

    /**
     * Creates new form JDialog_AggiungiCategoria
     */
    public JDialog_AggiungiCategoria(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        
        jButton_AggiungiCat_POP.addActionListener(new ActionListener() {
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
        jLabel_NomeCat_POP = new javax.swing.JLabel();
        jPanel_Right_NuovoUtente = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel_NuovaCat_POP = new javax.swing.JLabel();
        jTextField_NomeCat_POP = new javax.swing.JTextField();
        jButton_AggiungiCat_POP = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(0, 153, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel_NomeCat_POP.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jLabel_NomeCat_POP.setForeground(new java.awt.Color(51, 51, 51));
        jLabel_NomeCat_POP.setText("Nome Categoria");
        jPanel2.add(jLabel_NomeCat_POP, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, -1, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 130, 300));

        jPanel_Right_NuovoUtente.setBackground(new java.awt.Color(255, 255, 255));
        jPanel_Right_NuovoUtente.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/lineaBlu4.png"))); // NOI18N
        jPanel_Right_NuovoUtente.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-30, 50, -1, -1));

        jLabel_NuovaCat_POP.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        jLabel_NuovaCat_POP.setForeground(new java.awt.Color(51, 51, 51));
        jLabel_NuovaCat_POP.setText("Nuova Categoria");
        jPanel_Right_NuovoUtente.add(jLabel_NuovaCat_POP, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 200, 30));

        jTextField_NomeCat_POP.setBackground(new java.awt.Color(255, 255, 255));
        jTextField_NomeCat_POP.setForeground(new java.awt.Color(51, 51, 51));
        jPanel_Right_NuovoUtente.add(jTextField_NomeCat_POP, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 190, -1));

        jButton_AggiungiCat_POP.setBackground(new java.awt.Color(255, 255, 255));
        jButton_AggiungiCat_POP.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jButton_AggiungiCat_POP.setForeground(new java.awt.Color(51, 51, 51));
        jButton_AggiungiCat_POP.setText("Salva");
        jButton_AggiungiCat_POP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_AggiungiCat_POPActionPerformed(evt);
            }
        });
        jPanel_Right_NuovoUtente.add(jButton_AggiungiCat_POP, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 250, 100, -1));

        getContentPane().add(jPanel_Right_NuovoUtente, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 0, 270, 300));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_AggiungiCat_POPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_AggiungiCat_POPActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jButton_AggiungiCat_POPActionPerformed

    

    public javax.swing.JButton getjButton_AggiungiCat_POP() {
		return jButton_AggiungiCat_POP;
	}

	public void setjButton_AggiungiCat_POP(javax.swing.JButton jButton_AggiungiCat_POP) {
		this.jButton_AggiungiCat_POP = jButton_AggiungiCat_POP;
	}

	public javax.swing.JTextField getjTextField_NomeCat_POP() {
		return jTextField_NomeCat_POP;
	}

	public void setjTextField_NomeCat_POP(javax.swing.JTextField jTextField_NomeCat_POP) {
		this.jTextField_NomeCat_POP = jTextField_NomeCat_POP;
	}



	// Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_AggiungiCat_POP;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel_NomeCat_POP;
    private javax.swing.JLabel jLabel_NuovaCat_POP;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel_Right_NuovoUtente;
    private javax.swing.JTextField jTextField_NomeCat_POP;
    // End of variables declaration//GEN-END:variables
}
