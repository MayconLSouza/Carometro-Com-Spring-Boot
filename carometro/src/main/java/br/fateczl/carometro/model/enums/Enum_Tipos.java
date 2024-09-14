package br.fateczl.carometro.model.enums;

public enum Enum_Tipos {
    LIVRE(1),
    FATEC(2);

    private final int codigo;

    Enum_Tipos(int codigo) {
        this.codigo = codigo;
    }

    public int getCodigo() {
        return codigo;
    }
}