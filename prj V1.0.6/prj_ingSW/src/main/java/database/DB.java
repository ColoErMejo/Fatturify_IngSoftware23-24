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

	
	public Dipendente recuperaDipendentePerNome(String nome, String cognome) {
	    Dipendente dip = null;
	    try {
	        Connection conn = DriverManager.getConnection(DB_URL);
	        String query = "SELECT * FROM PERSONALE WHERE NOME = ? AND COGNOME = ? ";
	        PreparedStatement pstmt = conn.prepareStatement(query);
	        pstmt.setString(1, nome);
	        pstmt.setString(2, cognome);

	        ResultSet rs = pstmt.executeQuery();
	        if (rs.next()) {
	            String nomeD = rs.getString("NOME");
	            String cognomeD = rs.getString("COGNOME");
	            String mansioneD = rs.getString("MANSIONE");
	            float pagaD = rs.getFloat("PAGA");

	            dip = new Dipendente(nomeD, cognomeD, mansioneD, pagaD);
	            System.out.println("Dipendente trovato: " + dip.toString());
	        }

	        // Chiusura delle risorse
	        rs.close();
	        pstmt.close();
	        conn.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return dip;
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
	
	   // Metodo per recuperare il prezzo di un prodotto dato il suo nome
	public float getProductPriceByName(String productName) throws SQLException {
	       float price = 0;
	       
	       ResultSet rs = null;
	        try {
	        	Connection conn = DriverManager.getConnection(DB_URL);
		        String query = "SELECT PREZZO_UNITARIO FROM PRODOTTO WHERE NOME_PRODOTTO = ? ";
		        PreparedStatement pstmt = conn.prepareStatement(query);
	            pstmt.setString(1, productName);

	            // Esecuzione della query
	            rs = pstmt.executeQuery();

	            // Se il prodotto è trovato, ottieni il prezzo
	            if (rs.next()) {
	                price = rs.getFloat("PREZZO_UNITARIO");
	            }
	            rs.close();
		        pstmt.close();
		        conn.close();
	        } catch (SQLException e) {
	            // Gestione delle eccezioni
	            e.printStackTrace();
	        	} 
	        return price;
	        }

	

	
	/*public Object[][] contaProdottiPerCategoria() {
	    try {
	        Connection conn = DriverManager.getConnection(DB_URL);
	        Statement stmt = conn.createStatement();

	        String query = "SELECT CATEGORIA, COUNT(*) AS NUMEROPRODOTTI FROM PRODOTTO GROUP BY CATEGORIA";
	        ResultSet rs = stmt.executeQuery(query);

	        List<Object[]> resultList = new ArrayList<>();

	        while (rs.next()) {
	            String Categoria = rs.getString("CATEGORIA");
	            int NumeroProdotti = rs.getInt("NUMEROPRODOTTI");
	            Object[] categoriaENumero = {Categoria, NumeroProdotti};
	            resultList.add(categoriaENumero);
	        }

	        rs.close();
	        stmt.close();
	        conn.close();

	        return resultList.toArray(new Object[0][0]);
	    } catch (SQLException e) {
	        e.printStackTrace();
	        // Gestione delle eccezioni
	    }

	    return new Object[0][0]; // Se qualcosa va storto, restituisce un array vuoto
	}*/
	
	public Object[][] contaProdottiPerCategoria() {
	    try {
	        Connection conn = DriverManager.getConnection(DB_URL);
	        Statement stmt = conn.createStatement();

	        // Ottieni tutte le categorie dalla tabella Categoria
	        String queryCategorie = "SELECT NOMECATEGORIA FROM CATEGORIA";
	        ResultSet rsCategorie = stmt.executeQuery(queryCategorie);

	        List<Object[]> resultList = new ArrayList<>();

	        // Inizializza la lista di array con tutte le categorie e inizialmente 0 prodotti
	        while (rsCategorie.next()) {
	            String categoria = rsCategorie.getString("NOMECATEGORIA");
	            Object[] categoriaENumero = {categoria, 0};
	            resultList.add(categoriaENumero);
	        }

	        // Ottieni il conteggio dei prodotti per ciascuna categoria
	        String queryConteggio = "SELECT CATEGORIA, COUNT(*) AS NUMEROPRODOTTI FROM PRODOTTO GROUP BY CATEGORIA";
	        ResultSet rsConteggio = stmt.executeQuery(queryConteggio);

	        // Aggiorna il conteggio effettivo dei prodotti per ciascuna categoria
	        while (rsConteggio.next()) {
	            String categoria = rsConteggio.getString("CATEGORIA");
	            int numeroProdotti = rsConteggio.getInt("NUMEROPRODOTTI");

	            // Aggiorna il numero di prodotti per la categoria corrispondente
	            for (Object[] coppia : resultList) {
	                if (categoria.equals(coppia[0])) {
	                    coppia[1] = numeroProdotti;
	                    break;
	                }
	            }
	        }

	        rsCategorie.close();
	        rsConteggio.close();
	        stmt.close();
	        conn.close();

	        return resultList.toArray(new Object[0][0]);
	    } catch (SQLException e) {
	        e.printStackTrace();
	        // Gestione delle eccezioni
	    }

	    return new Object[0][0]; // Se qualcosa va storto, restituisce un array vuoto
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
                System.out.println("Prodotto " + nomeProdotto + " cancellato con successo.");
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
    
    // Metodo per cancellare un prodotto da una categoria
    public void deleteProdottoByCategoria(String nomeCategoria) {
        try {
            Connection conn = DriverManager.getConnection(DB_URL);
            PreparedStatement pstmt = null;

            // Query per eliminare i prodotti associati alla categoria specificata
            String deleteQuery = "DELETE FROM PRODOTTO WHERE CATEGORIA IN (SELECT NOMECATEGORIA FROM CATEGORIA WHERE NOMECATEGORIA = ?)";
            pstmt = conn.prepareStatement(deleteQuery);
            pstmt.setString(1, nomeCategoria);

            int rowsAffected = pstmt.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Prodotti appartenenti alla categoria " + nomeCategoria + " eliminati con successo.");
            } else {
                System.out.println("Nessun prodotto trovato appartenente alla categoria: " + nomeCategoria);
            }

            // Chiusura delle risorse
            if (pstmt != null) {
                pstmt.close();
            }
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
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
    
    public void changeCategoria(String vecchioNomeCategoria, String nuovoNomeCategoria) {
    	try {
            Connection conn = DriverManager.getConnection(DB_URL);
            String query = "UPDATE CATEGORIA SET NOMECATEGORIA = ? WHERE NOMECATEGORIA = ?" ;
            PreparedStatement pstmtCategoria = conn.prepareStatement(query);
            pstmtCategoria.setString(1, nuovoNomeCategoria);
            pstmtCategoria.setString(2, vecchioNomeCategoria);

            int rowsUpdatedCategoria = pstmtCategoria.executeUpdate();
            if (rowsUpdatedCategoria > 0) {
                // Aggiorna a cascata i prodotti che appartengono alla categoria
                String updateProdottiQuery = "UPDATE PRODOTTO SET CATEGORIA = ? WHERE CATEGORIA = ?";
                PreparedStatement pstmtProdotti = conn.prepareStatement(updateProdottiQuery);
                pstmtProdotti.setString(1, nuovoNomeCategoria);
                pstmtProdotti.setString(2, vecchioNomeCategoria);
                int rowsUpdatedProdotti = pstmtProdotti.executeUpdate();

                System.out.println("Categoria modificata con successo.");

                if (rowsUpdatedProdotti > 0) {
                    System.out.println("Prodotti appartenenti alla categoria aggiornati.");
                } else {
                    System.out.println("Nessun prodotto trovato appartenente alla categoria.");
                }

                pstmtProdotti.close();
            } else {
                System.out.println("Nessuna categoria trovata con il nome specificato.");
            }

            pstmtCategoria.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    	
    }

    public void deleteCategoria(String nomeCategoria) {
    	Connection conn = null;
    	PreparedStatement pstmt = null;

        try {
            // Connessione al database
            Connection conn1 = DriverManager.getConnection(DB_URL);
            
            // Query per cancellare la categoria col nome specificato
            String query = "DELETE FROM CATEGORIA WHERE NOMECATEGORIA= ?";
            
            // Creazione del prepared statement
            pstmt = conn1.prepareStatement(query);
            pstmt.setString(1, nomeCategoria);
            
            // Esecuzione della query per cancellare la categoria
            int rowsAffected = pstmt.executeUpdate();
            
            // Verifica se la categoria è stata cancellata correttamente
            if (rowsAffected > 0) {
                System.out.println("Categoria " + nomeCategoria + " cancellata con successo.");
            } else {
                System.out.println("Nessuna categoria con il seguente nome: " + nomeCategoria);
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

    public void changeDipendente(String nome, String cognome, String nuovaMansione, float nuovaPaga) {
    	
    	try {
            Connection conn = DriverManager.getConnection(DB_URL);
            String query = "UPDATE PERSONALE SET MANSIONE = ?, PAGA = ? WHERE NOME = ? AND COGNOME = ? " ;
            PreparedStatement pstmtPersonale = conn.prepareStatement(query);
            pstmtPersonale.setString(1, nuovaMansione);
            pstmtPersonale.setFloat(2, nuovaPaga);
            pstmtPersonale.setString(3, nome);
            pstmtPersonale.setString(4, cognome);
            
            int rowsUpdated = pstmtPersonale.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Dipendente modificato con successo.");
            } else {
                System.out.println("Nessun dipendente trovato con il nome specificato.");
            }
            
			pstmtPersonale.close();
			conn.close();
			System.out.println("Dipendente " + nome + " " + cognome + " Aggiornato");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void createNewTableCantiere(String NomeCantiere) {
		try {
			Connection conn = DriverManager.getConnection(DB_URL);
			if (conn != null) {
				Statement stmt = conn.createStatement();
				String sql = "CREATE TABLE " +NomeCantiere + " ( NOMECANTIERE		TEXT PRIMARY KEY)";
				stmt.executeUpdate(sql);
				stmt.close();
				conn.close();
				System.out.println("Nuova tabella " + NomeCantiere + " creata");
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
    
    /*public void insertIntoNewCantiere(String NomeCantiere, String Categoria, String Prodotto, float Quantita) {
    	try {
			Connection conn = DriverManager.getConnection(DB_URL);
			if (conn != null) {
				Statement stmt = conn.createStatement();
				String sql = "INSERT INTO " + NomeCantiere + " VALUES (" + " \"" + Categoria + "\"," + " \""
						+ prod.getNomeProdotto() + "\"," + " \"" + prod.getPrezzoProdotto() + "\"," + " \""
						+ prod.getCategoria() + "\"" + ")";;
				}
    	}
    }*/
}

	


