package database;

import java.io.File;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DB_NewDBUtente {
	public static String NomeUtente;
	private static String DB_REL_FILE;
	private static String DB_URL;

	public DB_NewDBUtente(String NomeUtente) {
		this.NomeUtente = NomeUtente;
		this.DB_REL_FILE = "../database/" + NomeUtente + ".db3";
		this.DB_URL = "jdbc:sqlite:" + DB_REL_FILE;
	}

	public void createDB() throws SQLException {
		// System.out.println("debug " + NomeUtente);
		if (new File(DB_REL_FILE).exists())
			System.out.println("db " + NomeUtente + " gia esistente");
		else {
			Connection conn = DriverManager.getConnection(DB_URL);
			DatabaseMetaData meta = conn.getMetaData();
			System.out.println("db " + NomeUtente + " creato con successo");
			// funzioni create table
			createTableUtente();
			createTableCantiere();
			createTableProdotto();
			createTablePersonale();
			createTableFatture();
			createTableCategoria();
		}
	}

	// CREATE TABLE
	public void createTableUtente() {
		try {
			Connection conn = DriverManager.getConnection(DB_URL);
			if (conn != null) {
				Statement stmt = conn.createStatement();
				String sql = "CREATE TABLE UTENTE (" + "NOMEAZIENDA		TEXT PRIMARY KEY," + " NOMEUTENTE		TEXT,"
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

	public void createTableCantiere() {
		try {
			Connection conn = DriverManager.getConnection(DB_URL);
			if (conn != null) {
				Statement stmt = conn.createStatement();
				String sql = "CREATE TABLE CANTIERE ( NOMECANTIERE		TEXT PRIMARY KEY)";
				stmt.executeUpdate(sql);
				stmt.close();
				conn.close();
				System.out.println("Tabella cantiere creata");
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public void createTableProdotto() {
		try {
			Connection conn = DriverManager.getConnection(DB_URL);
			if (conn != null) {
				Statement stmt = conn.createStatement();
				String sql = "CREATE TABLE PRODOTTO (" + "CODICE_PRODOTTO  TEXT PRIMARY KEY," + "NOME_PRODOTTO    TEXT,"
						+ "DESCRIZIONE      TEXT," + "PREZZO           DECIMAL(10, 2))";
				stmt.executeUpdate(sql);
				stmt.close();
				conn.close();
				System.out.println("Tabella prodotto creata");
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public void createTablePersonale() {
		try {
			Connection conn = DriverManager.getConnection(DB_URL);
			if (conn != null) {
				Statement stmt = conn.createStatement();
				String sql = "CREATE TABLE PERSONALE (" + "ID_PERSONALE     TEXT PRIMARY KEY,"
						+ "NOME             TEXT," + "COGNOME          TEXT," + "MANSIONE            TEXT)";
				stmt.executeUpdate(sql);
				stmt.close();
				conn.close();
				System.out.println("Tabella personale creata");
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public void createTableFatture() {
		try {
			Connection conn = DriverManager.getConnection(DB_URL);
			if (conn != null) {
				Statement stmt = conn.createStatement();
				String sql = "CREATE TABLE FATTURE (" + "NUMERO_FATTURA   INT PRIMARY KEY," + "DATA_EMISSIONE   DATE,"
						+ "CLIENTE          TEXT," + "IMPORTO          DECIMAL(10, 2)," + "DESCRIZIONE      TEXT)";
				stmt.executeUpdate(sql);
				stmt.close();
				conn.close();
				System.out.println("Tabella fatture creata");
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public void createTableCategoria() {
		try {
			Connection conn = DriverManager.getConnection(DB_URL);
			if (conn != null) {
				Statement stmt = conn.createStatement();
				String sql = "CREATE TABLE CATEGORIA ( NOMECATEGORIA		TEXT PRIMARY KEY)";
				stmt.executeUpdate(sql);
				stmt.close();
				conn.close();
				System.out.println("Tabella categoria creata");
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

}
