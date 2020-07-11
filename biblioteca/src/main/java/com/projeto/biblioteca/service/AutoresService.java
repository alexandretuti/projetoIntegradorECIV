package com.projeto.biblioteca.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projeto.biblioteca.domain.Autor;
import com.projeto.biblioteca.repository.AutoresRepository;

@Service
public class AutoresService {

	@Autowired
	private AutoresRepository autoresRepository; 
	
	public Autor salvar(Autor autor) {
		autor.setId(null);
		return autoresRepository.save(autor);
	}
	
	
	public Optional<Autor> buscar(Long id) {
		Optional<Autor> autor = autoresRepository.findById(id);
		return autor;
	}
	

}
