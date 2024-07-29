package br.com.fiap.delivery.domain.pedido;

public enum StatusPedido {

    RECEBIDO("RECEBIDO"),
    EM_PREPARACAO("EM_PREPARACAO"),
    PRONTO_ENTREGA("PRONTO_ENTREGA"),
    CANCELADO("CANCELADO"),
    FINALIZADO("FINALIZADO");

    private final String status;

    StatusPedido(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
