package br.fateczl.carometro.model.enums;

public enum Enum_TurnosCursos {
	Matutino(1),
	Vespertino(2),
	Noturno(3);

	private final int periodo;

	Enum_TurnosCursos(int periodo) {
		this.periodo = periodo;
	}

	public int getPeriodo() {
		return periodo;
	}

}
