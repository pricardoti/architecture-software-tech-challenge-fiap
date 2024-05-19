package br.com.delivery.delivery.adapters.inbound.pedido.request;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CadastrarPedidoRequest {

    @NotNull
    private String nomeEstabelecimento;
}
