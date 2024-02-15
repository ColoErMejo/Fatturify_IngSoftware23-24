package fatturify_database;

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
			createTableAttivitaCantProd();
			createTableAttivitaCantPers();
		}
	}

	// CREATE TABLE
	public void createTableUtente() {
		try {
			Connection conn = DriverManager.getConnection(DB_URL);
			if (conn != null) {
				Statement stmt = conn.createStatement();
				String sql = "CREATE TABLE UTENTE (" + "NOMEAZIENDA		TEXT PRIMARY KEY," + " NOMEUTENTE		TEXT,"
						+ " PASSWORD		 TEXT, "
						+ "CANTIERE        BOOLEAN DEFAULT FALSE,"
	                    + "PERSONALE       BOOLEAN DEFAULT FALSE,"
	                    + "CATEGORIA       BOOLEAN DEFAULT FALSE,"
	                    + "PRODOTTO        BOOLEAN DEFAULT FALSE)";
				stmt.executeUpdate(sql);
				stmt.close();
				conn.close();
				System.out.println("Classe NewDB: Tabella utente creata");
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
				String sql = "CREATE TABLE CANTIERE (" +
						"NOMECANTIERE TEXT, " +
						"ID_ATTIVITA INTEGER PRIMARY KEY AUTOINCREMENT " +
		             ")";

				stmt.executeUpdate(sql);
				stmt.close();
				conn.close();
				System.out.println("Tabella cantiere creata");
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void createTableAttivitaCantProd() {
		try {
			Connection conn = DriverManager.getConnection(DB_URL);
			if (conn != null) {
				Statement stmt = conn.createStatement();
				String sql = "CREATE TABLE ATTIVITACANTPROD (" +
		                "ID_ATTIVITA INT," +
		                "ID_Prodotto TEXT," +
		                "Quantita FLOAT," +
		                "Costo_Totale FLOAT," +
		                "PRIMARY KEY (ID_ATTIVITA, ID_Prodotto)," +
		                "FOREIGN KEY (ID_ATTIVITA) REFERENCES CANTIERE(ID_ATTIVITA)," +
		                "FOREIGN KEY (ID_Prodotto) REFERENCES PRODOTTO(CODICE_PRODOTTO)" +
		                ")";

				stmt.executeUpdate(sql);
				stmt.close();
				conn.close();
				System.out.println("Tabella Attivita' Prodotto creata");
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	public void createTableAttivitaCantPers() {
		try {
			Connection conn = DriverManager.getConnection(DB_URL);
			if (conn != null) {
				Statement stmt = conn.createStatement();
				String sql = "CREATE TABLE ATTIVITACANTPERS (" +
		                "ID_ATTIVITA INT," +
		                "ID_Dipendente TEXT," +
		                "Nore INT," +
		                "Descrizione TEXT," +
		                "PRIMARY KEY (ID_ATTIVITA, ID_Dipendente)," +
		                "FOREIGN KEY (ID_ATTIVITA) REFERENCES CANTIERE(ID_ATTIVITA)," +
		                "FOREIGN KEY (ID_Dipendente) REFERENCES PERSONALE(ID_PERSONALE)" +
		                ")";

				stmt.executeUpdate(sql);
				stmt.close();
				conn.close();
				System.out.println("Tabella Attivita' Personale creata");
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
				String sql = "CREATE TABLE PRODOTTO (" + "CODICE_PRODOTTO  TEXT PRIMARY KEY," + 
							 "NOME_PRODOTTO    TEXT," +
							 "PREZZO           DECIMAL(10, 2)," +
							 "CATEGORIA      TEXT)";
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
				String sql = "CREATE TABLE PERSONALE (" +
					    "ID_PERSONALE     TEXT PRIMARY KEY," +
					    "NOME             TEXT," +
					    "COGNOME          TEXT," +
					    "MANSIONE         TEXT," +
					    "PAGA             DECIMAL(10,2)" +
					    ")";
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
