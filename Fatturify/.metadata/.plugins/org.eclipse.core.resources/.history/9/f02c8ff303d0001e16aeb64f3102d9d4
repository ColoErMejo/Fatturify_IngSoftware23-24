import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import fatturify_database.DB;
import fatturify_model.Prodotto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBTest {
    private static String NomeUtente;
	private Connection connection;
    private DB db;
    private static String DB_REL_FILE= "../database/" + NomeUtente + ".db3";
	private static String DB_URL= "jdbc:sqlite:" + DB_REL_FILE;

    @Before
    public void setUp() throws SQLException {
        // Inizializza il database prima di eseguire ogni test
        String nomeUtente = "prova4";
        db = new DB(nomeUtente);

        // Crea una connessione al database SQLite
        connection = DriverManager.getConnection(DB_URL);

        // Crea una tabella di prova per il test
        Statement stmt = connection.createStatement();
        stmt.executeUpdate("CREATE TABLE IF NOT EXISTS ProdottoTest (id INTEGER PRIMARY KEY AUTOINCREMENT, nome TEXT, categoria TEXT, prezzo REAL)");
    }

    @After
    public void tearDown() throws SQLException {
        // Elimina la tabella di prova dopo ogni test
        Statement stmt = connection.createStatement();
        stmt.executeUpdate("DROP TABLE IF EXISTS ProdottoTest");
        System.out.println("Test Concluso");
        
        // Chiudi la connessione dopo ogni test
        connection.close();
    }

    @Test
    public void testInserimentoProdotto() throws SQLException {
        // Dati di esempio per il nuovo prodotto
        String nome = "Smartphone";
        String categoria = "Elettronica";
        float prezzo = 699;

        Prodotto prodotto = new Prodotto(nome, prezzo, categoria);
        // Inserisci il nuovo prodotto nel database
        db.insertNuovoProdotto(prodotto);
        // Verifica che il prodotto sia stato inserito correttamente
        assertTrue(verificaProdottoPresente(nome, categoria, prezzo));
    }
    
    
 // Metodo di utilità per verificare se un prodotto è presente nel database
    private boolean verificaProdottoPresente(String nome, String categoria, float prezzo) throws SQLException {
        Statement stmt = connection.createStatement();
        ResultSet resultSet = stmt.executeQuery("SELECT * FROM ProdottoTest WHERE nome = '" + nome + "' AND categoria = '" + categoria + "' AND prezzo = " + prezzo);
        return resultSet.next(); // Restituisce true se il prodotto è presente nel ResultSet
    }
}

