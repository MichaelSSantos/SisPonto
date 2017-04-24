package main;

import java.util.InputMismatchException;
import java.util.Scanner;

import dao.AdministrativoDao;
import dao.AlunoDao;
import dao.GenericDao;
import dao.ProfessorDao;
import entity.Aluno;
import entity.Curso;
import entity.Funcionario;
import entity.Professor;
import exceptions.SalarioInvalidoException;

public class SisPonto {

	public static void main(String[] args) {

		System.out.println("--SISPONTO--");
		
		GenericDao<Aluno> alunoDao = new AlunoDao();
		GenericDao<Professor> professorDao = new ProfessorDao();
		GenericDao<Funcionario> administrativoDao = new AdministrativoDao();
		
		
		Scanner in = new Scanner(System.in);
		String opcaoMenu;
		String opcaoCurso;
		
		do {
			System.out.println("\n--MENU--");
			System.out.println("[1] Consultar dados de uma pessoa");
			System.out.println("[2] Cadastrar novo aluno");
			System.out.println("[3] Cadastrar novo professor");
			System.out.println("[4] Cadastrar novo administrativo");
			System.out.println("[0] Sair");

			System.out.print("Opção: ");
			opcaoMenu = in.nextLine();

			switch (opcaoMenu) {
			case "1":
				System.out.println("\nOpção selecionada: " + opcaoMenu);
				break;

			case "2":
				Aluno aluno = new Aluno();
				
				System.out.println("\n--Cadastro de aluno--");
				System.out.print("-Informe o nome: ");
				aluno.setNome(in.nextLine());
				System.out.print("-Informe o CPF: ");
				aluno.setCpf(in.nextLine());
				System.out.print("-Informe a matrícula: ");
				aluno.setMatricula(in.nextLine());
				
				do {
					System.out.print("\n-Selecione \n[1] para inserir um curso para o aluno ou \n[0] para finalizar: ");
					opcaoCurso = in.nextLine();
					
					switch (opcaoCurso) {
					case "1":
						Curso curso = new Curso();
						System.out.print("\n-Informe o nome do curso: ");
						curso.setNome(in.nextLine());
						System.out.print("-Informe a carga horária do curso: ");
						curso.setHoras(Integer.valueOf(in.nextLine()));//TODO TRATAR EXCEÇÃO

						aluno.getCursos().add(curso);
						break;
					
					case "0":
						break;
					
					default:
						System.out.println("Opção inválida.");
						break;
					}
					
				} while (!"0".equals(opcaoCurso));
				
				System.out.println("\n" + aluno.toString());
				alunoDao.cadastrar(aluno);
				break;

			case "3":
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
				break;

			case "4":
				Funcionario administrativo = new Funcionario();
				
				System.out.println("\n--Cadastro de administrativo--");
				System.out.print("-Informe o nome: ");
				administrativo.setNome(in.nextLine());
				System.out.print("-Informe o CPF: ");
				administrativo.setCpf(in.nextLine());
				System.out.print("-Informe a matrícula: ");
				administrativo.setMatricula(in.nextLine());
				administrativo.setSalario(inserirSalario());

				System.out.println("\n" + administrativo.toString());
				administrativoDao.cadastrar(administrativo);
				break;

			case "0":
				System.out.println("\nExecução terminada.");
				break;
				
			default:
				System.out.println("\nOpção inválida.");
				break;
			}

		} while (!"0".equals(opcaoMenu));
		
		in.close();

	}
	
	public static Double calcularSalarioProfessor(Professor professor){
		Double totalHoras = 0.0;
		final Integer HORA_AULA = 40;
		
		for (Curso curso : professor.getCursos()) {
			totalHoras += curso.getHoras();
		}
		
		return totalHoras * HORA_AULA;
	}
	
	public static Double inserirSalario(){
		System.out.print("-Informe o salário: ");
		Scanner in = new Scanner(System.in);
		Double salario = in.nextDouble();
		in.close();
		try {

			if(salario < 0.0){
				throw new SalarioInvalidoException("O salário não pode ser um valor negativo.");
			}
		} catch (InputMismatchException e) {
			System.out.println("O salário deve ser um valor numérico.");
			inserirSalario();
			
		} catch (SalarioInvalidoException e){
			System.out.println(e.getMessage());
			inserirSalario();
		}
		return salario;
	};

}
