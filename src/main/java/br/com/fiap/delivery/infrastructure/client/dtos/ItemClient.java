package br.com.fiap.delivery.infrastructure.client.dtos;

import br.com.fiap.delivery.domain.produto.Produto;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
@Builder
public class ItemClient {

    @JsonProperty("sku_number")
    private String codigo;

    @JsonProperty("category")
    private String categoria;

    @JsonProperty("title")
    private String titulo;

    @JsonProperty("description")
    private String descricao;

    @JsonProperty("unit_price")
    private BigDecimal precoUnitario;

    @JsonProperty("quantity")
    private Integer quantidade;

    @JsonProperty("unit_measure")
    private final String unidade = "unit";

    @JsonProperty("total_amount")
    private BigDecimal valorTotal;

    public static ItemClient toDTO(Produto produto, Integer quantidade) {
        var quantidadeItem = BigDecimal.valueOf(quantidade);
        return ItemClient.builder()
                .codigo(produto.getCodigo().toString())
                .categoria(produto.getCategoria().name())
                .titulo(produto.getNome())
                .descricao(produto.getDescricao())
                .precoUnitario(produto.getPreco())
                .quantidade(quantidade)
                .valorTotal(produto.getPreco().multiply(quantidadeItem))
                .build();
    }
}