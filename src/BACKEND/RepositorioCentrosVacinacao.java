package BACKEND;

import java.util.HashMap;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Gonçalo
 */
public class RepositorioCentrosVacinacao implements Serializable {

    HashMap<String, CentroVacinacao> centros;

    /**
     *
     */
    public RepositorioCentrosVacinacao() {
        centros = new HashMap<>();

    }

    /**
     *
     * @param centro
     */
    public void adicionarCentro(CentroVacinacao centro) {
        if (centro == null || centro.getCodigo() == null || centro.getCodigo().trim().isEmpty()) {
            System.out.println("Erro, centro inválido");
            return;
        }
        centro.inicializarEstruturas();
        String codigoCentro = centro.getCodigo();
        CentroVacinacao centroVac = centros.get(codigoCentro);
        if (centroVac == null) // se não houver neste centro de vac neste cod. fazemos isto.
        {
            centros.put(codigoCentro, centro);
        } else {
            System.out.println("Erro, este centro já existe no sistema");
        }
    }

    /**
     *
     * @param centro
     */
    public void remover(CentroVacinacao centro) {
        if (centro != null && centro.getCodigo() != null && centros.containsKey(centro.getCodigo())) {
            centros.remove(centro.getCodigo());
        } else {
            System.out.println("Erro, este centro não existe no sistema");
        }
    }

    /**
     *
     * @param centro
     * @return boolean
     */
    public boolean existir(CentroVacinacao centro) {
        return centro != null && centro.getCodigo() != null && centros.containsKey(centro.getCodigo());

    }
    
    /**
     *
     * @return int
     */
    public int sizeRepositorio(){
        return centros.size();
        
    }

    /**
     *
     * @return ArrayList<CentroVacinacao>
     */
    public ArrayList<CentroVacinacao> todos() {
        return new ArrayList<>(centros.values());
    }
    
    /**
     *
     * @param codigo
     */
    public void removerCentro(String codigo){ //remover através do código
        centros.remove(codigo);
    }

    /**
     *
     * @param codigo
     * @return CentroVacinacao
     */
    public CentroVacinacao getCentroVacinacao(String codigo){
        if (codigo == null) {
            return null;
        }
        return centros.get(codigo);
    }
    
    /**
     *
     * @param localidade
     * @return CentroVacinacao
     */
    public CentroVacinacao getCentroVacinacaoLocalidade(String localidade){
        var entrySet = centros.entrySet(); //entrySet vai verificar todas as linhas do HashMap, for faz loop em todas as linhas pra verificar
        for (var entry : entrySet){
            if (entry.getValue().getLocalidade() != null && entry.getValue().getLocalidade().equals(localidade)){ //entry.getvalue vai buscar todos os atributos , equals depois vai dar a localidade
                return entry.getValue();
            }
        }
        return null;
    }
    
    /**
     *
     * @param username
     * @return CentroVacinacao
     */
    public CentroVacinacao procurarCentro(String username){
        if (username == null) {
            return null;
        }
        for (CentroVacinacao centro : centros.values())
        {
            if (centro.getGestor() != null && username.equals(centro.getGestor().getUsername())) {
                centro.inicializarEstruturas();
                return centro;
            }
        }
       return null;
    }
    
}
