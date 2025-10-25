package trabalhojogopoo.model.orcs;

import trabalhojogopoo.model.GuerreiroMontador;

public abstract class OrcMontador extends GuerreiroMontador {
    public OrcMontador(String nome, int idade, int peso) {
        super(nome, idade, peso);
    }

    @Override
    public void criarMontaria() {
        setMontaria(new Warg(getNome() + " (montaria)", getIdade(), getPeso()));
    }
}
