package br.com.delivery.delivery.application.usecases.pedido;

import br.com.delivery.delivery.application.domain.pedido.Pedido;
import br.com.delivery.delivery.application.ports.inbound.pedido.CadastrarPedidoInboundPort;
import br.com.delivery.delivery.application.ports.outbound.pedido.CadastrarPedidoOutboundPort;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CadastrarPedidoInboundUseCase implements CadastrarPedidoInboundPort {

    private final CadastrarPedidoOutboundPort cadastrarPedidoOutboundPort;

    @Override
    public Pedido cadastrar(Pedido pedido) {
        return cadastrarPedidoOutboundPort.salvar(pedido);
    }
}
