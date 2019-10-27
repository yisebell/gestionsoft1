package co.gestionsoft.persistence.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

import org.springframework.stereotype.Repository;

import co.gestionsoft.persistence.dao.GenericDAO;
import co.gestionsoft.persistence.dao.exception.GSDAOException;


/**
 * Clase que implementa la interface generica del DAO de la aplicacion.
 * 
 * @author james
 * @date 20/10/2019
 * @version 1.0
 * @see
 */
@Repository
public abstract class AbstractGenericDAOImpl<T extends Serializable> implements GenericDAO<T> {

	// Constante con el simbolo de porcentaje como comodin de busquedas.
	protected static final String PORCENTAJE = "%";	
	
	// Atributos de la clase.
	@PersistenceContext(unitName = "PU_GS_NOXA", type = PersistenceContextType.TRANSACTION)
	protected EntityManager nonXAEntityManager;
	
	/**
	 * Constructor por defecto de la clase.
	 */
	public AbstractGenericDAOImpl() {
		super();
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public T obtener(final Serializable primaryKey) {
		T entity = null;

		if (primaryKey != null) {
			entity = nonXAEntityManager.find(getDaoGenericType(), primaryKey);
		}	
		return entity;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public T obtenerReferencia(final Class<T> clazz, final Serializable primaryKey) {
		T entity = null;

		if (primaryKey != null) {
			entity = nonXAEntityManager.getReference(clazz, primaryKey);
		}	
		return entity;	
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void crear(final T entity) throws GSDAOException {
		nonXAEntityManager.persist(entity);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public T actualizar(final T entity) throws GSDAOException {
		return nonXAEntityManager.merge(entity);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void eliminar(final T entity) throws GSDAOException {
		nonXAEntityManager.remove(entity);
	}

	/**
	 * Metodo que permite obtener el tipo de dato que se esta gestionando de forma
	 * generica en la ejecucion de alguno de los metodos tipados del dao.
	 * 
	 * @return tipo de dato generico empleado.
	 */
	@SuppressWarnings("unchecked")
	private Class<T> getDaoGenericType() {
	    final Type type = getClass().getGenericSuperclass();
        final ParameterizedType parameterizedType = (ParameterizedType) type;
        return (Class<T>) parameterizedType.getActualTypeArguments()[0];	    
	}		
	
}  // Final GenericDAOImpl.
