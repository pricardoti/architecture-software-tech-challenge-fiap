package br.com.delivery.delivery.adapters.inbound.produto;

import br.com.delivery.delivery.adapters.inbound.produto.request.CadastrarProdutoRequest;
import br.com.delivery.delivery.adapters.inbound.produto.response.CadastrarProdutoResponse;
import br.com.delivery.delivery.application.domain.produto.Produto;
import br.com.delivery.delivery.application.ports.inbound.produto.CadastrarProdutoInboundPort;
import br.com.delivery.delivery.application.ports.inbound.produto.ConsultarProdutoInboundPort;
import br.com.delivery.delivery.application.ports.inbound.produto.EditarProdutoInboundPort;
import br.com.delivery.delivery.application.ports.inbound.produto.ExcluirProdutoInboundPort;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NO_CONTENT;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/produtos")
public class ProdutoRestAdapter {

    private final CadastrarProdutoInboundPort cadastrarProdutoInboundPort;
    private final EditarProdutoInboundPort editarProdutoInboundPort;
    private final ConsultarProdutoInboundPort consultarProdutoInboundPort;
    private final ExcluirProdutoInboundPort excluirProdutoInboundPort;

    @PostMapping(
            consumes = APPLICATION_JSON_VALUE,
            produces = APPLICATION_JSON_VALUE
    )
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

    @GetMapping(
            path = "/{codigoProduto}",
            produces = APPLICATION_JSON_VALUE
    )
    public Produto consultarPorId(@PathVariable("codigoProduto") String codigoProduto) {
        return consultarProdutoInboundPort.consultar(UUID.fromString(codigoProduto));
    }

    @DeleteMapping(path = "/{codigoProduto}")
    public void excluirCadastro(@PathVariable("codigoProduto") String codigoProduto) {
        excluirProdutoInboundPort.excluir(UUID.fromString(codigoProduto));
    }
}
