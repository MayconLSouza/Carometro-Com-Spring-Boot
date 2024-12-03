package br.fateczl.carometro.model.entities;

import java.io.Serial;
import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Historico implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
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

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public int getTempoEmpresa() {
        return tempoEmpresaEmAnos;
    }

    public void setTempoEmpresa(int tempoEmpresaEmAnos) {
        this.tempoEmpresaEmAnos = tempoEmpresaEmAnos;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

	@Override
	public String toString() {
		return "Historico [id=" + id + ", aluno=" + aluno + ", empresa=" + empresa + ", atividade=" + atividade
				+ ", tempoEmpresaEmAnos=" + tempoEmpresaEmAnos + "]";
	}
}
