package trabalhojogopoo.model.anoes;

import trabalhojogopoo.batalha.Lado;

public class Glutao extends AnaoMontador {
    public Glutao(String nome, int idade, int peso) {
        super(nome, idade, peso);
    }

    @Override
    protected int getDanoBase() {
        return 30;
    }

    @Override
    protected void morrer(Lado ladoAliado) {
        super.morrer(ladoAliado);
        if (temMontaria()) {
            ladoAliado.adicionarGuerreiro(getMontaria());
        }
    }

    @Override
    public String getNomeVerboso() {
        return "Glutão";
    }

}
