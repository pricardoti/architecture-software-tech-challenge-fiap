package br.com.fiap.delivery.infrastructure.api.clientes.dtos;

import br.com.fiap.delivery.domain.cliente.Endereco;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class AtualizarEnderecoRequest extends CadastrarEnderecoRequest {

    @NotBlank
    private String codigo;

    @Override
    public Endereco toDomain() {
        return new Endereco(UUID.fromString(codigo), getLogradouro(), getNumero(), getComplemento(), getBairro(), getCidade(), getCep(), getUf());
    }
}