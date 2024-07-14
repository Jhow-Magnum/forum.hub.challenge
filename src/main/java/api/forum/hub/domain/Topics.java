package api.forum.hub.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Table(name = "topicos")
@Entity(name = "Topico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topics {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String mensagem;
    private LocalDateTime dataCriacao;
    private Short status;
    private String autor;
    private String curso;

    public Topics(api.forum.hub.domain.dto.RegistrationTopicRequest request) {
        this.titulo = request.titulo();
        this.mensagem = request.mensagem();
        this.dataCriacao = LocalDateTime.now();
        this.status = 1;
        this.autor = request.autor();
        this.curso = request.curso();
    }

    public Topics(api.forum.hub.domain.dto.RequestUpdateTopics request) {
        this.id = request.id();
        this.titulo = request.titulo();
        this.mensagem = request.mensagem();
        this.autor = request.autor();
        this.curso = request.curso();
    }

    public api.forum.hub.domain.Topics atualizarTopico(api.forum.hub.domain.Topics topics) {
        this.titulo = topics.getTitulo();
        this.mensagem = topics.getMensagem();
        this.autor = topics.getAutor();
        this.curso = topics.getCurso();

        return topics;
    }

    public void excluir() {
        this.status = (short) 0;
    }
}
