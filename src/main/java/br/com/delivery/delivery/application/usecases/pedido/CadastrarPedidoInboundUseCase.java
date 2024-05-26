package br.com.delivery.delivery.application.usecases.pedido;

import br.com.delivery.delivery.application.domain.pedido.Pedido;
import br.com.delivery.delivery.application.ports.inbound.pedido.CadastrarPedidoInboundPort;
import br.com.delivery.delivery.application.ports.outbound.pedido.SalvarPedidoOutboundPort;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CadastrarPedidoInboundUseCase implements CadastrarPedidoInboundPort {

    private final SalvarPedidoOutboundPort salvarPedidoOutboundPort;

    @Override
    public Pedido salvar(Pedido cliente) {
        return salvarPedidoOutboundPort.salvar(null);
    }
}
