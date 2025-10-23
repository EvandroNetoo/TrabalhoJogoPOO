package trabalhojogopoo.enums;

public enum TipoLado {
    ORCS_E_GOBLINS("Orcs e Goblins"),
    ELFOS_E_ANOES("Elfos e Anões");

    private String veboso;

    TipoLado(String descricao) {
        setVeboso(descricao);
    }

    public String getVeboso() {
        return veboso;
    }

    private void setVeboso(String descricao) {
        this.veboso = descricao;
    }
}