package co.gestionsoft.web.listener;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

/**
 * Clase que implementa el listener del ciclo de vida de faces.
 * 
 * @author james
 * @date 08/10/2014 
 * @version 1.0
 * @see
 */
public final class GSPhaseListener implements PhaseListener {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final String SESSION_TOKEN = "MULTI_PAGE_MESSAGES_SUPPORT";
	
	public GSPhaseListener() {
		super();
	}
	
	/**
	 * {@inheritDoc}
	 */	
	public void afterPhase(final PhaseEvent event) {
      if (!PhaseId.RENDER_RESPONSE.equals(event.getPhaseId())) {
            FacesContext facesContext = event.getFacesContext();
            this.saveMessages(facesContext);
        }
	}

	/**
	 * {@inheritDoc}
	 */	
	public void beforePhase(final PhaseEvent event) {
	       FacesContext facesContext = event.getFacesContext();
	        this.saveMessages(facesContext);
	 
	        if (PhaseId.RENDER_RESPONSE.equals(event.getPhaseId()) 
	        		&& !facesContext.getResponseComplete()){
	            this.restoreMessages(facesContext);
	        }
	}

	/**
	 * Metodo que permite obtener el identificador por defecto de las fases que
	 * se van a evaluar.
	 * 
	 * @return identificador de la fase que se va evaluar.
	 */
	public PhaseId getPhaseId() {
		return PhaseId.ANY_PHASE;
	}

    @SuppressWarnings("unchecked")
    private int saveMessages(final FacesContext facesContext)
    {
        List<FacesMessage> messages = new ArrayList<FacesMessage>();
        for (Iterator<FacesMessage> iter = facesContext.getMessages(null); iter.hasNext();)
        {
            messages.add(iter.next());
            iter.remove();
        }
 
        if (messages.isEmpty())
        {
            return 0;
        }
 
        Map<String, Object> sessionMap = facesContext.getExternalContext().getSessionMap();
        List<FacesMessage> existingMessages = (List<FacesMessage>) sessionMap.get(SESSION_TOKEN);
        if (existingMessages != null)
        {
            existingMessages.addAll(messages);
        }
        else
        {
            sessionMap.put(SESSION_TOKEN, messages);
        }
        return messages.size();
    }
 
    @SuppressWarnings("unchecked")
    private int restoreMessages(final FacesContext facesContext)
    {
        Map<String, Object> sessionMap = facesContext.getExternalContext().getSessionMap();
        List<FacesMessage> messages = (List<FacesMessage>) sessionMap.remove(SESSION_TOKEN);
 
        if (messages == null)
        {
            return 0;
        }
 
        int restoredCount = messages.size();
        for (FacesMessage element : messages)
        {
            facesContext.addMessage(null, element);
        }
        return restoredCount;
    }	
	
}  // Final SavaPhaseListener.
