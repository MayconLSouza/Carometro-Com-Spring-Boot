package br.fateczl.carometro.configuration;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import br.fateczl.carometro.model.entities.Turma;
import br.fateczl.carometro.model.enums.Enum_TurnosCursos;
import br.fateczl.carometro.model.primarykeysclass.TurmaId;
import br.fateczl.carometro.service.implementations.TurmaServiceImp;

@Component
public class TurmaConverter implements Converter <String, Turma> {
	
	private final TurmaServiceImp turmaService;
	
	public TurmaConverter(TurmaServiceImp turmaService) {
        this.turmaService = turmaService;
    }
	
		public Turma convert(String source) {
	        // Parse the source string to create a Turma object
			
			
	        String[] parts = source.split(",");
	        TurmaId idturma = new TurmaId();
	        Turma turma = new Turma();
	        idturma.setCodigoCurso(parts[0]);
	        idturma.setAno(Integer.parseInt(parts[1]));
	        idturma.setSemestre(Integer.parseInt(parts[2]));
	        if(parts[3].equals("0")) {
	        	idturma.setTurno(Enum_TurnosCursos.Matutino);
	        }else {
	        	if(parts[3].equals("1")) {
	        		idturma.setTurno(Enum_TurnosCursos.Vespertino);
	        	}else {
	        		idturma.setTurno(Enum_TurnosCursos.Noturno);
	        	}
	        }
	        try {
				return turmaService.buscar(idturma.getCodigoCurso(), idturma.getAno(), idturma.getSemestre(), idturma.getTurno());
			} catch (ClassNotFoundException e) {
				System.err.println(e);
			}
			return turma;
	
	}

}
