package br.com.fiap.delivery.infrastructure.api.pedidos.dtos;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

import static lombok.AccessLevel.PRIVATE;

@Getter
@RequiredArgsConstructor(staticName = "from", access = PRIVATE)
public class CadastrarPedidoResponse {

    @NonNull
    private String codigoPedido;

    public static CadastrarPedidoResponse createByCodigoPedido(UUID codigoPedido) {
        return CadastrarPedidoResponse.from(codigoPedido.toString());
    }
}