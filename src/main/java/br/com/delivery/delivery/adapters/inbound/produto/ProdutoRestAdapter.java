package br.com.delivery.delivery.adapters.inbound.produto;

import br.com.delivery.delivery.adapters.inbound.produto.request.CadastrarProdutoRequest;
import br.com.delivery.delivery.adapters.inbound.produto.response.CadastrarProdutoResponse;
import br.com.delivery.delivery.application.domain.enums.CategoriaProduto;
import br.com.delivery.delivery.application.domain.produto.Produto;
import br.com.delivery.delivery.application.ports.inbound.produto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Objects;
import java.util.UUID;

import static org.springframework.http.HttpStatus.*;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/produtos")
public class ProdutoRestAdapter {

    private final CadastrarProdutoInboundPort cadastrarProdutoInboundPort;
    private final EditarProdutoInboundPort editarProdutoInboundPort;
    private final ConsultarProdutoPorIdInboundPort consultarProdutoPorIdInboundPort;
    private final ConsultarProdutoInboundPort consultarProdutosInboundPort;
    private final ExcluirProdutoInboundPort excluirProdutoInboundPort;

    @PostMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(CREATED)
    public ResponseEntity<CadastrarProdutoResponse> cadastrar(@RequestBody CadastrarProdutoRequest cadastrarProdutoRequest) {
        var produto = cadastrarProdutoInboundPort.cadastrar(cadastrarProdutoRequest.toDomain());
        return ResponseEntity
                .ofNullable(CadastrarProdutoResponse.from(produto.codigo()));
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
    ) {
        var produto = consultarProdutoPorIdInboundPort.consultar(UUID.fromString(codigoProduto));

        if (Objects.isNull(produto)) {
            return ResponseEntity
                    .status(NO_CONTENT)
                    .build();
        }

        editarProdutoInboundPort.editar(cadastrarProdutoRequest.toDomain(UUID.fromString(codigoProduto)));
        return ResponseEntity
                .status(OK)
                .build();
    }

    @GetMapping(path = "/{codigoProduto}", produces = APPLICATION_JSON_VALUE)
    public Produto consultarProdutoPorId(@PathVariable("codigoProduto") String codigoProduto) {
        return consultarProdutoPorIdInboundPort.consultar(UUID.fromString(codigoProduto));
    }

    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<Collection<Produto>> consultarProdutos(@RequestParam("categoria") CategoriaProduto categoria) {
        var produtos = consultarProdutosInboundPort.consultar(categoria);
        return ResponseEntity
                .status(OK)
                .body(produtos);
    }

    @DeleteMapping(path = "/{codigoProduto}")
    public void excluirCadastro(@PathVariable("codigoProduto") String codigoProduto) {
        excluirProdutoInboundPort.excluir(UUID.fromString(codigoProduto));
    }
}
