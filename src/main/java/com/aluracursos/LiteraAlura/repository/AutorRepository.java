package com.aluracursos.LiteraAlura.repository;

import com.aluracursos.LiteraAlura.model.EAutor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AutorRepository extends JpaRepository <EAutor, Long>{
    @Query("SELECT a FROM AutorEntity a WHERE :anio between a.fechaNacimiento AND a.fechaFallecimiento")
    List<EAutor> findForYear(int anio);
}
