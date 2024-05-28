package br.com.delivery.delivery.adapters.inbound.pedido.request;

import br.com.delivery.delivery.application.domain.enums.StatusPedido;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AtualizarPedidoRequest {

    @NotNull
    private StatusPedido status;
}
