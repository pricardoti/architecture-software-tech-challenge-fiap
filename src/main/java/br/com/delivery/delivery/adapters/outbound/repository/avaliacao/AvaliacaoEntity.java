package br.com.delivery.delivery.adapters.outbound.repository.avaliacao;

import br.com.delivery.delivery.application.domain.avaliacao.Avaliacao;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.experimental.Accessors;

import static jakarta.persistence.GenerationType.IDENTITY;

@Data
@Entity
@Accessors(fluent = true)
@Table(name = "avaliacoes")
public class AvaliacaoEntity {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    private Integer avaliacao;
    private String comentario;

    // TODO: mapear value objects
    // private Credencial credencial;
    // private Endereco endereco;

    public static AvaliacaoEntity from(Avaliacao avaliacao) {
        var avaliacaoEntity = new AvaliacaoEntity();
        avaliacaoEntity.avaliacao(avaliacao.avaliacao());
        avaliacaoEntity.comentario(avaliacao.comentario());

        return avaliacaoEntity;
    }
}
