package com.projeto.biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projeto.biblioteca.domain.Autor;

public interface AutoresRepository extends JpaRepository<Autor, Long> {
		

}
