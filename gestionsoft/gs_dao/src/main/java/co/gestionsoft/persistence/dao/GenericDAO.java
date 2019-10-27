package co.gestionsoft.persistence.dao;


import java.io.Serializable;

import co.gestionsoft.persistence.dao.exception.GSDAOException;


/**
 * Interface que define los metodos comunes para todos
 * los componentes de tipo DAO.
 * 
 * @author james
 * @date 22/10/2019
 * @version 1.0
 * @see
 */
public interface GenericDAO<T extends Serializable> {

	/**
	 * Metodo que permite realizar la busqueda de una entidad
	 * a partir de su clave primaria.
	 *
	 * @param primaryKey clave primaria.
	 * @return entidad que corresponde con su clave primaria o valor nulo si no existe.
	 */
	T obtener(Serializable primaryKey);

	/**
	 * Metodo que permite realizar la busqueda de una referencia
	 * a partir de la clave primaria de la entidad.
	 * 
	 * Si la instancia existe en el persistence context, 
	 * logicamente, sera cargada. En otro caso, 
	 * devolvera el correspondiente proxy sin hacer hit sobre la base de datos.
	 * 
	 * @param clazz clase de la entidad.
	 * @param primaryKey clave primaria.
	 * @return entidad que corresponde con su clave primaria o valor nulo si no existe.
	 */	
	T obtenerReferencia(Class<T> clazz, Serializable primaryKey);
	
	/**
	 * Metodo que permite realizar la persistencia de una entidad.
	 *
	 * @param entity entidad que se desea persistir.
	 */
    void crear(T entity) throws GSDAOException;
    
    /**
     * Metodo que permite realizar la actualizacion de una entidad.
     *
     * @param entity entidad que se desea actualizar.
     */
    T actualizar(T entity) throws GSDAOException;

    /**
     * Metodo que permite eliminar físicamente una entidad persistida anteriormente.
     * 
     * @param entity entidad que se pretende eliminar en el modelo de datos.
     */
    void eliminar(T entity) throws GSDAOException;
		
}  // Final GenericDAO.