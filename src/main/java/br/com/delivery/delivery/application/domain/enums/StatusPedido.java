package br.com.delivery.delivery.application.domain.enums;

import lombok.Getter;

@Getter
public enum StatusPedido {

    RECEBIDO("RECEBIDO"),
    PAGO("PAGO"),
    EM_PREPARACAO("EM_PREPARACAO"),
    PRONTO_ENTREGA("PRONTO_ENTREGA"),
    CANCELADO("CANCELADO"),
    FINALIZADO("FINALIZADO");

    private final String status;

    StatusPedido(String status) {
        this.status = status;
    }
}
