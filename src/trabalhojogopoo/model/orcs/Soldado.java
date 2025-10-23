package trabalhojogopoo.model.orcs;

import trabalhojogopoo.model.Guerreiro;

public class Soldado extends Guerreiro {
    public Soldado(String nome, int idade, int peso) {
        super(nome, idade, peso);
    }

    @Override
    protected int getDanoBase() {
        return 20;
    }

    @Override
    public String getNomeVerboso() {
        return "Soldado";
    }

}
