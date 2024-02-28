package fatturify_database;

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

import fatturify_controller.Return_Avalaible_Data;
import fatturify_model.Categoria;
import fatturify_model.Dipendente;
import fatturify_model.Prodotto;

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
						+ " \"" + Password + "\", "
						+ "FALSE, FALSE, FALSE, FALSE)";
				stmt.executeUpdate(sql);
				stmt.close();
				conn.close();
				System.out.println("Classe DB: Utente inserito con successo");
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public void insertNuovoCantiere(String NomeCantiere) {
		try {
			Connection conn = DriverManager.getConnection(DB_URL);
			if (conn != null) {
				
				String sql = "INSERT INTO CANTIERE (NOMECANTIERE) VALUES (?)";
				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, NomeCantiere);
			    pstmt.executeUpdate();
			    
				pstmt.close();
				conn.close();
				System.out.println("Cantiere " + NomeCantiere + "inserito con successo");
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void insertAttCantProd(int idAttivita, String Codice_Prodotto, float quantita, float costoTotale) {
	    String sql = "INSERT INTO ATTIVITACANTPROD (ID_ATTIVITA, ID_Prodotto, Quantita, Costo_Totale) VALUES (?, ?, ?, ?)";

	    try (Connection conn = DriverManager.getConnection(DB_URL);
	         PreparedStatement pstmt = conn.prepareStatement(sql)) {

	        pstmt.setInt(1, idAttivita);
	        pstmt.setString(2, Codice_Prodotto);
	        pstmt.setFloat(3, quantita);
	        pstmt.setFloat(4, costoTotale);

	        pstmt.executeUpdate();
	        System.out.println("Prodotto aggiunto alle attività del cantiere con successo!");

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
	
	public void updateQuantitaProdotto(int idAttivita, String idProdotto, float nuovaQuantita) {
	    String sql = "UPDATE ATTIVITACANTPROD SET Quantita = ? WHERE ID_ATTIVITA = ? AND ID_Prodotto = ?";

	    try (Connection conn = DriverManager.getConnection(DB_URL);
	         PreparedStatement pstmt = conn.prepareStatement(sql)) {

	        pstmt.setFloat(1, nuovaQuantita);
	        pstmt.setInt(2, idAttivita);
	        pstmt.setString(3, idProdotto);

	        pstmt.executeUpdate();

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
	
	public boolean isProdottoInAttivita(int idAttivita, String idProdotto) {
	    String sql = "SELECT COUNT(*) AS count FROM ATTIVITACANTPROD WHERE ID_ATTIVITA = ? AND ID_Prodotto = ?";

	    try (Connection conn = DriverManager.getConnection(DB_URL);
	         PreparedStatement pstmt = conn.prepareStatement(sql)) {

	        pstmt.setInt(1, idAttivita);
	        pstmt.setString(2, idProdotto);

	        try (ResultSet resultSet = pstmt.executeQuery()) {
	            if (resultSet.next()) {
	                int count = resultSet.getInt("count");
	                return count > 0; // Se count è maggiore di 0, il prodotto è presente
	            }
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return false; // In caso di errore o nessun risultato
	}


	
	public void insertAttCantPers(int idAttivita, String ID_Personale, float nOre, String descrizione) {
	    String sql = "INSERT INTO ATTIVITACANTPERS (ID_ATTIVITA, ID_Dipendente, Nore, Descrizione) VALUES (?, ?, ?, ?)";

	    try (Connection conn = DriverManager.getConnection(DB_URL);
	         PreparedStatement pstmt = conn.prepareStatement(sql)) {

	        pstmt.setInt(1, idAttivita);
	        pstmt.setString(2, ID_Personale);
	        pstmt.setFloat(3, nOre);
	        pstmt.setString(4, descrizione);

	        pstmt.executeUpdate();
	        System.out.println("Dipendente aggiunto alle attività del cantiere con successo!");

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
	
	public void updateOreDescPersonale(int idAttivita, String idPersonale, float nOre, String descrizione) {
	    String sql = "UPDATE ATTIVITACANTPERS SET Nore = ?, Descrizione = ? WHERE ID_ATTIVITA = ? AND ID_Dipendente = ?";

	    try (Connection conn = DriverManager.getConnection(DB_URL);
	         PreparedStatement pstmt = conn.prepareStatement(sql)) {

	        pstmt.setFloat(1, nOre);
	        pstmt.setString(2, descrizione);
	        pstmt.setInt(3, idAttivita);
	        pstmt.setString(4, idPersonale);

	        pstmt.executeUpdate();

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}

	
	public boolean isPersonaleInAttivita(int idAttivita, String idDipendente) {
	    String sql = "SELECT COUNT(*) AS count FROM ATTIVITACANTPERS WHERE ID_ATTIVITA = ? AND ID_Dipendente = ?";

	    try (Connection conn = DriverManager.getConnection(DB_URL);
	         PreparedStatement pstmt = conn.prepareStatement(sql)) {

	        pstmt.setInt(1, idAttivita);
	        pstmt.setString(2, idDipendente);

	        try (ResultSet resultSet = pstmt.executeQuery()) {
	            if (resultSet.next()) {
	                int count = resultSet.getInt("count");
	                return count > 0; // Se count è maggiore di 0, il dipendente è presente
	            }
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return false; // In caso di errore o nessun risultato
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
		        String query = "SELECT PREZZO FROM PRODOTTO WHERE NOME_PRODOTTO = ? ";
		        PreparedStatement pstmt = conn.prepareStatement(query);
	            pstmt.setString(1, productName);

	            // Esecuzione della query
	            rs = pstmt.executeQuery();

	            // Se il prodotto è trovato, ottieni il prezzo
	            if (rs.next()) {
	                price = rs.getFloat("PREZZO");
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
	
	public Object[][] getProductsForIdAttivita(int idAttivita) {
	    ArrayList<Object[]> productList = new ArrayList<>();

	    String sqlSelect = "SELECT ID_Prodotto, Quantita, Costo_Totale " +
	                       "FROM ATTIVITACANTPROD " +
	                       "WHERE ID_ATTIVITA = ?";

	    String sqlProductName = "SELECT NOME_PRODOTTO " +
	                            "FROM PRODOTTO " +
	                            "WHERE Codice_Prodotto = ?";

	    try (Connection conn = DriverManager.getConnection(DB_URL);
	         PreparedStatement pstmtSelect = conn.prepareStatement(sqlSelect);
	         PreparedStatement pstmtProductName = conn.prepareStatement(sqlProductName)) {

	        pstmtSelect.setInt(1, idAttivita);
	        ResultSet rs = pstmtSelect.executeQuery();

	        while (rs.next()) {
	            String IDProdotto = rs.getString("ID_Prodotto");
	            int quantita = rs.getInt("Quantita");
	            float prezzoTotale = rs.getFloat("Costo_Totale");

	            // Eseguire la query per ottenere il nome del prodotto
	            pstmtProductName.setString(1, IDProdotto);
	            ResultSet rsProductName = pstmtProductName.executeQuery();

	            String nomeProdotto = "";
	            if (rsProductName.next()) {
	                nomeProdotto = rsProductName.getString("NOME_PRODOTTO");
	            }

	            Object[] productData = {nomeProdotto, quantita, prezzoTotale};
	            productList.add(productData);
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    // Converte l'ArrayList in un array bidimensionale di Object
	    Object[][] productArray = new Object[productList.size()][3];
	    productList.toArray(productArray);
	    return productArray;
	}
	
	
	public Object[][] getPersonalForIdAttivita(int idAttivita) {
	    ArrayList<Object[]> personalList = new ArrayList<>();

	    String sqlSelect = "SELECT ID_Dipendente, Nore, Descrizione " +
	                       "FROM ATTIVITACANTPERS " +
	                       "WHERE ID_ATTIVITA = ?";

	    String sqlPersonalName = "SELECT NOME || ' ' || COGNOME AS NomeCompleto " +
	                             "FROM PERSONALE " +
	                             "WHERE ID_PERSONALE = ?";

	    try (Connection conn = DriverManager.getConnection(DB_URL);
	         PreparedStatement pstmtSelect = conn.prepareStatement(sqlSelect);
	         PreparedStatement pstmtPersonalName = conn.prepareStatement(sqlPersonalName)) {

	        pstmtSelect.setInt(1, idAttivita);
	        ResultSet rs = pstmtSelect.executeQuery();

	        while (rs.next()) {
	            String ID_Dipendente = rs.getString("ID_Dipendente");
	            float numeroOre = rs.getFloat("Nore");
	            String descrizione = rs.getString("Descrizione");

	            // Eseguire la query per ottenere il nome completo del dipendente
	            pstmtPersonalName.setString(1, ID_Dipendente);
	            ResultSet rsPersonalName = pstmtPersonalName.executeQuery();

	            String nomeCompleto = "";
	            if (rsPersonalName.next()) {
	                nomeCompleto = rsPersonalName.getString("NomeCompleto");
	            }

	            Object[] personalData = {nomeCompleto, numeroOre, descrizione};
	            personalList.add(personalData);
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    // Converte l'ArrayList in un array bidimensionale di Object
	    Object[][] personalArray = new Object[personalList.size()][3];
	    personalList.toArray(personalArray);
	    return personalArray;
	}

	
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



	public int getIdAttivitaFromNomeCantiere(String nomeCantiere) {
	    int idAttivita = -1; // Valore di default nel caso in cui non venga trovato l'ID

	    String sql = "SELECT ID_ATTIVITA FROM CANTIERE WHERE NOMECANTIERE = ? LIMIT 1";
	    
	    try (Connection conn = DriverManager.getConnection(DB_URL);
	         PreparedStatement pstmt = conn.prepareStatement(sql)) {

	        pstmt.setString(1, nomeCantiere);
	        ResultSet rs = pstmt.executeQuery();

	        if (rs.next()) {
	            idAttivita = rs.getInt("ID_ATTIVITA");
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return idAttivita;
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
    
    public void deleteDipendente(String nomeDipendente, String cognomeDipendente) {
    	Connection conn = null;
    	PreparedStatement pstmt = null;

        try {
            // Connessione al database
            Connection conn1 = DriverManager.getConnection(DB_URL);
            
            // Query per cancellare la categoria col nome specificato
            String query = "DELETE FROM PERSONALE WHERE NOME= ? AND COGNOME = ?";
            
            // Creazione del prepared statement
            pstmt = conn1.prepareStatement(query);
            pstmt.setString(1, nomeDipendente);
            pstmt.setString(2, cognomeDipendente);
            
            // Esecuzione della query per cancellare il dipendente
            int rowsAffected = pstmt.executeUpdate();
            
            // Verifica se la categoria è stata cancellata correttamente
            if (rowsAffected > 0) {
                System.out.println("Dipendente " + nomeDipendente + " " + cognomeDipendente + " cancellato con successo.");
            } else {
                System.out.println("Nessun Dipendente con il seguente nome: " + nomeDipendente + " " + cognomeDipendente );
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

    public String getCodiceProdottoByNome(String nomeProdotto) {
        String codiceProdotto = null;

        try (Connection connection = DriverManager.getConnection(DB_URL)) {
            String query = "SELECT CODICE_PRODOTTO FROM PRODOTTO WHERE NOME_PRODOTTO = ?";
            
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, nomeProdotto);

                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        codiceProdotto = resultSet.getString("CODICE_PRODOTTO");
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return codiceProdotto;
    }

    public String getIDPersonaleByNomeCognome(String nome, String cognome) {
        String idPersonale = null;

        try (Connection connection = DriverManager.getConnection(DB_URL)) {
            String query = "SELECT ID_PERSONALE FROM PERSONALE WHERE NOME = ? AND COGNOME = ?";
            
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, nome);
                preparedStatement.setString(2, cognome);

                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        idPersonale = resultSet.getString("ID_PERSONALE");
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return idPersonale;
    }
    
    public boolean isColonnaPopolata(String NomeUtente, String colonna) {
        boolean columnValue = false;

        try {
            Connection conn = DriverManager.getConnection(DB_URL);
            if (conn != null) {
                String sql = "SELECT " + colonna + " FROM UTENTE WHERE NOMEUTENTE = ?";
                try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                    pstmt.setString(1, NomeUtente);

                    try (ResultSet rs = pstmt.executeQuery()) {
                        if (rs.next()) {
                            // Leggi il valore booleano dalla colonna specificata
                            columnValue = rs.getBoolean(colonna);
                        } else {
                            System.out.println("Nessun risultato trovato per NomeUtente: " + NomeUtente);
                        }
                    }
                }
                conn.close();
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return columnValue;
    }
    
    public void updateColonnaPopolata(String NomeUtente, String columnName) {
        try {
            Connection conn = DriverManager.getConnection(DB_URL);
            if (conn != null) {
                // Controlla se la tabella specificata è vuota
                boolean isTableEmpty = isTableEmpty(columnName);
                
                if (isTableEmpty) {
                    System.out.println("La tabella " + columnName + " è vuota. Aggiornamento a FALSE per NomeUtente: " + NomeUtente + " colonna: " + columnName);
                    
                    String sqlUpdateFalse = "UPDATE UTENTE SET " + columnName + " = FALSE WHERE NOMEUTENTE = ?";
                    try (PreparedStatement pstmtUpdateFalse = conn.prepareStatement(sqlUpdateFalse)) {
                        pstmtUpdateFalse.setString(1, NomeUtente);
                        int rowsAffectedFalse = pstmtUpdateFalse.executeUpdate();

                        if (rowsAffectedFalse > 0) {
                            System.out.println("Valore di " + columnName + " aggiornato a FALSE per NomeUtente: " + NomeUtente);
                        } else {
                            System.out.println("Nessun utente trovato con NomeUtente: " + NomeUtente);
                        }
                    }
                    
                } else {
                    // Verifica se il valore è già true
                    if (isColonnaPopolata(NomeUtente, columnName)) {
                        System.out.println("Il valore di " + columnName + " è già TRUE per NomeUtente: " + NomeUtente);
                    } else {
                        String sqlUpdateTrue = "UPDATE UTENTE SET " + columnName + " = TRUE WHERE NOMEUTENTE = ?";
                        try (PreparedStatement pstmtUpdateTrue = conn.prepareStatement(sqlUpdateTrue)) {
                            pstmtUpdateTrue.setString(1, NomeUtente);
                            int rowsAffectedTrue = pstmtUpdateTrue.executeUpdate();

                            if (rowsAffectedTrue > 0) {
                                System.out.println("Valore di " + columnName + " aggiornato a TRUE per NomeUtente: " + NomeUtente);
                            } else {
                                System.out.println("Nessun utente trovato con NomeUtente: " + NomeUtente);
                            }
                        }
                    }
                }
                conn.close();
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    
 // Metodo ausiliario per verificare se la tabella è vuota
    public boolean isTableEmpty(String tableName) {
        boolean isEmpty = false;

        try {
            Connection conn = DriverManager.getConnection(DB_URL);
            if (conn != null) {
                String sql = "SELECT COUNT(*) FROM " + tableName;
                try (PreparedStatement pstmt = conn.prepareStatement(sql);
                     ResultSet rs = pstmt.executeQuery()) {
                    if (rs.next()) {
                        int rowCount = rs.getInt(1);
                        isEmpty = (rowCount == 0);
                    }
                }
                conn.close();
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return isEmpty;
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

	


