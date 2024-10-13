package br.fateczl.carometro.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import br.fateczl.carometro.model.entities.Comentario;

public interface IComentarioRepository extends JpaRepository<Comentario, Long> {

}
