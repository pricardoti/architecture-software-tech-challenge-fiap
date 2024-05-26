package br.com.delivery.delivery.application.domain.enums;

import java.util.Arrays;
import java.util.Objects;

public enum StatusPedido {

    RECEBIDO("RECEBIDO"),
    PAGO("PAGO"),
    EM_PREPARACAO("EM_PREPARACAO"),
    PRONTO_PARA_ENTREGA("PRONTO_PARA_ENTREGA"),
    CANCELADO("CANCELADO"),
    FINALIZADO("FINALIZADO");

    private final String status;

    StatusPedido(String status) {
        this.status = status;
    }

    public static StatusPedido fromString(String status) {
        if (Objects.isNull(status)) return null;

        return Arrays.stream(values())
                .filter(statusPedido -> statusPedido.status.equals(status.toUpperCase()))
                .findFirst()
                .orElse(null);
    }

    @Override
    public String toString() {
        return this.status;
    }
}
