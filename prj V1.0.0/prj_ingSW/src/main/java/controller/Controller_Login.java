package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import GUI.JDialog_NuovoUtente;
import GUI.jFrame_Cantiere;
import GUI.jFrame_Login;
import GUI.jFrame_Personale;
import GUI.jFrame_principale;

public class Controller_Login implements ActionListener {
	
	private jFrame_Login jframe_login;
	
	
	public Controller_Login (jFrame_Login jFrame)
	{
		this.jframe_login=jFrame;
		
		jFrame.getjButton_Login().addActionListener(this);
		jFrame.getjButton_Nuovo_Utente().addActionListener(this);
		jFrame.getjTextField_Nome_Utente().addActionListener(this);
		jFrame.getjPasswordField().addActionListener(this);
	}

	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()== jframe_login.getjButton_Login()) jButton_LoginActionPerformed();
		else if (e.getSource()== jframe_login.getjButton_Nuovo_Utente()) jButton_Nuovo_UtenteActionPerformed();
	}

	//bottone per login
    private void jButton_LoginActionPerformed() {
    	if(checkUtente(jframe_login.getjTextField_Nome_Utente().getText(), jframe_login.getjPasswordField().getText()))
    	{
    		jFrame_principale jframe_principale = new jFrame_principale();
    		Controller_Principale controller_principale = new Controller_Principale(jframe_principale);
    		jframe_principale.setVisible(true);
    		jframe_login.setVisible(false);
    	}
    	else
    	{
    		JOptionPane.showMessageDialog(jframe_login, "combinazione di nome utente e password errate");
    	}
    	
    }

    //bottone nuovo utente
    private void jButton_Nuovo_UtenteActionPerformed() {
    	openDialogForNuovoUtente();  		
    }
    	
    //dialog per creare nuovo utente
    private void openDialogForNuovoUtente()
    {
    	JDialog_NuovoUtente jdialog_nuovoutente = new JDialog_NuovoUtente(jframe_login, true);
    	jdialog_nuovoutente.setVisible(true);
    	
    	String NomeAzienda = jdialog_nuovoutente.getjTextField_NomeAzienda_POP().getText().trim();
    	String NomeUtente = jdialog_nuovoutente.getjTextField_NomeUtente_POP().getText().trim();
    	String Password = jdialog_nuovoutente.getjTextField_Password_POP1().getText().trim();
    	
    	boolean ERROR=false;
    	if(NomeAzienda.isEmpty()) 
    		{
    			JOptionPane.showMessageDialog(jdialog_nuovoutente, "i campi non possono essere vuoti");
    			ERROR=true;
    		}
    	else if(NomeUtente.isEmpty()) 
    		{
    			JOptionPane.showMessageDialog(jdialog_nuovoutente, "i campi non possono essere vuoti");
    			ERROR=true;
    		}
    	else if(Password.isEmpty()) 
    		{
    			JOptionPane.showMessageDialog(jdialog_nuovoutente, "i campi non possono essere vuoti");
    			ERROR=true;
    		}
    	if(!ERROR)
    	{
    		System.out.println(NomeAzienda + NomeUtente + Password);
    		addUtente(NomeAzienda, NomeUtente, Password);
    	}
    }
    
    //salvare utente in db ---- DA COMPLETARE ----
    private void addUtente(String nomeAzienda, String nomeUtente, String password)
    {
    	//SALVARE IN DB
    }
    
    //check utente per login ---- DA COMPLETARE ----
    private boolean checkUtente(String NomeUtente, String Password)
    {
    	//System.out.println(NomeUtente + Password);
    	return true;
    }
}
