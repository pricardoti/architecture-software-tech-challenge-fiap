package br.com.delivery.delivery.adapters.outbound.repository.pedido;

import br.com.delivery.delivery.application.domain.pedido.Pedido;
import br.com.delivery.delivery.application.ports.outbound.pedido.SalvarPedidoOutboundPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CadastrarPedidoOutboundAdapter implements SalvarPedidoOutboundPort {

    private final PedidoRepository pedidoRepository;

    @Override
    public Pedido salvar(Pedido pedido) {
        return null;
    }
}
