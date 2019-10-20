package business.builder;

import persistence.entity.Empresa;
import util.domain.EmpresaDTO;

/**
 * Clase que implementa el builder para la transformacion de entidades de persistencia para las empresas
 * 
 * @author james
 * @date 20/10/2019
 * @version 1.0
 * @see
 */
public final class EmpresaBuilder {

	/**
	 * 
	 * Metodo que convierte un objeto de tipo entity de Empresa en un objeto de tipo DTO de EmpresaDTO
	 * 
	 * @param entity
	 *            Objeto de tipo entity de Empresa
	 * @return Devuelve un objeto de tipo DTO de EmpresaDTO
	 */
	public static EmpresaDTO convertToDTO(final Empresa entity) {
		
		EmpresaDTO dto = null;
		
		if(entity != null) {
			dto = new EmpresaDTO();
			
			dto.setIdEmpresa(entity.getIdEmpresa());
			dto.setNit(entity.getNit());
			dto.setRazonSocial(entity.getRazonSocial());
			dto.setSigla(entity.getSigla());
			dto.setPrefijo(entity.getPrefijo());
			dto.setDireccion(entity.getDireccion());
			dto.setDepartamento(entity.getDepartamento());
			dto.setCiudad(entity.getCiudad());
			dto.setTelefono(entity.getTelefono());
			dto.setLogo(entity.getLogo());
			dto.setMision(entity.getMision());
			dto.setVision(entity.getVision());
			dto.setValores(entity.getValores());
			dto.setSlogan(entity.getSlogan());
		}
		
		return dto;
	}

}
