package br.fateczl.carometro.model.entities;

import java.io.Serial;
import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonBackReference;

import br.fateczl.carometro.model.primarykeysclass.HistoricoId;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Historico implements Serializable {

	@Serial
	private static final long serialVersionUID = 1L;
/*
	@EmbeddedId
	HistoricoId historicoId;
*/
	@Id
	private Long idHistorico;
	
	@ManyToOne
	@JoinColumn(name = "aluno_ra", referencedColumnName = "ra", nullable = false) // foreign key
	@JsonBackReference // Evita loop infinito na serialização JSON
	private Aluno aluno;

	private String empresa;
	private String atividade;
	private int tempoEmpresaEmAnos;

	public Historico() {
		super();
	}
/*
	// Getters e Setters
	public HistoricoId getId() {
		return historicoId;
	}

	public void setId(HistoricoId historicoId) {
		this.historicoId = historicoId;
	}
*/
	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}
	
	public String getEmpresa() {
		return empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	public String getAtividade() {
		return atividade;
	}

	public void setAtividade(String atividade) {
		this.atividade = atividade;
	}

	public int getTempoEmpresaEmAnos() {
		return tempoEmpresaEmAnos;
	}

	public void setTempoEmpresaEmAnos(int tempoEmpresaEmAnos) {
		this.tempoEmpresaEmAnos = tempoEmpresaEmAnos;
	}

	@Override
	public String toString() {
		return "Historico "+ ", aluno=" + aluno  + ", empresa=" + empresa + ", atividade="
				+ atividade + ", tempoEmpresaEmAnos=" + tempoEmpresaEmAnos + "]";
	}
}
