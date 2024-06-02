package br.com.delivery.delivery.application.domain.cliente;

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
@AllArgsConstructor
@NoArgsConstructor
public class Endereco {

    private UUID codigo;
    private String logradouro;
    private String numero;
    private String complemento;
    private String bairro;
    private String cidade;
    private String cep;
    private String uf;

    public Endereco(
            String logradouro,
            String numero,
            String complemento,
            String bairro,
            String cidade,
            String cep,
            String uf
    ) {
        this(UUID.randomUUID(), logradouro, numero, complemento, bairro, cidade, cep, uf);
    }
}