package br.com.veritech.igreja.jovens.services.interfaces;

import java.io.Serializable;
import java.util.List;

	
public interface IBaseRepository<T, ID> extends Serializable {
	T buscarPorId(ID entidade);
	List<T> buscarTodos();
	void salvar(T tipo);
	void remover(T tipo);
	T atualizar(T tipo);
	void sincronizarBanco();
	void limparCache();
}