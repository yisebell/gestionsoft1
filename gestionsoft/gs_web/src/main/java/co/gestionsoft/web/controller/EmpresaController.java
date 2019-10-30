package co.gestionsoft.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import co.gestionsoft.business.EmpresaService;
import co.gestionsoft.util.domain.EmpresaDTO;
import co.gestionsoft.util.utilidades.Utilidades;
import co.gestionsoft.web.controller.common.GenericManagedBean;
import co.gestionsoft.web.view.util.FacesUtil;

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
	private static final long ID_EMPRESA = 1L;
	
	// Atributos de la clase.
	@Autowired
	@Qualifier(EMPRESA_SERVICE)
	private transient EmpresaService empresaService;
	
	// Listas
	private List<EmpresaDTO> empresasSeleccionadas;
	private EmpresaDTO empresa;

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
		empresa = getEmpresaService().obtener(ID_EMPRESA);
	}
	
	/**
	 * Metodo que permite obtener la propiedad empresaService.
	 * 
	 * @return empresaService propiedad empresaService
	 */
	public EmpresaService getEmpresaService() {
		if(Utilidades.isNull(empresaService)) {
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
	
	public EmpresaDTO getEmpresa() {
		return empresa;
	}

	public void setEmpresa(EmpresaDTO empresa) {
		this.empresa = empresa;
	}

}
