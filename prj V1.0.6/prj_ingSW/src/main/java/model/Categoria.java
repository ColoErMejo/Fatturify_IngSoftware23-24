package model;

import java.util.ArrayList;
import java.util.List;

import database.DB;

public class Categoria {

	public String NomeCategoria;
	private List<Prodotto> ListaProdotti = new ArrayList<>();
	

	public Categoria(String NomeCategoria) {
		this.NomeCategoria = NomeCategoria;
		
	}

	public void AddProdotto(Prodotto prodotto) {
		ListaProdotti.add(prodotto);
	}

	public void RimuoviProdotto(Prodotto prodotto) {
		ListaProdotti.remove(prodotto);
	}

	//DA RIFARE IN PRODOTTO
	/*public void ModificaProdotto(Prodotto prodotto, String NuovoNome, float NuovoCosto) {
		System.out.println("vecchio prodotto");
		System.out.println("prodotto.toString()");
		int posizione = ListaProdotti.indexOf(prodotto);
		Prodotto prodottoNew = new Prodotto(NuovoNome, NuovoCosto, NomeCategoria);
		ListaProdotti.set(posizione, prodottoNew);
	}*/

	public String NumeroDiProdotti() {
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
		ListaProdotti = listaProdotti;
	}
	
	

}
