package com.example.demo;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProdutoController {
	
	private final ProdutoRepository repository;
	private final ProdutoModelAssembler assembler;
	
	public ProdutoController(ProdutoRepository repository, ProdutoModelAssembler assembler) {
		this.repository = repository;
		this.assembler = assembler;
	}
	
	@GetMapping("/produtos")
	CollectionModel<EntityModel<Produto>> all(){
		List<EntityModel<Produto>> produtos = repository.findAll().stream()
				.map(assembler::toModel)
				.collect(Collectors.toList());
		
		return CollectionModel.of(produtos, linkTo(methodOn(ProdutoController.class).all()).withSelfRel());
	}
}
