package br.com.fiap.delivery.domain.produto;

import java.math.BigDecimal;
import java.util.UUID;

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

    public Produto(UUID codigo, String nome, String descricao, BigDecimal preco, CategoriaProduto categoria, String imagemUrl) {
        this.codigo = codigo;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.categoria = categoria;
        this.imagemUrl = imagemUrl;
    }

    public UUID getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public CategoriaProduto getCategoria() {
        return categoria;
    }

    public String getImagemUrl() {
        return imagemUrl;
    }
}