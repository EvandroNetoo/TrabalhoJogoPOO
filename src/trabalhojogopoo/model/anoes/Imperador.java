package trabalhojogopoo.model.anoes;

import trabalhojogopoo.batalha.Lado;

public class Imperador extends Glutao {
    private static final int DANO_QUANDO_ATACA_PRIMEIRO = 50;

    public Imperador(String nome, int idade, int peso) {
        super(nome, idade, peso);
    }

    @Override
    public void atacar(Lado ladoAliado, Lado ladoAdversario, boolean atacouPrimeiro) {
        if (atacouPrimeiro) {
            setDano(DANO_QUANDO_ATACA_PRIMEIRO);
        }
        super.atacar(ladoAliado, ladoAdversario, atacouPrimeiro);

        setDano(getDanoBase());
        ladoAdversario.primeiro().setEstaTonto(true);
    }

    @Override
    public String getNomeVerboso() {
        return "Imperador";
    }
}
