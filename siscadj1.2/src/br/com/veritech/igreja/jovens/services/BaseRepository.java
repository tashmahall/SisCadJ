package br.com.veritech.igreja.jovens.services;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.veritech.igreja.jovens.services.interfaces.IBaseRepository;

public abstract class BaseRepository<T, ID> implements IBaseRepository<T, ID> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static final Logger log = LoggerFactory.getLogger(BaseRepository.class);
	
	@PersistenceContext(unitName="IgrejaDB",type=PersistenceContextType.TRANSACTION)
	protected EntityManager entityManager;
	
	private Class<T> persistenceClazz;

	public T buscarPorId(ID entidade) {
		return entityManager.find(getPersistenceClass(), entidade);
	}
	
	@SuppressWarnings("unchecked")
	public List<T> buscarTodos() {
		List<T> retorno = entityManager.createQuery("SELECT c FROM " + getPersistenceClass().getSimpleName() + " c").getResultList();
		return retorno;
	}
	
	@Override
	public void salvar(T tipo) {
		entityManager.persist(tipo);
		log.debug("Objeto "+ tipo.getClass().getSimpleName() + " salvo com sucesso");
	}

	@Override
	public void remover(T tipo) {
		entityManager.remove(entityManager.merge(tipo));
		log.debug("Objeto "+ tipo.getClass().getSimpleName() + " removido com sucesso");
	}

	@Override
	public T atualizar(T tipo) {
		T retorno = entityManager.merge(tipo);
		log.debug("Objeto "+ tipo.getClass().getSimpleName() + " atualizado com sucesso");
		return retorno;
	}

	@Override
	public void sincronizarBanco() {
		entityManager.flush();
		log.debug("Sincronizacao com o banco de dados realizada com sucesso");
	}
	
	@Override
	public void limparCache() {
		entityManager.clear();
		log.debug("Remocao dos objetos do cache de 1o nivel realizada com sucesso");
	}

	@SuppressWarnings("unchecked")
	protected Class<T> getPersistenceClass() {
		if (persistenceClazz == null) {
			persistenceClazz = (Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
		}
		return persistenceClazz;
	}
}