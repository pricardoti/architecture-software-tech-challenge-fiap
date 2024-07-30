package br.com.fiap.delivery.domain.cliente;

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
            String email
    ) {
        this.cpf = cpf;
        this.nomeCompleto = nomeCompleto;
        this.email = email;
    }

    public Cliente(
            String cpf,
            String nomeCompleto,
            String email,
            Endereco endereco
    ) {
        this(cpf, nomeCompleto, email);
        this.endereco = endereco;
    }

    public Cliente(UUID codigo, String cpf, String nomeCompleto, String email, Endereco endereco) {
        this(cpf, nomeCompleto, email, endereco);
        this.codigo = codigo;
    }

    public UUID getCodigo() {
        return codigo;
    }

    public void setCodigo(UUID codigo) {
        this.codigo = codigo;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
}
