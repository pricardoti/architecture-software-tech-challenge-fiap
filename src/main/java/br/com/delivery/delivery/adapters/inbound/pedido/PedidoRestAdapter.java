package br.com.delivery.delivery.adapters.inbound.pedido;

import br.com.delivery.delivery.adapters.inbound.pedido.request.CadastrarPedidoRequest;
import br.com.delivery.delivery.adapters.inbound.pedido.response.CadastrarPedidoResponse;
import br.com.delivery.delivery.application.domain.pedido.Pedido;
import br.com.delivery.delivery.application.ports.inbound.pedido.CadastrarPedidoInboundPort;
import br.com.delivery.delivery.application.ports.inbound.pedido.ConsultarPedidoInboundPort;
import br.com.delivery.delivery.application.ports.inbound.pedido.EditarPedidoInboundPort;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NO_CONTENT;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/pedidos")
public class PedidoRestAdapter {

    private final CadastrarPedidoInboundPort cadastrarPedidoInboundPort;
    private final EditarPedidoInboundPort editarPedidoInboundPort;
    private final ConsultarPedidoInboundPort consultarPedidoInboundPort;

    @PostMapping(
            consumes = APPLICATION_JSON_VALUE,
            produces = APPLICATION_JSON_VALUE
    )
    @ResponseStatus(CREATED)
    public ResponseEntity<CadastrarPedidoResponse> cadastrar(@RequestBody @Valid CadastrarPedidoRequest cadastrarPedidoRequest) {
        var pedido = cadastrarPedidoInboundPort.cadastrar(cadastrarPedidoRequest.toDomain());
        var response = CadastrarPedidoResponse.createByCodigoPedido(pedido.codigoPedido());
        return ResponseEntity
                .status(CREATED)
                .body(response);
    }

    @PutMapping(
            path = "/{idPedido}",
            consumes = APPLICATION_JSON_VALUE,
            produces = APPLICATION_JSON_VALUE
    )
    @ResponseStatus(NO_CONTENT)
    public ResponseEntity<Void> atualizarCadastro(
            @PathVariable("idPedido") String idPedido,
            @RequestBody CadastrarPedidoRequest cadastrarPedidoRequest
    ) {
        editarPedidoInboundPort.editar(null);
        return ResponseEntity
                .status(NO_CONTENT)
                .build();
    }

    @GetMapping(
            path = "/{idPedido}",
            consumes = APPLICATION_JSON_VALUE,
            produces = APPLICATION_JSON_VALUE
    )
    public Pedido consultarPorId(@PathVariable("idPedido") String idPedido) {
        return consultarPedidoInboundPort.consultar(null);
    }
}
