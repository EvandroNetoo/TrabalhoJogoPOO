package trabalhojogopoo.model.efeitos;

import trabalhojogopoo.batalha.Lado;
import trabalhojogopoo.model.Guerreiro;

public class EfeitoPragaDosPorcos implements IEfeito {
    private int qtdAmplificada;
    private static final int DANO_BASE = 5;
    private static final int MAX_AMPLIFICACAO = 3;

    public EfeitoPragaDosPorcos() {
        setQtdAmplificada(1);
    }

    @Override
    public TipoEfeito tipo() {
        return TipoEfeito.PRE_ATAQUE;
    }

    @Override
    public void aplicar(Guerreiro guerreiro, Lado ladoAliado) {
        guerreiro.receberDano(getQtdAmplificada() * DANO_BASE, ladoAliado);
    }

    @Override
    public void amplificar() {
        setQtdAmplificada(Math.min(getQtdAmplificada() + 1, MAX_AMPLIFICACAO));
    }

    public int getQtdAmplificada() {
        return qtdAmplificada;
    }

    public void setQtdAmplificada(int qtdAmplificada) {
        this.qtdAmplificada = qtdAmplificada;
    }

    @Override
    public String toString() {
        return "Praga dos Porcos (dano: " + (getQtdAmplificada() * DANO_BASE) + ")";
    }
}
