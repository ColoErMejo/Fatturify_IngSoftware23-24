package model;

import java.util.ArrayList;
import java.util.List;

public class Categoria {

	public String NomeCategoria;
	List<Prodotto> ListaProdotti = new ArrayList<>();

	public Categoria(String NomeCategoria) {
		this.NomeCategoria = NomeCategoria;
	}

	public void AddProdotti(Prodotto prodotto) {
		ListaProdotti.add(prodotto);
	}

	public void RimuoviProdotto(Prodotto prodotto) {
		ListaProdotti.remove(prodotto);
	}

	public void ModificaProdotto(Prodotto prodotto, String NuovoNome, float NuovoCosto) {
		System.out.println("vecchio prodotto");
		prodotto.toString();
		int posizione = ListaProdotti.indexOf(prodotto);
		Prodotto prodottoNew = new Prodotto(NuovoNome, NuovoCosto);
		ListaProdotti.set(posizione, prodottoNew);
	}

}
