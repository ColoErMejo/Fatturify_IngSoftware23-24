package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.event.ChangeListener;

import GUI.jFrame_Cantiere;
import GUI.jFrame_fattura;
import GUI.jFrame_principale;
import database.DB;

public class Controller_Fattura implements ActionListener {

	private jFrame_fattura jframe_fattura = new jFrame_fattura();
	private String NomeUtente;
	private String NomeCantiere;
	private DB db;

	public Controller_Fattura(jFrame_fattura jFrame, String NomeUtente, String NomeCantiere) {
		this.jframe_fattura = jFrame;
		this.NomeUtente = NomeUtente;
		this.NomeCantiere = NomeCantiere;
		this.db = new DB(NomeUtente);

		jFrame.getjButton1().addActionListener(this);
		jFrame.getjButton_Back_Fattura().addActionListener(this);
		jFrame.getjButton_Home_Fattura().addActionListener(this);
		// jFrame.getjSlider1().addChangeListener((ChangeListener) this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == jframe_fattura.getjButton1())
			jButton1ActionPerformed();
		else if (e.getSource() == jframe_fattura.getjButton_Back_Fattura())
			jButton_Back_FatturaActionPerformed();
		else if (e.getSource() == jframe_fattura.getjButton_Home_Fattura())
			jButton_Home_FatturaActionPerformed();
	}

	// EXPORT TXT SU DESKTOP
	private void jButton1ActionPerformed() {

	}

	private void jButton_Home_FatturaActionPerformed() {
		jFrame_principale jframe_principale = new jFrame_principale();
		Controller_Principale controller_principale = new Controller_Principale(jframe_principale, NomeUtente);
		jframe_principale.setVisible(true);
		jframe_fattura.setVisible(false);
	}

	// DA RIVEDERE E IMPLEMENTARE CON DB
	private void jButton_Back_FatturaActionPerformed() {
		jFrame_Cantiere jframe_cantiere = new jFrame_Cantiere(NomeCantiere);
		Controller_Cantiere Controller_cantiere = new Controller_Cantiere(jframe_cantiere, NomeUtente, NomeCantiere);
		jframe_cantiere.setVisible(true);
		jframe_fattura.setVisible(false);
	}

}
