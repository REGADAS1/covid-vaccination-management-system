
package BACKEND;


import java.util.ArrayList;
import java.io.Serializable;

/**
 *
 * @author Gonçalo
 */
public class RepositorioUtentes implements Serializable {
   private ArrayList<Utente> listaUtentes = new ArrayList<>();

    /**
     *
     */
    public RepositorioUtentes() {
        listaUtentes =new ArrayList<> ();
    }

    /**
     *
     * @return ArrayList<Utente>
     */
    public ArrayList<Utente> getLista() {
        return listaUtentes;
    }

    /**
     *
     * @param lista
     */
    public void setLista(ArrayList<Utente> lista) {
        this.listaUtentes = lista;
    }
    
    /**
     *
     * @param utente
     */
    public void adicionarUtente(Utente utente){
      listaUtentes.add(utente);
    }
    
    /**
     *
     * @param utente
     */
    public void removerUtente(Utente utente){
    
    listaUtentes.remove(utente);
    
    }
    
    /**
     *
     * @return int
     */
    public int getTotalUtentes(){
         
         return listaUtentes.size();
     }
    
    /**
     *
     * @param username
     * @return boolean
     */
    public boolean existeUtente(String username) {
        for (Utente u : listaUtentes) {
            if (u != null && u.getUsername().equals(username)) {
                return true;
            }
        }
        return false;
    }

    /**
     *
     * @param username
     * @return Utente
     */
    public Utente getUtente(String username) {

        for (Utente u : listaUtentes) {
            if (u != null && u.getUsername().equals(username)) {
                return u;
            }
        }
        return null;
    }
    
    /**
     *
     * @param centro
     * @return
     */
    /* public ArrayList<Utente> utentesPorCentro(CentroVacinacao centro) {
        ArrayList<Utente> utentes = new ArrayList<>();
        for (Utente u : listaUtentes) {
            if (u.getCentrovacinacao() == centro) {
               utentes.add(u);
            }

        }
        return utentes;
    }*/
     
     
    
    
}
