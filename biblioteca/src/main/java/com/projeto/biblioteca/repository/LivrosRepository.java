package com.projeto.biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projeto.biblioteca.domain.Livro;

public interface LivrosRepository extends JpaRepository<Livro, Long>{

}
