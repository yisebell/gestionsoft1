package co.gestionsoft.web.controller.common;

import java.io.Serializable;
import java.util.ResourceBundle;
/**
 * Clase que representa el controlador generico faces y que sera extendido por aquellos 
 * managed beans que requieran tener un scope de tipo vista o session.
 * 
 * @author a586979
 * @date 11/11/2014
 * @version 1.0
 * @see
 */
public abstract class GenericManagedBean implements Serializable {

	// Identificador de Serial Version.
	private static final long serialVersionUID = 1L;
	
	// Constante que define la ruta del recurso de mensajes.
	protected static final String MESSAGE_RESOURCE = "co.gestionsoft.web.view.messages";
	
	// Resource Bundle para la gestion de los mensajes de error.
	protected static final ResourceBundle BUNDLE = ResourceBundle.getBundle(MESSAGE_RESOURCE);	
	
	// Constante numerica de valor cero.
	protected static final Long ZERO_AS_VALUE = Long.valueOf(0);
	
	// Atributos de la clase.
	protected boolean loadSuccess;
	
	/**
	 * Constructor por defecto de la clase.
	 */
	public GenericManagedBean() {
		super();
	}
	
	/**
     * Metodo que permite conocer si la pagina ha cargado correctamente.  
     *
     * @return valor que indica si la pagina ha cargado correctamente.
     */
	public boolean isLoadSuccess() {
		return loadSuccess;
	}	

}  // Final GenericManagedBean.
