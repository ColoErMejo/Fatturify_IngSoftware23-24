package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import GUI.jDialog_NuovoUtente;
import GUI.jFrame_Cantiere;
import GUI.jFrame_Login;
import GUI.jFrame_Personale;
import GUI.jFrame_fattura;
import GUI.jFrame_principale;

public class Controller_Principale implements ActionListener{

	private jFrame_principale jframe_principale;

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
		if(e.getSource()== jframe_principale.getjButton_AggiungiCantiere()) jButton_AggiungiCantiereActionPerformed();
		else if(e.getSource()== jframe_principale.getjButton_IlMioPersonale()) jButton_IlMioPersonaleActionPerformed();
		else if(e.getSource()== jframe_principale.getjButton_Inventario()) jButton_InventarioActionPerformed();
		else if(e.getSource()== jframe_principale.getjButton_Fatture()) jButton_FattureActionPerformed();
		else if(e.getSource()== jframe_principale.getjButton_Bilancio()) jButton_BilancioActionPerformed();
		else if(e.getSource()== jframe_principale.getjButton_AggiungiCantiere()) jButton_AggiungiCantiereActionPerformed();
		else if(e.getSource()== jframe_principale.getjButton_Impostazioni()) jButton_ImpostazioniActionPerformed();
		else if(e.getSource()== jframe_principale.getjButton_VediUser()) jButton_VediUserActionPerformed();
	}
	
    private void jButton_IMieiCantieriActionPerformed() {//GEN-FIRST:event_jButton_IMieiCantieriActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton_IMieiCantieriActionPerformed

    private void jButton_IlMioPersonaleActionPerformed() {
    	jFrame_Personale jframe_personale = new jFrame_Personale();
    	jframe_personale.setVisible(true);
    	jframe_principale.setVisible(false);	
    }

    private void jButton_InventarioActionPerformed() {
        //manca GUI
    }

    private void jButton_FattureActionPerformed() {
    	jFrame_fattura jframe_fattura = new jFrame_fattura();
    	jframe_fattura.setVisible(true);
    	jframe_principale.setVisible(false);
    }

    private void jButton_BilancioActionPerformed() {
        //manca GUI
    }

    private void jButton_AggiungiCantiereActionPerformed() {
    	//manca GUI
    }

    private void jComboBox_IMieiCantieriActionPerformed() {
    	
    }
    
    private void jButton_ImpostazioniActionPerformed() {
    	
    }

    private void jButton_VediUserActionPerformed() {
    	
    }

}
