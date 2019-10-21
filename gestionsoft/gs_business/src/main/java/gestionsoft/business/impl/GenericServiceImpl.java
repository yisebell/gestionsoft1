package gestionsoft.business.impl;

import java.util.HashSet;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;

import gestionsoft.business.GenericService;
import gestionsoft.util.domain.AbstractGenericDTO;

/**
 * Clase que representa la generalizacion de los servicios de negocio para la implementacion de los
 * casos de uso.
 * 
 * @author a586979
 * @date 18/11/2014
 * @version 1.0
 * @see
 */
public abstract class GenericServiceImpl implements GenericService {

	@Autowired(required = true)
	protected Validator validator;
	
	/**
	 * Constructor por defecto de la clase.
	 */
	public GenericServiceImpl() {
		super();
	}
	
	protected void validateDomainEntity(final String errorCode, final Class<?> group, final AbstractGenericDTO ...domainEntities) throws Exception {
		final Set<ConstraintViolation<AbstractGenericDTO>> validationCompositionErrors = new HashSet<ConstraintViolation<AbstractGenericDTO>>();

		for (AbstractGenericDTO entity : domainEntities) {
			// Se realiza la validacion de la entidad de dominio.
			validationCompositionErrors.addAll(validator.validate(entity, group));			
		}
		
		// Se revisa si existen o no errores.
        if (!validationCompositionErrors.isEmpty()) { 	
            throw new Exception("Error en la validacion de la entidad de dominio");
        }
	}

	
}  // Final GenericServiceImpl.