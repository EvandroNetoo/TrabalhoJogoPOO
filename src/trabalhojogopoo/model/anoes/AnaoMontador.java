package trabalhojogopoo.model.anoes;

import trabalhojogopoo.model.GuerreiroMontador;

public abstract class AnaoMontador extends GuerreiroMontador {
    public AnaoMontador(String nome, int idade, int peso) {
        super(nome, idade, peso);
    }

    @Override
    public void criarMontaria() {
        setMontaria(new PorcoDeGuerra(getNome() + " (montaria)", getIdade(), getPeso()));
    }
}
