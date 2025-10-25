package trabalhojogopoo.model;

public abstract class GuerreiroMontador extends Guerreiro {
    private Guerreiro montaria;

    public GuerreiroMontador(String nome, int idade, int peso) {
        super(nome, idade, peso);
    }

    public abstract void criarMontaria();

    public boolean temMontaria() {
        return montaria != null;
    }

    public Guerreiro getMontaria() {
        return montaria;
    }

    protected void setMontaria(Guerreiro montaria) {
        this.montaria = montaria;
    }

    @Override
    public String toString() {
        return super.toString() + "  || montaria: " + (temMontaria() ? getMontaria() : " sem montaria");
    }
}
