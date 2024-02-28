package fatturify_model;

public class Utente {

    private String idUtente; 
    private String nome;     
    private String email;    
    private String password; 

    // Costruttore per creare un nuovo utente
    public Utente(String idUtente, String nome, String email, String password) {
        this.idUtente = idUtente;
        this.nome = nome;
        this.email = email;
        this.password = password;
    }

    public String getIdUtente() {
        return idUtente;
    }

    public void setIdUtente(String idUtente) {
        this.idUtente = idUtente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // autenticare l'utente
    public boolean login(String email, String password) {
        // logica di login
        if (this.email.equals(email) && this.password.equals(password)) {
            return true;
        } else {
            return false;
        }
    }

    // Metodo per terminare la sessione dell'utente
    public void logout() {
    }

    // aggiorno i dettagli del profilo dell'utente
    public void updateProfileDetails(String newEmail, String newPassword) {
        this.email = newEmail;
        this.password = newPassword;
    }

    // stringa di un utente
    @Override
    public String toString() {
        return "Utente{" +
                "idUtente='" + idUtente + '\'' +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", password='[PROTECTED]'" +
                '}';
    }
}
