package model;
import java.util.Date;


public class Fattura {
    private int idFattura;
    private String idCliente;
    private Date dataEmissione;
    private float importo;
    private String descrizione;
    static final int aliquotaIVA = 22;

    // Costruttore
    public Fattura(int idFattura, String idCliente, Date dataEmissione, float importo, String descrizione) {
        this.idFattura = idFattura;
        this.idCliente = idCliente;
        this.dataEmissione = dataEmissione;
        this.importo = importo;
        this.descrizione = descrizione;
    }

    // Getters e setters
    public int getIdFattura() {
        return idFattura;
    }

    public void setIdFattura(int idFattura) {
        this.idFattura = idFattura;
    }

    public String getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(String idCliente) {
		this.idCliente = idCliente;
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
    public String toString() {
        return "Fattura{" +
                "idFattura='" + idFattura + '\'' +
                ", idCliente='" + idCliente + '\'' +
                ", dataFattura=" + dataEmissione +
                ", totaleImporto=" + importo +
                '}';
    }

}
