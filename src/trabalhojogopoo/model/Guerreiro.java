package trabalhojogopoo.model;

import trabalhojogopoo.batalha.Lado;

public class Guerreiro {
    private String nome;
    private int idade;
    private int peso;
    private int energia;
    private int dano;

    public Guerreiro(String nome, int idade, int peso) {
        setNome(nome);
        setIdade(idade);
        setPeso(peso);
        setEnergia(getEnergiaInicial());
        setDano(getDanoBase());
    }

    protected int getEnergiaInicial() {
        return 100;
    }

    protected int getDanoBase() {
        return 10;
    }

    public boolean estaVivo() {
        return energia > 0;
    }

    public void atacar(Lado ladoAliado, Lado ladoAdversário) {
        Guerreiro defensor = ladoAdversário.primeiro();
        if (defensor != null) {
            defensor.receberDano(getDano());
        }
    }

    public void receberDano(int dano) {
        setEnergia(getEnergia() - dano);
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

    public String getNomeVerboso() {
        return "Guerreiro";
    }

    @Override
    public String toString() {
        return getNomeVerboso() + ": " + nome + ", " + idade + " anos, " + peso + " Kilos";
    }
}
