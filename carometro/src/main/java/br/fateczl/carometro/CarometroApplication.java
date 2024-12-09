package br.fateczl.carometro;

import java.io.File;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CarometroApplication {

	public static void main(String[] args) {
		verificarDiretorio();
		SpringApplication.run(CarometroApplication.class, args);
	}

	// Metodo que verifica se o diretorio ja existe no computador, caso nao exista ele cria um novo
	private static void verificarDiretorio() {
		File diretorio = new File("C:\\PastaImagensCarometro\\");
		if (!diretorio.exists() || !diretorio.isDirectory()) {
			diretorio.mkdirs();
		}
	}

}
