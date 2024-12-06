package br.fateczl.carometro.model.entities;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
public class Turma implements Serializable {

	@Serial
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private TurmaId turmaId;

	private Enum_TurnosCursos turno;

	@OneToMany(mappedBy = "turma", cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonManagedReference("turma-alunos")
	private List<Aluno> alunos;

	@ManyToOne
	@JoinColumn(name = "curso_codigo", referencedColumnName = "codigo", nullable = false)
	@JsonBackReference("curso-turmas") // Mesmo nome usado na referência gerenciada
	private Curso curso;


	public TurmaId getTurmaId() {
		return turmaId;
	}

	public void setTurmaId(TurmaId turmaId) {
		this.turmaId = turmaId;
	}

	public Enum_TurnosCursos getTurno() {
		return turno;
	}

	public void setTurno(Enum_TurnosCursos turno) {
		this.turno = turno;
	}

	public List<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	@Override
	public String toString() {
		return "Turma [turmId=" + turmaId + ", turno=" + turno + "]";
	}

}
