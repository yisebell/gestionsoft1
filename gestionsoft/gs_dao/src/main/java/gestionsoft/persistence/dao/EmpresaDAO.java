package gestionsoft.persistence.dao;

import java.util.List;

import gestionsoft.persistence.entity.Empresa;

/**
 * 
 * Interface que define los metodos de acceso a la entidad de persistencia de empresas.
 * 
 * @author james
 * @date 20/10/2019
 * @version 1.0
 * @see
 */
public interface EmpresaDAO extends GenericDAO<Empresa>{	
	
	List<Empresa> obtenerEmpresa();

}
