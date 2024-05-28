package br.com.delivery.delivery.application.usecases.produto;

import br.com.delivery.delivery.application.domain.produto.Produto;
import br.com.delivery.delivery.application.ports.inbound.produto.ConsultarProdutoPorIdInboundPort;
import br.com.delivery.delivery.application.ports.outbound.produto.ConsultarProdutoPorIdOutboundPort;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@RequiredArgsConstructor
public class ConsultarProdutoPorCodigoInboundUseCase implements ConsultarProdutoPorIdInboundPort {

    private final ConsultarProdutoPorIdOutboundPort consultarProdutoPorIdOutboundPort;

    @Override
    public Produto consultar(UUID codigoProduto) {
        return consultarProdutoPorIdOutboundPort.consultar(codigoProduto);
    }
}
