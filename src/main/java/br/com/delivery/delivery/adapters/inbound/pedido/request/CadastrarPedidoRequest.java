package br.com.delivery.delivery.adapters.inbound.pedido.request;

import br.com.delivery.delivery.application.domain.pedido.Pedido;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import static br.com.delivery.delivery.application.domain.enums.StatusPedido.AGUARDANDO_PAGAMENTO;

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
        return Pedido.builder()
                .codigoPedido(UUID.randomUUID())
                .cliente(UUID.fromString(codigoCliente))
                .status(AGUARDANDO_PAGAMENTO)
                .dataHoraSolicitacao(LocalDateTime.now())
                .produtos(
                        produtos.stream()
                                .map(PedidoProdutoRequest::toDomain)
                                .toList()
                )
                .build();
    }
}
