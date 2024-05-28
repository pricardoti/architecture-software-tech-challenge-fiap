package br.com.delivery.delivery.adapters.inbound.cliente.request;

import br.com.delivery.delivery.application.domain.cliente.Endereco;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CadastrarEnderecoRequest {

    private String logradouro;
    private String numero;
    private String complemento;
    private String bairro;
    private String cidade;
    private String cep;
    private String uf;

    public Endereco toDomain() {
        return new Endereco(logradouro, numero, complemento, bairro, cidade, cep, uf);
    }

}