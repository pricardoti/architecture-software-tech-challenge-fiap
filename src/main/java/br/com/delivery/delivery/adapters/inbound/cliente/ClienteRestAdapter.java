package br.com.delivery.delivery.adapters.inbound.cliente;

import br.com.delivery.delivery.adapters.inbound.cliente.dto.CadastrarClienteRequest;
import br.com.delivery.delivery.adapters.inbound.cliente.dto.ClienteResponse;
import br.com.delivery.delivery.application.ports.inbound.cliente.CadastrarClienteInboundPort;
import br.com.delivery.delivery.application.ports.inbound.cliente.ConsultarClienteInboundPort;
import br.com.delivery.delivery.application.ports.inbound.cliente.EditarClienteInboundPort;
import br.com.delivery.delivery.application.ports.inbound.cliente.ExcluirClienteInboundPort;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
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

	private final CadastrarClienteInboundPort cadastrarClientePort;
	private final EditarClienteInboundPort editarClienteInboundPort;
	private final ConsultarClienteInboundPort consultarClienteInboundPort;
	private final ExcluirClienteInboundPort excluirClienteInboundPort;

	@PostMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
	@ResponseStatus(CREATED)
	public ResponseEntity<HttpStatus> cadastrar(@RequestBody CadastrarClienteRequest cadastrarClienteRequest) {
		cadastrarClientePort.salvar(cadastrarClienteRequest);
		return ResponseEntity.ok(HttpStatus.CREATED);
	}

	@PutMapping(path = "/{idCliente}", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
	@ResponseStatus(NO_CONTENT)
	public ResponseEntity<Void> atualizarCadastro(@PathVariable("idCliente") String idCliente,
			@RequestBody CadastrarClienteRequest cadastrarClienteRequest) {
		editarClienteInboundPort.editar(null);
		return ResponseEntity.status(NO_CONTENT).build();
	}

	@GetMapping(path = "/{cpf}/ducumentoId")
	public ResponseEntity<ClienteResponse> consultarPorId(@PathVariable("cpf") String cpf) {
		return ResponseEntity.ok(consultarClienteInboundPort.consultar(cpf));
	}

	@DeleteMapping(path = "/{idCliente}", consumes = APPLICATION_JSON_VALUE)
	public void excluirCadastro(@PathVariable("idCliente") String idCliente) {
		excluirClienteInboundPort.excluir(UUID.fromString(idCliente));
	}
}
