package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JOptionPane;

//import GUI.JDialog_AggiungiCategoria;
import GUI.JDialog_AggiungiPersonale;
import GUI.jFrame_Cantiere;
import GUI.jFrame_Personale;
import GUI.jFrame_principale;
import database.DB;
import model.Categoria;
import model.Dipendente;
import model.Dipendente;

public class Controller_Personale implements ActionListener {

	private jFrame_Personale jframe_personale;
	private String nomeUtente;
	private DB db;
	private String NomeDipendente, CognomeDipendente;

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
		openDialogForNuovoDipendente();
	}

	private void jButton_ModificaPersonaleActionPerformed() {
		// AGGIUNGERE FUNZIONE PER MODIFICARE PERSONALE IN DB
	}

	private void jButton_EliminaPersonaleActionPerformed() {
		// AGGIUNGERE FUNZIONE PER ELIMINARE PERSONALE IN DB
	}
	
	// AGGIUNGE NUOVO DIPENDENTE
	private void openDialogForNuovoDipendente() {
				JDialog_AggiungiPersonale Jdialog_aggiungidipendente = new JDialog_AggiungiPersonale(jframe_personale, true);
				Jdialog_aggiungidipendente.setVisible(true);

				String[] parti = Jdialog_aggiungidipendente.getjTextField_Nome_POP().getText().split(" ");
				if (parti.length >= 2) {
		            NomeDipendente = parti[0];
		            CognomeDipendente = parti[1]; // Considera lo spazio tra nome e cognome
		        } else {
		            JOptionPane.showMessageDialog(null, "Inserisci sia il nome che il cognome separati da uno spazio.");
		        }
				if (NomeDipendente.isEmpty()|| CognomeDipendente.isEmpty()) {
					JOptionPane.showMessageDialog(Jdialog_aggiungidipendente, "i campi non possono essere vuoti");
				} else {
					/*addDipendente(NomeDipendente, CognomeDipendente);*/
				}
			}

	/*private void addDipendente(String nomeDipendente2, String cognomeDipendente2) {
		Dipendente prod=new Dipendente(NomeDipendente, PrezzoUnitario, Categoria);
		Categoria cat = new Categoria(Categoria);
		cat.AddProdotto(prod);
		System.out.println(cat.toString());
		db.insertNuovoProdotto(prod);
		
	}*/
			
}

