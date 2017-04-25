package service;

import dao.AdministrativoDao;
import dao.AlunoDao;
import dao.Dao;
import dao.ProfessorDao;
import entity.Aluno;
import entity.Funcionario;
import entity.Professor;

public interface SisPontoService {

	Dao<Aluno> alunoDao = new AlunoDao();
	Dao<Professor> professorDao = new ProfessorDao();
	Dao<Funcionario> administrativoDao = new AdministrativoDao();
	
	public void execute();
	
}
