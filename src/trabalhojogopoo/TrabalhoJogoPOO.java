package trabalhojogopoo;

import java.io.FileNotFoundException;
import java.util.Map;

import trabalhojogopoo.batalha.Arena;
import trabalhojogopoo.batalha.Lado;
import trabalhojogopoo.enums.TipoLado;
import trabalhojogopoo.service.GeradorLados;
import trabalhojogopoo.service.exceptions.ArquivoInvalidoException;
import trabalhojogopoo.service.importadorGuerreiros.IImportadorGuerreiros;
import trabalhojogopoo.service.importadorGuerreiros.ImportadorGuerreirosArquivo;

public class TrabalhoJogoPOO {

    public static void main(String[] args) {
        IImportadorGuerreiros importadorGuerreiros = new ImportadorGuerreirosArquivo(System.getProperty("user.dir"));

        try {
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

        } catch (FileNotFoundException e) {
            System.err.println("Arquivo de guerreiros não encontrado: " + e.getMessage());
            return;
        } catch (ArquivoInvalidoException e) {
            System.err.println("Arquivo inválido: " + e.getMessage());
            return;
        } catch (Exception e) {
            System.err.println("Erro interno do sistema: " + e.getMessage());
            return;
        }

    }
}
