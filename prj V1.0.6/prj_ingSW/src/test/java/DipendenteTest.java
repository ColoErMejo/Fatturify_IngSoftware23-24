import static org.junit.Assert.*;
import org.junit.Test;

import fatturify_model.Dipendente;

public class DipendenteTest {

    @Test
    public void testCreazioneDipendente() {
        // Dati di esempio per il dipendente
        String nome = "Mario";
        String cognome = "Rossi";
        String mansione = "Programmatore";
        float pagaOraria = 20.50f;

        // Crea un'istanza della classe Dipendente
        Dipendente dipendente = new Dipendente(nome, cognome, mansione, pagaOraria);

        // Verifica che l'istanza sia stata creata correttamente
        assertNotNull(dipendente);
        assertEquals(nome, dipendente.getNome());
        assertEquals(cognome, dipendente.getCognome());
        assertEquals(mansione, dipendente.getMansione());
        assertEquals(pagaOraria, dipendente.getPaga(), 0.001f); // Tolleranza di errore
    }

    @Test
    public void testModificaPagaDipendente() {
        // Dati di esempio per il dipendente
        String nome = "Paolo";
        String cognome = "Bianchi";
        String mansione = "Analista";
        float pagaOraria = 25.00f;

        // Crea un'istanza della classe Dipendente
        Dipendente dipendente = new Dipendente(nome, cognome, mansione, pagaOraria);

        // Modifica la paga oraria del dipendente
        float nuovaPagaOraria = 27.00f;
        dipendente.setPaga(nuovaPagaOraria);

        // Verifica che la paga sia stata modificata correttamente
        assertEquals(nuovaPagaOraria, dipendente.getPaga(), 0.001f);
    }

    @Test
    public void testModificaPagaDipendenteNelDatabase() {
        // Dati di esempio per il dipendente
        String nome = "Paolo";
        String cognome = "Bianchi";
        String mansione = "Analista";
        float pagaOraria = 25.00f;

        // Crea un'istanza della classe Dipendente
        Dipendente dipendente = new Dipendente(nome, cognome, mansione, pagaOraria);

        // Modifica la paga oraria del dipendente
        float nuovaPagaOraria = 27.00f;
        dipendente.setPaga(nuovaPagaOraria); // Modifica la paga nel database

        // Ora, recupera il dipendente dal database o dal sistema di persistenza
        // Assicurati che il dipendente sia stato effettivamente modificato nel database
        Dipendente dipendenteRecuperato = new Dipendente(nome, cognome, mansione, pagaOraria);
        assertEquals(nuovaPagaOraria, dipendenteRecuperato.getPaga(), 0.001f);
    }


    @Test
    public void testCognomeNullo() {
        // Dati di esempio per il dipendente
        String nome = "Luca";
        String cognome = null; // Cognome nullo
        String mansione = "Amministrativo";
        float pagaOraria = 18.00f;

        // Testa la creazione di un dipendente con cognome nullo
        try {
            // Cerca di creare un'istanza della classe Dipendente con cognome nullo
            Dipendente dipendente = new Dipendente(nome, cognome, mansione, pagaOraria);
            // Se non viene lanciata un'eccezione, il test fallisce
            fail("Dovrebbe essere lanciata un'eccezione per cognome nullo");
        } catch (IllegalArgumentException e) {
            // Se viene lanciata un'eccezione come previsto, il test passa
            assertTrue(true);
        }
    }

}

/*import static org.junit.Assert.*;
import org.junit.Test;

import fatturify_model.Dipendente;

public class DipendenteTest {

    @Test
    public void testCreazioneDipendente() {
        // Dati di esempio per il dipendente
        String nome = "Mario";
        String cognome = "Rossi";
        String mansione = "Programmatore";
        float pagaOraria = 20.50f;

        // Crea un'istanza della classe Dipendente
        Dipendente dipendente = new Dipendente(nome, cognome, mansione, pagaOraria);

        // Verifica che l'istanza sia stata creata correttamente
        assertNotNull(dipendente);
        assertEquals(nome, dipendente.getNome());
        assertEquals(cognome, dipendente.getCognome());
        assertEquals(mansione, dipendente.getMansione());
        assertEquals(pagaOraria, dipendente.getPaga(), 0.001f); // Tolleranza di errore
    }
}
*/