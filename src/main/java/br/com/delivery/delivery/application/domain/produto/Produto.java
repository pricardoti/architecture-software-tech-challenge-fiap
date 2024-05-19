package br.com.delivery.delivery.application.domain.produto;

public record Produto(
        String nome,
        String tipo,
        String descricao,
        String comentario
) {
}
