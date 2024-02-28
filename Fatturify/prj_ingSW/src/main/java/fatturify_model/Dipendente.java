package fatturify_model;

import java.util.Random;

public class Dipendente {

    private String idDipendente;  
    private String nome;          
    private String cognome;       
    //private String reparto;       
    private String mansione;     
    private double pagaOraria;     

    public Dipendente(String nome, String cognome, String mansione, float pagaOraria) {
        
    	this.idDipendente =GenerateID(nome, cognome);
        this.nome = nome;
        this.cognome = cognome;
        /*this.reparto = reparto;*/
        this.mansione = mansione;
        this.pagaOraria = pagaOraria;
    }
    
	public String GenerateID(String Nome, String Cognome) {
		Random random = new Random();
		int numeroCasuale = random.nextInt(90) + 10;
		String finalID = Nome.substring(0, Math.min(Nome.length(), 3))+Cognome.substring(0, Math.min(Cognome.length(), 3));
		finalID += numeroCasuale;
		return finalID;
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

    /*public String getReparto() {
        return reparto;
    }

    public void setReparto(String reparto) {
        this.reparto = reparto;
    }*/

    public String getMansione() {
        return mansione;
    }

    public void setMansione(String mansione) {
        this.mansione = mansione;
    }

    public double getPaga() {
        return pagaOraria;
    }

    public void setPaga(float pagaOraria) {
        this.pagaOraria = pagaOraria;
    }

    @Override
    public String toString() {
        return "Dipendente{" +
                "idDipendente='" + idDipendente + '\'' +
                ", nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                /*", reparto='" + reparto + '\'' +*/
                ", mansione='" + mansione + '\'' +
                ", paga oraria=" + pagaOraria +
                '}';
    }
}
