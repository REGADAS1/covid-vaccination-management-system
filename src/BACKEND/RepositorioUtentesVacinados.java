package BACKEND;

import java.util.ArrayList;
import java.io.Serializable;

/**
 *
 * @author Gonçalo
 */
public class RepositorioUtentesVacinados implements Serializable{

    private ArrayList<Utente> lista;

    /**
     *
     */
    public RepositorioUtentesVacinados() {
        lista = new ArrayList();
    }

    /**
     *
     * @param lista
     */
    public RepositorioUtentesVacinados(ArrayList<Utente> lista) {
        this.lista = lista;
    }

    /**
     *
     * @return ArrayList<Utente>
     */
    public ArrayList<Utente> getLista() {
        return lista;
    }

    /**
     *
     * @param lista
     */
    public void setLista(ArrayList<Utente> lista) {
        this.lista = lista;
    }
//ADICIONAR UM NOVO UTENTE À LISTA DE VACINADOS

    /**
     *
     * @param utente
     */
    public void adicionar(Utente utente) {
        if (lista.contains(utente)) {
            System.err.print("ERRO! Utente já foi vacinado! ");
        } else {
            lista.add(utente);
        }
    }
//VERIFICAR SE UM CERTO UTENTE JÁ FOI VACINADO

    /**
     *
     * @param utente
     * @return boolean
     */
    public boolean existeUtenteVacinado(Utente utente) {
        return lista.contains(utente);
    }

    /**
     *
     * @param utente
     * @return Utente
     */
    public Utente UtenteVacinado(Utente utente) {
        boolean a = existeUtenteVacinado(utente);
        if (a == true) {
            return utente;
        } else {
            return null;
        }

    }
    
    /*public void listarEfeitosSecundariosPopulacaoVacinada{
    for(Utente u : lista){
        System.out.println(u.get);
    }
}
*/
}

