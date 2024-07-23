package br.com.fiap.delivery.infrastructure.controllers.clientes.dtos;

import br.com.fiap.delivery.domain.cliente.Cliente;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.UUID;

@Getter(onMethod = @__(@JsonProperty))
@Setter(onMethod = @__(@JsonProperty))
@Accessors(fluent = true)
@NoArgsConstructor
@AllArgsConstructor
public class ConsultarClienteResponse {

    private UUID codigo;
    private String cpf;
    private String nomeCompleto;
    private String email;
    private ClienteEnderecoResponse endereco;

    public ConsultarClienteResponse(Cliente cliente) {
        this(
                cliente.getCodigo(),
                cliente.getCpf(),
                cliente.getNomeCompleto(),
                cliente.getEmail(),
                new ClienteEnderecoResponse(cliente.getEndereco())
        );
    }
}
