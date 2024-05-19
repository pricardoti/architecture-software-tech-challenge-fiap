package br.com.delivery.delivery.adapters.inbound.produto;

import br.com.delivery.delivery.adapters.inbound.produto.request.CadastrarProdutoRequest;
import br.com.delivery.delivery.adapters.inbound.produto.response.CadastrarProdutoResponse;
import br.com.delivery.delivery.application.domain.produto.Produto;
import br.com.delivery.delivery.application.ports.inbound.cliente.CadastrarProdutoPort;
import br.com.delivery.delivery.application.ports.inbound.produto.ConsultarProdutoPort;
import br.com.delivery.delivery.application.ports.inbound.produto.EditarProdutoPort;
import br.com.delivery.delivery.application.ports.inbound.produto.ExcluirProdutoPort;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NO_CONTENT;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RequiredArgsConstructor
@RestController
@RequestMapping("/produtos")
public class ProdutoRestAdapter {

    private final CadastrarProdutoPort cadastrarProdutoPort;
    private final EditarProdutoPort editarProdutoPort;
    private final ConsultarProdutoPort consultarProdutoPort;
    private final ExcluirProdutoPort excluirProdutoPort;

    @PostMapping(
            consumes = APPLICATION_JSON_VALUE,
            produces = APPLICATION_JSON_VALUE
    )
    @ResponseStatus(CREATED)
    public ResponseEntity<CadastrarProdutoResponse> cadastrar(@RequestBody CadastrarProdutoRequest cadastrarProdutoRequest) {
        var produto = cadastrarProdutoPort.salvar(null);
        var response = CadastrarProdutoResponse.from(UUID.randomUUID().toString());
        return ResponseEntity
                .ofNullable(response);
    }

    @PutMapping(
            path = "/{idProduto}",
            consumes = APPLICATION_JSON_VALUE,
            produces = APPLICATION_JSON_VALUE
    )
    @ResponseStatus(NO_CONTENT)
    public ResponseEntity<Void> atualizarCadastro(
            @PathVariable("idProduto") String idProduto,
            @RequestBody CadastrarProdutoRequest cadastrarProdutoRequest
    ) {
        editarProdutoPort.editar(null);
        return ResponseEntity
                .status(NO_CONTENT)
                .build();
    }

    @GetMapping(
            path = "/{idProduto}",
            consumes = APPLICATION_JSON_VALUE,
            produces = APPLICATION_JSON_VALUE
    )
    public Produto consultarPorId(@PathVariable("idProduto") String idProduto) {
        return consultarProdutoPort.consultar(null);
    }

    @DeleteMapping(
            path = "/{idProduto}",
            consumes = APPLICATION_JSON_VALUE
    )
    public void excluirCadastro(@PathVariable("idProduto") String idProduto) {
        excluirProdutoPort.excluir(UUID.fromString(idProduto));
    }
}
