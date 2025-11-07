package trabalhojogopoo.batalha;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import trabalhojogopoo.enums.TipoLado;
import trabalhojogopoo.model.Guerreiro;

public class Arena {
    private Map<TipoLado, Lado> lados;
    TipoLado ganhador;

    public Arena(Map<TipoLado, Lado> lados) {
        setLados(lados);
    }

    public List<TipoLado> gerarOrdemTipoLados() {
        List<TipoLado> ordemTiposLados = new ArrayList<>(lados.keySet());
        Collections.shuffle(ordemTiposLados);
        return ordemTiposLados;
    }

    public void iniciar() {

        int iRound = 0;
        System.err.println("ROUND " + ++iRound);
        dadosGerais();
        System.out.println("---------------------------------------------------");

        while (getLados().values().stream().filter(lado -> lado.qtdVivos() > 0).count() > 1) {
            List<TipoLado> ordemAtaque = gerarOrdemTipoLados(), ordemDefesa = gerarOrdemTipoLados();

            for (TipoLado tipoLadoAtacante : ordemAtaque) {
                Lado ladoAtacante = getLados().get(tipoLadoAtacante);
                if (ladoAtacante.qtdVivos() == 0) {
                    continue;
                }

                for (TipoLado tipoLadoDefensor : ordemDefesa.stream()
                        .filter(tipoLado -> tipoLado != tipoLadoAtacante)
                        .toList()) {
                    Lado ladoDefensor = getLados().get(tipoLadoDefensor);

                    Guerreiro guerreiroAtacante = ladoAtacante.primeiro();

                    if (guerreiroAtacante.podeAtacar()) {
                        guerreiroAtacante.atacar(
                                ladoAtacante,
                                ladoDefensor,
                                tipoLadoAtacante == ordemAtaque.get(0));
                    }

                }

            }

            aplicarRotinasAposRodada();

            System.out.println("ROUND " + ++iRound);
            dadosGerais();
            System.out.println("---------------------------------------------------");
        }

        TipoLado ganhador = getLados().entrySet().stream()
                .filter(entry -> entry.getValue().qtdVivos() > 0)
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse(null);
        setGanhador(ganhador);
    }

    private void aplicarRotinasAposRodada() {
        getLados().values().forEach(lado -> {
            lado.andarFila();
            lado.aplicarEfeitos();
            lado.removerTontura();
            lado.removerMortos();
        });
    }

    public void dadosGerais() {
        for (Map.Entry<TipoLado, Lado> entry : lados.entrySet()) {
            TipoLado tipoLado = entry.getKey();
            Lado lado = entry.getValue();
            System.out.println("Lado " + tipoLado.getVeboso() + ":");
            lado.printGuerreiros();
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

    private Map<TipoLado, Lado> getLados() {
        return lados;
    }

    private void setLados(Map<TipoLado, Lado> lados) {
        this.lados = lados;
    }

    public TipoLado getGanhador() {
        return ganhador;
    }

    private void setGanhador(TipoLado ganhador) {
        this.ganhador = ganhador;
    }

    public Guerreiro getUltimoAtacante() {
        return lados.get(ganhador).streamGuerreiros().findFirst().orElse(null);
    }

    public Guerreiro getUltimoPerdedor() {
        return lados.get(ganhador == TipoLado.ELFOS_E_ANOES ? TipoLado.ORCS_E_GOBLINS : TipoLado.ELFOS_E_ANOES).streamGuerreirosMortos().findFirst().orElse(null);
    }
}
