package br.com.fiap.delivery.infrastructure.api.pedidos.dtos;

import br.com.fiap.delivery.domain.pedido.StatusPedido;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AtualizarPedidoRequest {

    @NotNull
    private StatusPedido status;
}