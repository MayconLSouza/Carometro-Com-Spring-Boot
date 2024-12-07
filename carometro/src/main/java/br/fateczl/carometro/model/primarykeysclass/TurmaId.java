package br.fateczl.carometro.model.primarykeysclass;

import br.fateczl.carometro.model.enums.Enum_TurnosCursos;
import jakarta.persistence.Embeddable;

@Embeddable
public class TurmaId {

	private String codigoCurso;
	private Integer ano;
	private Integer semestre;
	private Enum_TurnosCursos turno;
	
	public TurmaId() {
		super();
	}

	public TurmaId(String codigoCurso, Integer ano, Integer semestre, Enum_TurnosCursos turno) {
		this.codigoCurso = codigoCurso;
		this.ano = ano;
		this.semestre = semestre;
		this.turno = turno;
	}

	// Getters e Setters
	public String getCodigoCurso() {
		return codigoCurso;
	}

	public Integer getAno() {
		return ano;
	}

	public Integer getSemestre() {
		return semestre;
	}

	public void setCodigoCurso(String codigoCurso) {
		this.codigoCurso = codigoCurso;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}

	public void setSemestre(Integer semestre) {
		this.semestre = semestre;
	}

	public Enum_TurnosCursos getTurno() {
		return turno;
	}

	public void setTurno(Enum_TurnosCursos turno) {
		this.turno = turno;
	}

	@Override
	public String toString() {
		return "TurmaId [codigoCurso=" + codigoCurso + ", ano=" + ano + ", semestre=" + semestre + "]";
	}

}
