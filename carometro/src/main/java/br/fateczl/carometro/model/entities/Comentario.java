package br.fateczl.carometro.model.entities;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonBackReference;

import br.fateczl.carometro.model.enums.Enum_Tipos;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Comentario implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "aluno_ra", referencedColumnName = "ra", nullable = false) // foreign key
    @JsonBackReference // Evita loop infinito na serialização JSON
    private Aluno aluno;
    
    private String descricao;
    private LocalDate data;
    
    @Column(name = "tipo")
    private Enum_Tipos tipo;
    
    public Comentario() {
    	super();
    }

    // Getters e Setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public Enum_Tipos getTipo() {
		return tipo;
	}

	public void setTipo(Enum_Tipos tipo) {
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		return "Comentario [id=" + id + ", aluno=" + aluno + ", descricao=" + descricao + ", data=" + data + ", tipo="
				+ tipo + "]";
	}
	
	


}
