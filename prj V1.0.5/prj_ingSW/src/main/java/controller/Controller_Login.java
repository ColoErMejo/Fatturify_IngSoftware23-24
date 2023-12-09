package controller;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import GUI.JDialog_NuovoUtente;
import GUI.jFrame_Cantiere;
import GUI.jFrame_Login;
import GUI.jFrame_Personale;
import GUI.jFrame_principale;
import database.DB;
import database.DB_Login;
import database.DB_NewDBUtente;

public class Controller_Login implements ActionListener {

	private jFrame_Login jframe_login;
	DB_Login db_login = new DB_Login();

	public Controller_Login(jFrame_Login jFrame, DB_Login db_login) {
		this.jframe_login = jFrame;
		this.db_login = db_login;

		jFrame.getjButton_Login().addActionListener(this);
		jFrame.getjButton_Nuovo_Utente().addActionListener(this);
		jFrame.getjTextField_Nome_Utente().addActionListener(this);
		jFrame.getjPasswordField().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == jframe_login.getjButton_Login())
			try {
				jButton_LoginActionPerformed();
			} catch (HeadlessException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		else if (e.getSource() == jframe_login.getjButton_Nuovo_Utente())
			jButton_Nuovo_UtenteActionPerformed();
	}

	// bottone per login
	private void jButton_LoginActionPerformed() throws HeadlessException, SQLException {
		if (checkUtente(jframe_login.getjTextField_Nome_Utente().getText(),
				jframe_login.getjPasswordField().getText())) {
			jFrame_principale jframe_principale = new jFrame_principale();
			Controller_Principale controller_principale = new Controller_Principale(jframe_principale,
					jframe_login.getjTextField_Nome_Utente().getText().toString());
			jframe_principale.setVisible(true);
			jframe_login.setVisible(false);
		} else {
			JOptionPane.showMessageDialog(jframe_login, "combinazione di nome utente e password errate");
		}

	}

	// bottone nuovo utente
	private void jButton_Nuovo_UtenteActionPerformed() {
		try {
			openDialogForNuovoUtente();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// dialog per creare nuovo utente
	private void openDialogForNuovoUtente() throws SQLException {
		JDialog_NuovoUtente jdialog_nuovoutente = new JDialog_NuovoUtente(jframe_login, true);
		jdialog_nuovoutente.setVisible(true);

		String NomeAzienda = jdialog_nuovoutente.getjTextField_NomeAzienda_POP().getText().trim();
		String NomeUtente = jdialog_nuovoutente.getjTextField_NomeUtente_POP().getText().trim();
		String Password = jdialog_nuovoutente.getjTextField_Password_POP1().getText().trim();

		boolean ERROR = false;
		if (NomeAzienda.isEmpty()) {
			JOptionPane.showMessageDialog(jdialog_nuovoutente, "i campi non possono essere vuoti");
			ERROR = true;
		} else if (NomeUtente.isEmpty()) {
			JOptionPane.showMessageDialog(jdialog_nuovoutente, "i campi non possono essere vuoti");
			ERROR = true;
		} else if (Password.isEmpty()) {
			JOptionPane.showMessageDialog(jdialog_nuovoutente, "i campi non possono essere vuoti");
			ERROR = true;
		}
		if (!ERROR) {
			System.out.println(NomeAzienda + NomeUtente + Password);

			addUtente(NomeAzienda, NomeUtente, Password);
			DB_NewDBUtente DB_NewdbUtente = new DB_NewDBUtente(NomeUtente);
			DB_NewdbUtente.createDB();
			DB db = new DB(NomeUtente);
			db.insertNuovoUtente(NomeAzienda, NomeUtente, Password);
		}
	}

	// salvare utente in db
	private void addUtente(String nomeAzienda, String nomeUtente, String password) {
		db_login.insertNuovoUtente(nomeAzienda, nomeUtente, password);
	}

	// check utente per login
	private boolean checkUtente(String NomeUtente, String Password) throws SQLException {
		List<String[]> UtentePass = db_login.SelectUtentePassword();
		boolean correct = false;
		for (String[] valore : UtentePass) {
			if (valore[0].equals(NomeUtente) && valore[1].equals(Password))
				correct = true;
		}
		System.out.println(correct);
		return correct;
	}
}
