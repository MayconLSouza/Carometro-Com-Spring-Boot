package br.fateczl.carometro.model.entities;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonBackReference;

import br.fateczl.carometro.model.primarykeysclass.HistoricoId;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;

@Entity
public class Historico implements Serializable {

	private static final long serialVersionUID = 1L;

	@EmbeddedId
    private HistoricoId historicoId;

    @ManyToOne
    @MapsId("alunoRa") // Mapeia "alunoRa" de HistoricoId diretamente no relacionamento
    @JsonBackReference
    private Aluno aluno;

    private String empresa;
    private String atividade;
    private int tempoEmpresaEmAnos;

    public Historico() {
        super();
    }

    public HistoricoId getHistoricoId() {
        return historicoId;
    }

    public void setHistoricoId(HistoricoId historicoId) {
        this.historicoId = historicoId;
    }

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
        return "Historico [historicoId=" + historicoId + ", aluno=" + aluno + ", empresa=" + empresa
                + ", atividade=" + atividade + ", tempoEmpresaEmAnos=" + tempoEmpresaEmAnos + "]";
    }
}
