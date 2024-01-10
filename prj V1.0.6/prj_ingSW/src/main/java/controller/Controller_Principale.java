package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import GUI.JDialog_Import;
import GUI.JDialog_NuovoCantiere;
import GUI.JDialog_NuovoUtente;
import GUI.jFrame_Cantiere;
import GUI.jFrame_Inventario;
import GUI.jFrame_Login;
import GUI.jFrame_Personale;
import GUI.jFrame_fattura;
import GUI.jFrame_principale;
import database.DB;
import database.DB_Login;

public class Controller_Principale implements ActionListener {

	private String NomeUtente;
	private DB_Login db_login = new DB_Login();
	private DB db;
	private jFrame_principale jframe_principale;
	private int count = 0;
	private boolean vedi_cant = false;

	public Controller_Principale(jFrame_principale jFrame, String NomeUtente) {
		this.jframe_principale = jFrame;
		this.NomeUtente = NomeUtente;
		this.db = new DB(NomeUtente);

		jFrame.getjButton_AggiungiCantiere().addActionListener(this);
		jFrame.getjButton_Bilancio().addActionListener(this);
		jFrame.getjButton_Fatture().addActionListener(this);
		jFrame.getjButton_IlMioPersonale().addActionListener(this);
		jFrame.getjButton_IMieiCantieri().addActionListener(this);
		jFrame.getjButton_Impostazioni().addActionListener(this);
		jFrame.getjButton_Inventario().addActionListener(this);
		jFrame.getjButton_VediUser().addActionListener(this);
		jFrame.getjComboBox_IMieiCantieri().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == jframe_principale.getjButton_IMieiCantieri())
			try {
				jButton_IMieiCantieriActionPerformed();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		else if (e.getSource() == jframe_principale.getjButton_AggiungiCantiere())
			jButton_AggiungiCantiereActionPerformed();
		else if (e.getSource() == jframe_principale.getjButton_IlMioPersonale())
			jButton_IlMioPersonaleActionPerformed();
		else if (e.getSource() == jframe_principale.getjButton_Inventario())
			jButton_InventarioActionPerformed();
		else if (e.getSource() == jframe_principale.getjButton_Fatture())
			jButton_FattureActionPerformed();
		else if (e.getSource() == jframe_principale.getjButton_Bilancio())
			jButton_BilancioActionPerformed();
		else if (e.getSource() == jframe_principale.getjButton_Impostazioni())
			jButton_ImpostazioniActionPerformed();
		else if (e.getSource() == jframe_principale.getjButton_VediUser())
			jButton_VediUserActionPerformed();
		else if (e.getSource() == jframe_principale.getjComboBox_IMieiCantieri())
			jComboBox_IMieiCantieriActionPerformed();
	}

	// RENDE COMBOBOX VISIBILE PER SCELTA CANTIERE
	private void jButton_IMieiCantieriActionPerformed() throws SQLException {
		if (!vedi_cant)
		{
			jframe_principale.comboBoxvisible(jframe_principale.getjComboBox_IMieiCantieri(), db.SelectNomeCantiere());
			vedi_cant=true;
		}
		
	}

	// PASSA A FRAME PERSONALE
	private void jButton_IlMioPersonaleActionPerformed() {
		jFrame_Personale jframe_personale = new jFrame_Personale(NomeUtente);
		Controller_Personale controller_personale = new Controller_Personale(jframe_personale, NomeUtente);

		jframe_personale.setVisible(true);
		jframe_principale.setVisible(false);
		System.out.println("open jframe_personale");
	}

	// PASSA A FRAME INVENTARIO
	private void jButton_InventarioActionPerformed() {
		jFrame_Inventario jframe_inventario = new jFrame_Inventario(NomeUtente);
		Controller_Inventario controller_inventario = new Controller_Inventario(jframe_inventario, NomeUtente);
		jframe_inventario.setVisible(true);
		jframe_principale.setVisible(false);
		System.out.println("open jframe_inventario");
	}

	// APRE FRAME FATTURE (PRESA DA BOZZA GUI PROGETTO MA SECONDO ME DA TOGLIERE)
	private void jButton_FattureActionPerformed() {
		jFrame_fattura jframe_fattura = new jFrame_fattura();
		jframe_fattura.setVisible(true);
		jframe_principale.setVisible(false);
		System.out.println("open jframe_fattura");
	}

	// FRAME BILANCIO NON ANCORA DISCUSSE, PRESE DA BOZZA PROGETTO.  "../database/DB.db3";
	private void jButton_BilancioActionPerformed() {
		  try {
			  String percorsoFilePython = "../easter egg/heart2.py";
	            String percorsoPythonExe = "../easter egg/python/python.exe";  // Sostituisci con il tuo percorso reale

	            ProcessBuilder processoBuilder = new ProcessBuilder(percorsoPythonExe, percorsoFilePython);
	            processoBuilder.directory(new java.io.File("../prj_ingSW"));

	            Process processo = processoBuilder.start();

	            // Leggi l'output del processo
	            BufferedReader reader = new BufferedReader(new InputStreamReader(processo.getErrorStream()));
	            String linea;
	            while ((linea = reader.readLine()) != null) {
	                System.out.println(linea);
	            }

	            // Attendi che il processo termini
	            int codiceUscita = processo.waitFor();
	            System.out.println("Il processo Python ha restituito il codice di uscita: " + codiceUscita);

	        } catch (IOException | InterruptedException e) {
	            e.printStackTrace();
	        }
	}

	// APRE POP UP PER INSERIRE NUOCO CANTIERE
	private void jButton_AggiungiCantiereActionPerformed() {
		JDialog_NuovoCantiere Jdialog_nuovocantiere = new JDialog_NuovoCantiere(jframe_principale, true);
		Jdialog_nuovocantiere.setVisible(true);
		String NomeNuovoCantiere = Jdialog_nuovocantiere.getjTextField_NomeCat_POP().getText().trim();
		if (NomeNuovoCantiere.isEmpty()) {
			JOptionPane.showMessageDialog(Jdialog_nuovocantiere, "i campi non possono essere vuoti");
		}
		// System.out.println(NomeNuovoCantiere);
		AddNuovoCantiere(NomeNuovoCantiere);

	}

	// SALVARE NUOCO CANTIERE IN DB
	private void AddNuovoCantiere(String nomeNuovoCantiere) {
		db.insertNuovoCantiere(nomeNuovoCantiere);
	}

	// SELEZIONA CANTIERE DA APRIRE, PASSA NOME CANTIERE AL COSTRUTTORE DELLA CLASSE
	// CANTIERE
	private void jComboBox_IMieiCantieriActionPerformed() {
		if (count == 0)
			count++;
		else {
			String NomeCantiere = jframe_principale.getjComboBox_IMieiCantieri().getSelectedItem().toString();
			System.out.println(jframe_principale.getjComboBox_IMieiCantieri().getSelectedItem().toString());
			jFrame_Cantiere jframe_cantiere = new jFrame_Cantiere(NomeCantiere, NomeUtente);
			Controller_Cantiere Controller_cantiere = new Controller_Cantiere(jframe_cantiere, NomeUtente,
					NomeCantiere);
			jframe_cantiere.setVisible(true);
			jframe_principale.setVisible(false);
			System.out.println("open jframe_cantiere");
		}
	}

	// IMPOSTAZIONI NON ANCORA DISCUSSE, PRESE DA BOZZA PROGETTO.
	private void jButton_ImpostazioniActionPerformed() {
		JDialog_Import JDialog_import = new JDialog_Import(jframe_principale, true);
		JDialog_import.setVisible(true);
		
	}

	// IMPOSTAZIONI USER NON ANCORA DISCUSSE, PRESE DA BOZZA PROGETTO.
	private void jButton_VediUserActionPerformed() {

	}

}
