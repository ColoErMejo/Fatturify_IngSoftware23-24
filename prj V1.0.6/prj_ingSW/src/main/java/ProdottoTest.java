import static org.junit.Assert.*;
import org.junit.Test;

import model.Prodotto;

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
