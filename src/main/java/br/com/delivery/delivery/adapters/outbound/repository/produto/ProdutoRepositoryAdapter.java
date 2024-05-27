package br.com.delivery.delivery.adapters.outbound.repository.produto;

import br.com.delivery.delivery.application.domain.enums.CategoriaProduto;
import br.com.delivery.delivery.application.domain.produto.Produto;
import br.com.delivery.delivery.application.ports.outbound.produto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class ProdutoRepositoryAdapter implements CadastrarProdutoOutboundPort, EditarProdutoOutboundPort, ConsultarProdutoPorIdOutboundPort, ConsultarProdutoOutboundPort, ExcluirProdutoOutboundPort {

    private final ProdutoRepository produtoRepository;

    @Override
    public Produto cadastrar(Produto produto) {
        var produtoEntity = produtoRepository.save(ProdutoEntity.from(produto));
        return produtoEntity.toDomain();
    }

    @Override
    public Produto editar(Produto produto) {
        var produtoEntity = produtoRepository.save(ProdutoEntity.from(produto));
        return produtoEntity.toDomain();
    }

    @Override
    public Produto consultar(UUID codigoProduto) {
        var produtoEntity = produtoRepository.findById(codigoProduto);
        return produtoEntity
                .orElseThrow(IllegalArgumentException::new) // TODO: create custom exception with controller advice
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
}
