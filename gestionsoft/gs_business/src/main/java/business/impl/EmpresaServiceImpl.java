/**
 * 
 */
package business.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.annotation.Propagation;

import business.EmpresaService;
import business.builder.EmpresaBuilder;
import persistence.dao.EmpresaDAO;
import persistence.entity.Empresa;
import util.domain.EmpresaDTO;

/**
 * 
 * Clase que implementa la interfaz de EmpresaService
 * 
 * @author james
 * @date 17/10/2019
 * @version 1.0
 * @see
 */
@Service(value = "empresaService")
@Transactional(propagation = Propagation.SUPPORTS)
public class EmpresaServiceImpl extends GenericServiceImpl implements EmpresaService {
	
	@Autowired
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
