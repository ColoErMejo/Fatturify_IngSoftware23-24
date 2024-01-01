package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import GUI.JDialog_AggiungiProdotto;
import GUI.JDialog_EliminaProdotto;
import GUI.jFrame_Inventario;
import GUI.jFrame_principale;
import database.DB;
import database.DB_Login;
import model.Categoria;
import model.Prodotto;

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
		JDialog_AggiungiProdotto Jdialog_aggiungiprodotto = new JDialog_AggiungiProdotto(jFrame_inventario, true, NomeUtente);
		Jdialog_aggiungiprodotto.setVisible(true);
		
		String NomeProdotto = Jdialog_aggiungiprodotto.getjTextField_Nome_POP().getText().trim();
		String PrezzoUnitario = Jdialog_aggiungiprodotto.getjTextFieldPrezzo_POP().getText().trim();
		String Categoria = Jdialog_aggiungiprodotto.getjComboBox_Categoria_POP().getSelectedItem().toString();

		boolean ERROR = false;
		if (NomeProdotto.isEmpty()) {
			JOptionPane.showMessageDialog(Jdialog_aggiungiprodotto, "i campi non possono essere vuoti");
			ERROR = true;
		} else if (PrezzoUnitario.isEmpty()) {
			JOptionPane.showMessageDialog(Jdialog_aggiungiprodotto, "i campi non possono essere vuoti");
			ERROR = true;
		} else if (Categoria.isEmpty()) {
			JOptionPane.showMessageDialog(Jdialog_aggiungiprodotto, "i campi non possono essere vuoti");
			ERROR = true;
		}
		if (!ERROR) {
			boolean errorFloat = true;
			try {
				float PrezzoUnitarioFloat = Float.parseFloat(PrezzoUnitario);
				System.out.println(NomeProdotto + PrezzoUnitarioFloat + Categoria);
				errorFloat = false;
				addProdotto(NomeProdotto, PrezzoUnitarioFloat, Categoria);
			} catch (ArithmeticException e) {
				e.printStackTrace();
			} finally {
				if (errorFloat) {
					JOptionPane.showMessageDialog(Jdialog_aggiungiprodotto, "il costo deve essere un numero");
				}
			}
		}

	}

	private void jButton_EliminaProdActionPerformed() {
		JDialog_EliminaProdotto Jdialog_eliminaprodotto = new JDialog_EliminaProdotto(jFrame_inventario, true, NomeUtente);
		Jdialog_eliminaprodotto.setVisible(true);
		

	}
	
	
	private void addProdotto(String NomeProdotto, float PrezzoUnitario, String Categoria) {
		// SALVARE IN DB
		Prodotto prod=new Prodotto(NomeProdotto, PrezzoUnitario, Categoria);
		Categoria cat = new Categoria(Categoria);
		cat.AddProdotto(prod);
		System.out.println(cat.toString());
		db.insertNuovoProdotto(prod);
		System.out.println("prodotto" + prod.toString() + " inserito correttamente nel db");
	}
	
	  


}
