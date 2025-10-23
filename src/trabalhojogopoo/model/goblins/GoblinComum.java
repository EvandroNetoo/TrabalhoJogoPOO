package trabalhojogopoo.model.goblins;

import trabalhojogopoo.model.Guerreiro;

public class GoblinComum extends Guerreiro {
    public GoblinComum(String nome, int idade, int peso) {
        super(nome, idade, peso);
    }

    @Override
    protected int getEnergiaInicial() {
        return 50;
    }

    @Override
    protected int getDanoBase() {
        return 10;
    }

    @Override
    public String getNomeVerboso() {
        return "Goblin Comum";
    }

}
