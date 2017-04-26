package service;

import java.util.Scanner;

import dao.AdministrativoDao;
import dao.Dao;
import entity.Funcionario;
import exceptions.SalarioInvalidoException;

public class CadastroAdministrativoService implements SisPontoService {

	@Override
	public void execute() {

		Scanner in = new Scanner(System.in);

		Funcionario administrativo = new Funcionario();
		Dao<Funcionario> administrativoDao = AdministrativoDao.getDao();

		System.out.println("\n--Cadastro de administrativo--");
		System.out.print("-Informe o nome: ");
		administrativo.setNome(in.nextLine());
		System.out.print("-Informe o CPF: ");
		administrativo.setCpf(in.nextLine());
		System.out.print("-Informe a matr�cula: ");
		administrativo.setMatricula(in.nextLine().trim());
		administrativo.setSalario(inserirSalario());

		System.out.println("\n" + administrativo.toString());
		administrativoDao.cadastrar(administrativo);
	}

	private Double inserirSalario() {
		try {
			System.out.print("-Informe o sal�rio: ");
			Double salario = Double.valueOf(new Scanner(System.in).nextLine());

			if (salario <= 0.0)
				throw new SalarioInvalidoException("O sal�rio n�o pode ser um valor negativo.");

			return salario;
		} catch (NumberFormatException e) {
			System.out.println("O sal�rio deve ser um valor num�rico.");
			return inserirSalario();

		} catch (SalarioInvalidoException e) {
			System.out.println(e.getMessage());
			return inserirSalario();
		}
	};

}
