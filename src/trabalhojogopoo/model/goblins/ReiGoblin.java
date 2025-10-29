package trabalhojogopoo.model.goblins;

import trabalhojogopoo.batalha.Lado;
import trabalhojogopoo.model.Guerreiro;

public class ReiGoblin extends Guerreiro {
    public static final int QTD_MAX_INSTANCIAS = 1;
    public ReiGoblin(String nome, int idade, int peso) {
        super(nome, idade, peso);
    }

    @Override
    protected int getEnergiaInicial() {
        return 300;
    }

    @Override
    protected int getDanoBase() {
        return 100;
    }

    @Override
    public void morrer(Lado ladoAliado) {
        ladoAliado
                .streamGuerreirosMortos()
                .filter(g -> g instanceof GoblinComum)
                .forEach(
                        g -> ladoAliado
                                .adicionarGuerreiro(
                                        new GoblinComum(g.getNome() + " (ressusitado)", g.getIdade(),
                                                g.getPeso())));
    }

    @Override
    public String getNomeVerboso() {
        return "Rei Goblin";
    }

}
