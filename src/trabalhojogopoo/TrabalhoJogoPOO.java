package trabalhojogopoo;

import java.util.Map;

import trabalhojogopoo.batalha.Arena;
import trabalhojogopoo.batalha.Lado;
import trabalhojogopoo.enums.TipoLado;
import trabalhojogopoo.service.GeradorLados;
import trabalhojogopoo.service.importadorGuerreiros.IImportadorGuerreiros;
import trabalhojogopoo.service.importadorGuerreiros.ImportadorGuerreirosArquivo;

public class TrabalhoJogoPOO {

    public static void main(String[] args) throws Exception {
        IImportadorGuerreiros importadorGuerreiros = new ImportadorGuerreirosArquivo(System.getProperty("user.dir"));

        Map<TipoLado, Lado> lados = GeradorLados.gerar(importadorGuerreiros);

        Arena campoDeBatalha = new Arena(lados);

        System.out.println("\na)");
        campoDeBatalha.dadosGerais();

        System.out.println("\nb)");
        campoDeBatalha.dadosPesos();

        System.out.println("\nc)");
        campoDeBatalha.dadosMaisVelho();

        campoDeBatalha.iniciar();
        
        System.out.println("\nd)");
        System.out.println("Ganhador: " + campoDeBatalha.getGanhador());

        System.out.println("\ne)");
        System.out.println("Último Atacante: " + campoDeBatalha.getUltimoAtacante());

        System.out.println("\nf)");
        System.out.println("Último Perdedor: " + campoDeBatalha.getUltimoPerdedor());
    }
}
