package br.com.delivery.delivery.adapters.outbound.repository.produto;


import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;


// TODO: ajustar logica de produto
//@Data
//@Entity
//@Accessors(fluent = true)
//@Table(name = "produtos")
//@AllArgsConstructor
//@NoArgsConstructor
public class ProdutoPedidoEntity {

//    @EmbeddedId
    private ProdutoEntity produto;
    private int quantidade;
}
