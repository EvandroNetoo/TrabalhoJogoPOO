package trabalhojogopoo.model;

import java.util.LinkedList;
import java.util.List;

import trabalhojogopoo.batalha.Lado;
import trabalhojogopoo.model.efeitos.IEfeito;
import trabalhojogopoo.model.efeitos.TipoEfeito;

public abstract class Guerreiro {
    public static final int QTD_MAX_INSTANCIAS = Integer.MAX_VALUE;
    private String nome;
    private int idade;
    private int peso;
    private int energia;
    private int dano;
    private boolean estaTonto;
    private List<IEfeito> efeitos;

    public Guerreiro(String nome, int idade, int peso) {
        setNome(nome);
        setIdade(idade);
        setPeso(peso);
        setEnergia(getEnergiaInicial());
        setDano(getDanoBase());
        setEfeitos(new LinkedList<>());
    }

    protected int getEnergiaInicial() {
        return 100;
    }

    protected abstract int getDanoBase();

    public boolean estaVivo() {
        return energia > 0;
    }

    public boolean podeAtacar() {
        return estaVivo() && !estaTonto;
    }

    public void atacar(Lado ladoAliado, Lado ladoAdversario, boolean atacouPrimeiro) {
        Guerreiro defensor = ladoAdversario.primeiro();
        if (defensor != null) {
            aplicarTipoEfeito(TipoEfeito.PRE_ATAQUE, ladoAliado);
            defensor.receberAtaque(this, ladoAdversario, ladoAliado);
            aplicarTipoEfeito(TipoEfeito.POS_ATAQUE, ladoAliado);
        }
    }

    public void receberAtaque(Guerreiro atacante, Lado ladoAliado, Lado ladoAdversario) {
        if (!estaVivo()) {
            return;
        }
        receberDano(atacante.getDano(), ladoAliado);
    }

    public void receberDano(int dano, Lado ladoAliado) {
        setEnergia(getEnergia() - dano);
        if (!estaVivo()) {
            morrer(ladoAliado);
        }
    }

    protected void morrer(Lado ladoAliado) {
        setEnergia(0);
        setEfeitos(new LinkedList<>());
    }

    public void aplicarTipoEfeito(TipoEfeito tipoEfeito, Lado ladoAliado) {
        getEfeitos().stream()
                .filter(e -> e.tipo() == tipoEfeito)
                .forEach(e -> e.aplicar(this, ladoAliado));
    }

    public void receberEfeito(IEfeito efeito) {
        boolean efeitoPresente = getEfeitos().stream()
                .anyMatch(e -> e.getClass().equals(efeito.getClass()));

        if (efeitoPresente) {
            getEfeitos().stream()
                    .filter(e -> e.getClass().equals(efeito.getClass()))
                    .findFirst()
                    .ifPresent(IEfeito::amplificar);
        } else {
            getEfeitos().add(efeito);
        }
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public int getEnergia() {
        return energia;
    }

    public void setEnergia(int energia) {
        this.energia = energia;
    }

    public int getDano() {
        return dano;
    }

    public void setDano(int dano) {
        this.dano = dano;
    }

    public boolean getEstaTonto() {
        return estaTonto;
    }

    public void setEstaTonto(boolean estaTonto) {
        this.estaTonto = estaTonto;
    }

    public void setEfeitos(List<IEfeito> efeitos) {
        this.efeitos = efeitos;
    }

    public List<IEfeito> getEfeitos() {
        return efeitos;
    }

    public abstract String getNomeVerboso();

    @Override
    public String toString() {
        return String.format("%s: %s, %d anos, %d Kilos, %d energia, efeitos: %s", getNomeVerboso(), nome, idade, peso, energia, getEfeitos());
    }
}
