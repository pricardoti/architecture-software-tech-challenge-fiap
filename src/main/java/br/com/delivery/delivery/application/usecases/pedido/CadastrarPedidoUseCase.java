package br.com.delivery.delivery.application.usecases.pedido;

import br.com.delivery.delivery.application.domain.pedido.Pedido;
import br.com.delivery.delivery.application.ports.inbound.pedido.CadastrarPedidoPort;
import br.com.delivery.delivery.application.ports.outbound.pedido.SalvarPedidoPort;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CadastrarPedidoUseCase implements CadastrarPedidoPort {

    private final SalvarPedidoPort salvarPedidoPort;

    @Override
    public Pedido salvar(Pedido cliente) {
        return salvarPedidoPort.salvar(null);
    }
}
