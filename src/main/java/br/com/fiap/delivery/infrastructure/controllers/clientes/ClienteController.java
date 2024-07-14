package br.com.fiap.delivery.infrastructure.controllers.clientes;

import br.com.fiap.delivery.application.usecases.clientes.CadastrarClienteUseCase;
import br.com.fiap.delivery.infrastructure.controllers.clientes.dtos.CadastrarClienteRequest;
import br.com.fiap.delivery.infrastructure.controllers.clientes.dtos.CadastrarClienteResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/clientes")
public class ClienteController {

    private final CadastrarClienteUseCase<CadastrarClienteResponse> cadastrarClienteUseCase;
    //    private final ConsultarClienteUseCase consultarClienteUseCase;
//    private final EditarClienteUseCase editarClienteUseCase;
//    private final ExcluirClienteUseCase excluirClienteUseCase;

    @PostMapping(
            consumes = APPLICATION_JSON_VALUE,
            produces = APPLICATION_JSON_VALUE
    )
    @ResponseStatus(CREATED)
    public ResponseEntity<CadastrarClienteResponse> cadastrar(@RequestBody @Valid CadastrarClienteRequest cadastrarClienteRequest) {
        var cliente = cadastrarClienteUseCase.cadastrar(cadastrarClienteRequest.toDomain());
        return ResponseEntity.status(CREATED)
                .body(cliente);
    }

//    @PutMapping(
//            path = "/{codigoCliente}",
//            consumes = APPLICATION_JSON_VALUE,
//            produces = APPLICATION_JSON_VALUE
//    )
//    @ResponseStatus(OK)
//    public ResponseEntity<Void> atualizarCadastro(
//            @PathVariable("codigoCliente") String codigoCliente,
//            @RequestBody @Valid AtualizarClienteRequest atualizarClienteRequest
//    ) {
//        var cliente = atualizarClienteRequest.toDomain(UUID.fromString(codigoCliente));
//        editarClienteUseCase.editar(cliente);
//        return ResponseEntity
//                .status(OK)
//                .build();
//    }

//    @GetMapping(produces = APPLICATION_JSON_VALUE)
//    public ResponseEntity<Collection<Cliente>> consultarClientes(@RequestParam(value = "cpf", required = false) String cpf) {
//        if (nonNull(cpf)) {
//            var cliente = consultarClienteUseCase.consultarPorCpf(cpf);
//            return validacaoClientePorCpfNaoEncontrado(cliente);
//        }
//
//        var clientes = consultarClienteInboundPort.consultarClientes();
//        return ResponseEntity
//                .status(OK)
//                .body(clientes);
//    }

//    private static ResponseEntity<Collection<Cliente>> validacaoClientePorCpfNaoEncontrado(Cliente cliente) {
//        if (Objects.isNull(cliente)) return ResponseEntity.status(NO_CONTENT).body(Collections.emptyList());
//
//        return ResponseEntity
//                .status(OK)
//                .body(List.of(cliente));
//    }

//    @DeleteMapping(path = "/{codigoCliente}", consumes = APPLICATION_JSON_VALUE)
//    public void excluirCadastro(@PathVariable("codigoCliente") String codigoCliente) {
//        excluirClienteUseCase.excluir(UUID.fromString(codigoCliente));
//    }
}
