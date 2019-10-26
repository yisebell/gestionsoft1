package co.gestionsoft.business;

import java.util.List;

import co.gestionsoft.util.domain.EmpresaDTO;

/**
 * 
 * Interfaz de Empresa
 * 
 * @author james
 * @date 17/10/2019
 * @version 1.0
 * @see
 */
public interface EmpresaService {
	
	/**
	 * Mètodo para obtener la lista de empresas
	 * 
	 */
	List<EmpresaDTO> obtenerEmpresa();
	
	/**
	 * Mètodo para obtener la empresa
	 * 
	 */
	EmpresaDTO obtener(long idEmpresa);

}
