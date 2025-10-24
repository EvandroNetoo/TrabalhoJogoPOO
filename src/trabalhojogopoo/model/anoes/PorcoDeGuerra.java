package trabalhojogopoo.model.anoes;

import trabalhojogopoo.batalha.Lado;
import trabalhojogopoo.model.Guerreiro;
import trabalhojogopoo.model.efeitos.EfeitoPragaDosPorcos;

public class PorcoDeGuerra extends Guerreiro {
    public PorcoDeGuerra(String nome, int idade, int peso) {
        super(nome, idade, peso);
    }

    @Override
    protected int getEnergiaInicial() {
        return 250;
    }

    @Override
    protected int getDanoBase() {
        return 0;
    }

    @Override
    public void receberAtaque(int dano, Lado ladoAliado, Lado ladoAdversario) {
        super.receberAtaque(dano, ladoAliado, ladoAdversario);
        ladoAdversario.primeiro().receberEfeito(new EfeitoPragaDosPorcos());
    }

    @Override
    public String getNomeVerboso() {
        return "Porco de Guerra";
    }

}
