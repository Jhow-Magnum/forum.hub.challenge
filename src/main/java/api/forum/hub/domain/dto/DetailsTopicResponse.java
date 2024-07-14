package api.forum.hub.domain.dto;

import java.time.LocalDateTime;

public record DetailsTopicResponse(
        Long id,
        String titulo,
        String mensagem,
        LocalDateTime dataCriacao,
        Short status,
        String autor,
        String curso
) {
    public DetailsTopicResponse(api.forum.hub.domain.Topics topics) {
        this(topics.getId(),
             topics.getTitulo(),
             topics.getMensagem(),
             topics.getDataCriacao(),
             topics.getStatus(),
             topics.getAutor(),
             topics.getCurso()
        );
    }
}
