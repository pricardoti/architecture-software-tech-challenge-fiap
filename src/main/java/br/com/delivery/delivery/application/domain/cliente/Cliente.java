package br.com.delivery.delivery.application.domain.cliente;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.UUID;

@Getter
@Setter
@Accessors(fluent = true)
@AllArgsConstructor
public class Cliente {

    private UUID codigo;
    private String cpf;
    private String nome;
    private String email;
    private Endereco endereco;

    public Cliente(
            String cpf,
            String nome,
            String email,
            Endereco endereco
    ) {
        this.cpf = cpf;
        this.nome = nome;
        this.email = email;
        this.endereco = endereco;
    }
}
