package trabalhojogopoo.model.elfos;

import trabalhojogopoo.batalha.Lado;
import trabalhojogopoo.model.Guerreiro;
import trabalhojogopoo.model.GuerreiroMontadorDeCavalo;

public class Arqueiro extends GuerreiroMontadorDeCavalo {
    public Arqueiro(String nome, int idade, int peso) {
        super(nome, idade, peso);
    }

    @Override
    protected int getDanoBase() {
        return 5;
    }

    @Override
    public void atacar(Lado ladoAliado, Lado ladoAdversario, boolean atacouPrimeiro) {
        for (Guerreiro guerreiroAlvo : ladoAdversario.streamGuerreiros().toList()) {
            guerreiroAlvo.receberAtaque(getDano(), ladoAdversario, ladoAliado);
        }
    }

    @Override
    public String getNomeVerboso() {
        return "Arqueiro";
    }

}
