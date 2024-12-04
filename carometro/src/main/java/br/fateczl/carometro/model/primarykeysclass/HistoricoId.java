package br.fateczl.carometro.model.primarykeysclass;

import java.io.Serial;
import java.io.Serializable;

import jakarta.persistence.Embeddable;

@Embeddable
public class HistoricoId implements Serializable{
	
	@Serial
    private static final long serialVersionUID = 1L;
	
	private String alunoRa;
	private Long id;
	
	// Getters e Setters
	public String getAlunoRa() {
		return alunoRa;
	}
	public Long getId() {
		return id;
	}
	public void setAlunoRa(String alunoRa) {
		this.alunoRa = alunoRa;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	@Override
	public String toString() {
		return "HistoricoId [alunoRa=" + alunoRa + ", id=" + id + "]";
	}
	
}
