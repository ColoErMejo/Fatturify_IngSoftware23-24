/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

/**
 *
 * @author Merlo
 */
public class jFrame_Inventario extends javax.swing.JFrame {

    /**
     * Creates new form jFrame_Inventario
     */
    public jFrame_Inventario() {
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

        jPanel_Inventario_Left = new javax.swing.JPanel();
        jButton_Back_Invent = new javax.swing.JButton();
        jButton_Home_Invent = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_InvProd_Bot = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable_InvCat_Top = new javax.swing.JTable();
        jPanel_Inventario_Right = new javax.swing.JPanel();
        jButton_AddProd = new javax.swing.JButton();
        jButton_EliminaCat = new javax.swing.JButton();
        jButtonAddCategoria = new javax.swing.JButton();
        jButton_ChangeProd = new javax.swing.JButton();
        jButton_ChangeCat1 = new javax.swing.JButton();
        jButton_EliminaProd = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel_Inventario_Left.setBackground(new java.awt.Color(0, 153, 255));
        jPanel_Inventario_Left.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton_Back_Invent.setBackground(new java.awt.Color(0, 153, 255));
        jButton_Back_Invent.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/Back.png"))); // NOI18N
        jButton_Back_Invent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_Back_InventActionPerformed(evt);
            }
        });
        jPanel_Inventario_Left.add(jButton_Back_Invent, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 10, -1, -1));

        jButton_Home_Invent.setBackground(new java.awt.Color(0, 153, 255));
        jButton_Home_Invent.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/Home.png"))); // NOI18N
        jButton_Home_Invent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_Home_InventActionPerformed(evt);
            }
        });
        jPanel_Inventario_Left.add(jButton_Home_Invent, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));

        jTable_InvProd_Bot.setBackground(new java.awt.Color(255, 255, 255));
        jTable_InvProd_Bot.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome", "Costo Unitario", "Produttore", "Paga Oraria"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable_InvProd_Bot);

        jPanel_Inventario_Left.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 340, -1, 230));

        jScrollPane2.setBackground(new java.awt.Color(255, 255, 255));

        jTable_InvCat_Top.setBackground(new java.awt.Color(255, 255, 255));
        jTable_InvCat_Top.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Categoria", "Numero Prodotti"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTable_InvCat_Top);

        jPanel_Inventario_Left.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, -1, 230));

        getContentPane().add(jPanel_Inventario_Left, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 500, 600));

        jPanel_Inventario_Right.setBackground(new java.awt.Color(255, 255, 255));
        jPanel_Inventario_Right.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton_AddProd.setBackground(new java.awt.Color(255, 255, 255));
        jButton_AddProd.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jButton_AddProd.setForeground(new java.awt.Color(51, 51, 51));
        jButton_AddProd.setText("Aggiungi Prodotto");
        jButton_AddProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_AddProdActionPerformed(evt);
            }
        });
        jPanel_Inventario_Right.add(jButton_AddProd, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 250, 160, -1));

        jButton_EliminaCat.setBackground(new java.awt.Color(255, 255, 255));
        jButton_EliminaCat.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jButton_EliminaCat.setForeground(new java.awt.Color(51, 51, 51));
        jButton_EliminaCat.setText("Elimina Categoria");
        jButton_EliminaCat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_EliminaCatActionPerformed(evt);
            }
        });
        jPanel_Inventario_Right.add(jButton_EliminaCat, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 300, 160, -1));

        jButtonAddCategoria.setBackground(new java.awt.Color(255, 255, 255));
        jButtonAddCategoria.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jButtonAddCategoria.setForeground(new java.awt.Color(51, 51, 51));
        jButtonAddCategoria.setText("Aggiungi Categoria");
        jButtonAddCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddCategoriaActionPerformed(evt);
            }
        });
        jPanel_Inventario_Right.add(jButtonAddCategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 200, 160, -1));

        jButton_ChangeProd.setBackground(new java.awt.Color(255, 255, 255));
        jButton_ChangeProd.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jButton_ChangeProd.setForeground(new java.awt.Color(51, 51, 51));
        jButton_ChangeProd.setText("Modifica Prodotto");
        jButton_ChangeProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_ChangeProdActionPerformed(evt);
            }
        });
        jPanel_Inventario_Right.add(jButton_ChangeProd, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 200, 160, -1));

        jButton_ChangeCat1.setBackground(new java.awt.Color(255, 255, 255));
        jButton_ChangeCat1.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jButton_ChangeCat1.setForeground(new java.awt.Color(51, 51, 51));
        jButton_ChangeCat1.setText("Modifica Categoria");
        jButton_ChangeCat1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_ChangeCat1ActionPerformed(evt);
            }
        });
        jPanel_Inventario_Right.add(jButton_ChangeCat1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 250, 160, -1));

        jButton_EliminaProd.setBackground(new java.awt.Color(255, 255, 255));
        jButton_EliminaProd.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jButton_EliminaProd.setForeground(new java.awt.Color(51, 51, 51));
        jButton_EliminaProd.setText("Elimina Prodotto");
        jButton_EliminaProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_EliminaProdActionPerformed(evt);
            }
        });
        jPanel_Inventario_Right.add(jButton_EliminaProd, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 300, 160, -1));

        getContentPane().add(jPanel_Inventario_Right, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 0, 500, 600));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAddCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddCategoriaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonAddCategoriaActionPerformed

    private void jButton_Home_InventActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Home_InventActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton_Home_InventActionPerformed

    private void jButton_Back_InventActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Back_InventActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton_Back_InventActionPerformed

    private void jButton_ChangeCat1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_ChangeCat1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton_ChangeCat1ActionPerformed

    private void jButton_EliminaCatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_EliminaCatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton_EliminaCatActionPerformed

    private void jButton_ChangeProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_ChangeProdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton_ChangeProdActionPerformed

    private void jButton_AddProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_AddProdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton_AddProdActionPerformed

    private void jButton_EliminaProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_EliminaProdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton_EliminaProdActionPerformed

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
            java.util.logging.Logger.getLogger(jFrame_Inventario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(jFrame_Inventario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(jFrame_Inventario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(jFrame_Inventario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new jFrame_Inventario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAddCategoria;
    private javax.swing.JButton jButton_AddProd;
    private javax.swing.JButton jButton_Back_Invent;
    private javax.swing.JButton jButton_ChangeCat1;
    private javax.swing.JButton jButton_ChangeProd;
    private javax.swing.JButton jButton_EliminaCat;
    private javax.swing.JButton jButton_EliminaProd;
    private javax.swing.JButton jButton_Home_Invent;
    private javax.swing.JPanel jPanel_Inventario_Left;
    private javax.swing.JPanel jPanel_Inventario_Right;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable_InvCat_Top;
    private javax.swing.JTable jTable_InvProd_Bot;
    // End of variables declaration//GEN-END:variables
}
