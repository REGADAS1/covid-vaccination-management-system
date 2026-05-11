package BACKEND;

import java.io.Serializable;
import java.util.ArrayList;

//CLASSE PARA SABER O TIPO DE VACINAS QUE CADA CENTRO DE VACINAÇÃO TEM, CRIAMOS CLASSE NOVA, CASO CONTRÁRIO SÓ SABERIAMOS A QUANTIDADE A PARTIR DO STOCK

/**
 *
 * @author Gonçalo
 */
public class RepositorioVacinas implements Serializable {

    private ArrayList<Vacina> nomeVacinas;

    /**
     *
     */
    public RepositorioVacinas() {
      nomeVacinas = new ArrayList<>();
    }

    /**
     *
     * @param nomesVacinas
     */
    public void setNomesVacinas(ArrayList<Vacina> nomesVacinas) {
        this.nomeVacinas = nomesVacinas;
    }

    /**
     *
     * @return ArrayList<Vacina>
     */
    public ArrayList<Vacina> getNomesVacinas() {
        return nomeVacinas;
    }

    //adicionar nova vacina (nome) / remover um tipo de vacina / verificar se existe uma vacina (nome) / get vacina 

    /**
     *
     * @param vacina
     */
    public void adicionar(Vacina vacina) {
        if (vacina == null) {
            return;
        }
        if (nomeVacinas.contains(vacina)) {
            System.out.println("Erro, esta vacina já consta no sistema.");
        } else {
            nomeVacinas.add(vacina);
        }
    }

    /**
     *
     * @param vacina
     */
    public void remover(Vacina vacina) {
        if (nomeVacinas.contains(vacina)) {
            nomeVacinas.remove(vacina);
        } else {
            System.out.println("Erro, esta vacina não consta no sistema.");
        }
    }

    /**
     *
     * @param vacina
     * @return boolean
     */
    public boolean existe(Vacina vacina) {
        return nomeVacinas.contains(vacina);
        /* if (nomeVacinas.contains(vacina)){  ----> mesmo efeito, mais simples
                                                   return true;
                                                }else{
                                                   return false;
                                                } */
    }

    /**
     *
     * @param vacina
     * @return Vacina
     */
    public Vacina getVacina(Vacina vacina) {
        if (existe(vacina)) {
            return vacina;
        } else {
            return null;
        }
    }

    //verificar se a vacina tem alguma restrição em comum com alguma doença do utente
    private boolean verificarDoencas(Vacina vacina, Utente utente) {
        return !vacina.doencasRestritas.existeDoenca(utente.getDoencas().toString()); //restriçoes da vacina
    }

    //verificar se a vacina pode ser administrada consoante a idade
    private boolean verificarIdadeVacina(Vacina vacina, Utente utente) {  //ERRO: TINHAMOS LONG EM CALCULAR IDADE E STRING EM LIMITE MINIMO E MAX, PERGUNTAR SITUAÇAÃO !!!!!!!!!!!!!!!!
        if (utente.CalcularIdade() > vacina.limiteMinimo && utente.CalcularIdade() < vacina.limiteMaximo) {
            return true;
        }
        return false;

    }

    //verificar se o utente já tomou alguma dose
    private boolean verificarSeExistePrimeiraToma(Utente utente) {
        return utente.getVacina() != null;
    }

    //caso o utente ainda não tenha tomado a vacina, vai verificar os parametros todos, escolhendo a mais adequada ao utente

    /**
     *
     * @param utente
     * @return Vacina
     */
    public Vacina VacinaAdequada(Utente utente) {
        for (Vacina vacina : nomeVacinas) {
            if (verificarDoencas(vacina, utente) && verificarIdadeVacina(vacina, utente) && !verificarSeExistePrimeiraToma(utente)) {
                return vacina;
            }

            if (verificarSeExistePrimeiraToma(utente)) { //se o utente tiver tomado alguma dose, vai retornar essa vacina
                return utente.getVacina();
            }
        }

        return null;
    }

    /**
     *
     * @return int
     */
    public int size(){
        return nomeVacinas.size();
    }

    /**
     *
     * @param i
     * @return Vacina
     */
    public Vacina get(int i){
        return nomeVacinas.get(i);
    }

    /**
     *
     * @param nome
     * @return Vacina
     */
    public Vacina get(String nome){
    for(Vacina vacina : nomeVacinas){
        if(vacina.getNome() != null && vacina.getNome().equals(nome)){
            return vacina;
        }
        
    }
    return null;
}
   
}


