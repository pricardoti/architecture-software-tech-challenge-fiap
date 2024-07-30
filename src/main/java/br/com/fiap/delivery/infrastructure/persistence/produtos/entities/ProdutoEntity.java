package br.com.fiap.delivery.infrastructure.persistence.produtos.entities;

import br.com.fiap.delivery.domain.produto.CategoriaProduto;
import br.com.fiap.delivery.domain.produto.Produto;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;

@Data
@Entity
@Accessors(fluent = true)
@Table(name = "produtos")
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class ProdutoEntity implements Serializable {

    private static final long serialVersionUID = 5693408919694958946L;

    @Id
    @EqualsAndHashCode.Include
    private UUID codigo;
    private String nome;
    private String descricao;
    private String imagemUrl;
    private BigDecimal preco;
    private CategoriaProduto categoria;

// TODO: aguardando a feature de pedidos
//    @OneToMany(mappedBy = "produto")
//    private List<PedidoProdutoEntity> pedidos;

    public ProdutoEntity(UUID codigo, String nome, String descricao, String imagemUrl, BigDecimal preco, CategoriaProduto categoria) {
        this.codigo = codigo;
        this.nome = nome;
        this.descricao = descricao;
        this.imagemUrl = imagemUrl;
        this.preco = preco;
        this.categoria = categoria;
    }
}