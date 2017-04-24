package entity;

public class Curso {

	private String nome;
	private Integer horas;

	@Override
	public String toString() {
		return "\nCurso: " + this.nome + ", Carga horária: " + this.horas + " horas";
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getHoras() {
		return horas;
	}

	public void setHoras(Integer horas) {
		this.horas = horas;
	}

}
