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



}