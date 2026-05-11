package BACKEND;

import java.time.LocalDate;
import java.io.Serializable;
/*
 Cada centro de vacinacao tem um codigo, uma morada, incluindo a localidade, um gestor, um
número de postos de atendimento, stock de cada tipo de vacinas, uma agenda de marcacoes.
 */

/**
 *
 * @author Gonçalo
 */

public class CentroVacinacao implements Serializable {

    private String codigo;
    private String morada;
    private String localidade;
    private Utilizador gestor;
    private int numeroPostosAtendimento;
    private StockVacinas stockvacinas;
    private Marcacao agendaMarcacoes;
    private RepositorioVacinas RepositorioVacinas;
    private int MaxVacinasPorDia;

    /**
     *
     */
    public CentroVacinacao() {
        inicializarEstruturas();
    }

    /**
     *
     * @param codigo
     * @param morada
     * @param localidade
     * @param gestor
     * @param numeroPostosAtendimento
     */
    public CentroVacinacao(String codigo, String morada, String localidade, Utilizador gestor, int numeroPostosAtendimento) {
        this.codigo = codigo;
        this.morada = morada;
        this.localidade = localidade;
        this.gestor = gestor;
        this.numeroPostosAtendimento = numeroPostosAtendimento;
        this.MaxVacinasPorDia = numeroPostosAtendimento;
        inicializarEstruturas();
    }

    /**
     * Garante que os objetos internos existem, mesmo em centros antigos carregados de utilizadores.data.
     */
    public void inicializarEstruturas() {
        if (this.stockvacinas == null) {
            this.stockvacinas = new StockVacinas();
        }
        if (this.agendaMarcacoes == null) {
            this.agendaMarcacoes = new Marcacao();
        }
        if (this.RepositorioVacinas == null) {
            this.RepositorioVacinas = new RepositorioVacinas();
        }
    }

    /**
     *
     * @return String
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     *
     * @return String
     */
    public String getMorada() {
        return morada;
    }

    /**
     *
     * @return String
     */
    public String getLocalidade() {
        return localidade;
    }

    /**
     *
     * @return Utilizador
     */
    public Utilizador getGestor() {
        return gestor;
    }

    /**
     *
     * @return int
     */
    public int getNumeroPostosAtendimento() {
        return numeroPostosAtendimento;
    }

    /**
     *
     * @return StockVacinas
     */
    public StockVacinas getStockVacinas() {
        inicializarEstruturas();
        return stockvacinas;
    }

    /**
     *
     * @return Marcacao
     */
    public Marcacao getAgendaMarcacoes() {
        inicializarEstruturas();
        return agendaMarcacoes;
    }

    /**
     *
     * @return StockVacinas
     */
    public StockVacinas getStockvacinas() {
        inicializarEstruturas();
        return stockvacinas;
    }

    /**
     *
     * @return RepositorioVacinas
     */
    public RepositorioVacinas getRepositorioVacinas() {
        inicializarEstruturas();
        return RepositorioVacinas;
    }

    /**
     *
     * @return int
     */
    public int getMaxVacinasPorDia() {
        return MaxVacinasPorDia;
    }

    /**
     *
     * @param codigo
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    /**
     *
     * @param morada
     */
    public void setMorada(String morada) {
        this.morada = morada;
    }

    /**
     *
     * @param localidade
     */
    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }

    /**
     *
     * @param gestor
     */
    public void setGestor(Utilizador gestor) {
        this.gestor = gestor;
    }

    /**
     *
     * @param numeroPostosAtendimento
     */
    public void setNumeroPostosAtendimento(int numeroPostosAtendimento) {
        this.numeroPostosAtendimento = numeroPostosAtendimento;
        if (this.MaxVacinasPorDia <= 0) {
            this.MaxVacinasPorDia = numeroPostosAtendimento;
        }
    }

    /**
     *
     * @param stockVacinas
     */
    public void setStockVacinas(StockVacinas stockVacinas) {
        this.stockvacinas = stockVacinas;
    }

    /**
     *
     * @param agendaMarcacoes
     */
    public void setAgendaMarcacoes(Marcacao agendaMarcacoes) {
        this.agendaMarcacoes = agendaMarcacoes;
    }

    /**
     *
     * @param stockvacinas
     */
    public void setStockvacinas(StockVacinas stockvacinas) {
        this.stockvacinas = stockvacinas;
    }

    /**
     *
     * @param RepositorioVacinas
     */
    public void setRepositorioVacinas(RepositorioVacinas RepositorioVacinas) {
        this.RepositorioVacinas = RepositorioVacinas;
    }

    /**
     *
     * @param MaxVacinasPorDia
     */
    public void setMaxVacinasPorDia(int MaxVacinasPorDia) {
        this.MaxVacinasPorDia = MaxVacinasPorDia;
    }

    /**
     *
     * @return String
     */
    @Override
    public String toString() {
        return "CentroVacinacao{" + "codigo=" + codigo + ", morada=" + morada + ", localidade=" + localidade + ", gestor=" + gestor + ", numeroPostosAtendimento=" + numeroPostosAtendimento + ", stockVacinas=" + stockvacinas + ", agendaMarcacoes=" + agendaMarcacoes + '}';
    }

    //FAZER MARCACAO 

    /**
     *
     * @param data
     * @param utente
     */
    public boolean fazerMarcacao(LocalDate data, Utente utente){
        inicializarEstruturas();
        if (data == null || utente == null) {
            return false;
        }
        if (MaxVacinasPorDia > 0 && agendaMarcacoes.numeroMarcacoes(data) >= MaxVacinasPorDia){
            System.err.println("Erro, número máximo de marcações para este dia foi atingido");
            return false;
        }
        if (agendaMarcacoes.verificarMarcacao(data, utente)) {
            System.err.println("Erro, já existe uma marcação para este utente nesta data");
            return false;
        }
        agendaMarcacoes.adicionar(data, utente);
        return true;
    }
    
    /**
     *
     * @param utente
     */
    public void Vacinar(Utente utente) {
        inicializarEstruturas();
        if (utente == null) {
            return;
        }
        LocalDate hoje = LocalDate.now(); //para descobrir a data de administração
        Vacina vacinaAdequada = RepositorioVacinas.VacinaAdequada(utente); //estamos a chamar o método já para um utente
        if (vacinaAdequada != null && stockvacinas.ExisteVacina(vacinaAdequada)){
            utente.setDataAdministracao(hoje);
            stockvacinas.RemoverVacinas(vacinaAdequada, 1); //ao vacinar, vamos remover uma vacina do stock, com o método
            utente.setVacina(vacinaAdequada);
            utente.setTomas(utente.getTomas() + 1);
            /* Vacina_adequada.getTomas(); //saber o numero de tomas
            if (Vacina_adequada.getTomas() > 1) {
                agendaMarcacoes.adicionar(LocalDate.MAX, utente); //adiciona nova data de marcação de utente ---> exemplo
            }*/
            
        }else{
            System.err.println("Não existe stock dessa vacina");
        }
    }

}
