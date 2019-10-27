package co.gestionsoft.business.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import co.gestionsoft.business.EmpresaService;
import co.gestionsoft.business.builder.EmpresaBuilder;
import co.gestionsoft.persistence.dao.EmpresaDAO;
import co.gestionsoft.persistence.entity.Empresa;
import co.gestionsoft.util.domain.EmpresaDTO;

/**
 * Clase que implementa la interfaz de EmpresaService
 * 
 * @author james
 * @date 17/10/2019
 * @version 1.0
 * @see
 */
@Service("empresaService")
@Transactional(propagation = Propagation.SUPPORTS)
public class EmpresaServiceImpl extends GenericServiceImpl implements EmpresaService {
	
	@Autowired
	@Qualifier("empresaDAO")
	private EmpresaDAO empresaDAO;

	/**
	 * Metodo constructor
	 */
	public EmpresaServiceImpl() {
		super();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<EmpresaDTO> obtenerEmpresas() {
		List<EmpresaDTO> empresaDTOList = null;
		
		List<Empresa> empresaEntitylist = empresaDAO.obtenerEmpresa();
		
		empresaDTOList = new ArrayList<>();
		// Recorremos la lista de entidades y las convertimos
		// en objetos dto
		for(Empresa empresa : empresaEntitylist) {
			empresaDTOList.add(EmpresaBuilder.convertToDTO(empresa));
		}
		
		return empresaDTOList;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public EmpresaDTO obtener(long idEmpresa) {
		Empresa empresa = empresaDAO.obtener(idEmpresa);
		// Retornamos el objeto dto
		return EmpresaBuilder.convertToDTO(empresa);
	}

} // Fin class EmpresaServiceImpl
