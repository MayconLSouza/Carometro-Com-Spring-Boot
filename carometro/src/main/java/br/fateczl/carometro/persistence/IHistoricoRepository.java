package br.fateczl.carometro.persistence;
 
import org.springframework.data.jpa.repository.JpaRepository;
 
import br.fateczl.carometro.model.entities.Historico;
 
public interface IHistoricoRepository extends JpaRepository<Historico, Long> {
}