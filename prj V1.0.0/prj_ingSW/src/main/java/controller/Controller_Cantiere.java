package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import GUI.JDialog_AggiungiProdotto;
import GUI.jFrame_Cantiere;

public class Controller_Cantiere implements ActionListener{

	private jFrame_Cantiere jframe_cantiere;
	
	public Controller_Cantiere (jFrame_Cantiere jFrame)
	{
		this.jframe_cantiere=jFrame;
		
		jFrame.getjButton_Aggiungi_Cant().addActionListener(this);
		jFrame.getjButton_NuovoProd_Cant().addActionListener(this);
		jFrame.getjButton_ToFAttura_Cant().addActionListener(this);
		jFrame.getjButton_Back_Cant().addActionListener(this);
		jFrame.getjButton_Home_Cant().addActionListener(this);
		jFrame.getjComboBox_Categoria_Cant().addActionListener(this);
		jFrame.getjComboBox_Prodotto_Cant().addActionListener(this);
		jFrame.getjComboBox_Pers_Cant().addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()== jframe_cantiere.getjButton_Aggiungi_Cant())jButton_Aggiungi_CantActionPerformed();
		else if(e.getSource()== jframe_cantiere.getjButton_NuovoProd_Cant())jButton_NuovoProd_CantActionPerformed();
	}
	
	private void jButton_Aggiungi_CantActionPerformed() {
		
    }

	private void jComboBox_Categoria_CantActionPerformed() {//GEN-FIRST:event_jComboBox_Categoria_CantActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox_Categoria_CantActionPerformed

    private void jComboBox_Prodotto_CantActionPerformed() {//GEN-FIRST:event_jComboBox_Prodotto_CantActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox_Prodotto_CantActionPerformed

    private void jTextField_Quantita_CantActionPerformed() {//GEN-FIRST:event_jTextField_Quantita_CantActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_Quantita_CantActionPerformed

    private void jComboBox_Pers_CantActionPerformed() {//GEN-FIRST:event_jComboBox_Pers_CantActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox_Pers_CantActionPerformed

    private void jTextField_Nore_CantActionPerformed() {//GEN-FIRST:event_jTextField_Nore_CantActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_Nore_CantActionPerformed

    private void jTextField_Descrizione_CantActionPerformed() {//GEN-FIRST:event_jTextField_Descrizione_CantActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_Descrizione_CantActionPerformed

    private void jButton_NuovoProd_CantActionPerformed() {//GEN-FIRST:event_jButton_NuovoProd_CantActionPerformed
    	openDialogForNuovoProdotto();
    }//GEN-LAST:event_jButton_NuovoProd_CantActionPerformed

    private void jButton_ToFAttura_CantActionPerformed() {//GEN-FIRST:event_jButton_ToFAttura_CantActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton_ToFAttura_CantActionPerformed

    private void jButton_Home_CantActionPerformed() {//GEN-FIRST:event_jButton_Home_CantActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton_Home_CantActionPerformed

    private void jButton_Back_CantActionPerformed() {//GEN-FIRST:event_jButton_Back_CantActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton_Back_CantActionPerformed

    private void openDialogForNuovoProdotto() {
    	JDialog_AggiungiProdotto Jdialog_aggiungiprodotto = new JDialog_AggiungiProdotto(jframe_cantiere, true);
    	Jdialog_aggiungiprodotto.setVisible(true);
    	
    	String NomeProdotto = Jdialog_aggiungiprodotto.getjTextField_Nome_POP().getText().trim();
    	String PrezzoUnitario = Jdialog_aggiungiprodotto.getjTextFieldPrezzo_POP().getText().trim();
    	String Categoria = Jdialog_aggiungiprodotto.getjComboBox_Categoria_POP().getSelectedItem().toString();
	
    	boolean ERROR=false;
    	if(NomeProdotto.isEmpty()) 
    		{
    			JOptionPane.showMessageDialog(Jdialog_aggiungiprodotto, "i campi non possono essere vuoti");
    			ERROR=true;
    		}
    	else if(PrezzoUnitario.isEmpty()) 
    		{
    			JOptionPane.showMessageDialog(Jdialog_aggiungiprodotto, "i campi non possono essere vuoti");
    			ERROR=true;
    		}
    	else if(Categoria.isEmpty()) 
    		{
    			JOptionPane.showMessageDialog(Jdialog_aggiungiprodotto, "i campi non possono essere vuoti");
    			ERROR=true;
    		}
    	if(!ERROR)
    	{
    		boolean errorFloat=true;
    		try {
    			float PrezzoUnitarioFloat = Float.parseFloat(PrezzoUnitario);
    			System.out.println(NomeProdotto + PrezzoUnitarioFloat + Categoria);
    			errorFloat=false;
    			addProdotto(NomeProdotto, PrezzoUnitarioFloat, Categoria);
    		}
    		catch(ArithmeticException e)
    		{
    			e.printStackTrace();
    		}
    		finally
    		{
    			if(errorFloat)
        		{
        			JOptionPane.showMessageDialog(Jdialog_aggiungiprodotto, "la quantità deve essere un numero");
        		}
    		}
    	}
    }
    
    ////SALVARE IN DB ---- DA FINIRE ----
    private void addProdotto(String NomeProdotto, float PrezzoUnitario, String Categoria)
    {
    	//SALVARE IN DB
    }
	
}
