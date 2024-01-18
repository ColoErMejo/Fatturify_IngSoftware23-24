package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import GUI.jFrame_Cantiere;
import GUI.jFrame_Personale;
import GUI.jFrame_principale;
import database.DB;

public class Controller_Personale implements ActionListener {

	private jFrame_Personale jframe_personale;
	private String nomeUtente;
	private DB db;

	public Controller_Personale(jFrame_Personale jFrame, String NomeUtente) {
		this.jframe_personale = jFrame;
		this.nomeUtente = NomeUtente;
		this.db = new DB(NomeUtente);

		jFrame.getjButton_AddPersonale().addActionListener(this);
		jFrame.getjButton_Back_Pers().addActionListener(this);
		jFrame.getjButton_EliminaPersonale().addActionListener(this);
		jFrame.getjButton_Home_Pers().addActionListener(this);
		jFrame.getjButton_ModificaPersonale().addActionListener(this);
		jFrame.getjTable_Pers_Left();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == jframe_personale.getjButton_AddPersonale())
			jButton_AddPersonaleActionPerformed();
		else if (e.getSource() == jframe_personale.getjButton_Back_Pers())
			jButton_Back_PersActionPerformed();
		else if (e.getSource() == jframe_personale.getjButton_EliminaPersonale())
			jButton_EliminaPersonaleActionPerformed();
		else if (e.getSource() == jframe_personale.getjButton_Home_Pers())
			jButton_Home_PersActionPerformed();
		else if (e.getSource() == jframe_personale.getjButton_ModificaPersonale())
			jButton_ModificaPersonaleActionPerformed();

	}

	private void jButton_Home_PersActionPerformed() {
		jFrame_principale jframe_principale = new jFrame_principale();
		Controller_Principale controller_principale = new Controller_Principale(jframe_principale, nomeUtente);
		System.out.println("jframe_principale.setVisible(true)");
		jframe_principale.setVisible(true);
		jframe_personale.setVisible(false);
	}

	private void jButton_Back_PersActionPerformed() {
		jFrame_principale jframe_principale = new jFrame_principale();
		Controller_Principale controller_principale = new Controller_Principale(jframe_principale, nomeUtente);
		jframe_principale.setVisible(true);
		jframe_personale.setVisible(false);
	}

	private void jButton_AddPersonaleActionPerformed() {
		// AGGIUNGERE FUNZIONE PER SALVARE PERSONALE IN DB
	}

	private void jButton_ModificaPersonaleActionPerformed() {
		// AGGIUNGERE FUNZIONE PER MODIFICARE PERSONALE IN DB
	}

	private void jButton_EliminaPersonaleActionPerformed() {
		// AGGIUNGERE FUNZIONE PER ELIMINARE PERSONALE IN DB
	}

}
