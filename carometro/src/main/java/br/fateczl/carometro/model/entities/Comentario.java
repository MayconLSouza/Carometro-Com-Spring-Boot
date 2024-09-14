package br.fateczl.carometro.model.entities;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import br.fateczl.carometro.model.enums.Enum_Tipos;
import jakarta.persistence.*;

@Entity
public class Comentario implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;
    @Transient
    private final DateTimeFormatter  DIA_MES_ANO = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String descricao;
    private LocalDate data = LocalDate.now();
    @Enumerated(EnumType.STRING)
    @Column(name = "tipo")
    private Enum_Tipos tipo;
    @ManyToOne
    @JoinColumn(name = "aluno_ra")
    private Aluno aluno;

    public Comentario() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
    public String getDataFormat() {
        return data.format(DIA_MES_ANO);
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

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    @Override
    public String toString() {
        return "Comentario [id=" + id + ", descricao=" + descricao + ", data=" + getDataFormat() + ", tipo=" + tipo + "]";
    }

}
