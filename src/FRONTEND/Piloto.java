package FRONTEND;

import BACKEND.Administrador;
import BACKEND.CentroVacinacao;
import BACKEND.Gestor;
import BACKEND.RepositorioCentrosVacinacao;
import BACKEND.RepositorioDoencas;
import BACKEND.RepositorioUtilizador;
import BACKEND.Utente;
import BACKEND.Sistema;
import BACKEND.Utilizador;
import SERIALIZACAO.Serializacao;
import java.nio.file.Paths;

public class Piloto {

    public static void main(String[] args) {
        Sistema sistema;
        
        String ficheiroDados = Paths.get(System.getProperty("user.dir"), "utilizadores.data").toString();
        System.out.println(String.format("Ficheiro de dados: %s.", ficheiroDados));
        Serializacao serializacao = new Serializacao(ficheiroDados);

        if (!serializacao.getFicheiro().exists()) {
            //Cria uma instancia do sistema
            sistema = new Sistema();
            sistema.Inicializar();
                        
        } else {
            sistema = serializacao.carregar();
        }
        sistema.repararDados();
        serializacao.guardar(sistema);

        //Uma vez que a JanelaLogin é modal, este método irá bloquear até que a janela seja fechada.
        //A janela só fecha quando os dados de login são válidos.                
        LoginForm login = new LoginForm(sistema, serializacao);
        login.setVisible(true);

        // JanelaPrincipal principal = new JanelaPrincipal(sistema, bd);
        //  principal.setVisible(true);        
    }
}
