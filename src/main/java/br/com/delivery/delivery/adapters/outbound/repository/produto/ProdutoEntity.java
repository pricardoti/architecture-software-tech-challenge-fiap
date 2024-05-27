package br.com.delivery.delivery.adapters.outbound.repository.produto;

import br.com.delivery.delivery.application.domain.enums.CategoriaProduto;
import br.com.delivery.delivery.application.domain.produto.Produto;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@Entity
@Accessors(fluent = true)
@Table(name = "produtos")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class ProdutoEntity {

    @Id
    @EqualsAndHashCode.Include
    private UUID codigo;
    private String nome;
    private String descricao;
    private String imagemUrl;
    private BigDecimal preco;
    private CategoriaProduto categoria;

    public static ProdutoEntity from(Produto produto) {
        return new ProdutoEntity(
                produto.codigo(),
                produto.nome(),
                produto.descricao(),
                produto.imagemUrl(),
                produto.preco(),
                produto.categoria()
        );
    }

    public Produto convertToProduto() {
        return new Produto(
                codigo,
                nome,
                descricao,
                preco,
                categoria,
                imagemUrl
        );
    }
}