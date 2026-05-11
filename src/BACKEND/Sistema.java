package BACKEND;

import java.io.Serializable;
import java.time.LocalDate;

/**
 *
 * @author Gonçalo
 */
public class Sistema implements Serializable {

    private RepositorioUtilizador utilizadores;
    private Utilizador utilizadorligado;
    private RepositorioCentrosVacinacao repositorioCentrosVacinacao;
    private RepositorioGestores repositorioGestores;
    private RepositorioVacinas repositoriovacinas;
    private RepositorioUtentes repositorioUtentes;
  
    /**
     *
     * @param utilizadores
     * @param utilizadorligado
     */
    public Sistema(RepositorioUtilizador utilizadores, Utilizador utilizadorligado) {
        this.utilizadores = utilizadores == null ? new RepositorioUtilizador() : utilizadores;
        this.utilizadorligado = utilizadorligado;
        this.repositorioCentrosVacinacao = new RepositorioCentrosVacinacao();
        this.repositorioGestores = new RepositorioGestores();
        this.repositorioUtentes = new RepositorioUtentes();
        this.repositoriovacinas = new RepositorioVacinas();
    }
      
    /**
     *
     */
    public Sistema() {
        utilizadores = new RepositorioUtilizador();
        repositorioCentrosVacinacao = new RepositorioCentrosVacinacao();
        repositorioGestores = new RepositorioGestores();
        repositorioUtentes = new RepositorioUtentes();
        repositoriovacinas = new RepositorioVacinas();
    }

    /**
     * Corrige referências nulas depois de carregar dados antigos de utilizadores.data.
     */
    public void repararDados() {
        if (utilizadores == null) {
            utilizadores = new RepositorioUtilizador();
        }
        if (repositorioCentrosVacinacao == null) {
            repositorioCentrosVacinacao = new RepositorioCentrosVacinacao();
        }
        if (repositorioGestores == null) {
            repositorioGestores = new RepositorioGestores();
        }
        if (repositorioUtentes == null) {
            repositorioUtentes = new RepositorioUtentes();
        }
        if (repositoriovacinas == null) {
            repositoriovacinas = new RepositorioVacinas();
        }

        for (CentroVacinacao centro : repositorioCentrosVacinacao.todos()) {
            if (centro != null) {
                centro.inicializarEstruturas();
            }
        }

        if (repositoriovacinas.size() == 0) {
            adicionarVacinasBase();
        }
    }

    private void adicionarVacinasBase() {
        if (repositoriovacinas.get("Moderna") == null) {
            repositoriovacinas.adicionar(new Vacina("Moderna", "001", "States", 1.05, 2, 15, 30, "Dor de garganta"));
        }
        if (repositoriovacinas.get("Astrazenece") == null) {
            repositoriovacinas.adicionar(new Vacina("Astrazenece", "002", "USA", 1.05, 2, 15, 30, "Dor de Cabeça"));
        }
    }

    /**
     *
     * @return RepositorioVacinas
     */
    public RepositorioVacinas getRepositoriovacinas() {
        repararDados();
        return repositoriovacinas;
    }
        
    /**
     *
     * @return RepositorioCentrosVacinacao
     */
    public RepositorioCentrosVacinacao getRepositorioCentrosVacinacao() {
        repararDados();
        return repositorioCentrosVacinacao;
    }
    
    /**
     *
     * @return RepositorioGestores
     */
    public RepositorioGestores getRepositorioGestores() {
        repararDados();
        return repositorioGestores;
    }

    /**
     *
     * @return RepositorioUtentes
     */
    public RepositorioUtentes getRepositorioUtentes(){
       repararDados();
       return repositorioUtentes;
   }

    /**
     *
     * @return RepositorioUtilizador
     */
    public RepositorioUtilizador getUtilizadores() {
        repararDados();
        return utilizadores;
    }

    /**
     *
     * @return Utilizador
     */
    public Utilizador getUtilizadorligado() {
        return utilizadorligado;
    }

    /**
     *
     * @param utilizadorligado
     */
    public void setUtilizadorligado(Utilizador utilizadorligado) {
        this.utilizadorligado = utilizadorligado;
    }

    /**
     *
     * @param username
     * @param password
     * @return boolean
     */
    public boolean autenticarUtilizador(String username, String password) {
        repararDados();
        if (username == null || password == null) {
            return false;
        }
        if (utilizadores.existeUtilizador(username)) {

            Utilizador u = utilizadores.getUtilizador(username);
            if (u != null && password.equals(u.getPassword())) {
                utilizadorligado = u;

                return true;
            }

        }
        return false;
    }

    /**
     *
     */
    public void Inicializar() {
        repararDados();

        if (!utilizadores.existeUtilizador("admin")) {
            utilizadores.adicionar(new Administrador("admin", "admin", "Administrador@gmail.com", "Goncalo"));
        }
        if (!utilizadores.existeUtilizador("gestor")) {
            utilizadores.adicionar(new Gestor("gestor", "gestor", "Gestor@gmail.com", "Andre"));
        }

        adicionarVacinasBase();

        if (repositorioCentrosVacinacao.getCentroVacinacao("centro1") == null) {
            repositorioCentrosVacinacao.adicionarCentro(new CentroVacinacao("centro1", "Amares", "Amares", utilizadores.getGestor("gestor"), 10));
        }

        if (!utilizadores.existeUtilizador("utente")) {
            utilizadores.adicionar(new Utente("utente", "Amares", "Amares", LocalDate.parse("2002-09-01"), "937899799", repositorioCentrosVacinacao.getCentroVacinacao("centro1"), null, null, new RepositorioDoencas(), 0, "utente", "utente", "utente@gmail.com", "Diogo"));
        }
    }

    /**
     *
     */
    public void terminar() {
        System.exit(0);
    }

   
}
