package trabalhojogopoo.service.exceptions;

import trabalhojogopoo.enums.TipoLado;

public class TipoGuerreiroInvalidoException extends ArquivoInvalidoException {
    public TipoGuerreiroInvalidoException(TipoLado lado, int tipo) {
        super("Tipo de guerreiro inválido: " + tipo + " para o lado: " + lado);
    }
}
