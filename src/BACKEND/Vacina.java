package BACKEND;

import java.util.ArrayList;
import java.io.Serializable;
/*
Cada vacina tem um nome, código, fabricante, indicação da dose individual em ml, eventuais
restrições associadas à sua administração (por nível etário, por exemplo &gt; 30 e &lt; 65, ou doença
pré-existente), indicação se é de toma única ou múltipla, com um determinado limite mínimo e
máximo de dias entre doses, e lista de efeitos secundários possíveis.

 */

/**
 *
 * @author Gonçalo
 */

public class Vacina implements Serializable{

    /**
     *
     */
    public String nome;

    /**
     *
     */
    public String codigo;

    /**
     *
     */
    public String fabricante;

    /**
     *
     */
    public double doseIndividual;
    
    /**
     *
     */
    public int tomas;

    /**
     *
     */
    public long limiteMinimo;

    /**
     *
     */
    public long limiteMaximo;

    /**
     *
     */
    public String efeitosSecundarios;

    /**
     *
     */
    public RepositorioDoencas doencasRestritas;

    /**
     *
     * @param nome
     * @param codigo
     * @param fabricante
     * @param doseIndividual
     * @param tomas
     * @param limiteMinimo
     * @param limiteMaximo
     * @param efeitosSecundarios
     */
    public Vacina(String nome, String codigo, String fabricante, double doseIndividual, Integer tomas, long limiteMinimo, long limiteMaximo, String efeitosSecundarios) {
        this.nome = nome;
        this.codigo = codigo;
        this.fabricante = fabricante;
        this.doseIndividual = doseIndividual;
        
       this.tomas = tomas;
        this.limiteMinimo = limiteMinimo;
        this.limiteMaximo = limiteMaximo;
        this.efeitosSecundarios = efeitosSecundarios;
        this.doencasRestritas =  new RepositorioDoencas();
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
     * @return String
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     *
     * @return String
     */
    public String getFabricante() {
        return fabricante;
    }

    /**
     *
     * @return double
     */
    public double getDoseIndividual() {
        return doseIndividual;
    }

    /**
     *
     * @return int
     */
    public int getTomas() {
        return tomas;
    }

    /**
     *
     * @return long
     */
    public long getLimiteMinimo() {
        return limiteMinimo;
    }

    /**
     *
     * @return long
     */
    public long getLimiteMaximo() {
        return limiteMaximo;
    }

    /**
     *
     * @return String
     */
    public String getEfeitosSecundarios() {
        return efeitosSecundarios;
    }

    /**
     *
     * @return RepositorioDoencas
     */
    public RepositorioDoencas getDoencasRestritas() {
        return doencasRestritas;
    }

    /**
     *
     * @param nome
     */
    public void setNome(String nome) {
        this.nome = nome;
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
     * @param fabricante
     */
    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    /**
     *
     * @param doseIndividual
     */
    public void setDoseIndividual(double doseIndividual) {
        this.doseIndividual = doseIndividual;
    }

    /**
     *
     * @param tomas
     */
    public void setTomas(int tomas) {
        this.tomas = tomas;
    }

    /**
     *
     * @param limiteMinimo
     */
    public void setLimiteMinimo(long limiteMinimo) {
        this.limiteMinimo = limiteMinimo;
    }

    /**
     *
     * @param limiteMaximo
     */
    public void setLimiteMaximo(long limiteMaximo) {
        this.limiteMaximo = limiteMaximo;
    }

    /**
     *
     * @param efeitosSecundarios
     */
    public void setEfeitosSecundarios(String efeitosSecundarios) {
        this.efeitosSecundarios = efeitosSecundarios;
    }

    /**
     *
     * @param doencasRestritas
     */
    public void setDoencasRestritas(RepositorioDoencas doencasRestritas) {
        this.doencasRestritas = doencasRestritas;
    }

    /**
     *
     * @return String
     */
    @Override
    public String toString() {
        return "Vacina{" + "nome=" + nome + ", codigo=" + codigo + ", fabricante=" + fabricante + ", doseIndividual=" + doseIndividual + ", tomas=" + tomas + ", limiteMinimo=" + limiteMinimo + ", limiteMaximo=" + limiteMaximo + ", efeitosSecundarios=" + efeitosSecundarios + ", doen\u00e7asRestritas=" + doencasRestritas + '}';
    }

    /**
     *
     * @param doenca
     * @return RepositorioDoencas
     */
    public RepositorioDoencas doencasVacina(RepositorioDoencas doenca) {    //VERIFICAR DOENÇAS 
        return doenca;
    }
}
