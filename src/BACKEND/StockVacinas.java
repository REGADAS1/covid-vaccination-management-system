package BACKEND;

import java.util.HashMap;
import java.util.Map;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Gonçalo
 */
public class StockVacinas implements Serializable{

    private  Map<Vacina, Long> stock = new HashMap<>();

    /**
     *
     * @param vacina
     * @param quantidade
     * @return long
     */
    public long TotalVacinas(Vacina vacina, long quantidade) {
        Long total = stock.get(vacina);
        return total == null ? 0 : total;

    }

    /**
     *
     * @param vacina
     * @param quantidade
     * @return long
     */
    public long TipoVacinas(Vacina vacina, long quantidade) {
        return stock.size();

    }

    /**
     *
     * @param vacina
     * @param quantidade
     */
    public void AdicionarVacinas(Vacina vacina, long quantidade) {
    if(stock ==null){
        stock = new HashMap<>();
    }
    if(stock.containsKey(vacina)){
        stock.put(vacina, stock.get(vacina) + quantidade);
        
    }
    else{
        stock.put(vacina, quantidade);
    }
    
      
    }

    /**
     *
     * @param vacina
     * @param quantidade
     */
    public void RemoverVacinas(Vacina vacina, long quantidade) {

        Long stockatual = stock.get(vacina);
        if (stockatual == null || stockatual == 0) {
            System.err.println("Impossivel, não existem vacinas!");
        } else if (quantidade > stockatual) {
            System.err.println("Impossivel, não existem vacinas suficientes!");
        } else {
            stock.put(vacina, stockatual - quantidade);

        }

    }

    /**
     *
     * @param vacina
     * @return boolean
     */
    public boolean ExisteVacina(Vacina vacina) {
        return vacina != null && stock.containsKey(vacina) && stock.get(vacina) != null && stock.get(vacina) > 0;

    }

    /**
     *
     * @return int
     */
    public int size(){
        return stock.size();
    }

    /**
     *
     * @return ArrayList<Vacina>
     */
    public ArrayList<Vacina> todosKeys() { //vai buscar todas as vacinas
        ArrayList<Vacina> vacinas = new ArrayList<>();

        for (Vacina vacina : stock.keySet()) {
            vacinas.add(vacina);
        }
        return vacinas;
        
        
}

    /**
     *
     * @return ArrayList<Integer>
     */
    public  ArrayList<Integer>  todosValues() //vai buscar o inteiro do Stock
    {
        ArrayList<Integer> quantidade = new ArrayList<>();

        for (Vacina vacina : stock.keySet()) {
            quantidade.add(stock.get(vacina).intValue());
            
        }
        return quantidade;
    }

}

