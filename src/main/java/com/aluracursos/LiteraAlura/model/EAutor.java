package com.aluracursos.LiteraAlura.model;


import com.aluracursos.LiteraAlura.service.CadenasUtil;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.*;

@Entity
@Table(name = "Autor")
public class EAutor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private Integer fechaNacimiento;
    private Integer fechaFallecimiento;

    @OneToOne
    @JoinTable(name = "Libro",
            joinColumns = @JoinColumn(name = "autor_id"),
            inverseJoinColumns = @JoinColumn(name = "id"))
    private ELibro libros;

    public EAutor() {
    }

    public EAutor(Autor autor){
        this.nombre = CadenasUtil.limitarLongitud(autor.name(), 200);

        if (autor.birthYear() == null)
            this.fechaNacimiento = 1980;
        else
            this.fechaNacimiento = autor.birthYear();

        if (autor.deathYear() == null)
            this.fechaFallecimiento = 3022;
        else
            this.fechaFallecimiento = autor.deathYear();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Integer fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Integer getFechaFallecimiento() {
        return fechaFallecimiento;
    }

    public void setFechaFallecimiento(Integer fechaFallecimiento) {
        this.fechaFallecimiento = fechaFallecimiento;
    }

    @Override
    public String toString() {
        return "EAutor [id=" + id + ", nombre=" + nombre + ", fechaNacimiento=" + fechaNacimiento
                + ", fechaFallecimiento=" + fechaFallecimiento + ", libro=" + libros + "]";
    }

    public ELibro getLibros() {
        return libros;
    }

    public void setLibros(ELibro libros) {
        this.libros = libros;
    }
}
