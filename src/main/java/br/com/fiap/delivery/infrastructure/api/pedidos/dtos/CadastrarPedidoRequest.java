package br.com.fiap.delivery.infrastructure.api.pedidos.dtos;

import br.com.fiap.delivery.domain.pedido.Pedido;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import static br.com.fiap.delivery.domain.pedido.StatusPedido.AGUARDANDO_PAGAMENTO;

@Getter
@Setter
public class CadastrarPedidoRequest {

    private static final int TAMANHO_CODIGO_CLIENTE = 36;

    @NotNull
    @Size(
            min = TAMANHO_CODIGO_CLIENTE,
            max = TAMANHO_CODIGO_CLIENTE
    )
    private String codigoCliente;

    @NotNull
    private List<@Valid PedidoProdutoRequest> produtos;

    public Pedido toDomain() {
        var pedido = new Pedido();
        pedido.setCodigoPedido(UUID.randomUUID());
        pedido.setCliente(UUID.fromString(codigoCliente));
        pedido.setStatus(AGUARDANDO_PAGAMENTO);
        pedido.setDataHoraSolicitacao(LocalDateTime.now());
        pedido.setProdutos(
                produtos.stream()
                        .map(PedidoProdutoRequest::toDomain)
                        .toList()
        );
        return pedido;
    }
}