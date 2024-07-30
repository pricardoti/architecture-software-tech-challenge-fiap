package br.com.fiap.delivery.domain.pedido;

import java.util.UUID;

public class PedidoProduto {

    private UUID codigoProduto;
    private Integer quantidade;

    public PedidoProduto(UUID codigoProduto, Integer quantidade) {
        this.codigoProduto = codigoProduto;
        this.quantidade = quantidade;
    }

    public UUID getCodigoProduto() {
        return codigoProduto;
    }

    public Integer getQuantidade() {
        return quantidade;
    }
}
