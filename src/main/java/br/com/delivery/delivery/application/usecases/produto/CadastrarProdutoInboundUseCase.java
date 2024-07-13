package br.com.delivery.delivery.application.usecases.produto;

import br.com.delivery.delivery.application.domain.produto.Produto;
import br.com.delivery.delivery.application.ports.inbound.produto.CadastrarProdutoInboundPort;
import br.com.delivery.delivery.application.ports.outbound.produto.CadastrarProdutoOutboundPort;

public class CadastrarProdutoInboundUseCase implements CadastrarProdutoInboundPort {

    private final CadastrarProdutoOutboundPort cadastrarProdutoOutboundPort;

    public CadastrarProdutoInboundUseCase(CadastrarProdutoOutboundPort cadastrarProdutoOutboundPort) {
        this.cadastrarProdutoOutboundPort = cadastrarProdutoOutboundPort;
    }

    @Override
    public Produto cadastrar(Produto produto) {
        return cadastrarProdutoOutboundPort.cadastrar(produto);
    }
}
