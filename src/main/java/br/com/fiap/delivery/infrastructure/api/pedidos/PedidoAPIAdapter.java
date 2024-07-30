package br.com.fiap.delivery.infrastructure.api.pedidos;

import br.com.fiap.delivery.application.controllers.PedidoController;
import br.com.fiap.delivery.application.exception.PedidoException;
import br.com.fiap.delivery.infrastructure.api.pedidos.dtos.AtualizarPedidoRequest;
import br.com.fiap.delivery.infrastructure.api.pedidos.dtos.CadastrarPedidoRequest;
import br.com.fiap.delivery.infrastructure.api.pedidos.dtos.CadastrarPedidoResponse;
import br.com.fiap.delivery.infrastructure.api.pedidos.dtos.ConsultarPedidoResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.UUID;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/v1/pedidos")
@RequiredArgsConstructor
public class PedidoAPIAdapter {

    private final PedidoController<CadastrarPedidoResponse, ConsultarPedidoResponse> pedidoController;

    @PostMapping(
            consumes = APPLICATION_JSON_VALUE,
            produces = APPLICATION_JSON_VALUE
    )
    @ResponseStatus(CREATED)
    public ResponseEntity<CadastrarPedidoResponse> cadastrar(@RequestBody @Valid CadastrarPedidoRequest cadastrarPedidoRequest) throws PedidoException {
        var pedido = pedidoController.cadastrar(cadastrarPedidoRequest.toDomain());
        return ResponseEntity
                .status(CREATED)
                .body(pedido);
    }

    @PatchMapping(path = "/{codigoPedido}")
    @ResponseStatus(OK)
    public ResponseEntity<Void> atualizarPedido(
            @PathVariable("codigoPedido") String codigoPedido,
            @RequestBody AtualizarPedidoRequest atualizarPedidoRequest
    ) throws PedidoException {
        pedidoController.atualizar(UUID.fromString(codigoPedido), atualizarPedidoRequest.getStatus());
        return ResponseEntity
                .status(OK)
                .build();
    }

    @PostMapping(path = "/{codigoPedido}/checkout")
    @ResponseStatus(OK)
    public ResponseEntity<Void> checkout(@PathVariable("codigoPedido") String codigoPedido) throws PedidoException {
        pedidoController.checkout(UUID.fromString(codigoPedido));
        return ResponseEntity
                .status(OK)
                .build();
    }

    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<Collection<ConsultarPedidoResponse>> consultarPedidos() {
        var pedidos = pedidoController.consultar();
        return ResponseEntity
                .status(OK)
                .body(pedidos);
    }
}
