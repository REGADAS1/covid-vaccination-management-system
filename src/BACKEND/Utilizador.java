package BACKEND;

import java.io.Serializable;

/**
 *
 * @author Gonçalo
 */
public class Utilizador implements Serializable {
    private String username;
    private String password;
    private String email;
    private String nome;

    /**
     *
     * @param username
     * @param password
     * @param email
     * @param nome
     */
    public Utilizador(String username, String password, String email, String nome) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.nome = nome;
    }
 
    /**
     *
     * @return String
     */
    public String getNome() {
        return nome;
    }

    /**
     *
     * @param Nome
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     *
     * @return String
     */
    public String getUsername() {
        return username;
    }

    /**
     *
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     *
     * @return String
     */ 
    public String getEmail() {
        return email;
    }

    /**
     *
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     *
     * @return String
     */
    public String getPassword() {
        return password;
    }

    /**
     *
     * @param Password
     */
    public void setPassword(String Password) {
        this.password = Password;
    }

    /**
     *
     * @return String
     */
    @Override
    public String toString() {
        return "Utilizador{" + "username=" + username + ", password=" + password + ", email=" + email + ", nome=" + nome + '}';
    }
    
    /**
     *
     */
    public Utilizador() {
    }

    
}
