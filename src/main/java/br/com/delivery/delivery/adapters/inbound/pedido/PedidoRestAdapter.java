package br.com.delivery.delivery.adapters.inbound.pedido;

import br.com.delivery.delivery.adapters.inbound.pedido.request.CadastrarPedidoRequest;
import br.com.delivery.delivery.adapters.inbound.pedido.response.CadastrarPedidoResponse;
import br.com.delivery.delivery.application.domain.pedido.Pedido;
import br.com.delivery.delivery.application.ports.inbound.pedido.CadastrarPedidoInboundPort;
import br.com.delivery.delivery.application.ports.inbound.pedido.ConsultarPedidoInboundPort;
import br.com.delivery.delivery.application.ports.inbound.pedido.EditarPedidoInboundPort;
import br.com.delivery.delivery.application.ports.inbound.pedido.ExcluirPedidoInboundPort;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

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
    private final ExcluirPedidoInboundPort excluirPedidoInboundPort;

    @PostMapping(
            consumes = APPLICATION_JSON_VALUE,
            produces = APPLICATION_JSON_VALUE
    )
    @ResponseStatus(CREATED)
    public ResponseEntity<CadastrarPedidoResponse> cadastrar(@RequestBody CadastrarPedidoRequest cadastrarPedidoRequest) {
        var pedido = cadastrarPedidoInboundPort.salvar(null);
        var response = CadastrarPedidoResponse.from(UUID.randomUUID().toString());
        return ResponseEntity
                .ofNullable(response);
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

    @DeleteMapping(
            path = "/{idPedido}",
            consumes = APPLICATION_JSON_VALUE
    )
    public void excluirCadastro(@PathVariable("idPedido") String idPedido) {
        excluirPedidoInboundPort.excluir(UUID.fromString(idPedido));
    }
}
