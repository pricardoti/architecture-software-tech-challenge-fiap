package br.com.delivery.delivery.adapters.inbound.pedido;

import br.com.delivery.delivery.adapters.inbound.pedido.request.AtualizarPedidoRequest;
import br.com.delivery.delivery.adapters.inbound.pedido.request.CadastrarPedidoRequest;
import br.com.delivery.delivery.adapters.inbound.pedido.response.CadastrarPedidoResponse;
import br.com.delivery.delivery.application.domain.pedido.Pedido;
import br.com.delivery.delivery.application.ports.inbound.pedido.CadastrarPedidoInboundPort;
import br.com.delivery.delivery.application.ports.inbound.pedido.ConsultarPedidoInboundPort;
import br.com.delivery.delivery.application.ports.inbound.pedido.ConsultarPedidoPorCodigoInboundPort;
import br.com.delivery.delivery.application.ports.inbound.pedido.EditarPedidoInboundPort;
import br.com.delivery.delivery.application.ports.inbound.pedido.RealizarCheckoutPedidoInboundPort;
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
import static org.springframework.http.HttpStatus.NO_CONTENT;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/pedidos")
public class PedidoRestAdapter {

    private final CadastrarPedidoInboundPort cadastrarPedidoInboundPort;
    private final EditarPedidoInboundPort editarPedidoInboundPort;
    private final ConsultarPedidoInboundPort consultarPedidoInboundPort;
    private final ConsultarPedidoPorCodigoInboundPort consultarPedidoPorCodigoInboundPort;
    private final RealizarCheckoutPedidoInboundPort realizarCheckoutPedidoInboundPort;

    @PostMapping(
            consumes = APPLICATION_JSON_VALUE,
            produces = APPLICATION_JSON_VALUE
    )
    @ResponseStatus(CREATED)
    public ResponseEntity<CadastrarPedidoResponse> cadastrar(@RequestBody @Valid CadastrarPedidoRequest cadastrarPedidoRequest) {
        var pedido = cadastrarPedidoInboundPort.cadastrar(cadastrarPedidoRequest.toDomain());
        var response = CadastrarPedidoResponse.createByCodigoPedido(pedido.getCodigoPedido());
        return ResponseEntity
                .status(CREATED)
                .body(response);
    }

    @PatchMapping(path = "/{codigoPedido}")
    @ResponseStatus(NO_CONTENT)
    public ResponseEntity<Void> atualizarPedido(
            @PathVariable("codigoPedido") String codigoPedido,
            @RequestBody AtualizarPedidoRequest atualizarPedidoRequest
    ) {
        var pedido = consultarPedidoPorCodigoInboundPort.consultar(UUID.fromString(codigoPedido));
        editarPedidoInboundPort.editar(pedido, atualizarPedidoRequest.getStatus());
        return ResponseEntity
                .status(NO_CONTENT)
                .build();
    }

    @PostMapping(path = "/{codigoPedido}/checkout")
    @ResponseStatus(NO_CONTENT)
    public ResponseEntity<Void> checkout(@PathVariable("codigoPedido") String codigoPedido) {
        var pedido = consultarPedidoPorCodigoInboundPort.consultar(UUID.fromString(codigoPedido));
        realizarCheckoutPedidoInboundPort.checkout(pedido.getCodigoPedido());
        return ResponseEntity
                .status(NO_CONTENT)
                .build();
    }

    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<Collection<Pedido>> consultarPedidos() {
        var pedidos = consultarPedidoInboundPort.consultar();
        return ResponseEntity
                .status(OK)
                .body(pedidos);
    }
}
