package api.forum.hub.factory;

import java.time.LocalDateTime;
import java.time.Month;

public class TopicoFactory {

    public static api.forum.hub.domain.Topics criaTopicoCompleto() {
        return new api.forum.hub.domain.Topics(
                1L,
                "Titulo do post",
                "Mensagem sobre o topico...",
                LocalDateTime.of(2024, Month.JULY, 2, 10, 30),
                (short) 1,
                "Autor do Topico",
                "Curso do topico"
        );
    }

    public static api.forum.hub.domain.Topics criaTopicoInvalido() {
        return new api.forum.hub.domain.Topics(
                1L,
                "",
                "Mensagem sobre o topico...",
                LocalDateTime.of(2024, Month.JULY, 2, 10, 30),
                (short) 1,
                "Autor do Topico",
                "Curso do topico"
        );
    }
}
