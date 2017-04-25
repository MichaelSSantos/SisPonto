package dao;

import java.util.ArrayList;
import java.util.List;

import entity.Professor;

public class ProfessorDao implements Dao<Professor> {

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
