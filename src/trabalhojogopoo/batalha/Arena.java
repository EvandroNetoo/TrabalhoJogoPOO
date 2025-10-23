package trabalhojogopoo.batalha;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import trabalhojogopoo.enums.TipoLado;
import trabalhojogopoo.model.Guerreiro;

public class Arena {
    private Map<TipoLado, Lado> lados;

    public Arena(Map<TipoLado, Lado> lados) {
        setLados(lados);
    }

    public List<TipoLado> gerarOrdemTipoLados() {
        List<TipoLado> ordemTiposLados = new ArrayList<>(lados.keySet());
        Collections.shuffle(ordemTiposLados);
        return ordemTiposLados;
    }

    public void iniciar() {
        while (lados.values().stream().filter(lado -> lado.qtdVivos() > 0).count() > 1) {
            List<TipoLado> ordemAtaque = gerarOrdemTipoLados(), ordemDefesa = gerarOrdemTipoLados();

            for (TipoLado tipoLadoAtacante : ordemAtaque) {
                Lado ladoAtacante = lados.get(tipoLadoAtacante);
                if (ladoAtacante.qtdVivos() == 0) {
                    continue;
                }

                for (TipoLado tipoLadoDefensor : ordemDefesa.stream().filter(TipoLado -> TipoLado != tipoLadoAtacante)
                        .toList()) {
                    Lado ladoDefensor = lados.get(tipoLadoDefensor);

                    ladoAtacante.primeiro().atacar(ladoAtacante, ladoDefensor);
                }

            }

            lados.values().forEach(lado -> lado.getGuerreiros().removeIf(guerreiro -> !guerreiro.estaVivo()));
        }
    }

    public void dadosGerais() {
        for (Map.Entry<TipoLado, Lado> entry : lados.entrySet()) {
            TipoLado tipoLado = entry.getKey();
            Lado lado = entry.getValue();
            System.out.println("Lado: " + tipoLado.getVeboso());
            for (Guerreiro guerreiro : lado.getGuerreiros()) {
                System.out.println("\t" + guerreiro);
            }
        }
    }

    public void dadosPesos() {
        for (Map.Entry<TipoLado, Lado> entry : lados.entrySet()) {
            TipoLado tipoLado = entry.getKey();
            Lado lado = entry.getValue();

            System.out.println(tipoLado.getVeboso() + " pesam " + lado.somaPesos() + " Kilos.");
        }
    }

    public void dadosMaisVelho() {
        Guerreiro maisVelho = lados.values().stream().map(Lado::maisVelho)
                .max((g1, g2) -> Integer.compare(g1.getIdade(), g2.getIdade())).orElse(null);
        System.out
                .println("O " + maisVelho.getNomeVerboso() + " " + maisVelho.getNome() + " é o guerreiro mais velho.");
    }

    private void setLados(Map<TipoLado, Lado> lados) {
        this.lados = lados;
    }

}
