package trabalhojogopoo.model.efeitos;

import trabalhojogopoo.batalha.Lado;
import trabalhojogopoo.model.Guerreiro;

public interface IEfeito {
    public void aplicar(Guerreiro guerreiro, Lado ladoAliado);

    public default void amplificar() {
    };

    public TipoEfeito tipo();

    public String toString();
}
