package trabalhojogopoo.model.anoes;

import trabalhojogopoo.model.Guerreiro;

public class Glutao extends Guerreiro {
    public Glutao(String nome, int idade, int peso) {
        super(nome, idade, peso);
    }

    @Override
    protected int getDanoBase() {
        return 30;
    }
    
    @Override
    public String getNomeVerboso() {
        return "Glutão";
    }

}
