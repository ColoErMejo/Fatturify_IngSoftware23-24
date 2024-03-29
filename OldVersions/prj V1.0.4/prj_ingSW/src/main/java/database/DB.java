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

import controller.Return_Avalaible_Data;
import model.Categoria;
import model.Prodotto;

public class DB {

	public static String NomeUtente;
	private static String DB_REL_FILE;
	private static String DB_URL;
	Return_Avalaible_Data Avalaible_Data;

	public DB(String NomeUtente) {
		this.NomeUtente = NomeUtente;
		this.DB_REL_FILE = "../database/" + NomeUtente + ".db3";
		this.DB_URL = "jdbc:sqlite:" + DB_REL_FILE;
		this.Avalaible_Data = new Return_Avalaible_Data();
	}

	// INSERT
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

	public void insertNuovoCantiere(String NomeCantiere) {
		try {
			Connection conn = DriverManager.getConnection(DB_URL);
			if (conn != null) {
				Statement stmt = conn.createStatement();
				String sql = "INSERT INTO CANTIERE VALUES (" + " \"" + NomeCantiere + "\"" + ")";
				stmt.executeUpdate(sql);
				stmt.close();
				conn.close();
				System.out.println("cantiere inserito con successo");
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public void insertNuovaCategoria(String NomeCategoria) {
		try {
			Connection conn = DriverManager.getConnection(DB_URL);
			if (conn != null) {
				Statement stmt = conn.createStatement();
				String sql = "INSERT INTO CATEGORIA VALUES (" + " \"" + NomeCategoria + "\"" + ")";
				stmt.executeUpdate(sql);
				stmt.close();
				conn.close();
				System.out.println("categoria inserito con successo");
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public void insertNuovoProdotto(Prodotto prod) {
		try {

			Connection conn = DriverManager.getConnection(DB_URL);
			if (conn != null) {
				Statement stmt = conn.createStatement();
				String sql = "INSERT INTO PRODOTTO VALUES (" + " \"" + prod.getIDprodotto() + "\"," + " \""
						+ prod.getNomeProdotto() + "\"," + " \"" + prod.getPrezzoProdotto() + "\"," + " \""
						+ prod.getCategoria() + "\"" + ")";
				stmt.executeUpdate(sql);
				stmt.close();
				conn.close();
				System.out.println("prodotto inserito con successo");
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());			
		}
	}

	// RITRONA String[] UTENTE
	public String[] SelectUtente() throws SQLException {
		List<String[]> risultati = new ArrayList<>();
		Connection conn = DriverManager.getConnection(DB_URL);
		Statement stmt = conn.createStatement();
		String sql = "SELECT NOMEUTENTE FROM UTENTE";
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
		System.out.println("query SelectUtente con successo");

		return Avalaible_Data.ReadDataByListOfArray(risultati);
		// return readDataArray(risultati);
	}

	// RITRONA String[] CATEGORIA
	public List<Categoria> SelectCategoria() throws SQLException {
		Categoria cat;
		List<Categoria> risultati = new ArrayList<>();
		Connection conn = DriverManager.getConnection(DB_URL);
		Statement stmt = conn.createStatement();
		String sql = "SELECT NOMECATEGORIA FROM CATEGORIA";
		ResultSet resultSet = stmt.executeQuery(sql);
		int numeroColonne = resultSet.getMetaData().getColumnCount();
		while (resultSet.next()) {
			String[] riga = new String[numeroColonne];
			for (int i = 1; i <= numeroColonne; i++) {
				riga[i - 1] = resultSet.getString(i);
				cat = new Categoria(riga[i - 1]);
				risultati.add(cat);
			}
		}
		for (Categoria riga : risultati) {
			System.out.print(risultati.toString() + " ");
			System.out.println();
		}
		stmt.close();
		conn.close();
		System.out.println("query SelectCategoria con successo");

		return risultati;
	}

	// RITRONA String[] CON NOMICANTIERI
	public String[] SelectNomeCantiere() throws SQLException {
		List<String[]> risultati = new ArrayList<>();
		Connection conn = DriverManager.getConnection(DB_URL);
		Statement stmt = conn.createStatement();
		String sql = "SELECT NOMECANTIERE FROM CANTIERE";
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
		System.out.println("query SelectNomeCantiere con successo");

		return Avalaible_Data.ReadDataByListOfArray(risultati);
		// return readDataArray(risultati);
	}
	
	public String[][] SelectProdotto() throws SQLException {
		List<String[]> risultati = new ArrayList<>();
		Connection conn = DriverManager.getConnection(DB_URL);
		Statement stmt = conn.createStatement();
		String sql = "SELECT NOME_PRODOTTO, PREZZO, CATEGORIA FROM PRODOTTO";
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
		System.out.println("query SelectNomeCantiere con successo");

		return Avalaible_Data.DataPerProdottiTable(risultati);
		// return readDataArray(risultati);
	}


}
