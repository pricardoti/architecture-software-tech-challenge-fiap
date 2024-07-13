package br.com.delivery.delivery.application.domain.enums;

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
