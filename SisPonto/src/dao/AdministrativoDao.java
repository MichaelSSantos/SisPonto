package dao;

import java.util.ArrayList;
import java.util.List;

import entity.Funcionario;

public class AdministrativoDao implements GenericDao<Funcionario> {

	private List<Funcionario> administrativos = new ArrayList<>();
	
	@Override
	public void cadastrar(Funcionario funcionario) {
		administrativos.add(funcionario);
	}

}
