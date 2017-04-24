package entity;

public abstract class Pessoa {

	private String nome;
	private String cpf;
	private String matricula;

	@Override
	public String toString() {
		return "Nome: " + this.nome + ", CPF: " + this.cpf + ", Matricula: " + this.matricula;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

}
