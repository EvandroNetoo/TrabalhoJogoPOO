package trabalhojogopoo.service.exceptions;

import trabalhojogopoo.model.Guerreiro;

public class QtdMaxGuerreiroExcedidaException extends ArquivoInvalidoException {
    public QtdMaxGuerreiroExcedidaException(Class<? extends Guerreiro> classeGuerreiro) throws Exception {
        super(String.format("Quantidade máxima de instâncias (%s) excedida para o guerreiro: %s",
                classeGuerreiro.getField("QTD_MAX_INSTANCIAS").getInt(null),
                classeGuerreiro.getSimpleName()));
    }
}
