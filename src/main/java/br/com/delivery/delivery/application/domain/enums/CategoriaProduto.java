package br.com.delivery.delivery.application.domain.enums;

import org.springframework.util.StringUtils;

import java.util.Arrays;

public enum CategoriaProduto {

    SANDUICHE("SANDUICHE"),
    ACOMPANHAMENTO("ACOMPANHAMENTO"),
    BEBIDA("BEBIDA"),
    SOBREMESA("SOBREMESA");

    private final String value;

    CategoriaProduto(String value) {
        this.value = value;
    }

    private CategoriaProduto fromString(String value) {
        if (!StringUtils.hasText(value)) return null;

        return Arrays.stream(values())
                .filter(category -> category.value.equals(value))
                .findFirst()
                .orElse(null);
    }

    @Override
    public String toString() {
        return this.value;
    }
}
