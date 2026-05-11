package BACKEND;

import java.time.LocalDate;
import java.time.Period;
import java.io.Serializable;
/*
Os utentes têm um nº de utente do Serviço Nacional de Saúde, deverá ser registado o seu
nome, morada e localidade, data de nascimento, contacto telefónico, email, centro de
vacinação ao qual são alocados, indicação se já foi administrada a vacina e qual a vacina
administrada, as datas da administração da vacina se for o caso.
 */

/**
 *
 * @author Gonçalo
 */
public class Utente extends Utilizador implements Serializable{

    private String numSNS; // usar string, não vamos fazer contas e existem numeros que começam em 0 e se fosse int nao eram contados
    private String morada;
    private String localidade;
    private LocalDate data_Nasc;
    private String numTelemovel;
    private CentroVacinacao centrovacinacao;
    private Vacina vacina;
    private LocalDate dataAdministracao;
    private RepositorioDoencas doencas;
    private int tomas;

    /**
     *
     * @param numSNS
     * @param morada
     * @param localidade
     * @param data_Nasc
     * @param numTelemovel
     * @param centrovacinacao
     * @param vacina
     * @param dataAdministracao
     * @param doencas
     * @param tomas
     * @param username
     * @param password
     * @param email
     * @param nome
     */
    public Utente(String numSNS, String morada, String localidade, LocalDate data_Nasc, String numTelemovel, CentroVacinacao centrovacinacao, Vacina vacina, LocalDate dataAdministracao, RepositorioDoencas doencas, int tomas, String username, String password, String email, String nome) {
        super(username, password, email, nome);
        this.numSNS = numSNS;  //usamos this como um atributo da classe Utente: A palavra-chave se refere ao objeto atual em um método ou construtor.
        this.morada = morada;
        this.localidade = localidade;
        this.data_Nasc = data_Nasc;
        this.numTelemovel = numTelemovel;
        this.centrovacinacao = centrovacinacao;
        this.vacina = vacina;
        this.dataAdministracao = dataAdministracao;
        this.doencas = doencas == null ? new RepositorioDoencas() : doencas;
        this.tomas = tomas;
    }

    /**
     *
     */
    public Utente(){
        this.doencas = new RepositorioDoencas();
    }
     
    /**
     *
     * @return String
     */
    public String getNumSNS() {
        return numSNS;
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
     * @return LocalDate
     */
    public LocalDate getData_Nasc() {
        return data_Nasc;
    }

    /**
     *
     * @return String
     */
    public String getNumTelemovel() {
        return numTelemovel;
    }

    /**
     *
     * @return CentroVacinacao
     */
    public CentroVacinacao getCentrovacinacao() {
        return centrovacinacao;
    }

    /**
     *
     * @return Vacina
     */
    public Vacina getVacina() {
        return vacina;
    }

    /**
     *
     * @return LocalDate
     */
    public LocalDate getDataAdministracao() {
        return dataAdministracao;
    }

    /**
     *
     * @return RepositorioDoencas
     */
    public RepositorioDoencas getDoencas() {
        if (doencas == null) {
            doencas = new RepositorioDoencas();
        }
        return doencas;
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
     * @param numSNS
     */
    public void setNumSNS(String numSNS) {
        this.numSNS = numSNS;
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
     * @param data_Nasc
     */
    public void setData_Nasc(LocalDate data_Nasc) {
        this.data_Nasc = data_Nasc;
    }

    /**
     *
     * @param numTelemovel
     */
    public void setNumTelemovel(String numTelemovel) {
        this.numTelemovel = numTelemovel;
    }

    /**
     *
     * @param centrovacinacao
     */
    public void setCentrovacinacao(CentroVacinacao centrovacinacao) {
        this.centrovacinacao = centrovacinacao;
    }

    /**
     *
     * @param vacina
     */
    public void setVacina(Vacina vacina) {
        this.vacina = vacina;
    }

    /**
     *
     * @param dataAdministracao
     */
    public void setDataAdministracao(LocalDate dataAdministracao) {
        this.dataAdministracao = dataAdministracao;
    }

    /**
     *
     * @param Doencas
     */
    public void setDoencas(RepositorioDoencas Doencas) {
        this.doencas = Doencas;
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
     * @return String
     */
    @Override
    public String toString() {
        return "Utente{" + "numSNS=" + numSNS + ", morada=" + morada + ", localidade=" + localidade + ", data_Nasc=" + data_Nasc + ", numTelemovel=" + numTelemovel + ", centrovacinacao=" + centrovacinacao + ", vacina=" + vacina + ", dataAdministracao=" + dataAdministracao + ", Doenças=" + doencas + '}';
    }

    /**
     *
     * @return long
     */
    public long CalcularIdade() {  //calcula a idade através da diferença entre a data de hoje e a data de nascimento
        LocalDate hoje = LocalDate.now();
        if (data_Nasc == null) {
            return 0;
        }
        int idade = Period.between(data_Nasc, hoje).getYears();
        return idade;
    }

}
