package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import GUI.jFrame_Inventario;
import GUI.jFrame_principale;
import database.DB;
import database.DB_Login;

public class Controller_Inventario implements ActionListener {

	private String NomeUtente;
	private DB db;
	private jFrame_Inventario jFrame_inventario;

	public Controller_Inventario(jFrame_Inventario jFrame, String NomeUtente) {
		this.jFrame_inventario = jFrame;
		this.NomeUtente = NomeUtente;
		this.db = new DB(NomeUtente);

		jFrame.getjButton_AddProd().addActionListener(this);
		jFrame.getjButton_Back_Invent().addActionListener(this);
		jFrame.getjButton_ChangeCat1().addActionListener(this);
		jFrame.getjButton_ChangeProd().addActionListener(this);
		jFrame.getjButton_EliminaCat().addActionListener(this);
		jFrame.getjButton_EliminaProd().addActionListener(this);
		jFrame.getjButton_Home_Invent().addActionListener(this);
		jFrame.getjButtonAddCategoria().addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == jFrame_inventario.getjButton_AddProd())
			jButton_AddProdActionPerformed();
		else if (e.getSource() == jFrame_inventario.getjButton_Back_Invent())
			jButton_Back_InventActionPerformed();
		else if (e.getSource() == jFrame_inventario.getjButton_ChangeCat1())
			jButton_ChangeCat1ActionPerformed();
		else if (e.getSource() == jFrame_inventario.getjButton_ChangeProd())
			jButton_ChangeProdActionPerformed();
		else if (e.getSource() == jFrame_inventario.getjButton_EliminaCat())
			jButton_EliminaCatActionPerformed();
		else if (e.getSource() == jFrame_inventario.getjButton_EliminaProd())
			jButton_EliminaProdActionPerformed();
		else if (e.getSource() == jFrame_inventario.getjButton_Home_Invent())
			jButton_Home_InventActionPerformed();
		else if (e.getSource() == jFrame_inventario.getjButtonAddCategoria())
			jButtonAddCategoriaActionPerformed();
	}

	private void jButtonAddCategoriaActionPerformed() {

	}

	private void jButton_Home_InventActionPerformed() {
		jFrame_principale jframe_principale = new jFrame_principale();
		Controller_Principale controller_principale = new Controller_Principale(jframe_principale, NomeUtente);

		jframe_principale.setVisible(true);
		jFrame_inventario.setVisible(false);
		System.out.println("open jframe_principale");
	}

	private void jButton_Back_InventActionPerformed() {
		jFrame_principale jframe_principale = new jFrame_principale();
		Controller_Principale controller_principale = new Controller_Principale(jframe_principale, NomeUtente);

		jframe_principale.setVisible(true);
		jFrame_inventario.setVisible(false);
		System.out.println("open jframe_principale");
	}

	private void jButton_ChangeCat1ActionPerformed() {

	}

	private void jButton_EliminaCatActionPerformed() {

	}

	private void jButton_ChangeProdActionPerformed() {

	}

	private void jButton_AddProdActionPerformed() {

	}

	private void jButton_EliminaProdActionPerformed() {

	}

}
