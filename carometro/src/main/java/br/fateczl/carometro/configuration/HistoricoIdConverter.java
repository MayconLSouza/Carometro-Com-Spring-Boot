package br.fateczl.carometro.configuration;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import br.fateczl.carometro.model.primarykeysclass.HistoricoId;

@Component
public class HistoricoIdConverter implements Converter <String, HistoricoId> {

	public HistoricoIdConverter() {
		super();
	}

	@Override
	public HistoricoId convert(String source) {
		String[] parts = source.split(";");
		HistoricoId hid = new HistoricoId();
		
		hid.setAlunoRa(parts[0]);
		hid.setIdHistorico(Long.parseLong(parts[1]));
		
		return hid;
	}

}
