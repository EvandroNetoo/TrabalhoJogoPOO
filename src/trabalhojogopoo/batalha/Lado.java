package trabalhojogopoo.batalha;

import java.util.Queue;

import trabalhojogopoo.model.Guerreiro;

public class Lado {
    private Queue<Guerreiro> guerreiros;

    public Lado(Queue<Guerreiro> guerreiros) {
        setGuerreiros(guerreiros);
    }

    public int qtdVivos() {
        return guerreiros.size();
    }

    public Guerreiro primeiro() {
        return guerreiros.peek();
    }

    public int somaPesos() {
        return guerreiros.stream().mapToInt(Guerreiro::getPeso).sum();
    }

    public Guerreiro maisVelho() {
        return guerreiros.stream().max((g1, g2) -> Integer.compare(g1.getIdade(), g2.getIdade())).orElse(null);
    }

    public Queue<Guerreiro> getGuerreiros() {
        return guerreiros;
    }

    public void setGuerreiros(Queue<Guerreiro> guerreiros) {
        this.guerreiros = guerreiros;
    }
}
