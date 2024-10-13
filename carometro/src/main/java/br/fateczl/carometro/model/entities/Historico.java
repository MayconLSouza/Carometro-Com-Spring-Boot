package br.fateczl.carometro.model.entities;

import java.io.Serial;
import java.io.Serializable;
import java.time.format.DateTimeFormatter;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Transient;

@Entity
public class Historico implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;
    @Transient
    private final DateTimeFormatter ANO_MES = DateTimeFormatter.ofPattern("yy,MM");


    @Id
    //@GeneratedValue(strategy = GenerationType.SEQUENCE)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String empresa;
    private String atividade;
    private String tempoEmpresa;

    @OneToOne
    @JoinColumn(name = "aluno_ra")
    @JsonBackReference
    private Aluno aluno;

    public Historico() {
        // TODO Auto-generated constructor stub
    }

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

    public String getTempoEmpresa() {
        return tempoEmpresa;
    }

 

    public void setTempoEmpresa(String tempoEmpresa) {
        this.tempoEmpresa = tempoEmpresa;
    }


    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    @Override
    public String toString() {
        return "Historico [id=" + id + ", empresa=" + empresa + ", atividade=" + atividade + ", tempoEmpresa="
                + getTempoEmpresa() + "]";
    }

}

