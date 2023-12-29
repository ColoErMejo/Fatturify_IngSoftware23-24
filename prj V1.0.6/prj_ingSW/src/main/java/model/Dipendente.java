package model;

public class Dipendente {

    private String idDipendente;  
    private String nome;          
    private String cognome;       
    private String reparto;       
    private String posizione;     
    private double stipendio;     

    public Dipendente(String idDipendente, String nome, String cognome, String reparto, String posizione, double stipendio) {
        this.idDipendente = idDipendente;
        this.nome = nome;
        this.cognome = cognome;
        this.reparto = reparto;
        this.posizione = posizione;
        this.stipendio = stipendio;
    }

    public String getIdDipendente() {
        return idDipendente;
    }

    public void setIdDipendente(String idDipendente) {
        this.idDipendente = idDipendente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getReparto() {
        return reparto;
    }

    public void setReparto(String reparto) {
        this.reparto = reparto;
    }

    public String getPosizione() {
        return posizione;
    }

    public void setPosizione(String posizione) {
        this.posizione = posizione;
    }

    public double getStipendio() {
        return stipendio;
    }

    public void setStipendio(double stipendio) {
        this.stipendio = stipendio;
    }

    @Override
    public String toString() {
        return "Dipendente{" +
                "idDipendente='" + idDipendente + '\'' +
                ", nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", reparto='" + reparto + '\'' +
                ", posizione='" + posizione + '\'' +
                ", stipendio=" + stipendio +
                '}';
    }
}
