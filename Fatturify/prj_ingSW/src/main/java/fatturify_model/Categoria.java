package fatturify_model;

import java.util.ArrayList;
import java.util.List;

import fatturify_database.DB;

public class Categoria {

	public String NomeCategoria;
	private List<Prodotto> ListaProdotti;
	

	public Categoria(String NomeCategoria) {
		this.NomeCategoria = NomeCategoria;
		this.ListaProdotti= new ArrayList<>();
		
	}

	public void AddProdotto(Prodotto prodotto) {
		ListaProdotti.add(prodotto);
	}

	public void RimuoviProdotto(Prodotto prodotto) {
		ListaProdotti.remove(prodotto);
	}

	public void ModificaProdotto(String vecchioNome, String nuovoNome, float nuovoPrezzo) {
	// Itera sulla lista dei prodotti della categoria per trovare il prodotto corrispondente
    for (Prodotto prodotto : ListaProdotti) {
        if (prodotto.getNomeProdotto() == vecchioNome) {
            // Modifica il prodotto nella lista
            prodotto.setNomeProdotto(nuovoNome);
            prodotto.setPrezzoProdotto(nuovoPrezzo);
            break; // Esci dal ciclo una volta trovato il prodotto
        	}
    	}
	}

	public String NumeroDiProdotti(List<Prodotto> ListaProdotti) {
	    String data = Integer.toString(ListaProdotti.size());
		return data;
	}

	@Override
	public String toString() {
		return "Categoria [NomeCategoria=" + NomeCategoria + ", ListaProdotti=" + ListaProdotti + "]";
	}

	public String getNomeCategoria() {
		return NomeCategoria;
	}

	public void setNomeCategoria(String nomeCategoria) {
		NomeCategoria = nomeCategoria;
	}

	public List<Prodotto> getListaProdotti() {
		return ListaProdotti;
	}

	public void setListaProdotti(List<Prodotto> listaProdotti) {
		this.ListaProdotti = listaProdotti;
	}
	
	

}
