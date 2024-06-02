package br.com.delivery.delivery.adapters.handler;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter(onMethod = @__(@JsonProperty))
@Setter(onMethod = @__(@JsonProperty))
@Accessors(fluent = true)
@NoArgsConstructor
@AllArgsConstructor
public class ErrorDTO {

    private String mensagem;
    private String detalhe;

    public ErrorDTO(String mensagem) {
        this.mensagem = mensagem;
    }

}