package br.fateczl.carometro.persistence;

import br.fateczl.carometro.model.entities.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAlunoRepository extends JpaRepository<Aluno, String> {

}
