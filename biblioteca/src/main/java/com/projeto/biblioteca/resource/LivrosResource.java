package com.projeto.biblioteca.resource;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.CacheControl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.projeto.biblioteca.domain.Livro;
import com.projeto.biblioteca.service.LivrosService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/livros")
@Api(value="API REST Livros")
@CrossOrigin(origins = "*")
public class LivrosResource {

	@Autowired
	private LivrosService livrosService;
	
	@CrossOrigin
	@RequestMapping(method = RequestMethod.POST)
	@ApiOperation(value = "Salva um livro")
	public ResponseEntity<Void> salvar(@RequestBody Livro livro){
		livro = livrosService.salvar(livro);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(livro.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@CrossOrigin
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ApiOperation(value = "Retorna um livro pelo ID")
	public ResponseEntity<?> buscar(@PathVariable("id") Long id) {
		Optional<Livro> livro = livrosService.buscar(id);
		CacheControl cacheControl = CacheControl.maxAge(20, TimeUnit.SECONDS);
		return ResponseEntity.status(HttpStatus.OK).cacheControl(cacheControl).body(livro);
	}
	
	@CrossOrigin
	@RequestMapping(method = RequestMethod.GET)
	@ApiOperation(value = "Retorna uma lista de livros")
	public ResponseEntity<List<Livro>> listarLivros(){
		return ResponseEntity.status(HttpStatus.OK).body(livrosService.listar());
	}
	
	@CrossOrigin
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ApiOperation(value = "Deleta um livro")
	public ResponseEntity<Void> deletar(@PathVariable("id") Long id ) throws Exception { 
		livrosService.deletar(id);
		return ResponseEntity.noContent().build();
	}
	
}
