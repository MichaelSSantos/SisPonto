package dao;

import java.util.List;

public interface Dao<E> {

	void cadastrar(E entity);
	
	List<E> obterTodos();

}
