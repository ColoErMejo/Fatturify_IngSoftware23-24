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

public class DB {
	
	public static String NomeUtente;
	private static String DB_REL_FILE;
	private static String DB_URL;
	
	public DB(String NomeUtente)
	{
		this.NomeUtente=NomeUtente;
		this.DB_REL_FILE = "../database/"+NomeUtente+".db3";
		this.DB_URL = "jdbc:sqlite:" + DB_REL_FILE;
	}
	
	private String[] readDataArray(List<String[]> lista) throws SQLException {
    	String string = "";
		for (String[] riga : lista) {
            for (String valore : riga) {
                System.out.print(valore + " ");
                string = string  + valore + ",";
            }
            System.out.println(); 
        }	
		String [] data = string.split(",");
		System.out.println(data); 
		return data;	
	}
	
	//INSERT
	public void insertNuovoUtente(String NomeAzienda, String NomeUtente, String Password)
	{
		try {
			Connection conn = DriverManager.getConnection(DB_URL);
			if (conn != null) {
				Statement stmt = conn.createStatement();
				String sql = "INSERT INTO UTENTE VALUES (" + " \""+NomeAzienda+"\"," + " \""+NomeUtente+"\", " + " \""+Password+"\"  )";
				stmt.executeUpdate(sql);
				stmt.close();
				conn.close();
				System.out.println("Utente inserito con successo");
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void insertNuovoCantiere(String NomeCantiere)
	{
		try {
		Connection conn = DriverManager.getConnection(DB_URL);
		if (conn != null) 
				{
					Statement stmt = conn.createStatement();
					String sql = "INSERT INTO CANTIERE VALUES (" + " \""+NomeCantiere+"\"" +")";
					stmt.executeUpdate(sql);
					stmt.close();
					conn.close();
					System.out.println("cantiere inserito con successo");
				}
			}
			catch (SQLException e) 
			{
				System.out.println(e.getMessage());
			}
	
	}
	// RITRONA String[] UTENTE
	public String[] SelectUtente() throws SQLException
	{
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
			
		return readDataArray(risultati);
	}

	// RITRONA String[] CON NOMICANTIERI
			public String[] SelectNomeCantiere() throws SQLException
			{
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
				
				return readDataArray(risultati);
			}
	
	
	
	
	
}
