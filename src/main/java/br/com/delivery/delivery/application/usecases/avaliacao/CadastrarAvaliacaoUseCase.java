package br.com.delivery.delivery.application.usecases.avaliacao;

import br.com.delivery.delivery.application.domain.avaliacao.Avaliacao;
import br.com.delivery.delivery.application.ports.inbound.avaliacao.CadastrarAvaliacaoPort;
import br.com.delivery.delivery.application.ports.outbound.avaliacao.SalvarAvaliacaoPort;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CadastrarAvaliacaoUseCase implements CadastrarAvaliacaoPort {

    private final SalvarAvaliacaoPort salvarAvaliacaoPort;

    @Override
    public Avaliacao salvar(Avaliacao avaliacao) {
        return salvarAvaliacaoPort.salvar(null);
    }
}
