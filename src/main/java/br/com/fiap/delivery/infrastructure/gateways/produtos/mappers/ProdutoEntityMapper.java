package br.com.fiap.delivery.infrastructure.gateways.produtos.mappers;

import br.com.fiap.delivery.domain.produto.Produto;
import br.com.fiap.delivery.infrastructure.persistence.produtos.entities.ProdutoEntity;
import lombok.experimental.UtilityClass;

@UtilityClass
public class ProdutoEntityMapper {

    public static ProdutoEntity toEntity(Produto produto) {
        return new ProdutoEntity(
                produto.getCodigo(),
                produto.getNome(),
                produto.getDescricao(),
                produto.getImagemUrl(),
                produto.getPreco(),
                produto.getCategoria()
        );
    }

    public static  Produto toDomain(ProdutoEntity produto) {
        return new Produto(
                produto.codigo(),
                produto.nome(),
                produto.descricao(),
                produto.preco(),
                produto.categoria(),
                produto.imagemUrl()
        );
    }
}
