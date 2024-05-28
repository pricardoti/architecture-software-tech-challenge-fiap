package br.com.delivery.delivery.application.domain.cliente;

import java.util.UUID;

public record Endereco(
        UUID codigo,
        String logradouro,
        String numero,
        String complemento,
        String bairro,
        String cidade,
        String cep,
        String uf
) {
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