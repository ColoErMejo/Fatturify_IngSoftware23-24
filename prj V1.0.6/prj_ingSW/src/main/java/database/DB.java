package database;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import controller.Return_Avalaible_Data;
import model.Categoria;
import model.Dipendente;
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
	
	public void insertNuovoDipendente(Dipendente dip) {
		try {
			Connection conn = DriverManager.getConnection(DB_URL);
			if (conn != null) {
				Statement stmt = conn.createStatement();
				String sql = "INSERT INTO PERSONALE (ID_PERSONALE, NOME, COGNOME, MANSIONE, PAGA) VALUES (" +
					    "'" + dip.getIdDipendente() + "'," +
					    "'" + dip.getNome() + "'," +
					    "'" + dip.getCognome() + "'," +
					    "'" + dip.getMansione() + "'," +
					    dip.getPaga() + 
					    ")";
						
				stmt.executeUpdate(sql);
				stmt.close();
				conn.close();
				System.out.println("Dipendente inserito con successo");
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
	
	public Categoria recuperaCategoriaPerNome(String nomeCategoria) {
	    Categoria categoria = null;
	    try {
	        Connection conn = DriverManager.getConnection(DB_URL);
	        String query = "SELECT * FROM CATEGORIA WHERE NOMECATEGORIA = ?";
	        PreparedStatement pstmt = conn.prepareStatement(query);
	        pstmt.setString(1, nomeCategoria);

	        ResultSet rs = pstmt.executeQuery();
	        if (rs.next()) {
	            // Se esiste una categoria con il nome specificato, crea un'istanza di Categoria
	            categoria = new Categoria(nomeCategoria); // istanzia l'oggetto Categoria con il nome
	            // Puoi anche caricare altri dati necessari da questa riga del ResultSet se necessario
	        }

	        // Chiusura delle risorse
	        rs.close();
	        pstmt.close();
	        conn.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return categoria;
	}
	
	public Prodotto recuperaProdotto(String nomeProdotto, float prezzo, String categoria) {
	    Prodotto prod = null;
	    try {
	        Connection conn = DriverManager.getConnection(DB_URL);
	        String query = "SELECT * FROM PRODOTTO WHERE NOME_PRODOTTO = ?, PREZZO_UNITARIO = ?, CATEGORIA = ? ";
	        PreparedStatement pstmt = conn.prepareStatement(query);
	        pstmt.setString(1, nomeProdotto);
	        pstmt.setFloat(2, prezzo);
            pstmt.setString(3, categoria);

	        ResultSet rs = pstmt.executeQuery();
	        if (rs.next()) {
	            // Se esiste un prodotto con il nome specificato, crea un'istanza di prodotto
	            prod = new Prodotto(nomeProdotto, prezzo, categoria); // istanzia l'oggetto prodotto
	            }

	        // Chiusura delle risorse
	        rs.close();
	        pstmt.close();
	        conn.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return prod;
	}
	
	public int contaProdottiPerCategoria(String nomeCategoria) {
	    int count = 0;
	    try {
	        Connection conn = DriverManager.getConnection(DB_URL);
	        String query = "SELECT COUNT(*) AS count FROM PRODOTTO WHERE CATEGORIA = ? GROUP BY CATEGORIA";
	        PreparedStatement pstmt = conn.prepareStatement(query);
	        pstmt.setString(1, nomeCategoria);

	        ResultSet rs = pstmt.executeQuery();
	        if (rs.next()) {
	            count = rs.getInt("count");
	        }

	        // Chiusura delle risorse
	        rs.close();
	        pstmt.close();
	        conn.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return count;
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
	
	public String[] SelectNomeProdotto(String categoria) throws SQLException {
		List<String[]> risultati = new ArrayList<>();
		Connection conn = DriverManager.getConnection(DB_URL);
		Statement stmt = conn.createStatement();
		String sql = "SELECT NOME_PRODOTTO FROM PRODOTTO WHERE CATEGORIA = '" + categoria + "'";
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
		System.out.println("query SelectNomeProdotto con successo");

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
		System.out.println("query SelectProdotto con successo");

		return Avalaible_Data.DataPerProdottiTable(risultati);
		// return readDataArray(risultati);
	}
	
	public String[][] SelectPersonale() throws SQLException {
		List<String[]> risultati = new ArrayList<>();
		Connection conn = DriverManager.getConnection(DB_URL);
		Statement stmt = conn.createStatement();
		String sql = "SELECT NOME, COGNOME, MANSIONE, PAGA FROM PERSONALE";
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
		System.out.println("query SelectPersonale eseguita con successo");

		return Avalaible_Data.DataPerProdottiTable(risultati);
		// return readDataArray(risultati);
	}
	
	  // Metodo per cancellare un prodotto dal database
    public void deleteProdotto(String nomeProdotto) {
    	Connection conn = null;
    	PreparedStatement pstmt = null;

        try {
            // Connessione al database
            Connection conn1 = DriverManager.getConnection(DB_URL);
            
            // Query per cancellare il prodotto con l'ID specificato
            String query = "DELETE FROM PRODOTTO WHERE NOME_PRODOTTO = ?";
            
            // Creazione del prepared statement
            pstmt = conn1.prepareStatement(query);
            pstmt.setString(1, nomeProdotto);
            
            // Esecuzione della query per cancellare il prodotto
            int rowsAffected = pstmt.executeUpdate();
            
            // Verifica se il prodotto è stato cancellato correttamente
            if (rowsAffected > 0) {
                System.out.println("Prodotto con ID " + nomeProdotto + " cancellato con successo.");
            } else {
                System.out.println("Nessun prodotto con il seguente nome: " + nomeProdotto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Chiusura delle risorse
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    
    public void changeProdotto(String vecchioNomeProdotto, String nuovoNomeProdotto, float nuovoPrezzo, String Categoria) {
        try {
            Connection conn = DriverManager.getConnection(DB_URL);
            String query = "UPDATE PRODOTTO SET NOME_PRODOTTO = ?, PREZZO = ? WHERE CATEGORIA = ? AND NOME_PRODOTTO = ?";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, nuovoNomeProdotto);
            pstmt.setFloat(2, nuovoPrezzo);
            pstmt.setString(3, Categoria);
            pstmt.setString(4, vecchioNomeProdotto);
            

            int rowsUpdated = pstmt.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Prodotto modificato con successo.");
            } else {
                System.out.println("Nessun prodotto trovato con il nome specificato.");
            }

            // Chiusura delle risorse
            pstmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}

	


