package gestionsoft.persistence.dao;


import java.io.Serializable;

import gestionsoft.persistence.dao.exception.GSDAOException;


/**
 * Interface que define los metodos comunes para todos los componentes de tipo DAO.
 * 
 * @author a586979
 * @date 10/11/2014
 * @version 1.0
 * @see
 */
public interface GenericDAO<Entity extends Serializable> {

	/**
	 * Metodo que permite realizar la busqueda de una entidad a partir de su clave primaria.
	 *
	 * @param primaryKey clave primaria.
	 * @return entidad que corresponde con su clave primaria o valor nulo si no existe.
	 */
	Entity obtener(Serializable primaryKey);

	/**
	 * Metodo que permite realizar la busqueda de una entidad a partir de su clave primaria
	 * empleando un driver XA.
	 *
	 * @param primaryKey clave primaria.
	 * @return entidad que corresponde con su clave primaria o valor nulo si no existe.
	 */	
	Entity obtenerXA(Serializable primaryKey);
	
	/**
	 * Metodo que permite realizar la busqueda de una referencia a partir de la clave primaria
	 * de la entidad.
	 * 
	 * Si la instancia existe en el persistence context, logicamente, sera cargada. En otro
	 * caso, devolvera el correspondiente proxy sin hacer hit sobre la base de datos.
	 * 
	 * @param clazz clase de la entidad.
	 * @param primaryKey clave primaria.
	 * @return entidad que corresponde con su clave primaria o valor nulo si no existe.
	 */	
	Entity obtenerReferencia(Class<Entity> clazz, Serializable primaryKey);
	
	/**
	 * Metodo que permite realizar la busqueda de una referencia a partir de la clave primaria
	 * de la entidad empleando para ello un driver XA.
	 * 
	 * Si la instancia existe en el persistence context, logicamente, sera cargada. En otro
	 * caso, devolvera el correspondiente proxy sin hacer hit sobre la base de datos.
	 * 
	 * @param clazz clase de la entidad.
	 * @param primaryKey clave primaria.
	 * @return entidad que corresponde con su clave primaria o valor nulo si no existe.
	 */		
	Entity obtenerReferenciaXA(Class<Entity> clazz, Serializable primaryKey);
	
	/**
	 * Metodo que permite realizar la persistencia de una entidad.
	 *
	 * @param entity entidad que se desea persistir.
	 */
    void crear(Entity entity) throws GSDAOException;
    
    /**
     * Metodo que permite realizar la persistencia de una entidad mediante driver XA. 
     *
	 * @param entity entidad que se desea persistir.
     */
    void crearXA(Entity entity) throws GSDAOException;
    
    /**
     * Metodo que permite realizar la actualizacion de una entidad.
     *
     * @param entity entidad que se desea actualizar.
     */
    Entity actualizar(Entity entity) throws GSDAOException;

    /**
     * Metodo que permite realizar la actualizacion de una entidad mediante driver XA.
     *
     * @param entity entidad que se desea actualizar.
     */    
    Entity actualizarXA(Entity entity) throws GSDAOException;
    
    /**
     * Metodo que permite eliminar físicamente una entidad persistida anteriormente.
     * 
     * @param entity entidad que se pretende eliminar en el modelo de datos.
     */
    void eliminar(Entity entity) throws GSDAOException;
	
    /**
     * Metodo que permite eliminar físicamente una entidad persistida anteriormente mediante driver XA.
     * 
     * @param entity entidad que se pretende eliminar en el modelo de datos.
     * @return entidad eliminada en el modelo de datos.
     */
    void eliminarXA(Entity entity) throws GSDAOException;
    
	
    
	
}  // Final GenericDAO.