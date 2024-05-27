package br.com.delivery.delivery.application.domain.cliente;

import java.util.UUID;

public record Endereco(
        UUID codigo,
        String logradouro,
        String numero,
        String complemento,
        String bairro,
        String cidade,
        String cep
) {
    public Endereco(
            String logradouro,
            String numero,
            String complemento,
            String bairro,
            String cidade,
            String cep
    ) {
        this(UUID.randomUUID(), logradouro, numero, complemento, bairro, cidade, cep);
    }
}