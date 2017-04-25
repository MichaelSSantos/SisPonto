package service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import dao.AdministrativoDao;
import dao.AlunoDao;
import dao.Dao;
import dao.ProfessorDao;
import entity.Aluno;
import entity.Funcionario;
import entity.Pessoa;
import entity.Professor;

public class ConsultaPessoaService implements SisPontoService{
	
	private Dao<Aluno> alunoDao = new AlunoDao();
	private Dao<Professor> professorDao = new ProfessorDao();
	private Dao<Funcionario> administrativoDao = new AdministrativoDao();
	
	@Override
	public void execute() {
		Scanner in = new Scanner(System.in);
		
		System.out.println("\n--Consulta de pessoa--");
		System.out.print("-Informe a matrícula: ");
		String matricula = in.nextLine();
		
		List<Pessoa> pessoas = new ArrayList<Pessoa>();
		
		pessoas.addAll(alunoDao.obterTodos());
		pessoas.addAll(professorDao.obterTodos());
		pessoas.addAll(administrativoDao.obterTodos());
		
		List<Pessoa> filtro = pessoas.stream().filter(pessoa -> pessoa.getMatricula().equals(matricula)).collect(Collectors.toList());
		
		System.out.println("\n-Retorno do filtro : " + filtro);
	}
	
}
