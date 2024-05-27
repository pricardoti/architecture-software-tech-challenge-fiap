package br.com.delivery.delivery.adapters.inbound.produto;

import br.com.delivery.delivery.adapters.inbound.produto.request.CadastrarProdutoRequest;
import br.com.delivery.delivery.adapters.inbound.produto.response.CadastrarProdutoResponse;
import br.com.delivery.delivery.application.domain.enums.CategoriaProduto;
import br.com.delivery.delivery.application.domain.produto.Produto;
import br.com.delivery.delivery.application.ports.inbound.produto.CadastrarProdutoInboundPort;
import br.com.delivery.delivery.application.ports.inbound.produto.ConsultarProdutoInboundPort;
import br.com.delivery.delivery.application.ports.inbound.produto.ConsultarProdutoPorIdInboundPort;
import br.com.delivery.delivery.application.ports.inbound.produto.EditarProdutoInboundPort;
import br.com.delivery.delivery.application.ports.inbound.produto.ExcluirProdutoInboundPort;
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
import static org.springframework.http.HttpStatus.NO_CONTENT;
import static org.springframework.http.HttpStatus.OK;
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
    @ResponseStatus(NO_CONTENT)
    public ResponseEntity<Void> atualizarCadastro(
            @PathVariable("codigoProduto") String codigoProduto,
            @RequestBody CadastrarProdutoRequest cadastrarProdutoRequest
    ) {
        var produto = cadastrarProdutoRequest.toDomain(UUID.fromString(codigoProduto));
        editarProdutoInboundPort.editar(produto);
        return ResponseEntity
                .status(NO_CONTENT)
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
