package br.com.fiap.delivery.infrastructure.api.clientes.dtos;

import br.com.fiap.delivery.domain.cliente.Cliente;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

import java.util.UUID;

@Getter
@Setter
public class CadastrarClienteRequest {

    @CPF
    @NotNull
    private String cpf;

    @NotNull
    private String nomeCompleto;

    @NotNull
    private String email;

    @NotNull
    private @Valid CadastrarEnderecoRequest endereco;

    public Cliente toDomain() {
        return new Cliente(UUID.randomUUID(), cpf, nomeCompleto, email, endereco.toDomain());
    }

    public Cliente toDomain(UUID codiogoCliente) {
        return new Cliente(codiogoCliente, cpf, nomeCompleto, email, endereco.toDomain());
    }
}
