package model;
import java.util.ArrayList;
import java.util.List;


public class Cantiere {
	    private String nome;
	    private List<Fattura> fatture;
	    private List<Dipendente> listaDipendenti;

	    // Costruttore
	    public Cantiere(String nome, String indirizzo) {
	        this.nome = nome;
	        this.fatture = new ArrayList<>();
	        this.listaDipendenti = new ArrayList<>();
	    }

	    // Metodi per gestire le fatture
	    public void addFattura(Fattura nuovaFattura) {
	        this.fatture.add(nuovaFattura);
	    }

	    public List<Fattura> getFatture() {
	        return this.fatture;
	    }

	    // Metodi per gestire i dipendenti
	    public void addDipendente(Dipendente nuovoDipendente) {
	        this.listaDipendenti.add(nuovoDipendente);
	    }

	    public List<Dipendente> getListaDipendenti() {
	        return this.listaDipendenti;
	    }

	    // Altri metodi per gestire il cantiere
	    // ... (ad esempio, per calcolare il totale delle fatture, gestire l'organizzazione del cantiere, ecc.)

	    // Getters e setters per nome
	    public String getNome() {
	        return nome;
	    }

	    public void setNome(String nome) {
	        this.nome = nome;
	    }

	}

