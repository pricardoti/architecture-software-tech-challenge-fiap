package br.com.delivery.delivery.application.domain.enums;

public enum CategoriaProduto {

    SANDUICHE("SANDUICHE"),
    ACOMPANHAMENTO("ACOMPANHAMENTO"),
    BEBIDA("BEBIDA"),
    SOBREMESA("SOBREMESA");

    private final String value;

    CategoriaProduto(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return this.value;
    }
}
