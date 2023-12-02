package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import GUI.JDialog_NuovoCantiere;
import GUI.JDialog_NuovoUtente;
import GUI.jFrame_Cantiere;
import GUI.jFrame_Inventario;
import GUI.jFrame_Login;
import GUI.jFrame_Personale;
import GUI.jFrame_fattura;
import GUI.jFrame_principale;

public class Controller_Principale implements ActionListener{

	private jFrame_principale jframe_principale;
	private int count=0;

	public Controller_Principale (jFrame_principale jFrame)
	{
		this.jframe_principale=jFrame;
		
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
		if(e.getSource()== jframe_principale.getjButton_IMieiCantieri()) jButton_IMieiCantieriActionPerformed();
		else if(e.getSource()== jframe_principale.getjButton_AggiungiCantiere()) jButton_AggiungiCantiereActionPerformed();
		else if(e.getSource()== jframe_principale.getjButton_IlMioPersonale()) jButton_IlMioPersonaleActionPerformed();
		else if(e.getSource()== jframe_principale.getjButton_Inventario()) jButton_InventarioActionPerformed();
		else if(e.getSource()== jframe_principale.getjButton_Fatture()) jButton_FattureActionPerformed();
		else if(e.getSource()== jframe_principale.getjButton_Bilancio()) jButton_BilancioActionPerformed();
		else if(e.getSource()== jframe_principale.getjButton_Impostazioni()) jButton_ImpostazioniActionPerformed();
		else if(e.getSource()== jframe_principale.getjButton_VediUser()) jButton_VediUserActionPerformed();
		else if(e.getSource()== jframe_principale.getjComboBox_IMieiCantieri()) jComboBox_IMieiCantieriActionPerformed();
	}
	
	//RENDE COMBOBOX VISIBILE PER SCELTA CANTIERE
    private void jButton_IMieiCantieriActionPerformed() {
    	jframe_principale.comboBoxvisible(jframe_principale.getjComboBox_IMieiCantieri());
    }

    //PASSA A FRAME PERSONALE
    private void jButton_IlMioPersonaleActionPerformed() {
    	jFrame_Personale jframe_personale = new jFrame_Personale();
    	jframe_personale.setVisible(true);
    	jframe_principale.setVisible(false);	
    }

    //PASSA A FRAME INVENTARIO
    private void jButton_InventarioActionPerformed() {
    	jFrame_Inventario jframe_inventario = new jFrame_Inventario();
    	jframe_inventario.setVisible(true);
    	jframe_principale.setVisible(false);	
    }

    //APRE FRAME FATTURE (PRESA DA BOZZA GUI PROGETTO MA SECONDO ME DA TOGLIERE)
    private void jButton_FattureActionPerformed() {
    	jFrame_fattura jframe_fattura = new jFrame_fattura();
    	jframe_fattura.setVisible(true);
    	jframe_principale.setVisible(false);
    }

    //FRAME BILANCIO NON ANCORA DISCUSSE, PRESE DA BOZZA PROGETTO.
    private void jButton_BilancioActionPerformed() {
        //manca GUI
    }

    //APRE POP UP PER INSERIRE NUOCO CANTIERE
    private void jButton_AggiungiCantiereActionPerformed() {
    	JDialog_NuovoCantiere Jdialog_nuovocantiere = new JDialog_NuovoCantiere(jframe_principale, true);
    	Jdialog_nuovocantiere.setVisible(true);
    	String NomeNuovoCantiere = Jdialog_nuovocantiere.getjTextField_NomeCat_POP().getText().trim();
    	if(NomeNuovoCantiere.isEmpty()) 
    		{
    			JOptionPane.showMessageDialog(Jdialog_nuovocantiere, "i campi non possono essere vuoti");
    		}	
    	//System.out.println(NomeNuovoCantiere);
    	AddNuovoCantiere(NomeNuovoCantiere);
    }

    //SALVARE NUOCO CANTIERE IN DB ---- DA FARE ----
    private void AddNuovoCantiere(String nomeNuovoCantiere) {
		//funzione per salvare dentro a db
		
	}

    //SELEZIONA CANTIERE DA APRIRE, PASSA NOME CANTIERE AL COSTRUTTORE DELLA CLASSE CANTIERE
	private void jComboBox_IMieiCantieriActionPerformed() {
    	if(count==0)count++;
    	else
    	{
    		String NomeCantiere = jframe_principale.getjComboBox_IMieiCantieri().getSelectedItem().toString();
        	System.out.println(jframe_principale.getjComboBox_IMieiCantieri().getSelectedItem().toString());
        	jFrame_Cantiere jframe_cantiere = new jFrame_Cantiere(NomeCantiere);
        	Controller_Cantiere controller_cantiere = new Controller_Cantiere(jframe_cantiere);
        	jframe_cantiere.setVisible(true);
        	jframe_principale.setVisible(false);
    	}
    }
    
	//IMPOSTAZIONI NON ANCORA DISCUSSE, PRESE DA BOZZA PROGETTO.
    private void jButton_ImpostazioniActionPerformed() {
    	
    }

   //IMPOSTAZIONI USER NON ANCORA DISCUSSE, PRESE DA BOZZA PROGETTO.
    private void jButton_VediUserActionPerformed() {
    	
    }

}
