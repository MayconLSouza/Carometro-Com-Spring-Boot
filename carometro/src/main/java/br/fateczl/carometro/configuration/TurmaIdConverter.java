package br.fateczl.carometro.configuration;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import br.fateczl.carometro.model.enums.Enum_TurnosCursos;
import br.fateczl.carometro.model.primarykeysclass.TurmaId;

@Component
public class TurmaIdConverter implements Converter<String, TurmaId> {

	public TurmaIdConverter() {
		super();
	}

	public TurmaId convert(String source) {

		String[] parts = source.split(",");
		TurmaId turmaId = new TurmaId();
		turmaId.setCodigoCurso(parts[0]);
		turmaId.setAno(Integer.parseInt(parts[1]));
		turmaId.setSemestre(Integer.parseInt(parts[2]));
		if (parts[3].equals("0")) {
			turmaId.setTurno(Enum_TurnosCursos.Matutino);
		} else {
			if (parts[3].equals("1")) {
				turmaId.setTurno(Enum_TurnosCursos.Vespertino);
			} else {
				turmaId.setTurno(Enum_TurnosCursos.Noturno);
			}
		}
		return turmaId;

	}

}