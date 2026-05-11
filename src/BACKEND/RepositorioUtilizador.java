package BACKEND;

import java.util.ArrayList;
import java.io.Serializable;

/**
 *
 * @author Gonçalo
 */
public class RepositorioUtilizador implements Serializable {


    private ArrayList<Utilizador> lista = new ArrayList<>();

    /**
     *
     */
    public RepositorioUtilizador() {
        lista = new ArrayList<>();
    }

    /**
     *
     * @param limite
     */
    public RepositorioUtilizador(int limite) {
        lista = new ArrayList<>(limite);
    }

    /**
     *
     * @param index
     * @return Utilizador
     */
    public Utilizador get(int index) {
        return lista.get(index);
    }

    /**
     *
     * @return ArrayList<Utilizador>
     */
    public ArrayList<Utilizador> getListaUtilizador() {
        return lista;
    }

    /**
     *
     * @param lista
     */
    public void setListaUtilizador(ArrayList<Utilizador> lista) {
        this.lista = lista;
    }

    /**
     *
     * @param utilizador
     */
    public void adicionar(Utilizador utilizador) {
        if (lista == null) {
            lista = new ArrayList<>();
            System.out.println("lista não criada");
        } else {
            lista.add(utilizador);

        }
    }

    /**
     *
     * @param utilizador
     */
    public void remover(Utilizador utilizador) {
        lista.remove(utilizador);
    }

    /**
     *
     * @return int
     */
    public int getTotalUtilizador() {
        return lista.size();
    }

    /**
     *
     * @param username
     * @return boolean
     */
    public boolean existeUtilizador(String username) {
        for (Utilizador u : lista) {
            if (u != null && u.getUsername() != null && u.getUsername().equals(username)) {
                return true;
            }
        }
        return false;
    }

    /**
     *
     * @param email
     * @return boolean
     */
    public boolean verificarEmail(String email) {
        for (Utilizador u : lista) {
            if (u != null && u.getEmail() != null && u.getEmail().equals(email)) {
                return true;
            }
        }
        return false;
    }

    /**
     *
     * @param username
     * @return Utilizador
     */
    public Utilizador getUtilizador(String username) {
        for (Utilizador u : lista) {
            if (u != null && u.getUsername() != null && u.getUsername().equals(username)) {
                return u;
            }
        }
        return null;
    }

    /**
     *
     * @param centroVacinacao
     */
    public void listarUtentesDeCentroVacinacao(CentroVacinacao centroVacinacao) {
        ArrayList<Utente> utentes = new ArrayList<>();
        for (Utilizador u : lista) {
            if (u instanceof Utente) {
                utentes.add((Utente) u);
            }

        }

        for (Utente u : utentes) {
            if (u.getCentrovacinacao() != null && u.getCentrovacinacao().equals(centroVacinacao)) {
                System.out.println(u.toString());
            }

        }

    }

    /**
     *
     */
    public void listarTodosUtentes() {
        ArrayList<Utente> utentes = new ArrayList<>();
        for (Utilizador u : lista) {
            if (u instanceof Utente) {
                utentes.add((Utente) u);
            }

        }

        for (Utente u : utentes) {

            System.out.println(u.toString());

        }
    }

    /**
     *
     * @param username
     * @return Utilizador
     */
    public Utilizador getGestor(String username) {
        for (Utilizador u : lista) {
            if (u instanceof Gestor && u.getUsername() != null && u.getUsername().equals(username)) {
                return u;
            }
        }
        return null;
    }

    /**
     *
     * @return long
     */
    public long getTotalGestores() {
        long total = 0;
        for (Utilizador u : lista) {
            if (u instanceof Gestor) {
                total++;
            }
        }
        return total;
    }

    /**
     *
     */
    public void listarGestores() {
        ArrayList<Gestor> gestores = new ArrayList<>();
        for (Utilizador u : lista) {
            if (u instanceof Gestor) {
                gestores.add((Gestor) u);
            }
        }

        for (Gestor g : gestores) {
            System.out.println(g.toString());
        }
    }

    /**
     *
     * @return ArrayList<Gestor>
     */
    public ArrayList<Gestor> todos() {
        ArrayList<Gestor> gestores = new ArrayList<>();
        for (Utilizador u : lista) {
            if (u instanceof Gestor) {
                gestores.add((Gestor) u);
            }
        }
        return gestores;
    }
    public ArrayList<Utente> utentesPorCentro(CentroVacinacao centro) {
        ArrayList<Utente> utentes = new ArrayList<>();
        if (centro == null) {
            return utentes;
        }
        for (Utilizador u : lista) {
            if (u instanceof Utente) {
               Utente utente = (Utente) u;
               CentroVacinacao centroUtente = utente.getCentrovacinacao();
               if (centroUtente != null && centroUtente.getCodigo() != null && centroUtente.getCodigo().equals(centro.getCodigo())) {
                   utentes.add(utente);
               }
            }

        }
        return utentes;
    }

    /**
     *
     */
    public class UtilizadorJaExisteException extends Exception {

        /**
         *
         */
        public UtilizadorJaExisteException() {
        }

        /**
         *
         * @param message
         */
        public UtilizadorJaExisteException(String message) {
            super(message);
        }
    }

    /**
     *
     * @param username
     */
    public void removerGestor(String username) { //remover através de username
        Utilizador gestor = getGestor(username);
        if (gestor != null) {
            lista.remove(gestor);
        }
    }
}
