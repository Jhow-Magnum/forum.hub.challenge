package api.forum.hub.factory;

public class CadastroTopicoRequestFactory {

    public static api.forum.hub.domain.dto.RegistrationTopicRequest criaCadastroTopicoRequestCompleto() {
        return new api.forum.hub.domain.dto.RegistrationTopicRequest(
                "Titulo do post",
                "Mensagem sobre o topico...",
                "Autor do Topico",
                "Curso do topico"
        );
    }

    public static api.forum.hub.domain.dto.RegistrationTopicRequest criaCadastroTopicoRequestInvalido() {
        return new api.forum.hub.domain.dto.RegistrationTopicRequest(
                "",
                "Mensagem sobre o topico...",
                "Autor do Topico",
                "Curso do topico"
        );
    }
}
