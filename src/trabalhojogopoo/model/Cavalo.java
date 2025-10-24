package trabalhojogopoo.model;

public class Cavalo extends Guerreiro {
    public Cavalo(String nome, int idade, int peso) {
        super(nome, idade, peso);
    }

    @Override
    protected int getDanoBase() {
        return 0;
    }

    @Override
    public String getNomeVerboso() {
        return "Cavalo";
    }
}
