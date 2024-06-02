package br.com.delivery.delivery.application.domain.produto;

import br.com.delivery.delivery.application.domain.enums.CategoriaProduto;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.math.BigDecimal;
import java.util.UUID;

@Getter(onMethod = @__(@JsonProperty))
@Setter(onMethod = @__(@JsonProperty))
@Accessors(fluent = true)
@NoArgsConstructor
@AllArgsConstructor
public class Produto {
    private UUID codigo;
    private String nome;
    private String descricao;
    private BigDecimal preco;
    private CategoriaProduto categoria;
    private String imagemUrl;

    public Produto(
            String nome,
            String descricao,
            BigDecimal preco,
            CategoriaProduto categoria,
            String imagemUrl
    ) {
        this(UUID.randomUUID(), nome, descricao, preco, categoria, imagemUrl);
    }
}