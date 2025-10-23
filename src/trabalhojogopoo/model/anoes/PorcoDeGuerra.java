package trabalhojogopoo.model.anoes;

import trabalhojogopoo.model.Guerreiro;

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
    public String getNomeVerboso() {
        return "Porco de Guerra";
    }

}
