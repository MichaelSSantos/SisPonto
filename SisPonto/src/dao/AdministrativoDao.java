package dao;

import java.util.ArrayList;
import java.util.List;

import entity.Funcionario;

public class AdministrativoDao implements Dao<Funcionario> {

	private static AdministrativoDao uniqueInstance;

	private AdministrativoDao() {
	}

	public static AdministrativoDao getDao() {
		return (uniqueInstance == null) ? uniqueInstance = new AdministrativoDao() : uniqueInstance;
	}

	private List<Funcionario> administrativos = new ArrayList<>();

	@Override
	public void cadastrar(Funcionario funcionario) {
		administrativos.add(funcionario);
	}

	@Override
	public List<Funcionario> obterTodos() {
		return administrativos;
	}

}
