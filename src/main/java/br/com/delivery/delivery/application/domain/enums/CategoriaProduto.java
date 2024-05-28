package br.com.delivery.delivery.application.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum CategoriaProduto {

    LANCHE("LANCHE"),
    ACOMPANHAMENTO("ACOMPANHAMENTO"),
    BEBIDA("BEBIDA"),
    SOBREMESA("SOBREMESA");

    private final String value;
}
