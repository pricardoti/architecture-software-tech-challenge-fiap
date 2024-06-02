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
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

import static java.util.Objects.nonNull;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NO_CONTENT;
import static org.springframework.http.HttpStatus.OK;
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
        if (Objects.isNull(cliente)) return ResponseEntity.status(NO_CONTENT).body(Collections.emptyList());

        return ResponseEntity
                .status(OK)
                .body(List.of(cliente));
    }

    @DeleteMapping(path = "/{codigoCliente}", consumes = APPLICATION_JSON_VALUE)
    public void excluirCadastro(@PathVariable("codigoCliente") String codigoCliente) {
        excluirClienteInboundPort.excluir(UUID.fromString(codigoCliente));
    }
}
