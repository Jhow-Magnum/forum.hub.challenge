package api.forum.hub.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/topicos")
public class TopicsController {

    @Autowired
    private api.forum.hub.service.TopicsService service;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid api.forum.hub.domain.dto.RegistrationTopicRequest request, UriComponentsBuilder uriComponentsBuilder) {
        var topico = service.cadastrarTopico(new api.forum.hub.domain.Topics(request));

        var uri = uriComponentsBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();

        return ResponseEntity.created(uri).body(new api.forum.hub.domain.dto.DetailsTopicResponse(topico));
    }

    @GetMapping
    public ResponseEntity<Page<api.forum.hub.domain.dto.DetailsTopicResponse>> listar(@PageableDefault(sort = {"dataCriacao"}) Pageable paginacao){
        var page = service.listarTopicos(paginacao).map(api.forum.hub.domain.dto.DetailsTopicResponse::new);

        return ResponseEntity.ok(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity detalhar(@PathVariable Long id) {
        var topico = service.detalharTopico(id);

        return ResponseEntity.ok(new api.forum.hub.domain.dto.DetailsTopicResponse(topico));
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid api.forum.hub.domain.dto.RequestUpdateTopics request) {
        var topico = service.atualizarTopico(new api.forum.hub.domain.Topics(request));

        return ResponseEntity.ok(new api.forum.hub.domain.dto.DetailsTopicResponse(topico));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id) {
        service.excluirTopico(id);

        return ResponseEntity.noContent().build();
    }
}