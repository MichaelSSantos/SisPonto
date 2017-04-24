package entity;

import java.util.ArrayList;
import java.util.List;

public class Professor extends Funcionario {

	private List<Curso> cursos;

	public Professor(){
		this.cursos = new ArrayList<>();
	}
	
	@Override
	public String toString() {
		return "Nome: " + getNome() + ", CPF: " + getCpf() + ", Matricula: " + getMatricula() + 
				", Cursos:"	+ this.cursos + ", \nSalário: " + getSalario();
	}

	public List<Curso> getCursos() {
		return cursos;
	}

	public void setCursos(List<Curso> cursos) {
		this.cursos = cursos;
	}

}
