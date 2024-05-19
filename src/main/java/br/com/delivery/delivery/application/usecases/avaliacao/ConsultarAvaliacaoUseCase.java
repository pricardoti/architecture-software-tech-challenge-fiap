package br.com.delivery.delivery.application.usecases.avaliacao;

import br.com.delivery.delivery.application.domain.avaliacao.Avaliacao;
import br.com.delivery.delivery.application.ports.inbound.avaliacao.ConsultarAvaliacaoPort;

import java.util.UUID;

public class ConsultarAvaliacaoUseCase implements ConsultarAvaliacaoPort {
    @Override
    public Avaliacao consultar(UUID idAvaliacao) {
        return null;
    }
}
