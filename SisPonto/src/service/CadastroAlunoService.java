package service;

import java.util.Scanner;

import dao.AlunoDao;
import dao.Dao;
import entity.Aluno;
import entity.Curso;

public class CadastroAlunoService implements SisPontoService{

	private Dao<Aluno> alunoDao = new AlunoDao();
	
	@Override
	public void execute() {
		
		Scanner in = new Scanner(System.in);
		String opcaoCurso;
		
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
	}
	

}
