package br.fateczl.carometro.model.primarykeysclass;

import jakarta.persistence.Embeddable;

@Embeddable
public class TurmaId {

	private String codigoCurso;
	private Integer ano;
	private Integer semestre;

	//Getters e Setters
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

	@Override
	public String toString() {
		return "TurmaId [codigoCurso=" + codigoCurso + ", ano=" + ano + ", semestre=" + semestre + "]";
	}
	
	
	
}
