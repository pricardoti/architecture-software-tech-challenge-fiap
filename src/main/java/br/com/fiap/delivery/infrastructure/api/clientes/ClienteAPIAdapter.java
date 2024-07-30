package br.com.fiap.delivery.infrastructure.api.clientes;

import br.com.fiap.delivery.application.controllers.ClienteController;
import br.com.fiap.delivery.application.exception.CadastroUsuarioException;
import br.com.fiap.delivery.infrastructure.api.clientes.dtos.AtualizarClienteRequest;
import br.com.fiap.delivery.infrastructure.api.clientes.dtos.CadastrarClienteRequest;
import br.com.fiap.delivery.infrastructure.api.clientes.dtos.CadastrarClienteResponse;
import br.com.fiap.delivery.infrastructure.api.clientes.dtos.ConsultarClienteResponse;
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
import java.util.UUID;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NO_CONTENT;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/v1/clientes")
@RequiredArgsConstructor
public class ClienteAPIAdapter {

    private final ClienteController<CadastrarClienteResponse, ConsultarClienteResponse> clienteController;

    @PostMapping(
            consumes = APPLICATION_JSON_VALUE,
            produces = APPLICATION_JSON_VALUE
    )
    @ResponseStatus(CREATED)
    public ResponseEntity<CadastrarClienteResponse> cadastrar(@RequestBody @Valid CadastrarClienteRequest cadastrarClienteRequest) throws CadastroUsuarioException {
        var clienteCadastrado = clienteController.cadastrar(cadastrarClienteRequest.toDomain());
        return ResponseEntity.status(CREATED)
                .body(clienteCadastrado);
    }

    @GetMapping(produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(OK)
    public ResponseEntity<Collection<ConsultarClienteResponse>> consultarClientes(@RequestParam(value = "cpf", required = false) String cpf) {
        var clientes = clienteController.consultar(cpf);
        return ResponseEntity.ok(clientes);
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
    ) throws CadastroUsuarioException {
        clienteController.atualizar(atualizarClienteRequest.toDomain(UUID.fromString(codigoCliente)));
        return ResponseEntity
                .status(OK)
                .build();
    }

    @DeleteMapping(path = "/{codigoCliente}")
    @ResponseStatus(NO_CONTENT)
    public ResponseEntity.HeadersBuilder<?> excluirCadastro(@PathVariable("codigoCliente") String codigoCliente) throws CadastroUsuarioException {
        clienteController.excluir(UUID.fromString(codigoCliente));
        return ResponseEntity.noContent();
    }
}
