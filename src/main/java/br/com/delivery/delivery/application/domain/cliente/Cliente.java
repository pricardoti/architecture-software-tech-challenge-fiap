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
@NoArgsConstructor
@AllArgsConstructor
public class Cliente {

    private UUID codigo;
    private String cpf;
    private String nomeCompleto;
    private String email;
    private Endereco endereco;

    public Cliente(
            String cpf,
            String nomeCompleto,
            String email,
            Endereco endereco
    ) {
        this.cpf = cpf;
        this.nomeCompleto = nomeCompleto;
        this.email = email;
        this.endereco = endereco;
    }
}
