package service;

import java.util.Scanner;

import dao.Dao;
import dao.ProfessorDao;
import entity.Curso;
import entity.Professor;

public class CadastroProfessorService implements SisPontoService {
	
	@Override
	public void execute() {
		Scanner in = new Scanner(System.in);
		String opcaoCurso;

		Professor professor = new Professor();
		
		System.out.println("\n--Cadastro de professor--");
		System.out.print("-Informe o nome: ");
		professor.setNome(in.nextLine());
		System.out.print("-Informe o CPF: ");
		professor.setCpf(in.nextLine());
		System.out.print("-Informe a matrícula: ");
		professor.setMatricula(in.nextLine());
		
		do {
			System.out.print("\n-Selecione \n[1] para inserir um curso para o professor ou \n[0] para finalizar: ");
			opcaoCurso = in.nextLine();
			
			switch (opcaoCurso) {
			case "1":
				Curso curso = new Curso();
				System.out.print("\n-Informe o nome do curso: ");
				curso.setNome(in.nextLine());
				System.out.print("-Informe a carga horária do curso: ");
				curso.setHoras(Integer.valueOf(in.nextLine()));//TODO TRATAR EXCEÇÃO

				professor.getCursos().add(curso);
				break;
			
			case "0":
				break;
			
			default:
				System.out.println("Opção inválida.");
				break;
			}
			
		} while (!"0".equals(opcaoCurso));
		
		professor.setSalario(calcularSalarioProfessor(professor));
		System.out.println("\n" + professor.toString());
		professorDao.cadastrar(professor);
	}
	
	private Double calcularSalarioProfessor(Professor professor){
		Double totalHoras = 0.0;
		final Integer HORA_AULA = 40;
		
		for (Curso curso : professor.getCursos()) {
			totalHoras += curso.getHoras();
		}
		
		return totalHoras * HORA_AULA;
	}

}
