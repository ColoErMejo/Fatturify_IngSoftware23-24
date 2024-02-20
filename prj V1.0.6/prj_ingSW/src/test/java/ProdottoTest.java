import static org.junit.Assert.*;
import org.junit.Test;

import fatturify_model.Prodotto;

public class ProdottoTest {

    @Test
    public void testCreazioneProdotto() {
        // Dati di esempio per il prodotto
        String categoria = "P001";
        String nome = "Prodotto di test";
        float prezzo = 25;

        // Crea un'istanza della classe Prodotto
        Prodotto prodotto = new Prodotto(nome, prezzo, categoria);

        // Verifica che l'istanza sia stata creata correttamente
        assertNotNull(prodotto);
        assertEquals(nome, prodotto.getNomeProdotto());
        assertEquals(categoria, prodotto.getCategoria());
        assertEquals(prezzo, prodotto.getPrezzoProdotto(), 0.001); // Tolleranza di errore
    }

    @Test
    public void testModificaPrezzoProdotto() {
        // Dati di esempio per il prodotto
        String categoria = "P002";
        String nome = "Prodotto di test 2";
        float prezzo = 30;

        // Crea un'istanza della classe Prodotto
        Prodotto prodotto = new Prodotto(nome, prezzo, categoria);

        // Modifica il prezzo del prodotto
        float nuovoPrezzo = 35;
        prodotto.setPrezzoProdotto(nuovoPrezzo);

        // Verifica che il prezzo sia stato modificato correttamente
        assertEquals(nuovoPrezzo, prodotto.getPrezzoProdotto(), 0.001);
    }

    @Test
    public void testNomeNullo() {
        // Dati di esempio per il prodotto
        String categoria = "P003";
        String nome = null; // Nome nullo
        float prezzo = 20;

        // Testa la creazione di un prodotto con nome nullo
        try {
            // Cerca di creare un'istanza della classe Prodotto con nome nullo
            Prodotto prodotto = new Prodotto(nome, prezzo, categoria);
            // Se non viene lanciata un'eccezione, il test fallisce
            fail("Dovrebbe essere lanciata un'eccezione per nome nullo");
        } catch (IllegalArgumentException e) {
            // Se viene lanciata un'eccezione come previsto, il test passa
            assertTrue(true);
        }
    }

}
/*import static org.junit.Assert.*;
import org.junit.Test;

import fatturify_model.Prodotto;

public class ProdottoTest {

    @Test
    public void testCreazioneProdotto() {
        // Dati di esempio per il prodotto
        String categoria = "P001";
        String nome = "Prodotto di test";
        float prezzo = 25;

        // Crea un'istanza della classe Prodotto
        Prodotto prodotto = new Prodotto(nome, prezzo, categoria);

        // Verifica che l'istanza sia stata creata correttamente
        assertNotNull(prodotto);
        assertEquals(nome, prodotto.getNomeProdotto());
        assertEquals(categoria, prodotto.getCategoria());
        assertEquals(prezzo, prodotto.getPrezzoProdotto(), 0.001); // Tolleranza di errore
    }
}
*/