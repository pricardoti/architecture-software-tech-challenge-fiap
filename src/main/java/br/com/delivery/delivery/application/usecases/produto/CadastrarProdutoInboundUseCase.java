package br.com.delivery.delivery.application.usecases.produto;

import br.com.delivery.delivery.application.domain.produto.Produto;
import br.com.delivery.delivery.application.ports.inbound.produto.CadastrarProdutoInboundPort;
import br.com.delivery.delivery.application.ports.outbound.produto.SalvarProdutoOutboundPort;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CadastrarProdutoInboundUseCase implements CadastrarProdutoInboundPort {

    private final SalvarProdutoOutboundPort salvarProdutoOutboundPort;

    @Override
    public Produto cadastrar(Produto produto) {
        return salvarProdutoOutboundPort.cadastrar(produto);
    }
}
