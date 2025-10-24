package trabalhojogopoo.model.elfos;

import trabalhojogopoo.model.GuerreiroMontadorDeCavalo;

public class Guardiao extends GuerreiroMontadorDeCavalo {
    public Guardiao(String nome, int idade, int peso) {
        super(nome, idade, peso);
    }

    @Override
    protected int getDanoBase() {
        return 25;
    }

    @Override
    public String getNomeVerboso() {
        return "Guardião";
    }

}
