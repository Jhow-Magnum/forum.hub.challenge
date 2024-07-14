package api.forum.hub.service;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class TopicsService {

    private Short ATIVO = (short) 1;

    @Autowired
    private api.forum.hub.repository.TopicsRepository repository;

    public api.forum.hub.domain.Topics cadastrarTopico(api.forum.hub.domain.Topics topics) {
        return repository.save(topics);
    }

    public Page<api.forum.hub.domain.Topics> listarTopicos(Pageable pageable) {
        return repository.findAllByStatus(ATIVO, pageable);
    }

    public api.forum.hub.domain.Topics detalharTopico(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException(id, "Topico com o ID fornecido não foi encontrado"));
    }

    public api.forum.hub.domain.Topics atualizarTopico(api.forum.hub.domain.Topics topicsAtt) {
        var topico = repository.findById(topicsAtt.getId())
                .orElseThrow(() -> new ObjectNotFoundException(topicsAtt.getId(), "Topico com o ID fornecido não foi encontrado"));
        topico.atualizarTopico(topicsAtt);
        return topico;
    }

    public void excluirTopico(Long id) {
        var topico = repository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException(id, "Topico com o ID fornecido não foi encontrado"));
        topico.excluir();
    }
}
