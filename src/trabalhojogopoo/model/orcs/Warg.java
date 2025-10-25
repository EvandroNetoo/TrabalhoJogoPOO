package trabalhojogopoo.model.orcs;

import trabalhojogopoo.batalha.Lado;
import trabalhojogopoo.model.Guerreiro;
import trabalhojogopoo.model.GuerreiroMontador;

public class Warg extends Guerreiro {
    private int DANO_POR_WARG_ATRAS = 5;

    public Warg(String nome, int idade, int peso) {
        super(nome, idade, peso);
    }

    @Override
    protected int getDanoBase() {
        return 15;
    }

    @Override
    public void atacar(Lado ladoAliado, Lado ladoAdversario, boolean atacouPrimeiro) {
        setDano(getDano() + (qtdWargAtras(ladoAliado) * DANO_POR_WARG_ATRAS));

        super.atacar(ladoAliado, ladoAdversario, atacouPrimeiro);

        setDano(getDanoBase());
    }

    private int qtdWargAtras(Lado ladoAliado) {
        int qtdWargAtras = (int) ladoAliado.streamGuerreiros()
                .takeWhile(g -> g instanceof Warg
                        || (g instanceof OrcMontador && ((GuerreiroMontador) g).getMontaria() instanceof Warg))
                .count();
        return qtdWargAtras - 1;
    }

    @Override
    public String getNomeVerboso() {
        return "Warg";
    }

}
