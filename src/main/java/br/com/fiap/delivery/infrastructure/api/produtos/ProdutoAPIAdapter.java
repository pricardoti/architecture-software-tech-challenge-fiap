package br.com.fiap.delivery.infrastructure.api.produtos;

import br.com.fiap.delivery.application.controllers.ProdutoController;
import br.com.fiap.delivery.application.exception.ProdutoException;
import br.com.fiap.delivery.domain.produto.CategoriaProduto;
import br.com.fiap.delivery.infrastructure.api.produtos.dtos.CadastrarProdutoRequest;
import br.com.fiap.delivery.infrastructure.api.produtos.dtos.CadastrarProdutoResponse;
import br.com.fiap.delivery.infrastructure.api.produtos.dtos.ConsultarProdutoResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.UUID;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/v1/produtos")
@RequiredArgsConstructor
public class ProdutoAPIAdapter {

    private final ProdutoController<CadastrarProdutoResponse, ConsultarProdutoResponse> produtoController;

    @PostMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(CREATED)
    public ResponseEntity<CadastrarProdutoResponse> cadastrar(@RequestBody CadastrarProdutoRequest cadastrarProdutoRequest) throws ProdutoException {
        var produto = produtoController.cadastrar(cadastrarProdutoRequest.toDomain());
        return ResponseEntity
                .status(CREATED)
                .body(produto);
    }

    @PutMapping(
            path = "/{codigoProduto}",
            consumes = APPLICATION_JSON_VALUE,
            produces = APPLICATION_JSON_VALUE
    )
    @ResponseStatus(OK)
    public ResponseEntity<Void> atualizarCadastro(
            @PathVariable("codigoProduto") String codigoProduto,
            @RequestBody CadastrarProdutoRequest cadastrarProdutoRequest
    ) throws ProdutoException {
        produtoController.editar(cadastrarProdutoRequest.toDomain(UUID.fromString(codigoProduto)));
        return ResponseEntity
                .status(OK)
                .build();
    }

    @GetMapping(path = "/{codigoProduto}", produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(OK)
    public ResponseEntity<ConsultarProdutoResponse> consultarProdutoPorId(@PathVariable("codigoProduto") String codigoProduto) {
        var produto = produtoController.consultarPorCodigo(UUID.fromString(codigoProduto));
        return ResponseEntity.ok(produto);
    }

    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<Collection<ConsultarProdutoResponse>> consultarProdutos(@RequestParam("categoria") CategoriaProduto categoria) {
        var produtos = produtoController.consultarPorCategoria(categoria);
        return ResponseEntity.ok(produtos);
    }

    @DeleteMapping(path = "/{codigoProduto}")
    public ResponseEntity.HeadersBuilder<?> excluirCadastro(@PathVariable("codigoProduto") String codigoProduto) throws ProdutoException {
        produtoController.excluir(UUID.fromString(codigoProduto));
        return ResponseEntity.noContent();
    }
}
