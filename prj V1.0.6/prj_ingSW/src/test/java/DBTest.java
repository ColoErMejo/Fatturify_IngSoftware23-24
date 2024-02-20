import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import fatturify_database.DB;
import fatturify_model.Dipendente;
import fatturify_model.Prodotto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBTest {
    private Connection connection;
    private DB db;
    private static final String DB_REL_FILE = "../database/DBTest.db3";
    private static final String DB_URL = "jdbc:sqlite:" + DB_REL_FILE;

    @Before
    public void setUp() throws SQLException {
        // Inizializza il database prima di eseguire ogni test
        db = new DB("DBTest");

        // Crea una connessione al database SQLite
        connection = DriverManager.getConnection(DB_URL);

    }

    @After
    public void tearDown() throws SQLException {
    	db.deleteProdotto("Smartphone");
    	db.deleteDipendente("NomeTest", "CognomeTest");
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

    @Test
    public void testAggiornamentoProdotto() throws SQLException {
        // Dati di esempio per il prodotto da aggiornare
        String nome = "Smartphone";
        String categoria = "Elettronica";
        float prezzo = 699;
        Prodotto prodotto = new Prodotto(nome, prezzo, categoria);

        // Inserisci il prodotto nel database
        db.insertNuovoProdotto(prodotto);
        
        assertTrue(verificaProdottoPresente(nome, categoria, prezzo));

        // Aggiorna il prezzo del prodotto
        float nuovoPrezzo = 749;
        db.changeProdotto(nome, nome, nuovoPrezzo, categoria); 
        // Verifica che il prezzo del prodotto sia stato aggiornato correttamente
       assertTrue(verificaProdottoPresente(nome, categoria, nuovoPrezzo));
    }

    @Test
    public void testEliminazioneProdotto() throws SQLException {
        // Dati di esempio per il prodotto da eliminare
        String nome = "Smartphone";
        String categoria = "Elettronica";
        float prezzo = 699;
        Prodotto prodotto = new Prodotto(nome, prezzo, categoria);

        // Inserisci il prodotto nel database
        db.insertNuovoProdotto(prodotto);
        
        // Elimina il prodotto dal database
        db.deleteProdotto(nome);
        
        // Verifica che il prodotto non sia più presente nel database
        assertFalse(verificaProdottoPresente(nome, categoria, prezzo));
    }
    
    @Test
    public void testInserimentoDipendente()throws SQLException {
    	//Dati di esempio
    	String nome = "NomeTest";
    	String cognome = "CognomeTest";
    	String mansione = "MansioneTest";
    	float paga = 5;
    	
    	Dipendente dipendente = new Dipendente(nome, cognome, mansione, paga);
    	
    	db.insertNuovoDipendente(dipendente);
    	
    	assertTrue(verificaDipendentePresente(nome, cognome, mansione, paga));
    	
    }
    
    @Test
    public void testModificaPagaDipendenteNelDatabase() {
        // Dati di esempio per il dipendente
    	String nome = "NomeTest";
    	String cognome = "CognomeTest";
    	String mansione = "MansioneTest";
    	float paga = 5;
    	Dipendente dipendenteRecuperato = null;

        // Crea un'istanza della classe Dipendente
        Dipendente dipendente = new Dipendente(nome, cognome, mansione, paga);
        db.insertNuovoDipendente(dipendente);

        // Modifica la paga oraria del dipendente
        float nuovaPagaOraria = 27;
        dipendente.setPaga(nuovaPagaOraria); // Modifica la paga nel database
        db.changeDipendente(nome, cognome, mansione, nuovaPagaOraria);

        // Ora, recupera il dipendente dal database o dal sistema di persistenza
        // Assicurati che il dipendente sia stato effettivamente modificato nel database
        dipendenteRecuperato = db.recuperaDipendentePerNome(nome, cognome);
        assertEquals(nuovaPagaOraria, dipendenteRecuperato.getPaga(), 0.001f);
    }
    
    

    // Metodo di utilità per verificare se un prodotto è presente nel database
    private boolean verificaProdottoPresente(String nome, String categoria, float prezzo) throws SQLException {
        String query = "SELECT * FROM PRODOTTO WHERE NOME_PRODOTTO = ? AND CATEGORIA = ? AND PREZZO = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, nome);
            stmt.setString(2, categoria);
            stmt.setFloat(3, prezzo);
            try (ResultSet resultSet = stmt.executeQuery()) {
                return resultSet.next();
            }
        }
    }
    
    // Metodo di utilità per verificare se un prodotto è presente nel database
    private boolean verificaDipendentePresente(String nome, String cognome, String mansione, float paga) throws SQLException {
        String query = "SELECT * FROM PERSONALE WHERE NOME = ? AND COGNOME = ? AND MANSIONE = ? AND PAGA = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, nome);
            stmt.setString(2, cognome);
            stmt.setFloat(4, paga);
            stmt.setString(3, mansione);
            try (ResultSet resultSet = stmt.executeQuery()) {
                return resultSet.next();
            }
        }
    }

}
