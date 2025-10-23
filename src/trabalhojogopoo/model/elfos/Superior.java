package trabalhojogopoo.model.elfos;

import trabalhojogopoo.model.Guerreiro;

public class Superior extends Guerreiro {
    public Superior(String nome, int idade, int peso) {
        super(nome, idade, peso);
    }

    @Override
    protected int getEnergiaInicial() {
        return 500;
    }

    @Override
    protected int getDanoBase() {
        return (int) Double.POSITIVE_INFINITY;
    }
    
    @Override
    public String getNomeVerboso() {
        return "Superior";
    }

}
