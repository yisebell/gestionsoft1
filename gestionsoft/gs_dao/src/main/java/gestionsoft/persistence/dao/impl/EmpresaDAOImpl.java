/**
 * 
 */
package gestionsoft.persistence.dao.impl;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import gestionsoft.persistence.dao.EmpresaDAO;
import gestionsoft.persistence.dao.exception.GSDAOException;
import gestionsoft.persistence.entity.Empresa;

/**
 * 
 * Clase que define los metodos de gestion de empresas
 * 
 * @author james
 * @date 20/10/2019
 * @version 1.0
 * @see
 */
@Repository("empresaDAO")
public class EmpresaDAOImpl extends AbstractGenericDAOImpl<Empresa> implements EmpresaDAO {

	/**
	 * Constructor
	 */
	public EmpresaDAOImpl() {
		super();
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Empresa> obtenerEmpresa() {
		final Query query = nonXAEntityManager.createQuery("SELECT emp FROM Empresa emp");
		return (List<Empresa>) query.getResultList();
	}

	@Override
	public Empresa obtenerXA(Serializable primaryKey) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Empresa obtenerReferenciaXA(Class<Empresa> clazz, Serializable primaryKey) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void crearXA(Empresa entity) throws GSDAOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Empresa actualizarXA(Empresa entity) throws GSDAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void eliminarXA(Empresa entity) throws GSDAOException {
		// TODO Auto-generated method stub
		
	}

}
