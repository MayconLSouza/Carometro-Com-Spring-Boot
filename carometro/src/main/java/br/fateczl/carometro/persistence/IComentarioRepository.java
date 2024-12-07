package br.fateczl.carometro.persistence;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.fateczl.carometro.model.entities.Comentario;
import br.fateczl.carometro.model.enums.Enum_Tipos;

@Repository
public interface IComentarioRepository extends JpaRepository<Comentario, Long> {
	Optional<Comentario> findByAlunoRaAndTipo(String RaDoAluno, Enum_Tipos tipo);
}
