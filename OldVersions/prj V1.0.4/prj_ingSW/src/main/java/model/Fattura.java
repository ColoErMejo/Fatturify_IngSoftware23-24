package model;
import java.util.Date;


public class Fattura {
    private int numeroFattura;
    private Date dataEmissione;
    private float importo;
    private String descrizione;
    static final int aliquotaIVA = 22;

    // Costruttore
    public Fattura(int numeroFattura, Date dataEmissione, float importo, String descrizione) {
        this.numeroFattura = numeroFattura;
        this.dataEmissione = dataEmissione;
        this.importo = importo;
        this.descrizione = descrizione;
    }

    // Getters e setters
    public int getNumeroFattura() {
        return numeroFattura;
    }

    public void setNumeroFattura(int numeroFattura) {
        this.numeroFattura = numeroFattura;
    }

    public Date getDataEmissione() {
        return dataEmissione;
    }

    public void setDataEmissione(Date dataEmissione) {
        this.dataEmissione = dataEmissione;
    }

    public float getImporto() {
        return importo;
    }

    public void setImporto(float importo) {
        this.importo = importo;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }
    public double calcolaIVA(int aliquotaIVA) {
        return importo * aliquotaIVA / 100;
    }

}
