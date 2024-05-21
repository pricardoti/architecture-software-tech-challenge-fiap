package br.com.delivery.delivery.adapters.inbound.cliente;

import br.com.delivery.delivery.adapters.inbound.cliente.request.CadastrarClienteRequest;
import br.com.delivery.delivery.adapters.inbound.cliente.response.CadastrarClienteResponse;
import br.com.delivery.delivery.application.domain.cliente.Cliente;
import br.com.delivery.delivery.application.ports.inbound.cliente.CadastrarClientePort;
import br.com.delivery.delivery.application.ports.inbound.cliente.ConsultarClientePort;
import br.com.delivery.delivery.application.ports.inbound.cliente.EditarClientePort;
import br.com.delivery.delivery.application.ports.inbound.cliente.ExcluirClientePort;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NO_CONTENT;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/clientes")
public class ClienteRestAdapter {

    private final CadastrarClientePort cadastrarClientePort;
    private final EditarClientePort editarClientePort;
    private final ConsultarClientePort consultarClientePort;
    private final ExcluirClientePort excluirClientePort;

    @PostMapping(
            consumes = APPLICATION_JSON_VALUE,
            produces = APPLICATION_JSON_VALUE
    )
    @ResponseStatus(CREATED)
    public ResponseEntity<CadastrarClienteResponse> cadastrar(@RequestBody CadastrarClienteRequest cadastrarClienteRequest) {
        var cliente = cadastrarClientePort.salvar(null);
        var response = CadastrarClienteResponse.from(UUID.randomUUID().toString());
        return ResponseEntity
                .ofNullable(response);
    }

    @PutMapping(
            path = "/{idCliente}",
            consumes = APPLICATION_JSON_VALUE,
            produces = APPLICATION_JSON_VALUE
    )
    @ResponseStatus(NO_CONTENT)
    public ResponseEntity<Void> atualizarCadastro(
            @PathVariable("idCliente") String idCliente,
            @RequestBody CadastrarClienteRequest cadastrarClienteRequest
    ) {
        editarClientePort.editar(null);
        return ResponseEntity
                .status(NO_CONTENT)
                .build();
    }

    @GetMapping(
            path = "/{idCliente}",
            consumes = APPLICATION_JSON_VALUE,
            produces = APPLICATION_JSON_VALUE
    )
    public Cliente consultarPorId(@PathVariable("idCliente") String idCliente) {
        return consultarClientePort.consultar(null);
    }

    @DeleteMapping(
            path = "/{idCliente}",
            consumes = APPLICATION_JSON_VALUE
    )
    public void excluirCadastro(@PathVariable("idCliente") String idCliente) {
        excluirClientePort.excluir(UUID.fromString(idCliente));
    }
}
