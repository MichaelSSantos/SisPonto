package service;

import java.util.Scanner;

import entity.Curso;

public abstract class BaseUtilsService {

	protected Curso inserirCurso() {
		
		Curso curso = new Curso();
		System.out.print("\n-Informe o nome do curso: ");
		curso.setNome(new Scanner(System.in).nextLine());
		curso.setHoras(inserirCargaHorariaCurso());
		return curso;
	}

	private Integer inserirCargaHorariaCurso() {
		try {

			System.out.print("-Informe a carga horária do curso: ");
			return Integer.valueOf(new Scanner(System.in).nextLine());

		} catch (NumberFormatException e) {
			System.out.println("Carga horária inválida.");
			return inserirCargaHorariaCurso();
		}
		
	}

}
