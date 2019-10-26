package co.gestionsoft.persistence.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import co.gestionsoft.persistence.dao.EmpresaDAO;
import co.gestionsoft.persistence.entity.Empresa;

/**
 * 
 * Clase que define los metodos de gestion de empresas
 * 
 * @author james
 * @date 20/10/2019
 * @version 1.0
 * @see
 */
@Repository(value = "empresaDAO")
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
}
