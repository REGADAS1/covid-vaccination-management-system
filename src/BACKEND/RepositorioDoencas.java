package BACKEND;

import java.util.ArrayList;
import java.io.Serializable;

/**
 *
 * @author Gonçalo
 */
public class RepositorioDoencas implements Serializable{

    ArrayList<String> repositorio = new ArrayList<>();

    /**
     *
     * @return ArrayList<String>
     */
    public ArrayList<String> getRepositorio() {
        return repositorio;
    }

    //ADICIONAR DOENÇA

    /**
     *
     * @param doenca
     */
    public void adicionarDoenca(String doenca) {
        if (repositorio.contains(doenca)) {
            System.err.println("Erro, a doença inserida já se encontra no sistema");
        } else {
            repositorio.add(doenca);
        }
    }

    //REMOVER DOENÇA

    /**
     *
     * @param doenca
     */
    public void removerDoenca(String doenca) {
        if (repositorio.contains(doenca)) {
            repositorio.remove(doenca);
        } else {
            System.err.println("Erro, a doença inserida não se encontra no sistema");
        }
    }

    //VER SE EXISTE CERTA DOENÇA

    /**
     *
     * @param doenca
     * @return boolean
     */
    public boolean existeDoenca(String doenca) {
        return repositorio.contains(doenca);
        /*  if (repositorio.contains(doenca)){
                  return true;
            }else{
                  return false;
            } */
    }

    //LISTAR DOENÇAS

    /**
     *
     */
    public void listarDoencas() {
        System.out.println("Doenças do Utente: ");
        for (String doenca : repositorio) {
            System.out.println(doenca);
        }
    }
}
