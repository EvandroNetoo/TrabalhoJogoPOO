package trabalhojogopoo.service.importadorGuerreiros;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Map;

import trabalhojogopoo.enums.TipoLado;

public interface IImportadorGuerreiros {
    public Map<TipoLado, List<RecordGuerreiro>> importarGuerreiros() throws FileNotFoundException;
}
