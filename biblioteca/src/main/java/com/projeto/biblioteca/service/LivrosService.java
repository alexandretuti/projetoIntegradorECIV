package com.projeto.biblioteca.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projeto.biblioteca.domain.Livro;
import com.projeto.biblioteca.repository.LivrosRepository;

@Service
public class LivrosService {

	@Autowired
	private LivrosRepository livrosRepository;
	
	public Livro salvar(Livro livro){
		livro.setId(null);
		return livrosRepository.save(livro);
	}
	
	public Optional<Livro> buscar(Long id) {
		Optional<Livro> livro = livrosRepository.findById(id);
		return livro; 
	}

	public List<Livro> listar() {
		return livrosRepository.findAll(); 
	}
	
	public void deletar(Long id) throws Exception {
	
		try {
			livrosRepository.deleteById(id);
			} catch (Exception e) {
				throw new Exception(e + "O livro não pode ser encontrado");
			}
	}
	
}
