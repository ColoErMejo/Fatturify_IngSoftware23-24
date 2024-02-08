import static org.junit.Assert.*;
import org.junit.Test;

import model.Categoria;
import model.Prodotto;

import java.util.ArrayList;
import java.util.List;

public class CategoriaTest {

    @Test
    public void testCreazioneCategoria() {
        // Dati di esempio per la categoria
        String nomeCategoria = "Elettronica";

        // Crea una lista di prodotti di esempio
        List<Prodotto> listaProdotti = new ArrayList<>();
        listaProdotti.add(new Prodotto("Smartphone", 699, "Elettronica"));
        listaProdotti.add(new Prodotto("Laptop", 1299, "Elettronica"));

        // Crea un'istanza della classe Categoria
        Categoria categoria = new Categoria(nomeCategoria);
        categoria.setListaProdotti(listaProdotti);

        // Verifica che l'istanza sia stata creata correttamente
        assertNotNull(categoria);
        assertEquals(nomeCategoria, categoria.getNomeCategoria());
        assertEquals(listaProdotti, categoria.getListaProdotti());
    }
}

