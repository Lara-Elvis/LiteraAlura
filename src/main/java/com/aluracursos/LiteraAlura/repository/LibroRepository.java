package com.aluracursos.LiteraAlura.repository;

import com.aluracursos.LiteraAlura.model.EAutor;
import com.aluracursos.LiteraAlura.model.ELibro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LibroRepository extends JpaRepository<ELibro, Long> {
    @Query("SELECT l FROM LibroEntity l WHERE l.lenguaje >= :idioma")
    List<ELibro> findForLanguaje(String idioma);
}
