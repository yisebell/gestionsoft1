package web.view.util;

import java.util.Map;

import javax.el.ELContext;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIViewRoot;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Clase de utilidad que permite el acceso al contexto faces, contexto external, objetos de
 * peticion y respuesta, etc.
 * 
 * @author james
 * @date 20/10/2019
 * @version 1.0
 * @see
 */
public final class FacesUtil {

	/**
	 * Constructor privado de la clase para evitar la instanciacion.
	 */
	private FacesUtil() {
		super();
	}

	/**
	 * Metodo que permite obtener el contexto externo sobre el que existe
	 * el contexto faces, de forma que facilite la obtencion de los elementos
	 * que corren sobre el servlet container (request, response, session, servlet
	 * context, etc).
	 *
	 * @return contexto externo.
	 */
	public static ExternalContext getExternalContext() {
		ExternalContext externalContext = null;
		
		if (FacesContext.getCurrentInstance() != null) {
			externalContext = FacesContext.getCurrentInstance().getExternalContext();
		}
		return externalContext;
	}
	
    /**
     * Metodo que permite obtener el contexto del servlet de faces.
     * 
     * @return contexto del servlet de faces.
     */
    public static final ServletContext getServletContext() {
        ServletContext servletContext = null;
        
        final ExternalContext ec = getExternalContext();

        if (null != ec && null != ec.getContext()) {
            servletContext = (ServletContext) ec.getContext();
        }
        return servletContext;
    }	
	
    /**
     * Metodo que permite obtener la session a la que se encuentra asociada la
     * peticion. Se obtiene del contexto faces, por lo que solo se podra acceder
     * a este metodo a partir de la fase 1 (antes, contexto no inicializado y 
     * obtencion de null value).
     * 
     * @return objeto de session.
     */
    public static final HttpSession getSession() {
        HttpSession session = null;

        final HttpServletRequest requestServlet = getRequest();
        if (requestServlet != null) {
            session = requestServlet.getSession(false);
        }
        return session;
    }    
    
	/**
	 * Metodo que permite obtener el objeto de peticion del contexto externo.
	 * 
	 * @return objeto de peticion.
	 */
	public static HttpServletRequest getRequest() {
        HttpServletRequest request = null;
        
        final ExternalContext ec = getExternalContext();
        
        if (null != ec && null != ec.getRequest()) {
        	request = (HttpServletRequest) ec.getRequest();
        }
        return request;
	}

	/**
	 * Metodo que permite obtener un parametro contenido en el parameter map del objeto
	 * de peticion.
	 * 
	 * @params paramName nombre del parametro.
	 * @return valor del parametro.
	 */
    public static final String getRequestParameter(final String paramName) {
        String value = null;

        final ExternalContext externalContext = getExternalContext();
        
        if (externalContext != null) {            

            final Map<String, String> params = externalContext.getRequestParameterMap();
            if (params != null) {
                value = params.get(paramName);
            }
        }
        return value;
    } 	
	
    /**
     * Metodo que permite obtener el objeto de respuesta del contexto externo.
     * 
     * @return objeto de response.
     */
    public static final HttpServletResponse getResponse() {
        HttpServletResponse response = null;
        
        final ExternalContext externalContext = getExternalContext();

        if (externalContext != null) {
        	response = (HttpServletResponse) externalContext.getResponse();
        }
        return response;
    }	
    
    /**
     * Metodo que permite establecer como atributo de peticion un determinado valor, ya que los controladores
     * son de ambito View y la inyeccion de los mismos entre ellos origina que se destruyan al navegar y 
     * crearse por duplicados.
     * 
     * @param attName nombre del atributo.
     * @param attValue valor del atributo.
     */
    public static final void putRequestAttribute(final String attName, final Object attValue) {
    	
    	final ExternalContext externalContext = getExternalContext();
    	
    	if (externalContext != null) {
    		externalContext.getSessionMap().put(attName, attValue);        	
        } 
    }    
	
    /**
     * Metodo que permite obtener el valor de un atributo de peticion.
     * 
     * @param attName nombre del atributo.
     * @return valor del atributo.
     */
    public static final Object getRequestAttribute(final String attName) {
        Object value = null;

        final ExternalContext externalContext = getExternalContext();
        
        if (externalContext != null) {
            final Map<String, Object> params = externalContext.getSessionMap();
            if (params != null) {
                value = params.get(attName);
                params.remove(attName);
            }
        }
        return value;
    }    

    /**
     * Metodo que permite recuperar el identificador de la vista actual.
     * 
     * @return identificador de la vista actual.
     */
    public static final String getCurrentViewId() {
        String viewId = null;

        final UIViewRoot viewRoot = FacesContext.getCurrentInstance().getViewRoot();
        if (viewRoot != null) {
            viewId = viewRoot.getViewId();
        }
        return viewId;
    }

    /**
     * Metodo que permite obtener una instancia de un controlador o componente de
     * servicio utilizado en la aplicacion.
     * 
     * @param beanName nombre del bean que se desea obtener.
     * @return objeto de la instancia buscada.
     */
    public static final <T> T lookUpBean(final String beanName, Class<T> clazz) {
        T bean = null;
        if (beanName != null) {
        	final ELContext elContext = FacesContext.getCurrentInstance().getELContext();
            Object aux = elContext.getELResolver().getValue(elContext, null, beanName);
            
            if (aux != null) {
            	if (clazz.isInstance(aux)) {
            		bean = clazz.cast(aux);
            	} else {
            		final StringBuilder builder = new StringBuilder();
            		builder.append("Incoherencia de tipos entre el Bean '");
            		builder.append(beanName);
            		builder.append("' y el tipo ");
            		builder.append(clazz.getName());
            		throw new IllegalArgumentException(builder.toString());
            	}
            }
        }
        return bean; 
    }
	
    /**
     * Metodo que permite anyadir un mensaje en la pantalla.
     * 
     * @param message mensaje que se desea mostrar por pantalla.
     */
    public static void addMessage(final String message) {
		final FacesContext context = FacesContext.getCurrentInstance();
		final FacesMessage facesMessage = new FacesMessage();
		facesMessage.setSeverity(FacesMessage.SEVERITY_ERROR);
		facesMessage.setSummary(message);
		context.addMessage(null,  facesMessage);
    }
    
    /**
     * Metodo que permite anyadir un mensaje en la pantalla. 
     *
     * @param severity severidad del mensaje
     * @param message mensaje
     */
	public static void addMessage(final FacesMessage.Severity severity, final String message) {
		final FacesContext context = FacesContext.getCurrentInstance();
		final FacesMessage facesMessage = new FacesMessage();
		facesMessage.setSeverity(severity);
		facesMessage.setSummary(message);
		context.addMessage(null,  facesMessage);	
	}
	
	/**
     * Metodo que permite anyadir un mensaje en la pantalla para un elemento concreto. 
     *
     * @param severity severidad del mensaje
     * @param message mensaje
     * @param componentId id del componente
     */
	public static void addMessage(final FacesMessage.Severity severity, final String message, final String componentId) {
		final FacesContext context = FacesContext.getCurrentInstance();
		final FacesMessage facesMessage = new FacesMessage();
		facesMessage.setSeverity(severity);
		facesMessage.setSummary(message);
		context.addMessage(componentId,  facesMessage);	
	}
    
	
	
	 /**
     * Metodo que permite saber si la pagina termina en _SA o no
     * lo que determinaría si es con accesibilidad de Agente
     * 
     * Este es el caso de paginas duplicadas con terminacion _sa 
	 * pues tienen el mismo controller pues la unica diferencia es
	 * si provienen del menu generico o del menu agente
     * por agente
     * 
     * @return true(accesibilidad Agente) false (accesibilidad generica)
     */
    public static final Boolean isPaginaAgente() {
        Boolean res = true;
    	String pagActual=getCurrentViewId();
		 if (pagActual != null && pagActual.endsWith("_sa.xhtml")){
			 res = false;
		 }
		 return res;
    }

    
}  // Final FacesUtil.
