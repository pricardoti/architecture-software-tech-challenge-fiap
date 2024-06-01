package br.com.delivery.delivery.adapters.inbound.cliente;

import br.com.delivery.delivery.adapters.inbound.cliente.request.AtualizarClienteRequest;
import br.com.delivery.delivery.adapters.inbound.cliente.request.CadastrarClienteRequest;
import br.com.delivery.delivery.adapters.inbound.cliente.response.CadastrarClienteResponse;
import br.com.delivery.delivery.application.domain.cliente.Cliente;
import br.com.delivery.delivery.application.ports.inbound.cliente.CadastrarClienteInboundPort;
import br.com.delivery.delivery.application.ports.inbound.cliente.ConsultarClienteInboundPort;
import br.com.delivery.delivery.application.ports.inbound.cliente.EditarClienteInboundPort;
import br.com.delivery.delivery.application.ports.inbound.cliente.ExcluirClienteInboundPort;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

import static java.util.Objects.nonNull;
import static org.springframework.http.HttpStatus.*;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/clientes")
public class ClienteRestAdapter {

    private final CadastrarClienteInboundPort cadastrarClienteInboundPort;
    private final EditarClienteInboundPort editarClienteInboundPort;
    private final ConsultarClienteInboundPort consultarClienteInboundPort;
    private final ExcluirClienteInboundPort excluirClienteInboundPort;

    @PostMapping(
            consumes = APPLICATION_JSON_VALUE,
            produces = APPLICATION_JSON_VALUE
    )
    @ResponseStatus(CREATED)
    public ResponseEntity<CadastrarClienteResponse> cadastrar(
            @RequestBody @Valid CadastrarClienteRequest cadastrarClienteRequest
    ) {
        var cliente = cadastrarClienteInboundPort.cadastrar(cadastrarClienteRequest.toDomain());
        return ResponseEntity.status(CREATED).body(CadastrarClienteResponse.from(cliente.codigo()));
    }

    @PutMapping(
            path = "/{codigoCliente}",
            consumes = APPLICATION_JSON_VALUE,
            produces = APPLICATION_JSON_VALUE
    )
    @ResponseStatus(OK)
    public ResponseEntity<Void> atualizarCadastro(
            @PathVariable("codigoCliente") String codigoCliente,
            @RequestBody @Valid AtualizarClienteRequest atualizarClienteRequest
    ) {
        var cliente = atualizarClienteRequest.toDomain(UUID.fromString(codigoCliente));
        editarClienteInboundPort.editar(cliente);
        return ResponseEntity
                .status(OK)
                .build();
    }

    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<Collection<Cliente>> consultarClientes(@RequestParam(value = "cpf", required = false) String cpf) {
        if (nonNull(cpf)) {
            var cliente = consultarClienteInboundPort.consultarPorCpf(cpf);
            return validacaoClientePorCpfNaoEncontrado(cliente);
        }

        return ResponseEntity
                .status(OK)
                .body(consultarClienteInboundPort.consultarClientes());
    }

    private static ResponseEntity<Collection<Cliente>> validacaoClientePorCpfNaoEncontrado(Cliente cliente) {
        if (Objects.isNull(cliente)) return ResponseEntity.status(NOT_FOUND).body(Collections.emptyList());

        return ResponseEntity
                .status(OK)
                .body(List.of(cliente));
    }

    @DeleteMapping(path = "/{codigoCliente}", consumes = APPLICATION_JSON_VALUE)
    public void excluirCadastro(@PathVariable("codigoCliente") String codigoCliente) {
        excluirClienteInboundPort.excluir(UUID.fromString(codigoCliente));
    }
}
