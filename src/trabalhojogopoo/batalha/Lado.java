package trabalhojogopoo.batalha;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Stream;

import trabalhojogopoo.model.Guerreiro;
import trabalhojogopoo.model.efeitos.TipoEfeito;

public class Lado {
    private Queue<Guerreiro> guerreiros;
    private List<Guerreiro> guerreiros_mortos;

    public Lado(Queue<Guerreiro> guerreiros) {
        setGuerreiros(guerreiros);
        setGuerreirosMortos(new LinkedList<>());
    }

    public void andarFila() {
        guerreiros.add(guerreiros.poll());
    }

    public void removerTontura() {
        getGuerreiros().forEach(g -> g.setEstaTonto(false));
    }

    public void aplicarEfeitos() {
        getGuerreiros().forEach(guerreiro -> {
            guerreiro.aplicarTipoEfeito(TipoEfeito.POS_RODADA, this);
        });
    }

    public void removerMortos() {
        List<Guerreiro> mortos = new LinkedList<>();
        for (Guerreiro guerreiro : guerreiros) {
            if (!guerreiro.estaVivo()) {
                mortos.add(guerreiro);
            }
        }

        guerreiros.removeAll(mortos);
        guerreiros_mortos.addAll(mortos);
    }

    public int qtdVivos() {
        return guerreiros.size();
    }

    public Guerreiro primeiro() {
        return guerreiros.peek();
    }

    public void adicionarGuerreiro(Guerreiro guerreiro) {
        getGuerreiros().add(guerreiro);
    }

    public void printGuerreiros() {
        for (Guerreiro guerreiro : getGuerreiros()) {
            System.out.println("\t" + guerreiro);
        }
    }

    public int somaPesos() {
        return guerreiros.stream().mapToInt(Guerreiro::getPeso).sum();
    }

    public Guerreiro maisVelho() {
        return guerreiros.stream().max((g1, g2) -> Integer.compare(g1.getIdade(), g2.getIdade())).orElse(null);
    }

    private Queue<Guerreiro> getGuerreiros() {
        return guerreiros;
    }

    public Stream<Guerreiro> streamGuerreiros() {
        return guerreiros.stream();
    }

    private void setGuerreiros(Queue<Guerreiro> guerreiros) {
        this.guerreiros = guerreiros;
    }

    public Stream<Guerreiro> streamGuerreirosMortos() {
        return guerreiros_mortos.stream();
    }

    private void setGuerreirosMortos(List<Guerreiro> guerreiros_mortos) {
        this.guerreiros_mortos = guerreiros_mortos;
    }
}
