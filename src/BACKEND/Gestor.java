package BACKEND;
import java.io.Serializable;

/**
 *
 * @author Gonçalo
 */
public class Gestor extends Utilizador implements Serializable {
    private CentroVacinacao centroVacinacao;

    /**
     *
     * @param username
     * @param password
     * @param email
     * @param nome
     */
    public Gestor(String username, String password, String email, String nome) {
        super(username, password, email, nome);
    }
    
    /**
     *
     */
    public Gestor(){
        
    }

    /**
     *
     * @return CentroVacinacao
     */
    public CentroVacinacao getCentroVacinacao() {
        return centroVacinacao;
    }

    /**
     *
     * @param centroVacinacao
     */
    public void setCentroVacinacao(CentroVacinacao centroVacinacao) {
        this.centroVacinacao = centroVacinacao;
    }
    
}
