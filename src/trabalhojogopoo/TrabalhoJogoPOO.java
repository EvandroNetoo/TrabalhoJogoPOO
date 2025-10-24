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

        System.err.println("\na)");
        campoDeBatalha.dadosGerais();

        System.err.println("\nb)");
        campoDeBatalha.dadosPesos();

        System.err.println("\nc)");
        campoDeBatalha.dadosMaisVelho();

        System.err.println("\nd)");
        campoDeBatalha.iniciar();

        System.err.println("\ne)");
        System.err.println("\nf)");
    }
}
