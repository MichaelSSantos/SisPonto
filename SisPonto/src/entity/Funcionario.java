package entity;

public class Funcionario extends Pessoa{

	private Double salario;

	@Override
	public String toString() {
		return super.toString() + ", Sal�rio: " + salario + "\n";
	}

	public Double getSalario() {
		return salario;
	}

	public void setSalario(Double salario) {
		this.salario = salario;
	}

}
