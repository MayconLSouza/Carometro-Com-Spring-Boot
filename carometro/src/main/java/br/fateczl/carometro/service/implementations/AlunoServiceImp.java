package br.fateczl.carometro.service.implementations;

import br.fateczl.carometro.model.entities.Aluno;
import br.fateczl.carometro.model.entities.Comentario;
import br.fateczl.carometro.model.entities.Historico;
import br.fateczl.carometro.persistence.IAlunoRepository;
import br.fateczl.carometro.service.services.IAlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;

@Service
public class AlunoServiceImp implements IAlunoService {

    @Autowired
    IAlunoRepository repository;

    @Override
    public Aluno inserir(Aluno aluno) {
    	System.err.println("reposytory");
        Optional<Aluno> validaAluno = repository.findById(aluno.getRa());
        if (validaAluno.isPresent()) {
            throw new IllegalArgumentException("Aluno Já Presente no Banco de Dados");
        }else{
 
            return repository.save(aluno);
        }
    }

    @Override
    public Aluno buscar(String RA) throws ClassNotFoundException {
        return repository.findById(RA).orElseThrow(ClassNotFoundException::new);
    }

    @Override
    public Aluno atualizar(String ra, Aluno aluno) throws ClassNotFoundException {
        Aluno alunoAtualizado = repository.findById(ra).orElseThrow(() -> new ClassNotFoundException("Aluno Inexistente"));
        alunoAtualizado.setNome(aluno.getNome());
        alunoAtualizado.setCurso(aluno.getCurso());
        alunoAtualizado.setFoto(aluno.getFoto());
        alunoAtualizado.setSemestreConclusao(aluno.getSemestreConclusao());
        alunoAtualizado.setLinks(aluno.getLinks());
        
        // Historico
        if (aluno.getHistorico() != null) {
            Historico historicoAtual = alunoAtualizado.getHistorico();

            if (historicoAtual != null) {
                // Se o historico ja existe, apenas atualiza os campos
                historicoAtual.setEmpresa(aluno.getHistorico().getEmpresa());
                historicoAtual.setAtividade(aluno.getHistorico().getAtividade());
                historicoAtual.setTempoEmpresa(aluno.getHistorico().getTempoEmpresa());
            } else {
                // Se o historico nao existe, configura o aluno e adiciona ao aluno atual
                aluno.getHistorico().setAluno(alunoAtualizado);
                alunoAtualizado.setHistorico(aluno.getHistorico());
            }
        }
        
        // Comentario
        if (aluno.getComentarios() != null) {
            Map<String, Comentario> comentariosAtualizados = alunoAtualizado.getComentarios();
            
            for (Map.Entry<String, Comentario> comentario : aluno.getComentarios().entrySet()) {
                String tipoComentario = comentario.getKey();
                Comentario novoComentario = comentario.getValue();

                if (comentariosAtualizados.containsKey(tipoComentario)) {
                    // Atualize o comentario existente
                    Comentario comentarioExistente = comentariosAtualizados.get(tipoComentario);
                    comentarioExistente.setDescricao(novoComentario.getDescricao());
                    comentarioExistente.setData(novoComentario.getData());
                } else {
                    // Adiciona novo comentario e vincule ao aluno
                    novoComentario.setAluno(alunoAtualizado);
                    comentariosAtualizados.put(tipoComentario, novoComentario);
                }
            }
        }

        return repository.save(alunoAtualizado);
    }

    @Override
    public void deletar(String RA) {
        Optional<Aluno> validaAluno = repository.findById(RA);
        if (validaAluno.isPresent()) {
            repository.deleteById(RA);
        }else{
            throw new IllegalArgumentException("Aluno Inexistente no Banco de Dados");
        }
    }

    @Override
    public Iterable<Aluno> buscarTodos() {
        return repository.findAll();
    }
}
