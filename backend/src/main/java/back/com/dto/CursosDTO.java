package back.com.dto;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * CursosDTO
 * @author jlrs
 *
 */
public class CursosDTO {

	private Long id;	
	private String nombre;
	private boolean status;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	@NotNull
	@JsonInclude(JsonInclude.Include.NON_NULL)
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@NotNull
	@JsonInclude(JsonInclude.Include.NON_NULL)
	public boolean getStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
	
	
}
