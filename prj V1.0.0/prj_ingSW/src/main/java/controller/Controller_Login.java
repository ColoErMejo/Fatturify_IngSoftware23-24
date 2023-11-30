package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import GUI.jFrame_Cantiere;
import GUI.jFrame_Login;

public class Controller_Login implements ActionListener {
	
	private jFrame_Login jFrame;
	
	
	public Controller_Login (jFrame_Login jFrame)
	{
		this.jFrame=jFrame;
		
		jFrame.getjButton_Login().addActionListener(this);
		jFrame.getjButton_Nuovo_Utente().addActionListener(this);
	}
	
	


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		//String error ="";
		
		if(e.getSource()== jFrame.getjButton_Login()) jButton_LoginActionPerformed();
		else if (e.getSource()== jFrame.getjButton_Nuovo_Utente()) jButton_Nuovo_UtenteActionPerformed();
	}

	private void jTextField_Nome_UtenteActionPerformed() {//GEN-FIRST:event_jTextField_Nome_UtenteActionPerformed
        // TODO add your handling code here:
    	
    }//GEN-LAST:event_jTextField_Nome_UtenteActionPerformed

    private void jButton_LoginActionPerformed() {//GEN-FIRST:event_jButton_LoginActionPerformed
        // TODO add your handling code here:
    	//jFrame.getjLabel_Password().setText("bravo");
    	jFrame.setVisible(false);
    	jFrame_Cantiere jframe_cantiere = new jFrame_Cantiere();
    	jframe_cantiere.setVisible(true);
    }//GEN-LAST:event_jButton_LoginActionPerformed

    private void jButton_Nuovo_UtenteActionPerformed() {//GEN-FIRST:event_jButton_Nuovo_UtenteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton_Nuovo_UtenteActionPerformed

    private void jPasswordFieldActionPerformed() {//GEN-FIRST:event_jPasswordFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jPasswordFieldActionPerformed

}
