package BACKEND;

import java.io.Serializable;

/**
 *
 * @author Gonçalo
 */
public class Administrador extends Utilizador implements Serializable {

    private RepositorioCentrosVacinacao repositorio;
    private RepositorioGestores repGestores;
    private Gestor gestor;

    /**
     *
     * @param username
     * @param Password
     * @param email
     * @param Nome
     */
    public Administrador(String username, String Password, String email, String Nome) {
        super(username, Password, email, Nome);
    }
//parametro 2 --> criar /apagar centros vacinacao

    /**
     *
     * @param centroVacinacao
     */
    public void adicionarCentroVacinacao(CentroVacinacao centroVacinacao) {
        if (centroVacinacao.getCodigo() == null) {
            repositorio.adicionarCentro(centroVacinacao);
        }
    }

    /**
     *
     * @param centroVacinacao
     */
    public void apagarCentroVacinacao(CentroVacinacao centroVacinacao) {
        if (centroVacinacao.getCodigo() != null) {
            repositorio.remover(centroVacinacao);
        }
    }

}
