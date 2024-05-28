package br.com.delivery.delivery.adapters.outbound.repository.produto;

import br.com.delivery.delivery.application.domain.enums.CategoriaProduto;
import br.com.delivery.delivery.application.domain.produto.Produto;
import br.com.delivery.delivery.application.ports.outbound.produto.CadastrarProdutoOutboundPort;
import br.com.delivery.delivery.application.ports.outbound.produto.ConsultarProdutoOutboundPort;
import br.com.delivery.delivery.application.ports.outbound.produto.ConsultarProdutoPorIdOutboundPort;
import br.com.delivery.delivery.application.ports.outbound.produto.EditarProdutoOutboundPort;
import br.com.delivery.delivery.application.ports.outbound.produto.ExcluirProdutoOutboundPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class ProdutoRepositoryAdapter implements CadastrarProdutoOutboundPort,
        EditarProdutoOutboundPort,
        ConsultarProdutoPorIdOutboundPort,
        ConsultarProdutoOutboundPort,
        ExcluirProdutoOutboundPort {

    private final ProdutoRepository produtoRepository;

    @Override
    public Produto cadastrar(Produto produto) {
        return salvarProduto(produto);
    }

    @Override
    public Produto editar(Produto produto) {
        return salvarProduto(produto);
    }

    @Override
    public Produto consultar(UUID codigoProduto) {
        var produtoEntity = produtoRepository.findById(codigoProduto);
        return produtoEntity
                .orElseThrow(() -> new IllegalArgumentException("produto nao encontrado"))
                .toDomain();
    }

    @Override
    public Collection<Produto> consultar(CategoriaProduto categoria) {
        return produtoRepository.findByCategoria(categoria)
                .stream()
                .map(ProdutoEntity::toDomain)
                .toList();
    }

    @Override
    public void excluir(UUID codigoProduto) {
        produtoRepository.deleteById(codigoProduto);
    }

    private Produto salvarProduto(Produto produto) {
        return produtoRepository
                .save(ProdutoEntity.from(produto))
                .toDomain();
    }
}
