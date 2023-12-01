/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package GUI;

import java.awt.event.ActionEvent;

/**
 *
 * @author Merlo
 */
public class jDialog_NuovoUtente extends javax.swing.JDialog {

    /**
     * Creates new form jDialog_NuovoUtente
     */
    public jDialog_NuovoUtente(java.awt.Frame parent, boolean modal) {
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

        jPanel_Right_NuovoUtente = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel_NuovoUtente_POP = new javax.swing.JLabel();
        jTextField_NomeAzienda_POP = new javax.swing.JTextField();
        jTextField_NomeUtente_POP = new javax.swing.JTextField();
        jButton_AggiungiUtente_POP = new javax.swing.JButton();
        jTextField_Password_POP1 = new javax.swing.JTextField();
        jPanel_Left_NuovoUtente = new javax.swing.JPanel();
        jLabel_NomeAzienda_POP = new javax.swing.JLabel();
        jLabel_NomeUtente_POP = new javax.swing.JLabel();
        jLabel_Password_POP = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Nuovo Utente");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel_Right_NuovoUtente.setBackground(new java.awt.Color(255, 255, 255));
        jPanel_Right_NuovoUtente.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/lineaBlu4.png"))); // NOI18N
        jPanel_Right_NuovoUtente.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-30, 50, -1, -1));

        jLabel_NuovoUtente_POP.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        jLabel_NuovoUtente_POP.setForeground(new java.awt.Color(51, 51, 51));
        jLabel_NuovoUtente_POP.setText("Nuovo Utente");
        jPanel_Right_NuovoUtente.add(jLabel_NuovoUtente_POP, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 200, 30));

        jTextField_NomeAzienda_POP.setBackground(new java.awt.Color(255, 255, 255));
        jTextField_NomeAzienda_POP.setForeground(new java.awt.Color(51, 51, 51));
        jPanel_Right_NuovoUtente.add(jTextField_NomeAzienda_POP, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 190, -1));

        jTextField_NomeUtente_POP.setBackground(new java.awt.Color(255, 255, 255));
        jTextField_NomeUtente_POP.setForeground(new java.awt.Color(51, 51, 51));
        jPanel_Right_NuovoUtente.add(jTextField_NomeUtente_POP, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, 190, -1));

        jButton_AggiungiUtente_POP.setBackground(new java.awt.Color(255, 255, 255));
        jButton_AggiungiUtente_POP.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jButton_AggiungiUtente_POP.setForeground(new java.awt.Color(51, 51, 51));
        jButton_AggiungiUtente_POP.setText("Salva");
        jButton_AggiungiUtente_POP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_AggiungiUtente_POPActionPerformed(evt);
            }
        });
        jPanel_Right_NuovoUtente.add(jButton_AggiungiUtente_POP, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 250, 100, -1));

        jTextField_Password_POP1.setBackground(new java.awt.Color(255, 255, 255));
        jTextField_Password_POP1.setForeground(new java.awt.Color(51, 51, 51));
        jPanel_Right_NuovoUtente.add(jTextField_Password_POP1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, 190, -1));

        getContentPane().add(jPanel_Right_NuovoUtente, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 0, 270, 300));

        jPanel_Left_NuovoUtente.setBackground(new java.awt.Color(0, 153, 255));
        jPanel_Left_NuovoUtente.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel_NomeAzienda_POP.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jLabel_NomeAzienda_POP.setForeground(new java.awt.Color(51, 51, 51));
        jLabel_NomeAzienda_POP.setText("Nome Azienda");
        jPanel_Left_NuovoUtente.add(jLabel_NomeAzienda_POP, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, -1, -1));

        jLabel_NomeUtente_POP.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jLabel_NomeUtente_POP.setForeground(new java.awt.Color(51, 51, 51));
        jLabel_NomeUtente_POP.setText("Nome Utente");
        jPanel_Left_NuovoUtente.add(jLabel_NomeUtente_POP, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, -1, -1));

        jLabel_Password_POP.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jLabel_Password_POP.setForeground(new java.awt.Color(51, 51, 51));
        jLabel_Password_POP.setText("Password");
        jPanel_Left_NuovoUtente.add(jLabel_Password_POP, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, -1, -1));

        getContentPane().add(jPanel_Left_NuovoUtente, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 130, 300));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_AggiungiUtente_POPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_AggiungiUtente_POPActionPerformed
        // TODO add your handling code here:
    	dispose();
    }//GEN-LAST:event_jButton_AggiungiUtente_POPActionPerformed
    
    


    public javax.swing.JButton getjButton_AggiungiUtente_POP() {
		return jButton_AggiungiUtente_POP;
	}

	public void setjButton_AggiungiUtente_POP(javax.swing.JButton jButton_AggiungiUtente_POP) {
		this.jButton_AggiungiUtente_POP = jButton_AggiungiUtente_POP;
	}

	public javax.swing.JTextField getjTextField_NomeAzienda_POP() {
		return jTextField_NomeAzienda_POP;
	}

	public void setjTextField_NomeAzienda_POP(javax.swing.JTextField jTextField_NomeAzienda_POP) {
		this.jTextField_NomeAzienda_POP = jTextField_NomeAzienda_POP;
	}

	public javax.swing.JTextField getjTextField_NomeUtente_POP() {
		return jTextField_NomeUtente_POP;
	}

	public void setjTextField_NomeUtente_POP(javax.swing.JTextField jTextField_NomeUtente_POP) {
		this.jTextField_NomeUtente_POP = jTextField_NomeUtente_POP;
	}

	public javax.swing.JTextField getjTextField_Password_POP1() {
		return jTextField_Password_POP1;
	}

	public void setjTextField_Password_POP1(javax.swing.JTextField jTextField_Password_POP1) {
		this.jTextField_Password_POP1 = jTextField_Password_POP1;
	}

	
	
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_AggiungiUtente_POP;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel_NomeAzienda_POP;
    private javax.swing.JLabel jLabel_NomeUtente_POP;
    private javax.swing.JLabel jLabel_NuovoUtente_POP;
    private javax.swing.JLabel jLabel_Password_POP;
    private javax.swing.JPanel jPanel_Left_NuovoUtente;
    private javax.swing.JPanel jPanel_Right_NuovoUtente;
    private javax.swing.JTextField jTextField_NomeAzienda_POP;
    private javax.swing.JTextField jTextField_NomeUtente_POP;
    private javax.swing.JTextField jTextField_Password_POP1;
    // End of variables declaration//GEN-END:variables
	
}
