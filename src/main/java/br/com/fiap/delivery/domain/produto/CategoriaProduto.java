package br.com.fiap.delivery.domain.produto;

public enum CategoriaProduto {

    LANCHE("LANCHE"),
    ACOMPANHAMENTO("ACOMPANHAMENTO"),
    BEBIDA("BEBIDA"),
    SOBREMESA("SOBREMESA");

    private final String value;

    CategoriaProduto(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
