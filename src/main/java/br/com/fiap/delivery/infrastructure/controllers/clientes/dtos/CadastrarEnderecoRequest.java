package br.com.fiap.delivery.infrastructure.controllers.clientes.dtos;

import br.com.fiap.delivery.domain.cliente.Endereco;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CadastrarEnderecoRequest {

    @NotBlank
    private String logradouro;

    private String numero;
    private String complemento;

    @NotBlank
    private String bairro;

    @NotBlank
    private String cidade;

    @NotBlank
    @Size(min = 9, max = 9)
    private String cep;

    @NotBlank
    @Size(min = 2, max = 2)
    private String uf;

    public Endereco toDomain() {
        return new Endereco(logradouro, numero, complemento, bairro, cidade, cep, uf);
    }

}