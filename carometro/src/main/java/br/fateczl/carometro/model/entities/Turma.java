package br.fateczl.carometro.model.entities;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import br.fateczl.carometro.model.enums.Enum_TurnosCursos;
import br.fateczl.carometro.model.primarykeysclass.TurmaId;
import jakarta.persistence.CascadeType;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Turma implements Serializable{

	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private TurmaId turmId;

	private Enum_TurnosCursos turno;

	@OneToMany(mappedBy = "turma", cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonManagedReference
	private List<Aluno> alunos;
	
	@ManyToOne
	@JoinColumn(name = "curso_codigo", referencedColumnName = "codigo", nullable = false)
	private Curso curso;

	public TurmaId getTurmId() {
		return turmId;
	}

	public Enum_TurnosCursos getTurno() {
		return turno;
	}

	public void setTurmId(TurmaId turmId) {
		this.turmId = turmId;
	}

	public void setTurno(Enum_TurnosCursos turno) {
		this.turno = turno;
	}

	public List<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(List<Aluno> aluno) {
		this.alunos = aluno;
	}

	public Curso getCurso() {
		return curso;
	}
	
	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	@Override
	public String toString() {
		return "Turma [turmId=" + turmId + ", turno=" + turno + "]";
	}

}
