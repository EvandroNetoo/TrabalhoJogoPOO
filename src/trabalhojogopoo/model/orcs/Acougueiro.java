package trabalhojogopoo.model.orcs;

import trabalhojogopoo.model.Guerreiro;

public class Acougueiro extends Guerreiro {
    public Acougueiro(String nome, int idade, int peso) {
        super(nome, idade, peso);
    }

    @Override
    protected int getEnergiaInicial() {
        return 200;
    }

    @Override
    protected int getDanoBase() {
        return 20;
    }

    @Override
    public String getNomeVerboso() {
        return "Açougueiro";
    }

}
