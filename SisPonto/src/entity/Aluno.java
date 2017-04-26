package entity;

import java.util.ArrayList;
import java.util.List;

public class Aluno extends Pessoa {

	private List<Curso> cursos;

	public Aluno() {
		this.cursos = new ArrayList<>();
	}

	@Override
	public String toString() {
		return super.toString() + ", Cursos: " + this.cursos + "\n";
	}

	public List<Curso> getCursos() {
		return cursos;
	}

	public void setCursos(List<Curso> cursos) {
		this.cursos = cursos;
	}

}
