package br.fateczl.carometro.model.primarykeysclass;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class HistoricoId implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "id_historico") // Nome físico da coluna no banco
    private Long idHistorico;

    @Column(name = "aluno_ra") // Nome físico da coluna no banco
    private String alunoRa;

    public HistoricoId() {
    	super();
    }

    public HistoricoId(Long idHistorico, String alunoRa) {
        this.idHistorico = idHistorico;
        this.alunoRa = alunoRa;
    }

    public Long getIdHistorico() {
        return idHistorico;
    }

    public void setIdHistorico(Long idHistorico) {
        this.idHistorico = idHistorico;
    }

    public String getAlunoRa() {
        return alunoRa;
    }

    public void setAlunoRa(String alunoRa) {
        this.alunoRa = alunoRa;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HistoricoId that = (HistoricoId) o;
        return Objects.equals(idHistorico, that.idHistorico) && Objects.equals(alunoRa, that.alunoRa);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idHistorico, alunoRa);
    }
}
