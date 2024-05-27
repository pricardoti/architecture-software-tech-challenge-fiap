package br.com.delivery.delivery.application.domain.cliente;

import java.util.UUID;

public record Cliente(
        UUID codigo,
        String cpf,
        String nome,
        String email,
        Endereco endereco
) {
    public Cliente(
            String cpf,
            String nome,
            String email,
            Endereco endereco
    ) {
        this(UUID.randomUUID(), cpf, nome, email, endereco);
    }
}
