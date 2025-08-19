package br.com.mixmercado.mix_mercado.controller;

import br.com.mixmercado.mix_mercado.model.Mercado;
import br.com.mixmercado.mix_mercado.service.MercadoService;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/mercado")
public class MercadoController {

    private final MercadoService service;

    public MercadoController(MercadoService service) {
        this.service = service;
    }

    @GetMapping
    public List<EntityModel<Mercado>> getAll() {
        return service.findAll().stream()
                .map(this::toHateoas)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public EntityModel<Mercado> getById(@PathVariable Long id) {
        return toHateoas(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<EntityModel<Mercado>> create(@RequestBody Mercado mercado) {
        Mercado saved = service.save(mercado);
        EntityModel<Mercado> resource = toHateoas(saved);

        return ResponseEntity.created(resource.getRequiredLink(IanaLinkRelations.SELF).toUri()).body(resource);
    }

    @PutMapping("/{id}")
    public EntityModel<Mercado> update(@PathVariable Long id, @RequestBody Mercado mercado) {
        return toHateoas(service.update(id, mercado));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    private EntityModel<Mercado> toHateoas(Mercado mercado) {
        return EntityModel.of(mercado,
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(MercadoController.class).getById(mercado.getId())).withSelfRel(),
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(MercadoController.class).getAll()).withRel("mercados"));
    }
}