package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import GUI.JDialog_AggiungiCategoria;
import GUI.JDialog_AggiungiProdotto;
import GUI.jFrame_Cantiere;
import GUI.jFrame_fattura;
import GUI.jFrame_principale;
import database.DB;
import model.Categoria;
import model.Prodotto;

public class Controller_Cantiere implements ActionListener {

	private jFrame_Cantiere jframe_cantiere;
	private String NomeUtente;
	private String NomeCantiere;
	private DB db;
	

	public Controller_Cantiere(jFrame_Cantiere jFrame, String NomeUtente, String NomeCantiere) {
		this.jframe_cantiere = jFrame;
		this.NomeCantiere = NomeCantiere;
		this.NomeUtente = NomeUtente;
		this.db = new DB(NomeUtente);

		jFrame.getjButton_Aggiungi_Cant().addActionListener(this);
		jFrame.getjButton_NuovoProd_Cant().addActionListener(this);
		jFrame.getjButton_ToFAttura_Cant().addActionListener(this);
		jFrame.getjButton_Back_Cant().addActionListener(this);
		jFrame.getjButton_Home_Cant().addActionListener(this);
		jFrame.getjComboBox_Categoria_Cant().addActionListener(this);
		jFrame.getjComboBox_Prodotto_Cant().addActionListener(this);
		jFrame.getjComboBox_Pers_Cant().addActionListener(this);
		jFrame.getjButton_NuovaCat_Cant().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == jframe_cantiere.getjButton_Aggiungi_Cant())
			jButton_Aggiungi_CantActionPerformed();
		else if (e.getSource() == jframe_cantiere.getjButton_NuovoProd_Cant())
			jButton_NuovoProd_CantActionPerformed();
		else if (e.getSource() == jframe_cantiere.getjButton_Back_Cant())
			jButton_Back_CantActionPerformed();
		else if (e.getSource() == jframe_cantiere.getjComboBox_Categoria_Cant())
			jComboBox_Categoria_CantActionPerformed();
		else if (e.getSource() == jframe_cantiere.getjComboBox_Prodotto_Cant())
			jComboBox_Prodotto_CantActionPerformed();
		else if (e.getSource() == jframe_cantiere.getjComboBox_Pers_Cant())
			jComboBox_Pers_CantActionPerformed();
		else if (e.getSource() == jframe_cantiere.getjButton_Home_Cant())
			jButton_Home_CantActionPerformed();
		else if (e.getSource() == jframe_cantiere.getjButton_ToFAttura_Cant())
			jButton_ToFAttura_CantActionPerformed();
		else if (e.getSource() == jframe_cantiere.getjButton_NuovaCat_Cant())
			jButton_NuovaCat_CantActionPerformed();
	}

	// SALVA NEL DB I DATI INSERITI DAL UTENTE
	private void jButton_Aggiungi_CantActionPerformed() {

		// IMPORT VALORI SCRITTI DA UTENTE
		String CategoriaSelezionata = jframe_cantiere.getjComboBox_Categoria_Cant().getSelectedItem().toString();
		String ProdottoSelezionato = jframe_cantiere.getjComboBox_Prodotto_Cant().getSelectedItem().toString();
		String PersonaleSelezionato = jframe_cantiere.getjComboBox_Pers_Cant().getSelectedItem().toString();
		String QuantitaSelezionata = jframe_cantiere.getjTextField_Quantita_Cant().getText().strip();
		String NoreSelezionate = jframe_cantiere.getjTextField_Nore_Cant().getText().strip();
		String Descrizione = jframe_cantiere.getjTextField_Descrizione_Cant().getText().strip();

		// CONTROLLI ED AGGIUNTA A DB
		if (checkInserimento(QuantitaSelezionata)) {
			if (textIsFloat(QuantitaSelezionata)) {
				float QuantitaSelezionataFloat = textTurnIntoFloat(QuantitaSelezionata);
				addProdottoToCantiere(jframe_cantiere.getNomeCantiere(), CategoriaSelezionata, ProdottoSelezionato,
						QuantitaSelezionataFloat);
				System.out.println(jframe_cantiere.getNomeCantiere() + " - " + CategoriaSelezionata + " - "
						+ ProdottoSelezionato + " - " + QuantitaSelezionataFloat + " - ");
			}
		}
		if (checkInserimento(NoreSelezionate)) {
			if (textIsFloat(NoreSelezionate)) {
				float NoreSelezionateFloat = textTurnIntoFloat(NoreSelezionate);
				addProdottoToCantiere(jframe_cantiere.getNomeCantiere(), PersonaleSelezionato, Descrizione,
						NoreSelezionateFloat);
				System.out.println(jframe_cantiere.getNomeCantiere() + " - " + PersonaleSelezionato + " - "
						+ Descrizione + " - " + NoreSelezionateFloat + " - ");
			}
		}
	}

	// FA CAST DA STRING A FLOAT
	private float textTurnIntoFloat(String string) {
		float valueFloat = Float.parseFloat(string);
		return valueFloat;
	}

	// CONTROLLA SE UNA STRINGA è COMPOSTA SOLO DA NUMERI CON GESTIONE DEGLI ERRORI
	private boolean textIsFloat(String string) {
		boolean errorFloat = false;
		try {
			float valueFloat = Float.parseFloat(string);
			// System.out.println(valueFloat);
			errorFloat = true;
		} catch (ArithmeticException e) {
			e.printStackTrace();
		} finally {
			if (!errorFloat) {
				JOptionPane.showMessageDialog(jframe_cantiere,
						"la quantità o il numero delle ore deve essere un numero");
			}
		}
		return errorFloat;
	}

	// CONTROLLA SE UN CAMPO è STATO COMPILATO OVVERO SE UNA STRINGA è VUOTA
	private boolean checkInserimento(String string) {
		boolean inserimento = true;
		if (string.isEmpty())
			inserimento = false;
		return inserimento;
	}

	// FUNZIONE PER SALVARE NEL DB I DATI RELATIVI ALLE ATTIVITà SVOLTE NEL CANTIERE
	// ---- DA FARE----
	private void addProdottoToCantiere(String NomeCantiere, String Categoria_Personale, String prodotto_desc,
			float quantita_Nore) {
		
	}

	// DOPO AVER SCELTO CATEGORIA SETTA VISIBILE IL COMBOBOX DEI PRODOTTI
	private void jComboBox_Categoria_CantActionPerformed() {
		String CategoriaSelezionata = jframe_cantiere.getjComboBox_Categoria_Cant().getSelectedItem().toString();
		jframe_cantiere.comboBoxvisible(jframe_cantiere.getjComboBox_Prodotto_Cant());
	}

	// DOPO AVER SCELTO PRODOTTO SETTA VISIBILE IL JFIEDLTEXT DELLA QUANTITA
	private void jComboBox_Prodotto_CantActionPerformed() {
		String ProdottoSelezionato = jframe_cantiere.getjComboBox_Prodotto_Cant().getSelectedItem().toString();
		jframe_cantiere.jLablevisible(jframe_cantiere.getjLabel_Quantita_Cant(),
				jframe_cantiere.getjTextField_Quantita_Cant());
	}

	// DOPO AVER SCELTO PERSONALE SETTA VISIBILE IL JFIEDLTEXT DELLE ORE
	private void jComboBox_Pers_CantActionPerformed() {
		String PersonaleSelezionato = jframe_cantiere.getjComboBox_Pers_Cant().getSelectedItem().toString();
		jframe_cantiere.jLablevisible(jframe_cantiere.getjLabel_Nore_Cant(), jframe_cantiere.getjTextField_Nore_Cant());
		jframe_cantiere.jLablevisible(jframe_cantiere.getjLabel_Descrizione_Cant(),
				jframe_cantiere.getjTextField_Descrizione_Cant());
	}

	// APRE DIALOG E CREA UNA NUOCA CATEGORIA
	private void jButton_NuovaCat_CantActionPerformed() {
		openDialogForNuovaCategoria();
	}

	// APRE DIALOG E AGGIUNGE UN PRODOTTO AD UNA CATEGORIA GIA ESISTENTE
	private void jButton_NuovoProd_CantActionPerformed() {
		openDialogForNuovoProdotto();
	}

	// PASSA A FRAME FATTURA
	private void jButton_ToFAttura_CantActionPerformed() {
		jFrame_fattura jframe_fattura = new jFrame_fattura();
		Controller_Fattura controller_fattura = new Controller_Fattura(jframe_fattura, NomeUtente, NomeCantiere);
		jframe_fattura.setVisible(true);
		jframe_cantiere.setVisible(false);
		System.out.println("open jframe_fattura");
	}

	// TORNA AL FRAME PRINCIPALE
	private void jButton_Home_CantActionPerformed() {
		jFrame_principale jframe_principale = new jFrame_principale();
		Controller_Principale controller_principale = new Controller_Principale(jframe_principale, NomeUtente);
		jframe_principale.setVisible(true);
		jframe_cantiere.setVisible(false);
		System.out.println("open jframe_principale");

	}

	// BOTTONE BACK DI UNA PAGINA
	private void jButton_Back_CantActionPerformed() {
		jFrame_principale jframe_principale = new jFrame_principale();
		Controller_Principale controller_principale = new Controller_Principale(jframe_principale, NomeUtente);
		jframe_principale.setVisible(true);
		jframe_cantiere.setVisible(false);
		System.out.println("open jframe_principale");
	}

	// AGGIUNGE NUOVA CATEGORIA
	private void openDialogForNuovaCategoria() {
		JDialog_AggiungiCategoria Jdialog_aggiungicategoria = new JDialog_AggiungiCategoria(jframe_cantiere, true);
		Jdialog_aggiungicategoria.setVisible(true);

		String NomeCategoria = Jdialog_aggiungicategoria.getjTextField_NomeCat_POP().getText().trim();
		if (NomeCategoria.isEmpty()) {
			JOptionPane.showMessageDialog(Jdialog_aggiungicategoria, "i campi non possono essere vuoti");
		} else {
			addCategoria(NomeCategoria);
		}
	}

	// SALVARE IN DB NUOVA CATEGORIA (CHIAMATA DA openDialogForNuovaCategoria())
	// ---- DA FINIRE ----
	private void addCategoria(String nomeCategoria) {
		db.insertNuovaCategoria(nomeCategoria);
	}

	// AGGIUNGI NUOVO PRODOTTO AD UNA CATEGORIA PIù CONTROLLI DOVUTI PER INPUT
	// UTENTE
	private void openDialogForNuovoProdotto() {
		JDialog_AggiungiProdotto Jdialog_aggiungiprodotto = new JDialog_AggiungiProdotto(jframe_cantiere, true, NomeUtente);
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

	//// SALVARE IN DB NUOVO PRODOTTO(CHIAMATA DA openDialogForNuovoProdotto()) ----
	//// DA FINIRE ----
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
