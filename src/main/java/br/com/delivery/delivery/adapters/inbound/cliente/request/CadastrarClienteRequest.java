package br.com.delivery.delivery.adapters.inbound.cliente.request;

import br.com.delivery.delivery.application.domain.cliente.Cliente;
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
    private CadastrarEnderecoRequest endereco;

    public Cliente toDomain() {
        return new Cliente(cpf, nomeCompleto, email, endereco.toDomain());
    }

    public Cliente toDomain(UUID codiogoCliente) {
        return new Cliente(codiogoCliente, cpf, nomeCompleto, email, endereco.toDomain());
    }
}
