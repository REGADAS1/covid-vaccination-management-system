package BACKEND;

import BACKEND.Gestor;
import java.util.ArrayList;
import java.io.Serializable;

/**
 *
 * @author Gonçalo
 */
public class RepositorioGestores implements Serializable {

    private ArrayList<Gestor> listaGestores;

    /**
     *
     */
    public RepositorioGestores() {
        this.listaGestores = new ArrayList<>();
    }

    /**
     *
     * @param lista
     */
    public RepositorioGestores(ArrayList<Gestor> lista) {
        this.listaGestores = lista == null ? new ArrayList<>() : lista;
    }

    /**
     *
     * @return ArrayList<Gestor>
     */
    public ArrayList<Gestor> getLista() {
        return listaGestores;
    }

    /**
     *
     * @param lista
     */
    public void setLista(ArrayList<Gestor> lista) {
        this.listaGestores = lista;
    }

    /**
     *
     * @param gestor
     */
    public void adicionarGestor(Gestor gestor) {
        listaGestores.add(gestor);
    }

    /**
     *
     * @param gestor
     */
    public void removerGestor(Gestor gestor) {
        listaGestores.remove(gestor);

    }

    /**
     *
     * @return int
     */
    public int getTotalGestores() {

        return listaGestores.size();
    }

    /**
     *
     * @param username
     * @return boolean
     */
    public boolean existeGestor(String username) {
        for (Gestor u : listaGestores) {
            if (u != null && u.getUsername().equals(username)) {
                return true;
            }
        }
        return false;
    }

    /**
     *
     * @param username
     * @return Gestor
     */
    public Gestor getGestor(String username) {

        for (Gestor u : listaGestores) {
            if (u != null && u.getUsername().equals(username)) {
                return u;
            }
        }
        return null;
    }

    /**
     *
     * @return int
     */
    public int sizeRepositorioGestores() {
        if (listaGestores.size() == 0) {
            return 0;
        } else {
            return listaGestores.size();
        }

    }

    /**
     *
     * @return ArrayList<Gestor>
     */
    public ArrayList<Gestor> todos() {
        return listaGestores;
    }

}
