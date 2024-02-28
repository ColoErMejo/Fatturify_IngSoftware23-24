import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;

import fatturify_model.Categoria;
import fatturify_model.Prodotto;

public class CategoriaTest {
   private Categoria categoria;

   @Before
   public void setUp() {
       categoria = new Categoria("Elettronica");
   }

   @Test
   public void testAggiuntaProdotto() {
       // Dati di esempio per il prodotto
       Prodotto prodotto = new Prodotto("Smartphone", 699, "Elettronica");
       // Aggiunge il prodotto alla categoria
       categoria.AddProdotto(prodotto);
       // Verifica che l'aggiunta del prodotto sia avvenuta correttamente
       assertTrue(categoria.getListaProdotti().contains(prodotto));
   }

   @Test
   public void testRimuoviProdotto() {
       // Dati di esempio per il prodotto
       Prodotto prodotto = new Prodotto("Smartphone", 699, "Elettronica");
       // Aggiungi il prodotto alla categoria
       categoria.AddProdotto(prodotto);
       // Rimuovi il prodotto dalla categoria
       categoria.RimuoviProdotto(prodotto);
       // Verifica che il prodotto sia stato rimosso correttamente
       assertFalse(categoria.getListaProdotti().contains(prodotto));
   }

   @Test
   public void testModificaProdotto() {
       // Dati di esempio per il prodotto
       Prodotto prodotto = new Prodotto("Smartphone", 699, "Elettronica");
       // Aggiungi il prodotto alla categoria
       categoria.AddProdotto(prodotto);
       // Modifica il prodotto
       categoria.ModificaProdotto("Smartphone", "Nuovo Smartphone", 799);
       // Verifica che il prodotto sia stato modificato correttamente
       assertEquals("Nuovo Smartphone", categoria.getListaProdotti().get(0).getNomeProdotto());
       assertEquals(799, categoria.getListaProdotti().get(0).getPrezzoProdotto(), 0.01);
   }

   @Test
   public void testNumeroDiProdotti() {
       // Dati di esempio per la categoria
       List<Prodotto> listaProdotti = new ArrayList<>();
       listaProdotti.add(new Prodotto("Smartphone", 699, "Elettronica"));
       listaProdotti.add(new Prodotto("Laptop", 1299, "Elettronica"));
       // Imposta la lista dei prodotti della categoria
       categoria.setListaProdotti(listaProdotti);
       // Verifica il numero di prodotti nella categoria
       assertEquals("2", categoria.NumeroDiProdotti(listaProdotti));
   }
}
