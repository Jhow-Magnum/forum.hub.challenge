package api.forum.hub.factory;

import java.time.LocalDateTime;
import java.time.Month;

public class DetalhesTopicoResponseFactory {

    public static api.forum.hub.domain.dto.DetailsTopicResponse criaDetalhesTopicoResponseCompleto() {
        return new api.forum.hub.domain.dto.DetailsTopicResponse(
                1L,
                "Titulo do post",
                "Mensagem sobre o topico...",
                LocalDateTime.of(2024, Month.JULY, 2, 10, 30),
                (short) 1,
                "Autor do Topico",
                "Curso do topico"
        );
    }
}
