package br.com.delivery.delivery.adapters.inbound.pedido.response;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor(staticName = "from")
public class CadastrarPedidoResponse {

    private @NonNull String idPedido;
}
