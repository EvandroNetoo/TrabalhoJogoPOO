package trabalhojogopoo.model.goblins;

import trabalhojogopoo.model.Guerreiro;

public class ReiGoblin extends Guerreiro {
    public ReiGoblin(String nome, int idade, int peso) {
        super(nome, idade, peso);
    }

    @Override
    protected int getEnergiaInicial() {
        return 300;
    }

    @Override
    protected int getDanoBase() {
        return 100;
    }

    @Override
    public String getNomeVerboso() {
        return "Rei Goblin";
    }

}
