package br.fateczl.carometro.model.entities;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Curso implements Serializable {
	
	@Serial
	private static final long serialVersionUID = 1L;
	
	@Id // primary key
	private String codigo;
	private String nome;
	private String coordenador;
	private boolean ativo;
	
	@OneToMany(mappedBy = "curso", cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonManagedReference("curso-turmas") // Nome único para a referência
	private List<Turma> turmas;


	public Curso() {
		super();
	}

	// Getters e Setters
	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCoordenador() {
		return coordenador;
	}

	public void setCoordenador(String coordenador) {
		this.coordenador = coordenador;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	public List<Turma> getTurmas() {
		return turmas;
	}

	public void setTurmas(List<Turma> turmas) {
		this.turmas = turmas;
	}

	@Override
	public String toString() {
		return "Curso [codigo=" + codigo + ", nome=" + nome + ", coordenador=" + coordenador + ", ativo=" + ativo + "]";
	}

}
