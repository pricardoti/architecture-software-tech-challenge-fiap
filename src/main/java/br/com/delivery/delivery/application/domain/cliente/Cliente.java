package br.com.delivery.delivery.application.domain.cliente;

public record Cliente(
        String nome,
        String sobrenome,
        String cpf,
        Endereco endereco
) {
}
