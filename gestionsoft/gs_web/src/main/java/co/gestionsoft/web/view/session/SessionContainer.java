package co.gestionsoft.web.view.session;

import java.util.Stack;

import co.gestionsoft.util.domain.AbstractGenericDTO;


/**
 * Clase que representa a un contenedor para su persistencia en HTTPSession.
 * 
 * @author a586979
 * @date 06/12/2014
 */
public final class SessionContainer {

	// Atributos de la clase.
	private Stack<BackwardState> backwardStack;
	
	/**
	 * Constructor por defecto de la clase.
	 */
	public SessionContainer() {
		super();
		
		backwardStack = new Stack<BackwardState>();
	}

	/**
	 * Metodo que permite guardar el estado en una pantalla con la regla de navegacion de retorno y 
	 * el filtro empleado en dicha pantalla.
	 * 
	 * @param backwardNavigationRule regla de navegacion.
	 */
	public void saveStateBackward(final String backwardNavigationRule, final AbstractGenericDTO filter) {
		backwardStack.push(new BackwardState(backwardNavigationRule, filter));
	}

	/**
	 * Metodo que permite eliminar la totalidad de estados de navegacion almacenadas en session. 
	 * 
	 * Es idoneo para los casos en los que se quiere romper con la secuencia de navegacion 
	 * y recordatorios entre pantallas, por ejemplo, al seleccionar una nueva opcion de menu.
	 */
	public void clear() {
		backwardStack.clear();
	}

	/**
	 * Metodo que permite obtener la pila de estados.
	 *
	 * @return backwardStack pila de estados.
	 */
	public Stack<BackwardState> getBackwardStack() {
		return backwardStack;
	}

	/**
	 * Metodo que permite establecer la pila de estados.
	 *
	 * @param backwardStack pila de estados.
	 */
	public void setBackwardStack(final Stack<BackwardState> backwardStack) {
		this.backwardStack = backwardStack;
	}
	
}  // Final SessionContainer.
