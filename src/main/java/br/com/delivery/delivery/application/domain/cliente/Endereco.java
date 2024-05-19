package br.com.delivery.delivery.application.domain.cliente;

public record Endereco(
        String logradouro,
        String numero,
        String complemento,
        String cep,
        String cidade,
        String bairro
) {
}
