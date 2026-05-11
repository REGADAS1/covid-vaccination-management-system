package BACKEND;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.io.Serializable;

/**
 *
 * @author Gonçalo
 */
public class Marcacao implements Serializable {

    private final HashMap<LocalDate, ArrayList<Utilizador>> repositorioMarcacoes; //repositorio --> nome do local onde estão guardadas as marcações 

    //construtor

    /**
     *
     */
    public Marcacao() {
        repositorioMarcacoes = new HashMap();
    }
    //CASO SE PRETENDA ADICIONAR UMA MARCAÇÃO 

    /**
     *
     * @return int
     */
    public int size() {
        if (repositorioMarcacoes.size() == 0) {
            return 0;
        } else {
            return repositorioMarcacoes.size();
        }
    }

    /**
     *
     * @param data
     * @param utilizador
     */
    public void adicionar(LocalDate data, Utilizador utilizador) {

        ArrayList<Utilizador> lista = repositorioMarcacoes.get(data); //vai ao repositorio, consoante a data atribuida e um certo utilizador, verificar se já tem marcacao para o dia específico

        // verifica se ainda nao existe agendamento para a data especificada
        if (lista == null) {
            lista = new ArrayList<>();
            repositorioMarcacoes.put(data, lista);
        }

        if (lista.contains(utilizador)) {
            System.err.println("Já existe uma marcação, nessa mesma data, para o utilizador"); //print a vermelho (igual ao out)
        } else {
            lista.add(utilizador); //adiciona marcação desse utilizador, para a data especifica
        }
        System.out.println(repositorioMarcacoes);
    }

//CASO SE PRETENDA REMOVER UMA MARCAÇÃO 

    /**
     *
     * @param data
     * @param utilizador
     */
    public void remover(LocalDate data, Utilizador utilizador) {
        ArrayList<Utilizador> lista = repositorioMarcacoes.get(data); //vai pesquisar a data ao repositorio

        if (lista != null && lista.contains(utilizador)) {
            lista.remove(utilizador);  //remove automaticamente a marcação deste utilizador
            if (lista.isEmpty()) {
                repositorioMarcacoes.remove(data);
            }
        } else {
            System.err.println("Erro: não é possível remover a marcação, uma vez que a mesma não existe");
        }
        System.out.println(repositorioMarcacoes);
    }

    //CÓDIGO PARA APENAS VERIFICAR SE EXISTE MARCAÇÃO PARA UMA DATA ESPECÍFICA

    /**
     *
     * @param data
     * @param utilizador
     * @return boolean
     */
    public boolean verificarMarcacao(LocalDate data, Utilizador utilizador) {
        ArrayList<Utilizador> lista = repositorioMarcacoes.get(data);
        return lista != null && lista.contains(utilizador); // return true se o nome do utilizador constar na lista, caso contrário return false;
        /*if (lista.contains(utilizador)) {
                return true;
            // return true significa que o sistema, na parte da frontend, após ser introduzida a pesquisa por marcação numa data específica, vai retornar verdade, como: System.out.println("Existe marcação");
        } else {
            return false;
        } */
    }

    //CÓDIGO PARA CALCULAR O NÚMERO DE MARCAÇÕES PARA UMA DATA ESPECÍFICA

    /**
     *
     * @param data
     * @return int
     */
    public int numeroMarcacoes(LocalDate data) {
        ArrayList<Utilizador> lista = repositorioMarcacoes.get(data);
        if (lista == null) {
            return 0;
        }
        return lista.size();
    }

    /**
     *
     * @param utilizador
     * @return LocalDate
     */
    public LocalDate dataMarcacao(Utilizador utilizador) {
        var entrySet = repositorioMarcacoes.entrySet();
        for (var entry : entrySet) {
            if (entry.getValue().contains(utilizador)) {  //retorna uma array e vai ver se contem o utilizador de cima
                return entry.getKey();
            }
        }
        return null;
    }

    /**
     *
     * @return ArrayList<LocalDate>
     */
    public ArrayList<LocalDate> todosKeys() {
        ArrayList<LocalDate> hora = new ArrayList<>();

        for (LocalDate horario : repositorioMarcacoes.keySet()) {
            hora.add(horario);
        }
        return hora;
    }

    /**
     *
     * @return ArrayList<Utilizador>
     */
    public ArrayList<Utilizador> todosValues() {
        ArrayList<Utilizador> utilizador = new ArrayList<Utilizador>();

        for (LocalDate hora : repositorioMarcacoes.keySet()) {
            ArrayList<Utilizador> utentes = repositorioMarcacoes.get(hora);
            for (Utilizador u : utentes) {
                utilizador.add(u);
            }
        }
        return utilizador;
    }

    /**
     * Devolve uma lista de datas com uma entrada por cada marcação, alinhada com todosValues().
     */
    public ArrayList<LocalDate> todosKeysPorMarcacao() {
        ArrayList<LocalDate> datas = new ArrayList<>();
        for (LocalDate data : repositorioMarcacoes.keySet()) {
            ArrayList<Utilizador> utentes = repositorioMarcacoes.get(data);
            for (int i = 0; i < utentes.size(); i++) {
                datas.add(data);
            }
        }
        return datas;
    }

    /**
     * Número total de marcações, não apenas número de dias com marcações.
     */
    public int totalMarcacoes() {
        int total = 0;
        for (ArrayList<Utilizador> utentes : repositorioMarcacoes.values()) {
            total += utentes.size();
        }
        return total;
    }
}
