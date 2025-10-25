package trabalhojogopoo.model.orcs;

import trabalhojogopoo.batalha.Lado;
import trabalhojogopoo.model.Guerreiro;

public class Acougueiro extends OrcMontador {
    public Acougueiro(String nome, int idade, int peso) {
        super(nome, idade, peso);
    }

    @Override
    protected int getEnergiaInicial() {
        return 200;
    }

    @Override
    protected int getDanoBase() {
        return 20;
    }

    @Override
    public void atacar(Lado ladoAliado, Lado ladoAdversario, boolean atacouPrimeiro) {
        Guerreiro defensor = ladoAdversario.primeiro();
        boolean estavaVivo = defensor.estaVivo();
        super.atacar(ladoAliado, ladoAdversario, atacouPrimeiro);
        if (estavaVivo && !defensor.estaVivo()) {
            setDano(getDano() + defensor.getDano());
        }
    }

    @Override
    public void receberDano(int dano, Lado ladoAliado) {
        super.receberDano(dano, ladoAliado);
        if (estaVivo() && getEnergia() <= 40 && temMontaria()) {
            setEnergia(getEnergia() + getMontaria().getEnergia());
            setMontaria(null);
        }
    }

    @Override
    public String getNomeVerboso() {
        return "Açougueiro";
    }

}
