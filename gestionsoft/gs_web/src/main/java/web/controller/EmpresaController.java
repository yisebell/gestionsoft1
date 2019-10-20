/**
 * 
 */
package web.controller;

import java.util.ArrayList;
import java.util.List;


import javax.faces.bean.ManagedBean;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import business.EmpresaService;
import util.domain.EmpresaDTO;
import web.controller.common.GenericManagedBean;
import web.view.util.FacesUtil;

/**
 * Clase controller para Empresa.
 * 
 * @author james
 * @date 17/10/2019
 * @version 1.0
 * @see
 */
@ManagedBean
@ViewScoped
public class EmpresaController extends GenericManagedBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	// Constante que posee el nombre de localizacion del servicio descuentoService
	private static final String EMPRESA_SERVICE = "empresaService";
	
	// Atributos de la clase.
	@ManagedProperty(name = "empresaService", value = "#{empresaService}")
	private transient EmpresaService empresaService;
	
	// Listas
	private List<EmpresaDTO> empresasSeleccionadas;

	/**
	 * 
	 */
	public EmpresaController() {
		super();
	}
	
	/**
	 * Método inicial
	 */
	@PostConstruct
	public void init() {
		empresasSeleccionadas = getEmpresaService().obtenerEmpresa();
	}
	
	/**
	 * Metodo que permite obtener la propiedad empresaService.
	 * 
	 * @return empresaService propiedad empresaService
	 */
	public EmpresaService getEmpresaService() {
		if (empresaService == null) {
			empresaService = FacesUtil.lookUpBean(EMPRESA_SERVICE, EmpresaService.class);
		}
		return empresaService;
	}

	/**
	 * Metodo que permite establecer la propiedad empresaService.
	 * 
	 * @param empresaService propiedad empresaService
	 */
	public void setEmpresaService(EmpresaService empresaService) {
		this.empresaService = empresaService;
	}
	
	/**
	 * Metodo que permite obtener la propiedad empresasSeleccionadas.
	 * 
	 * @return empresasSeleccionadas propiedad empresasSeleccionadas
	 */
	public List<EmpresaDTO> getEmpresasSeleccionadas()
	{
		if (empresasSeleccionadas == null)
		{
			empresasSeleccionadas = new ArrayList<EmpresaDTO>();
		}
		return empresasSeleccionadas;
	}
	
	/**
	 * Metodo que permite establecer la propiedad empresasSeleccionadas.
	 * 
	 * @param empresasSeleccionadas propiedad empresasSeleccionadas
	 */
	public void setEmpresasSeleccionadas(List<EmpresaDTO> empresasSeleccionadas){
		this.empresasSeleccionadas = empresasSeleccionadas;
	}

}
