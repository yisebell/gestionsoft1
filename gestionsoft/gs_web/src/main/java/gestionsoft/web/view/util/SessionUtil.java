package gestionsoft.web.view.util;

import java.util.Stack;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import util.domain.AbstractGenericDTO;
import gestionsoft.web.view.session.BackwardState;
import gestionsoft.web.view.session.SessionContainer;



/**
 * Clase que ofrece ciertas utilidades sobre el objeto de session, especialmente, la
 * conservacion del estado de retorno entre pantallas.
 * 
 * @author a586979
 * @date 06/11/2014
 */
public final class SessionUtil {

	// Constante que posee el atributo que se persiste en session.
	private static final String SESSION_CONTAINER_ATTR = "SavaBOSessionContainer";
	
	/**
	 * Constructor por defecto de la clase.
	 */
	private SessionUtil() {
		super();
	}
	

	/**
	 * Metodo que permite obtener el contenedor con la informacion basica de la session.
	 * 
	 * @return contenedor de la session.
	 */
	private static SessionContainer getSessionContainer() {
		SessionContainer sessionContainer = null;
		final HttpSession session = FacesUtil.getSession();
		
		if (session != null) {
			sessionContainer = (SessionContainer) session.getAttribute(SESSION_CONTAINER_ATTR);

			// En caso de que no exista el atributo de session, se crea explicitamente.
			if (sessionContainer == null) {
				sessionContainer = new SessionContainer();
				setSessionContainer(sessionContainer);
			}			
		}
		return sessionContainer;
	}
	
	/**
	 * Metodo que permite establecer el contenedor con la informacion basica de la session.
	 * 
	 * @param sessionContainer contenedor de la session.
	 */
	private static void setSessionContainer(final SessionContainer sessionContainer) {
		final HttpServletRequest request = FacesUtil.getRequest();

		if (request != null) {
			final HttpSession session = request.getSession(false);
			if (session != null) {
				session.setAttribute(SESSION_CONTAINER_ATTR, sessionContainer);
			}
		}
	}		
	
	/**
	 * Metodo que permite establecer en la session la regla de navegacion de retorno.
	 * 
	 * @param backwardNavigationRule regla de navegacion de retorno.
	 * @param filter filtro generico de busqueda.
	 * @param rangoFechas rango de fechas.
	 */
	public static void saveState(final String backwardNavigationRule, final AbstractGenericDTO filter) {
		final SessionContainer container = getSessionContainer();
		container.saveStateBackward(backwardNavigationRule, filter);
	}
	
	/**
	 * Metodo que permite obtener un estado previo almacenado en session. 
	 *
	 * @param remove valor que indica si se debe eliminar o no el estado.
	 * @return estado previo almacenado en session.
	 */
	public static BackwardState getState(final boolean remove) {
		BackwardState state = null;
		
		final SessionContainer sessionContainer = getSessionContainer();
		if (sessionContainer != null) {
			final Stack<BackwardState> backwardStack = sessionContainer.getBackwardStack();
			if (!backwardStack.isEmpty()) {
				if (remove) {
					state = backwardStack.pop();	
				} else {
					state = backwardStack.peek();
				}
			}			
		}
		return state;
	}
	
	/**
	 * Metodo que permite resetear el estado de guardado para navegaciones. 
	 */
	public static void resetState() {
		final SessionContainer sessionContainer = getSessionContainer();
		if (sessionContainer != null) {
			sessionContainer.clear();
		}
	}
	
	
}  // Final SessionUtil.