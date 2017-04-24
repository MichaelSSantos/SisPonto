package dao;

import java.util.ArrayList;
import java.util.List;

import entity.Aluno;

public class AlunoDao implements GenericDao<Aluno> {

	private List<Aluno> alunos = new ArrayList<>();
	
	@Override
	public void cadastrar(Aluno aluno) {
		alunos.add(aluno);
	}
	

}
