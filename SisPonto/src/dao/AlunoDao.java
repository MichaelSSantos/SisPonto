package dao;

import java.util.ArrayList;
import java.util.List;

import entity.Aluno;

public class AlunoDao implements Dao<Aluno> {

	private static AlunoDao uniqueInstance;

	private AlunoDao() {
	}

	public static AlunoDao getDao() {
		return (uniqueInstance == null) ? uniqueInstance = new AlunoDao() : uniqueInstance;
	}

	private List<Aluno> alunos = new ArrayList<>();

	@Override
	public void cadastrar(Aluno aluno) {
		alunos.add(aluno);
	}

	@Override
	public List<Aluno> obterTodos() {
		return alunos;
	}

}
