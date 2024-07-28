package br.com.fiap.delivery.infrastructure.gateways.produtos;

import br.com.fiap.delivery.application.gateways.ProdutoGateway;
import br.com.fiap.delivery.domain.produto.CategoriaProduto;
import br.com.fiap.delivery.domain.produto.Produto;
import br.com.fiap.delivery.infrastructure.gateways.produtos.mappers.ProdutoEntityMapper;
import br.com.fiap.delivery.infrastructure.persistence.produtos.ProdutoRepositoryJPA;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class ProdutoGatewayJPA implements ProdutoGateway {

    private final ProdutoRepositoryJPA produtoRepository;

    @Override
    public Produto cadastrar(Produto produto) {
        var produtoEntity = ProdutoEntityMapper.toEntity(produto);
        produtoRepository.save(produtoEntity);
        return ProdutoEntityMapper.toDomain(produtoEntity);
    }

    @Override
    public Optional<Produto> consultar(Produto produto) {
        var produtoEntity = produtoRepository.findByNomeAndCategoria(produto.getNome(), produto.getCategoria());

        if (produtoEntity.isEmpty())
            return Optional.empty();

        return produtoEntity.map(ProdutoEntityMapper::toDomain);
    }

    @Override
    public Collection<Produto> consultarPorCategoria(CategoriaProduto categoriaProduto) {
        var produtosEntities = produtoRepository.findByCategoria(categoriaProduto);
        return produtosEntities.stream()
                .map(ProdutoEntityMapper::toDomain)
                .toList();
    }

    @Override
    public Produto consultarPorCodigo(UUID codigoProduto) {
        var produtoEntity = produtoRepository.findById(codigoProduto);
        return produtoEntity.map(ProdutoEntityMapper::toDomain)
                .orElse(null);
    }

    @Override
    public void atualizar(Produto produto) {
        var produtoEntity = ProdutoEntityMapper.toEntity(produto);
        produtoRepository.save(produtoEntity);
    }

    @Override
    public void excluir(UUID codigoProduto) {
        produtoRepository.deleteById(codigoProduto);
    }
}
