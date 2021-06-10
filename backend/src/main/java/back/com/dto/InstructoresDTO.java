package back.com.dto;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * InstructoresDTO
 * @author jlrs
 *
 */
public class InstructoresDTO {

	private Long id;	
	private String nombre;
	private String apellido;
	private Long telefono;
	private String email;
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
	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	@NotNull
	@JsonInclude(JsonInclude.Include.NON_NULL)
	public Long getTelefono() {
		return telefono;
	}

	public void setTelefono(Long telefono) {
		this.telefono = telefono;
	}

	@NotNull
	@JsonInclude(JsonInclude.Include.NON_NULL)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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
