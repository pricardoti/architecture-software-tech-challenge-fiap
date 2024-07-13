package br.com.delivery.delivery.application.domain.cliente;

import java.util.UUID;

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

    public Cliente(UUID codigo, String cpf, String nomeCompleto, String email, Endereco endereco) {
        this.codigo = codigo;
        this.cpf = cpf;
        this.nomeCompleto = nomeCompleto;
        this.email = email;
        this.endereco = endereco;
    }

    public UUID getCodigo() {
        return codigo;
    }

    public String getCpf() {
        return cpf;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public String getEmail() {
        return email;
    }

    public Endereco getEndereco() {
        return endereco;
    }
}
