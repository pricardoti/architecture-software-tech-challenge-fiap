package br.com.delivery.delivery.adapters.inbound.cliente.request;

import br.com.delivery.delivery.application.domain.cliente.Endereco;
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