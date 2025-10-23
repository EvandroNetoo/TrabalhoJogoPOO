package trabalhojogopoo.model.anoes;

public class Imperador extends Glutao {
    public Imperador(String nome, int idade, int peso) {
        super(nome, idade, peso);
    }
    
    @Override
    public String getNomeVerboso() {
        return "Imperador";
    }
}
