package model;

import java.util.Date;  

public class Fatture {

    private String idFattura;          
    private String idCliente;          
    private Date dataFattura;          
    private double totaleImporto;      

    public Fatture(String idFatture, String idCliente, Date dataFattura, double totaleImporto) {
        this.idFattura = idFatture;
        this.idCliente = idCliente;
        this.dataFattura = dataFattura;
        this.totaleImporto = totaleImporto;
    }

    public String getIdFattura() {
        return idFattura;
    }

    public void setIdFattura(String idFattura) {
        this.idFattura = idFattura;
    }

    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    public Date getDataFattura() {
        return dataFattura;
    }

    public void setDataFattura(Date dataFattura) {
        this.dataFattura = dataFattura;
    }

    public double getTotaleImporto() {
        return totaleImporto;
    }

    public void setTotaleImporto(double totaleImporto) {
        this.totaleImporto = totaleImporto;
    }

    @Override
    public String toString() {
        return "Fattura{" +
                "idFattura='" + idFattura + '\'' +
                ", idCliente='" + idCliente + '\'' +
                ", dataFattura=" + dataFattura +
                ", totaleImporto=" + totaleImporto +
                '}';
    }

}
