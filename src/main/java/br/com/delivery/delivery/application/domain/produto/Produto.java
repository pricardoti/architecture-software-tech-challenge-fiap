package br.com.delivery.delivery.application.domain.produto;

import br.com.delivery.delivery.application.domain.enums.CategoriaProduto;

import java.math.BigDecimal;
import java.util.UUID;

public record Produto(
        UUID codigo,
        String nome,
        String descricao,
        BigDecimal preco,
        CategoriaProduto categoria,
        String imagemUrl
) {
    public Produto(
            String nome,
            String descricao,
            BigDecimal preco,
            CategoriaProduto categoria,
            String imagemUrl
    ) {
        this(UUID.randomUUID(), nome, descricao, preco, categoria, imagemUrl);
    }
}
