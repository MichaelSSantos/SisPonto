package dao;

import java.util.ArrayList;
import java.util.List;

import entity.Professor;

public class ProfessorDao implements Dao<Professor> {

	private static ProfessorDao uniqueInstance;

	private ProfessorDao() {
	}

	public static ProfessorDao getDao() {
		return (uniqueInstance == null) ? uniqueInstance = new ProfessorDao() : uniqueInstance;
	}

	private List<Professor> professores = new ArrayList<>();

	@Override
	public void cadastrar(Professor professor) {
		professores.add(professor);
	}

	@Override
	public List<Professor> obterTodos() {
		return professores;
	}

}
