package trabalhojogopoo.service;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import trabalhojogopoo.batalha.Lado;
import trabalhojogopoo.enums.TipoLado;
import trabalhojogopoo.model.Guerreiro;
import trabalhojogopoo.model.GuerreiroMontador;
import trabalhojogopoo.model.anoes.Glutao;
import trabalhojogopoo.model.anoes.Imperador;
import trabalhojogopoo.model.anoes.PorcoDeGuerra;
import trabalhojogopoo.model.elfos.Arqueiro;
import trabalhojogopoo.model.elfos.Guardiao;
import trabalhojogopoo.model.elfos.Superior;
import trabalhojogopoo.model.goblins.GoblinComum;
import trabalhojogopoo.model.goblins.ReiGoblin;
import trabalhojogopoo.model.orcs.Acougueiro;
import trabalhojogopoo.model.orcs.SenhorDasFeras;
import trabalhojogopoo.model.orcs.Soldado;
import trabalhojogopoo.model.orcs.Warg;
import trabalhojogopoo.service.exceptions.TipoGuerreiroInvalidoException;
import trabalhojogopoo.service.importadorGuerreiros.IImportadorGuerreiros;
import trabalhojogopoo.service.importadorGuerreiros.RecordGuerreiro;

public class GeradorLados {
    public static Map<TipoLado, Lado> gerar(IImportadorGuerreiros importadorGuerreiros) throws Exception {
        Map<TipoLado, List<RecordGuerreiro>> guerreirosPorLado = importadorGuerreiros.importarGuerreiros();

        Map<TipoLado, Map<Integer, Class<? extends Guerreiro>>> tipoGuerreirosPorLado = GeradorLados
                .getTipoGuerreirosPorLado();

        Map<TipoLado, Lado> lados = new HashMap<>();

        for (Map.Entry<TipoLado, List<RecordGuerreiro>> entry : guerreirosPorLado.entrySet()) {
            TipoLado lado = entry.getKey();
            List<RecordGuerreiro> recordsGuerreiro = entry.getValue();
            Queue<Guerreiro> fila = new LinkedList<>();

            for (RecordGuerreiro recordGuerreiro : recordsGuerreiro) {
                Class<? extends Guerreiro> classeGuerreiro = tipoGuerreirosPorLado.get(lado)
                        .get(recordGuerreiro.tipo());
                if (classeGuerreiro == null) {
                    throw new TipoGuerreiroInvalidoException(lado, recordGuerreiro.tipo());
                }

                Guerreiro guerreiro = classeGuerreiro
                        .getDeclaredConstructor(String.class, int.class, int.class)
                        .newInstance(recordGuerreiro.nome(), recordGuerreiro.idade(), recordGuerreiro.peso());

                if (recordGuerreiro.temMontaria() && guerreiro instanceof GuerreiroMontador) {
                    GuerreiroMontador guerreiroMontador = (GuerreiroMontador) guerreiro;
                    guerreiroMontador.criarMontaria();
                }

                fila.add(guerreiro);
            }

            Lado ladoObj = new Lado(fila);
            lados.put(lado, ladoObj);
        }

        return lados;
    }

    private static Map<TipoLado, Map<Integer, Class<? extends Guerreiro>>> getTipoGuerreirosPorLado() {
        Map<TipoLado, Map<Integer, Class<? extends Guerreiro>>> tipoGuerreirosPorLado = new HashMap<>();

        tipoGuerreirosPorLado.put(TipoLado.ORCS_E_GOBLINS, new HashMap<>());
        tipoGuerreirosPorLado.get(TipoLado.ORCS_E_GOBLINS).put(1, GoblinComum.class);
        tipoGuerreirosPorLado.get(TipoLado.ORCS_E_GOBLINS).put(2, ReiGoblin.class);
        tipoGuerreirosPorLado.get(TipoLado.ORCS_E_GOBLINS).put(3, Soldado.class);
        tipoGuerreirosPorLado.get(TipoLado.ORCS_E_GOBLINS).put(4, Acougueiro.class);
        tipoGuerreirosPorLado.get(TipoLado.ORCS_E_GOBLINS).put(5, Warg.class);
        tipoGuerreirosPorLado.get(TipoLado.ORCS_E_GOBLINS).put(6, SenhorDasFeras.class);

        tipoGuerreirosPorLado.put(TipoLado.ELFOS_E_ANOES, new HashMap<>());
        tipoGuerreirosPorLado.get(TipoLado.ELFOS_E_ANOES).put(1, Guardiao.class);
        tipoGuerreirosPorLado.get(TipoLado.ELFOS_E_ANOES).put(2, Arqueiro.class);
        tipoGuerreirosPorLado.get(TipoLado.ELFOS_E_ANOES).put(3, Superior.class);
        tipoGuerreirosPorLado.get(TipoLado.ELFOS_E_ANOES).put(4, Glutao.class);
        tipoGuerreirosPorLado.get(TipoLado.ELFOS_E_ANOES).put(5, PorcoDeGuerra.class);
        tipoGuerreirosPorLado.get(TipoLado.ELFOS_E_ANOES).put(6, Imperador.class);

        return tipoGuerreirosPorLado;
    }
}
