package trabalhojogopoo.model;

import trabalhojogopoo.batalha.Lado;

public abstract class GuerreiroMontadorDeCavalo extends GuerreiroMontador {
    public GuerreiroMontadorDeCavalo(String nome, int idade, int peso) {
        super(nome, idade, peso);
    }

    @Override
    public void criarMontaria() {
        setMontaria(new Cavalo(getNome() + " (montaria)", getIdade(), getPeso()));
    }

    @Override
    public void receberAtaque(Guerreiro atacante, Lado ladoAliado, Lado ladoAdversario) {
        if (temMontaria()) {
            getMontaria().receberAtaque(atacante, ladoAliado, ladoAdversario);
            if (!getMontaria().estaVivo()) {
                setMontaria(null);
            }
            return;
        }
        super.receberAtaque(atacante, ladoAliado, ladoAdversario);
    }

}
