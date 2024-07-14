package br.com.fiap.delivery.domain.cliente;

import java.util.UUID;

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

    public Endereco(UUID codigo, String logradouro, String numero, String complemento, String bairro, String cidade, String cep, String uf) {
        this.codigo = codigo;
        this.logradouro = logradouro;
        this.numero = numero;
        this.complemento = complemento;
        this.bairro = bairro;
        this.cidade = cidade;
        this.cep = cep;
        this.uf = uf;
    }

    public UUID getCodigo() {
        return codigo;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public String getNumero() {
        return numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public String getCep() {
        return cep;
    }

    public String getUf() {
        return uf;
    }
}