package br.com.delivery.delivery.application.usecases.produto;

import br.com.delivery.delivery.application.domain.produto.Produto;
import br.com.delivery.delivery.application.ports.inbound.produto.CadastrarProdutoPort;
import br.com.delivery.delivery.application.ports.outbound.produto.SalvarProdutoPort;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CadastrarProdutoUseCase implements CadastrarProdutoPort {

    private final SalvarProdutoPort salvarProdutoPort;

    @Override
    public Produto salvar(Produto produto) {
        return salvarProdutoPort.salvar(null);
    }
}
