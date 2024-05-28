package br.com.delivery.delivery.adapters.outbound.repository.produto;

import br.com.delivery.delivery.application.domain.enums.CategoriaProduto;
import br.com.delivery.delivery.application.domain.produto.Produto;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Data
@Entity
@Accessors(fluent = true)
@Table(name = "produtos")
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class ProdutoEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 5693408919694958946L;

    @Id
    @EqualsAndHashCode.Include
    private UUID codigo;
    private String nome;
    private String descricao;
    private String imagemUrl;
    private BigDecimal preco;
    private CategoriaProduto categoria;

    @OneToMany(mappedBy = "produto")
    private List<PedidoProdutoEntity> pedidos;

    public ProdutoEntity(UUID codigo, String nome, String descricao, String imagemUrl, BigDecimal preco, CategoriaProduto categoria) {
        this.codigo = codigo;
        this.nome = nome;
        this.descricao = descricao;
        this.imagemUrl = imagemUrl;
        this.preco = preco;
        this.categoria = categoria;
    }

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

    public Produto toDomain() {
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