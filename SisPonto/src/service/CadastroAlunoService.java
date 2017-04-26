package service;

import java.util.Scanner;

import dao.AlunoDao;
import dao.Dao;
import entity.Aluno;

public class CadastroAlunoService extends BaseUtilsService implements SisPontoService {

	@Override
	public void execute() {

		Scanner in = new Scanner(System.in);
		String opcaoCurso;

		Aluno aluno = new Aluno();
		Dao<Aluno> alunoDao = AlunoDao.getDao();

		System.out.println("\n--Cadastro de aluno--");
		System.out.print("-Informe o nome: ");
		aluno.setNome(in.nextLine());
		System.out.print("-Informe o CPF: ");
		aluno.setCpf(in.nextLine());
		System.out.print("-Informe a matrícula: ");
		aluno.setMatricula(in.nextLine());

		do {
			System.out.print("\n-Selecione [1] para inserir um curso para o aluno ou \n selecione [0] para finalizar: ");
			opcaoCurso = in.nextLine();

			switch (opcaoCurso) {

			case "1":
				aluno.getCursos().add(inserirCurso());
				break;

			case "0":
				break;

			default:
				System.out.println("\nOpção inválida.");
				break;
			}

		} while (!"0".equals(opcaoCurso));

		System.out.println("\n" + aluno.toString());
		alunoDao.cadastrar(aluno);
	}

}
