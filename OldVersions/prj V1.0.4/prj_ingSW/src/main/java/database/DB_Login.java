package database;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DB_Login {

	public static String DB_REL_FILE = "../database/DB.db3";
	public static String DB_URL = "jdbc:sqlite:" + DB_REL_FILE;

	// CREA DATABSE SE NON ESISTE NELLA CARTELLA
	public void createDB() throws SQLException {

		if (new File(DB_REL_FILE).exists())
			System.out.println("db utente gia esistente");
		else {
			Connection conn = DriverManager.getConnection(DB_URL);
			DatabaseMetaData meta = conn.getMetaData();
			System.out.println("db utente creato con successo");

			createTableUtente();
		}

	}

	// CREA TABELLA UTENTE
	public void createTableUtente() {
		try {
			Connection conn = DriverManager.getConnection(DB_URL);
			if (conn != null) {
				Statement stmt = conn.createStatement();
				String sql = "CREATE TABLE UTENTE (" + "NOMEAZIENDA		TEXT," + " NOMEUTENTE		TEXT,"
						+ " PASSWORD		 TEXT )";
				stmt.executeUpdate(sql);
				stmt.close();
				conn.close();
				System.out.println("Tabella utente creata");
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	// INSERISCE NUOVO UTENTE IN TABELLA UTENTE
	public void insertNuovoUtente(String NomeAzienda, String NomeUtente, String Password) {
		try {
			Connection conn = DriverManager.getConnection(DB_URL);
			if (conn != null) {
				Statement stmt = conn.createStatement();
				String sql = "INSERT INTO UTENTE VALUES (" + " \"" + NomeAzienda + "\"," + " \"" + NomeUtente + "\", "
						+ " \"" + Password + "\"  )";
				stmt.executeUpdate(sql);
				stmt.close();
				conn.close();
				System.out.println("Utente inserito con successo");
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	// SELECT TUTTI UTENTI, SOLO CONSOLE DEBUG
	public void SelectAllUtentiPassword() throws SQLException {
		Connection conn = DriverManager.getConnection(DB_URL);
		Statement stmt = conn.createStatement();
		String sql = "SELECT * FROM UTENTE";
		ResultSet resultSet = stmt.executeQuery(sql);
		// stampa i risultati
		while (resultSet.next()) {
			for (int i = 1; i <= 3; i++) {
				System.out.print(resultSet.getString(i) + " ");
			}
			System.out.println();
		}
		stmt.close();
		conn.close();
		System.out.println("query SelectAllUtenti eseguita");
	}

	// RITRONA LISTA CON COMBINAZIONE UTENTE PASSWORD
	public List<String[]> SelectUtentePassword() throws SQLException {
		List<String[]> risultati = new ArrayList<>();
		Connection conn = DriverManager.getConnection(DB_URL);
		Statement stmt = conn.createStatement();
		String sql = "SELECT NOMEUTENTE,PASSWORD FROM UTENTE";
		ResultSet resultSet = stmt.executeQuery(sql);
		int numeroColonne = resultSet.getMetaData().getColumnCount();
		while (resultSet.next()) {
			String[] riga = new String[numeroColonne];
			for (int i = 1; i <= numeroColonne; i++) {
				riga[i - 1] = resultSet.getString(i);
			}
			risultati.add(riga);
		}
		for (String[] riga : risultati) {
			for (String valore : riga) {
				System.out.print(valore + " ");
			}
			System.out.println();
		}
		stmt.close();
		conn.close();
		System.out.println("query SelectUtentePassword con successo");
		return risultati;
	}

}
