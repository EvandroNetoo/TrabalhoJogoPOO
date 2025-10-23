package trabalhojogopoo.model.orcs;

import trabalhojogopoo.model.Guerreiro;

public class Warg extends Guerreiro {
    public Warg(String nome, int idade, int peso) {
        super(nome, idade, peso);
    }

    @Override
    protected int getDanoBase() {
        return 15;
    }

    @Override
    public String getNomeVerboso() {
        return "Warg";
    }

}
