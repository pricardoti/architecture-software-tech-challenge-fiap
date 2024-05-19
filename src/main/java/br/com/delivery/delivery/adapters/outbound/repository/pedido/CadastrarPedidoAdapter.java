package br.com.delivery.delivery.adapters.outbound.repository.pedido;

import br.com.delivery.delivery.application.domain.pedido.Pedido;
import br.com.delivery.delivery.application.ports.outbound.pedido.SalvarPedidoPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CadastrarPedidoAdapter implements SalvarPedidoPort {

    private final PedidoRepository pedidoRepository;

    @Override
    public Pedido salvar(Pedido pedido) {
        pedidoRepository.save(PedidoEntity.from(pedido));
        return pedido;
    }
}
