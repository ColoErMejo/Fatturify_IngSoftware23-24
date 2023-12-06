package model;

import java.util.Random;

public class Prodotto {

	public String IDprodotto;
	public String NomeProdotto;
	private float PrezzoProdotto;

	public Prodotto(String NomeProdotto, float PrezzoProdotto) {
		this.IDprodotto = GenerateID(NomeProdotto);
		this.NomeProdotto = NomeProdotto;
		this.PrezzoProdotto = PrezzoProdotto;
	}

	public String GenerateID(String NomeProdotto) {
		Random random = new Random();
		int numeroCasuale = random.nextInt(90) + 10;
		String finalID = NomeProdotto.substring(0, Math.min(NomeProdotto.length(), 3));
		finalID += numeroCasuale;
		return finalID;
	}

	public String getIDprodotto() {
		return IDprodotto;
	}

	public void setIDprodotto(String iDprodotto) {
		IDprodotto = iDprodotto;
	}

	public String getNomeProdotto() {
		return NomeProdotto;
	}

	public void setNomeProdotto(String nomeProdotto) {
		NomeProdotto = nomeProdotto;
	}

	public float getPrezzoProdotto() {
		return PrezzoProdotto;
	}

	public void setPrezzoProdotto(float prezzoProdotto) {
		PrezzoProdotto = prezzoProdotto;
	}

	@Override
	public String toString() {
		return "Prodotto [IDprodotto=" + IDprodotto + ", NomeProdotto=" + NomeProdotto + ", PrezzoProdotto="
				+ PrezzoProdotto + "]";
	}

}
