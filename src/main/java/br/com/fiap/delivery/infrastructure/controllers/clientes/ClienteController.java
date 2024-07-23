package br.com.fiap.delivery.infrastructure.controllers.clientes;

import br.com.fiap.delivery.application.exception.CadastroUsuarioException;
import br.com.fiap.delivery.application.usecases.clientes.CadastrarClienteUseCase;
import br.com.fiap.delivery.application.usecases.clientes.ConsultarClientePorCpfUseCase;
import br.com.fiap.delivery.application.usecases.clientes.ConsultarClientesUseCase;
import br.com.fiap.delivery.application.usecases.clientes.AtualizarClienteUseCase;
import br.com.fiap.delivery.application.usecases.clientes.ExcluirClienteUseCase;
import br.com.fiap.delivery.domain.cliente.Cliente;
import br.com.fiap.delivery.infrastructure.controllers.clientes.dtos.AtualizarClienteRequest;
import br.com.fiap.delivery.infrastructure.controllers.clientes.dtos.CadastrarClienteRequest;
import br.com.fiap.delivery.infrastructure.controllers.clientes.dtos.CadastrarClienteResponse;
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

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

import static java.util.Objects.nonNull;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/clientes")
public class ClienteController {

    private final CadastrarClienteUseCase<CadastrarClienteResponse> cadastrarClienteUseCase;
    private final ConsultarClientesUseCase consultarClienteUseCase;
    private final ConsultarClientePorCpfUseCase consultarClientePorCpfUseCase;
    private final AtualizarClienteUseCase atualizarClienteUseCase;
    private final ExcluirClienteUseCase excluirClienteUseCase;

    @PostMapping(
            consumes = APPLICATION_JSON_VALUE,
            produces = APPLICATION_JSON_VALUE
    )
    @ResponseStatus(CREATED)
    public ResponseEntity<CadastrarClienteResponse> cadastrar(@RequestBody @Valid CadastrarClienteRequest cadastrarClienteRequest) throws CadastroUsuarioException {
        var cliente = cadastrarClienteRequest.toDomain();
        var clienteCadastrado = cadastrarClienteUseCase.executar(cliente);
        return ResponseEntity.status(CREATED)
                .body(clienteCadastrado);
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
        var cliente = atualizarClienteRequest.toDomain(UUID.fromString(codigoCliente));
        atualizarClienteUseCase.executar(cliente);
        return ResponseEntity
                .status(OK)
                .build();
    }

    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<Collection<Cliente>> consultarClientes(@RequestParam(value = "cpf", required = false) String cpf) {
        List<Cliente> clientes = new ArrayList<>();

        if (nonNull(cpf)) {
            var cliente = consultarClientePorCpfUseCase.executar(cpf);
            clientes.add(cliente);
        }

        var clientesCadastrados = consultarClienteUseCase.executar();
        clientes.addAll(clientesCadastrados);

        return ResponseEntity
                .status(OK)
                .body(clientes);
    }

    @DeleteMapping(path = "/{codigoCliente}")
    public void excluirCadastro(@PathVariable("codigoCliente") String codigoCliente) {
        excluirClienteUseCase.executar(UUID.fromString(codigoCliente));
    }
}
