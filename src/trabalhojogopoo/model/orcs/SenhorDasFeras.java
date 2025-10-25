package trabalhojogopoo.model.orcs;

import trabalhojogopoo.batalha.Lado;
import trabalhojogopoo.model.Guerreiro;

public class SenhorDasFeras extends Guerreiro {
    public SenhorDasFeras(String nome, int idade, int peso) {
        super(nome, idade, peso);
    }

    @Override
    protected int getEnergiaInicial() {
        return 400;
    }

    @Override
    protected int getDanoBase() {
        return 50;
    }

    @Override
    public void atacar(Lado ladoAliado, Lado ladoAdversario, boolean atacouPrimeiro) {
        super.atacar(ladoAliado, ladoAdversario, atacouPrimeiro);
        if (!ladoAdversario.primeiro().estaVivo()) {
            ladoAliado.adicionarGuerreiro(new Warg(getNome() + " (gerado)", getIdade(), getPeso()));
        }
    }

    @Override
    public String getNomeVerboso() {
        return "Senhor das Feras";
    }

}
