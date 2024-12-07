package br.fateczl.carometro.persistence;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.fateczl.carometro.model.entities.Curso;

@Repository
public interface ICursoRepository extends JpaRepository<Curso, String> {
	
	Optional<Curso> findByCodigo(String codigo);

}
