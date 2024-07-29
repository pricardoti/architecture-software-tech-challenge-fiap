package br.com.fiap.delivery.infrastructure.client.dtos;

import br.com.fiap.delivery.domain.pedido.Pedido;
import br.com.fiap.delivery.domain.produto.Produto;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;
import java.text.MessageFormat;
import java.util.Collection;
import java.util.List;

@Getter
@AllArgsConstructor
public class MercadoPagoQrDinamicoRequest {

    private static final String TECH_CHALLENGE = "Tech Challenge - Delivery App";
    private static final String DESCRICAO_PATTERN = "N° Pedido: {0}, cliente: {1}";

    @JsonProperty("title")
    private String titulo;

    @JsonProperty("external_reference")
    private String referencia;

    @JsonProperty("description")
    private String descricao;

    @JsonProperty("notification_url")
    private String urlCallback;

    @JsonProperty("total_amount")
    private BigDecimal valorTotal;

    private List<ItemClient> items;

    public static MercadoPagoQrDinamicoRequest fromPedido(Pedido pedido, Collection<Produto> produtos, String notificationUrl) {
        return new MercadoPagoQrDinamicoRequest(
                TECH_CHALLENGE,
                pedido.getCodigoPedido().toString(),
                notificationUrl,
                MessageFormat.format(DESCRICAO_PATTERN, pedido.getCodigoPedido(), pedido.getCliente()),
                pedido.getValorTotal(),
                pedido.getProdutos()
                        .stream()
                        .map(produtoPedido -> {
                            var produtoSelecionado = produtos.stream()
                                    .filter(produto -> produtoPedido.getCodigoProduto().equals(produto.getCodigo()))
                                    .findFirst()
                                    .get();

                            return ItemClient.toDTO(produtoSelecionado, produtoPedido.getQuantidade());
                        }).toList()
        );
    }
}