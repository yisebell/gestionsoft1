/**
 * 
 */
package persistence.dao.impl;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import persistence.dao.EmpresaDAO;
import persistence.dao.exception.GSDAOException;
import persistence.entity.Empresa;
import util.domain.EmpresaDTO;

/**
 * 
 * Clase que define los metodos de gestion de empresas
 * 
 * @author james
 * @date 20/10/2019
 * @version 1.0
 * @see
 */
@Repository
public final class EmpresaDAOImpl extends AbstractGenericDAOImpl<Empresa> implements EmpresaDAO {

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
