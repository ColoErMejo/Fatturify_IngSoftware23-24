/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import java.sql.SQLException;

import controller.Return_Avalaible_Data;
import database.DB;

/**
 *
 * @author Merlo
 */
public class jFrame_Inventario extends javax.swing.JFrame {

	/**
	 * Creates new form jFrame_Inventario
	 */
	private String nomeUtente;
	private Return_Avalaible_Data Return_avalaible_data = new Return_Avalaible_Data();
	private DB db;
	
	public jFrame_Inventario(String nomeUtente) {
		this.nomeUtente=nomeUtente;
		this.db=new DB(nomeUtente);
		initComponents();
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated
	
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
       
        jPanel_Inventario_Left.add(jButton_Back_Invent, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 10, -1, -1));

        jButton_Home_Invent.setBackground(new java.awt.Color(0, 153, 255));
        jButton_Home_Invent.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/Home.png"))); // NOI18N
        
        jPanel_Inventario_Left.add(jButton_Home_Invent, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));

        jTable_InvProd_Bot.setBackground(new java.awt.Color(255, 255, 255));
        jTable_InvProd_Bot.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome", "Costo Unitario", "Categoria"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
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
        
        jPanel_Inventario_Right.add(jButton_AddProd, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 200, 160, -1));

        jButton_EliminaCat.setBackground(new java.awt.Color(255, 255, 255));
        jButton_EliminaCat.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jButton_EliminaCat.setForeground(new java.awt.Color(51, 51, 51));
        jButton_EliminaCat.setText("Elimina Categoria");
        
        jPanel_Inventario_Right.add(jButton_EliminaCat, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 300, 160, -1));

        jButtonAddCategoria.setBackground(new java.awt.Color(255, 255, 255));
        jButtonAddCategoria.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jButtonAddCategoria.setForeground(new java.awt.Color(51, 51, 51));
        jButtonAddCategoria.setText("Aggiungi Categoria");
        
        jPanel_Inventario_Right.add(jButtonAddCategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 200, 160, -1));

        jButton_ChangeProd.setBackground(new java.awt.Color(255, 255, 255));
        jButton_ChangeProd.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jButton_ChangeProd.setForeground(new java.awt.Color(51, 51, 51));
        jButton_ChangeProd.setText("Modifica Prodotto");
       
        jPanel_Inventario_Right.add(jButton_ChangeProd, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 250, 160, -1));

        jButton_ChangeCat1.setBackground(new java.awt.Color(255, 255, 255));
        jButton_ChangeCat1.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jButton_ChangeCat1.setForeground(new java.awt.Color(51, 51, 51));
        jButton_ChangeCat1.setText("Modifica Categoria");
       
        jPanel_Inventario_Right.add(jButton_ChangeCat1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 250, 160, -1));

        jButton_EliminaProd.setBackground(new java.awt.Color(255, 255, 255));
        jButton_EliminaProd.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jButton_EliminaProd.setForeground(new java.awt.Color(51, 51, 51));
        jButton_EliminaProd.setText("Elimina Prodotto");
        
        jPanel_Inventario_Right.add(jButton_EliminaProd, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 300, 160, -1));

        getContentPane().add(jPanel_Inventario_Right, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 0, 500, 600));

        pack();
        setLocationRelativeTo(null);
        
        try {
			Return_avalaible_data.populateTable(jTable_InvCat_Top, Return_avalaible_data.DataPerCategoriaTable(db.SelectCategoria()));
			System.out.println("tabella categorie popolata con successo");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Return_avalaible_data.populateTable(jTable_InvProd_Bot, db.SelectProdotto());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
    }
	
	/*
	try {
			Return_avalaible_data.populateTable(jTable_InvCat_Top, Return_avalaible_data.DataPerCategoriaTable(db.SelectCategoria()));
			System.out.println("tabella categorie popolata con successo");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Return_avalaible_data.populateTable(jTable_InvProd_Bot, db.SelectProdotto());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	*/
	public javax.swing.JButton getjButtonAddCategoria() {
		return jButtonAddCategoria;
	}

	public javax.swing.JTable getjTable_InvCat_Top() {
		return jTable_InvCat_Top;
	}

	public void setjTable_InvCat_Top(javax.swing.JTable jTable_InvCat_Top) {
		this.jTable_InvCat_Top = jTable_InvCat_Top;
	}

	public javax.swing.JTable getjTable_InvProd_Bot() {
		return jTable_InvProd_Bot;
	}

	public void setjTable_InvProd_Bot(javax.swing.JTable jTable_InvProd_Bot) {
		this.jTable_InvProd_Bot = jTable_InvProd_Bot;
	}

	public void setjButtonAddCategoria(javax.swing.JButton jButtonAddCategoria) {
		this.jButtonAddCategoria = jButtonAddCategoria;
	}

	public javax.swing.JButton getjButton_AddProd() {
		return jButton_AddProd;
	}

	public void setjButton_AddProd(javax.swing.JButton jButton_AddProd) {
		this.jButton_AddProd = jButton_AddProd;
	}

	public javax.swing.JButton getjButton_Back_Invent() {
		return jButton_Back_Invent;
	}

	public void setjButton_Back_Invent(javax.swing.JButton jButton_Back_Invent) {
		this.jButton_Back_Invent = jButton_Back_Invent;
	}

	public javax.swing.JButton getjButton_ChangeCat1() {
		return jButton_ChangeCat1;
	}

	public void setjButton_ChangeCat1(javax.swing.JButton jButton_ChangeCat1) {
		this.jButton_ChangeCat1 = jButton_ChangeCat1;
	}

	public javax.swing.JButton getjButton_ChangeProd() {
		return jButton_ChangeProd;
	}

	public void setjButton_ChangeProd(javax.swing.JButton jButton_ChangeProd) {
		this.jButton_ChangeProd = jButton_ChangeProd;
	}

	public javax.swing.JButton getjButton_EliminaCat() {
		return jButton_EliminaCat;
	}

	public void setjButton_EliminaCat(javax.swing.JButton jButton_EliminaCat) {
		this.jButton_EliminaCat = jButton_EliminaCat;
	}

	public javax.swing.JButton getjButton_EliminaProd() {
		return jButton_EliminaProd;
	}

	public void setjButton_EliminaProd(javax.swing.JButton jButton_EliminaProd) {
		this.jButton_EliminaProd = jButton_EliminaProd;
	}

	public javax.swing.JButton getjButton_Home_Invent() {
		return jButton_Home_Invent;
	}

	public void setjButton_Home_Invent(javax.swing.JButton jButton_Home_Invent) {
		this.jButton_Home_Invent = jButton_Home_Invent;
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
