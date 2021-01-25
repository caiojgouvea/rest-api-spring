package com.example.demo;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class ProdutoModelAssembler implements RepresentationModelAssembler<Produto, EntityModel<Produto>>{

	@Override
	public EntityModel<Produto> toModel(Produto entity) {
		return EntityModel.of(entity,
				linkTo(methodOn(ProdutoController.class).all()).withRel("produto"));
	}

}
