package fatturify_controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JOptionPane;

//import GUI.JDialog_AggiungiCategoria;
import GUI.JDialog_AggiungiPersonale;
import GUI.JDialog_EliminaCategoria;
import GUI.JDialog_EliminaPersonale;
import GUI.JDialog_ModificaPersonale;
import GUI.JDialog_ModificaProdotto;
import GUI.jFrame_Cantiere;
import GUI.jFrame_Personale;
import GUI.jFrame_principale;
import fatturify_database.DB;
import fatturify_model.Categoria;
import fatturify_model.Dipendente;

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
		JDialog_AggiungiPersonale Jdialog_aggiungidipendente = new JDialog_AggiungiPersonale(jframe_personale, true);
		Jdialog_aggiungidipendente.setVisible(true);
		String[] parti = Jdialog_aggiungidipendente.getjTextField_Nome_POP().getText().split(" ");
		String Mansione = Jdialog_aggiungidipendente.getjTextField_Mansione_POP().getText();
		float PagaOraria = Float.parseFloat(Jdialog_aggiungidipendente.getjTextField_Paga_POP().getText());
		if (parti.length >= 2) {
            NomeDipendente = parti[0];
            CognomeDipendente = parti[1]; // Considera lo spazio tra nome e cognome
        } else {
            JOptionPane.showMessageDialog(null, "Inserisci sia il nome che il cognome separati da uno spazio.");
        }
		
		 if(Jdialog_aggiungidipendente.flag==true) {
			 if (NomeDipendente.isEmpty()|| CognomeDipendente.isEmpty()|| Mansione.isEmpty() || PagaOraria==0 ) {
					JOptionPane.showMessageDialog(Jdialog_aggiungidipendente, "i campi non possono essere vuoti");
				} else {
					addDipendente(NomeDipendente, CognomeDipendente, Mansione, PagaOraria);
					if(jframe_personale!=null) {
						jframe_personale.aggiornaTabPers();
					}
				}
		 }
	}

	private void jButton_ModificaPersonaleActionPerformed() {
		if(db.isTableEmpty("PERSONALE")) {
			JOptionPane.showMessageDialog(jframe_personale, "Nessun Dipendente inserito nel DB");
		} else {
		JDialog_ModificaPersonale Jdialog_modificapersonale = new JDialog_ModificaPersonale(jframe_personale, true, nomeUtente);
		Jdialog_modificapersonale.setVisible(true);
		
		String NomeDipendente = Jdialog_modificapersonale.getjComboBox_Personale_POP().getSelectedItem().toString();
		String Mansione = Jdialog_modificapersonale.getjTextField_Mansione_POP().getText();
		String PagaOraria = Jdialog_modificapersonale.getjTextField_NuovaPagaOraria_POP().getText();
		
		String[] parti = NomeDipendente.split(" ");
		String nome = null;
		String cognome = null;

        if (parti.length == 2) {
            nome = parti[0]; // Prima parte come nome
            cognome = parti[1]; // Seconda parte come cognome
        }
		
        System.out.println("split corretto: " + nome + cognome);
        if(Jdialog_modificapersonale.flag==true) {
		boolean ERROR = false;
		if (NomeDipendente.isEmpty()) {
			JOptionPane.showMessageDialog(Jdialog_modificapersonale, "i campi non possono essere vuoti");
			ERROR = true;
		} else if (Mansione.isEmpty()) {
			JOptionPane.showMessageDialog(Jdialog_modificapersonale, "i campi non possono essere vuoti");
			ERROR = true;
		}
		if (!ERROR) {
			boolean errorFloat = true;
			try {
				float PagaOrariaFloat = Float.parseFloat(PagaOraria);
				System.out.println(NomeDipendente +" "+ Mansione+ " " + PagaOrariaFloat);
				errorFloat = false;
				modificaDipendente(nome, cognome, Mansione, PagaOrariaFloat);
				if(jframe_personale!=null) {
					jframe_personale.aggiornaTabPers();
				}
			} catch (ArithmeticException e) {
				e.printStackTrace();
			} finally {
				if (errorFloat) {
					JOptionPane.showMessageDialog(Jdialog_modificapersonale, "la paga deve essere un numero");
				}
			}
		}
        }		
	}
}
	// FUNZIONE PER ELIMINARE PERSONALE DAL DB
	private void jButton_EliminaPersonaleActionPerformed() {
		if(db.isTableEmpty("PERSONALE")) {
			JOptionPane.showMessageDialog(jframe_personale, "Nessun Dipendente inserito nel DB");
		} else {
		JDialog_EliminaPersonale Jdialog_eliminapersonale = new JDialog_EliminaPersonale(jframe_personale, true, nomeUtente);
		Jdialog_eliminapersonale.setVisible(true);
		
		String Personale = Jdialog_eliminapersonale.getjComboBox_EliminaPersonale_POP().getSelectedItem().toString();
		String[] parti = Personale.split(" ");
		String nome = null;
		String cognome = null;

        if (parti.length == 2) {
            nome = parti[0]; // Prima parte come nome
            cognome = parti[1]; // Seconda parte come cognome
        }
		
        System.out.println("split corretto: " + nome + cognome);
		if(Jdialog_eliminapersonale.flag==true) {
		boolean ERROR = false;
		if (nome.isEmpty() || cognome.isEmpty()) {
			JOptionPane.showMessageDialog(Jdialog_eliminapersonale, "Selezionare un Dipendente");
			ERROR = true;
		}
		if (!ERROR) {
			try {
				System.out.println(Personale);
				eliminaDipendente(nome, cognome);
				if(jframe_personale!=null) {
					jframe_personale.aggiornaTabPers();
				}
				
			} catch (ArithmeticException e) {
				e.printStackTrace();
				}
			}
		}

		}
	}
	

	private void addDipendente(String nomeDipendente2, String cognomeDipendente2, String mansione2, float paga2) {
		Dipendente dip=new Dipendente(NomeDipendente, CognomeDipendente, mansione2, paga2);
		System.out.println(dip.toString());
		db.insertNuovoDipendente(dip);
		db.updateColonnaPopolata(nomeUtente, "PERSONALE");
		
	}
	
	private void modificaDipendente(String Nome, String Cognome, String nuovaMansione, float nuovaPagaOraria) {
	    // Recuperare il dipendente esistente dal database
		Dipendente dip = null;
		dip = db.recuperaDipendentePerNome(Nome, Cognome);

	    System.out.println("dip in modificadipendente: "+dip.toString());

	    if (dip != null) {
	        // Il Dipendente esiste già nel database
	        dip.setMansione(nuovaMansione);
	        dip.setPaga(nuovaPagaOraria);
	        // Esegui la modifica del nuovo prodotto nel database
	        db.changeDipendente(Nome, Cognome, nuovaMansione, nuovaPagaOraria);
	        
	        System.out.println("Modifica completata: " + dip.toString());
	    }
	}
	
	private void eliminaDipendente(String nome, String cognome) {
		db.deleteDipendente(nome, cognome);
		db.updateColonnaPopolata(nomeUtente, "PERSONALE");
		
	}
			
}

