package BACKEND;

import java.time.LocalDate;

/**
 *
 * @author Gonçalo
 */
public class Teste {

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        Utente utente1 = new Utente(); //Criam um objeto Utente com o nome utente1
        utente1.setNumSNS("306111");
        utente1.setMorada("Braga");
        utente1.setLocalidade("AMARES");
        utente1.setNumTelemovel("937899799");
        //utente1.setEmail("utente1@gmail.com");
        utente1.setData_Nasc(LocalDate.parse("2001-09-01"));

        utente1.toString();
        System.out.println(utente1.toString());
        System.out.println(utente1.CalcularIdade());
    }
}
