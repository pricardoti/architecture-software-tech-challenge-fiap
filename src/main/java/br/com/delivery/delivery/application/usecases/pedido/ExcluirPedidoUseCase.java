package br.com.delivery.delivery.application.usecases.pedido;

import br.com.delivery.delivery.application.ports.inbound.cliente.ExcluirClientePort;
import br.com.delivery.delivery.application.ports.inbound.pedido.ExcluirPedidoPort;

import java.util.UUID;

public class ExcluirPedidoUseCase implements ExcluirPedidoPort {
    @Override
    public void excluir(UUID idPedido) {

    }
}
