package trabalhojogopoo.model.elfos;

import trabalhojogopoo.model.Guerreiro;

public class Arqueiro extends Guerreiro {
    public Arqueiro(String nome, int idade, int peso) {
        super(nome, idade, peso);
    }

    @Override
    protected int getDanoBase() {
        return 5;
    }

    @Override
    public String getNomeVerboso() {
        return "Arqueiro";
    }

}
