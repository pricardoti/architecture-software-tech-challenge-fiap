package br.com.fiap.delivery.infrastructure.api.produtos.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.UUID;

@Getter
@AllArgsConstructor
public class CadastrarProdutoResponse {

    private String codigoProduto;

    public static CadastrarProdutoResponse from(UUID codigoProduto) {
        return new CadastrarProdutoResponse(codigoProduto.toString());
    }
}