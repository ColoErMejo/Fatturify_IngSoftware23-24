import static org.junit.Assert.*;
import org.junit.Test;

import model.Dipendente;

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
