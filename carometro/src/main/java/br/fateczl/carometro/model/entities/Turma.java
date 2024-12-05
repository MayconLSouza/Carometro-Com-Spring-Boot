package br.fateczl.carometro.model.entities;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import br.fateczl.carometro.model.primarykeysclass.TurmaId;
import jakarta.persistence.CascadeType;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

@Entity
public class Turma implements Serializable{

	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private TurmaId turmId;

	private String turno;

	@OneToMany(mappedBy = "turma", cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonManagedReference
	private List<Aluno> alunos;

	public TurmaId getTurmId() {
		return turmId;
	}

	public String getTurno() {
		return turno;
	}

	public void setTurmId(TurmaId turmId) {
		this.turmId = turmId;
	}

	public void setTurno(String turno) {
		this.turno = turno;
	}

	public List<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(List<Aluno> aluno) {
		this.alunos = aluno;
	}

	@Override
	public String toString() {
		return "Turma [turmId=" + turmId + ", turno=" + turno + "]";
	}

}
