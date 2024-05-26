package br.com.delivery.delivery.adapters.inbound.cliente;

import br.com.delivery.delivery.adapters.inbound.cliente.dto.CadastrarClienteRequest;
import br.com.delivery.delivery.adapters.inbound.cliente.dto.ClienteResponse;
import br.com.delivery.delivery.application.domain.cliente.Cliente;
import br.com.delivery.delivery.application.ports.inbound.cliente.ClientePortIn;
import br.com.delivery.delivery.application.ports.inbound.cliente.ConsultarClientePort;
import br.com.delivery.delivery.application.ports.inbound.cliente.EditarClientePort;
import br.com.delivery.delivery.application.ports.inbound.cliente.ExcluirClientePort;
import lombok.RequiredArgsConstructor;

import org.apache.coyote.http11.Http11InputBuffer;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpClient;
import java.util.UUID;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NO_CONTENT;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/clientes")
public class ClienteRestAdapter {

	private final ClientePortIn cadastrarClientePort;
	private final EditarClientePort editarClientePort;
	private final ConsultarClientePort consultarClientePort;
	private final ExcluirClientePort excluirClientePort;

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
		editarClientePort.editar(null);
		return ResponseEntity.status(NO_CONTENT).build();
	}

	@GetMapping(path = "/{cpf}/ducumentoId")
	public ResponseEntity<ClienteResponse> consultarPorId(@PathVariable("cpf") String cpf) {
		return ResponseEntity.ok(consultarClientePort.consultar(cpf));
	}

	@DeleteMapping(path = "/{idCliente}", consumes = APPLICATION_JSON_VALUE)
	public void excluirCadastro(@PathVariable("idCliente") String idCliente) {
		excluirClientePort.excluir(UUID.fromString(idCliente));
	}
}
