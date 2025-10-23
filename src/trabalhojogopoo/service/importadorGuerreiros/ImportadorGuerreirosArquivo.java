package trabalhojogopoo.service.importadorGuerreiros;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import trabalhojogopoo.enums.TipoLado;

public class ImportadorGuerreirosArquivo implements IImportadorGuerreiros {
    private String caminhoBase;
    private String nomeArquivoElfosAnoes;
    private String nomeArquivoOrcsGoblins;

    public ImportadorGuerreirosArquivo(String caminhoBase) {
        setCaminhoBase(caminhoBase);
        setNomeArquivoElfosAnoes("elfos_anoes.txt");
        setNomeArquivoOrcsGoblins("orcs_goblins.txt");
    }

    private List<RecordGuerreiro> lerGuerreirosLado(String nomeArquivo) throws FileNotFoundException {
        List<RecordGuerreiro> guerreiros = new java.util.LinkedList<RecordGuerreiro>();

        Scanner sc = new Scanner(new File(Paths.get(getCaminhoBase()).resolve(nomeArquivo).toString()));

        while (sc.hasNext()) {
            Scanner linhaScanner = new Scanner(sc.nextLine());

            int tipo = linhaScanner.nextInt();
            String nome = linhaScanner.next();
            int idade = linhaScanner.nextInt();
            int peso = linhaScanner.nextInt();
            boolean temMontaria = linhaScanner.hasNext() && linhaScanner.next().equals("Sim");

            guerreiros.add(new RecordGuerreiro(tipo, nome, idade, peso, temMontaria));

            linhaScanner.close();
        }

        sc.close();

        return guerreiros;
    }

    public Map<TipoLado, List<RecordGuerreiro>> importarGuerreiros() throws FileNotFoundException {
        Map<TipoLado, List<RecordGuerreiro>> guerreirosPorLado = new HashMap<>();
        guerreirosPorLado.put(TipoLado.ELFOS_E_ANOES, lerGuerreirosLado(getNomeArquivoElfosAnoes()));
        guerreirosPorLado.put(TipoLado.ORCS_E_GOBLINS, lerGuerreirosLado(getNomeArquivoOrcsGoblins()));
        return guerreirosPorLado;
    }

    public String getCaminhoBase() {
        return caminhoBase;
    }

    public void setCaminhoBase(String caminhoBase) {
        this.caminhoBase = caminhoBase;
    }

    public String getNomeArquivoElfosAnoes() {
        return nomeArquivoElfosAnoes;
    }

    public void setNomeArquivoElfosAnoes(String nomeArquivoElfosAnoes) {
        this.nomeArquivoElfosAnoes = nomeArquivoElfosAnoes;
    }

    public String getNomeArquivoOrcsGoblins() {
        return nomeArquivoOrcsGoblins;
    }

    public void setNomeArquivoOrcsGoblins(String nomeArquivoOrcsGoblins) {
        this.nomeArquivoOrcsGoblins = nomeArquivoOrcsGoblins;
    }
}
