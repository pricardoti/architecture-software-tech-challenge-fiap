package br.com.delivery.delivery.adapters.handler;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ErrorDTO {

    private String mensagem;
    private String detalhe;

    public ErrorDTO(String mensagem) {
        this.mensagem = mensagem;
    }

}