package trabalhojogopoo.model.orcs;

import trabalhojogopoo.batalha.Lado;

public class Soldado extends OrcMontador {
    public Soldado(String nome, int idade, int peso) {
        super(nome, idade, peso);
    }

    @Override
    protected int getDanoBase() {
        return 20;
    }

    @Override
    public void atacar(Lado ladoAliado, Lado ladoAdversario, boolean atacouPrimeiro) {
        if (temMontaria()) {
            getMontaria().atacar(ladoAliado, ladoAdversario, atacouPrimeiro);
        }

        if (ladoAdversario.primeiro().estaVivo()) {
            super.atacar(ladoAliado, ladoAdversario, atacouPrimeiro);
        }
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
        return "Soldado";
    }

}
