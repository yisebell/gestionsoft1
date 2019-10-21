package gestionsoft.business.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.annotation.Propagation;

import gestionsoft.business.EmpresaService;
import gestionsoft.business.builder.EmpresaBuilder;
import gestionsoft.persistence.dao.EmpresaDAO;
import gestionsoft.persistence.entity.Empresa;
import gestionsoft.util.domain.EmpresaDTO;

/**
 * 
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
	 * 
	 */
	public EmpresaServiceImpl() {
		super();
	}

	@Override
	public List<EmpresaDTO> obtenerEmpresa() {
		List<EmpresaDTO> empresaDTOList = null;
		
		List<Empresa> empresaEntitylist = empresaDAO.obtenerEmpresa();
		
		empresaDTOList = new ArrayList<>();
		for(Empresa empresa : empresaEntitylist) {
			empresaDTOList.add(EmpresaBuilder.convertToDTO(empresa));
		}
		
		return empresaDTOList;
	}

}
