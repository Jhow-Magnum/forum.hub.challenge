package api.forum.hub.factory;

public class AtualizacaoTopicoRequestFactory {

    public static api.forum.hub.domain.dto.RequestUpdateTopics criaAtualizacaoTopicoRequestCompleto() {
        return new api.forum.hub.domain.dto.RequestUpdateTopics(
                1L,
                "Titulo do post",
                "Mensagem sobre o topico...",
                "Autor do Topico",
                "Curso do topico"
        );
    }

    public static api.forum.hub.domain.dto.RequestUpdateTopics criaAtualizacaoTopicoRequestInvalido() {
        return new api.forum.hub.domain.dto.RequestUpdateTopics(
                1L,
                "",
                "Mensagem sobre o topico...",
                "Autor do Topico",
                "Curso do topico"
        );
    }
}
