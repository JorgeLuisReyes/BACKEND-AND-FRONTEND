package back.com.dto;

import java.util.Date;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * DetallesCursoDTO
 * @author jlrs
 *
 */
public class DetallesCursoDTO {
	
    private Long id;
    private String seccion;
	private Long dias;
    private String horaInicio;
    private String horaFin;
    private Date fechaInicio;
    private Date fechaFin;
    private boolean status;
	
    private Long idCursos;
    private Long idInstructores;
    
    private String nombreCurso;
    private String nombreInstructor;
    
    @JsonInclude(JsonInclude.Include.NON_NULL)
	public Long getId() {
		return id;
	}
    
	public void setId(Long id) {
		this.id = id;
	}
	
	@NotNull
	@JsonInclude(JsonInclude.Include.NON_NULL)
	public String getSeccion() {
		return seccion;
	}
	
	public void setSeccion(String seccion) {
		this.seccion = seccion;
	}
	
	@NotNull
	@JsonInclude(JsonInclude.Include.NON_NULL)
	public Long getDias() {
		return dias;
	}
	
	public void setDias(Long dias) {
		this.dias = dias;
	}
	
	@NotNull
	@JsonInclude(JsonInclude.Include.NON_NULL)
	public String getHoraInicio() {
		return horaInicio;
	}
	
	public void setHoraInicio(String horaInicio) {
		this.horaInicio = horaInicio;
	}
	
	@NotNull
	@JsonInclude(JsonInclude.Include.NON_NULL)
	public String getHoraFin() {
		return horaFin;
	}
	
	public void setHoraFin(String horaFin) {
		this.horaFin = horaFin;
	}
	
	@NotNull
	@JsonInclude(JsonInclude.Include.NON_NULL)
	public Date getFechaInicio() {
		return fechaInicio;
	}
	
	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	
	@NotNull
	@JsonInclude(JsonInclude.Include.NON_NULL)
	public Date getFechaFin() {
		return fechaFin;
	}
	
	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}
	
	@NotNull
	@JsonInclude(JsonInclude.Include.NON_NULL)
	public boolean getStatus() {
		return status;
	}
	
	public void setStatus(boolean status) {
		this.status = status;
	}
	
	@NotNull
	@JsonInclude(JsonInclude.Include.NON_NULL)
	public Long getIdCursos() {
		return idCursos;
	}
	
	public void setIdCursos(Long idCursos) {
		this.idCursos = idCursos;
	}
	
	@NotNull
	@JsonInclude(JsonInclude.Include.NON_NULL)
	public Long getIdInstructores() {
		return idInstructores;
	}
	
	public void setIdInstructores(Long idInstructores) {
		this.idInstructores = idInstructores;
	}

	@JsonInclude(JsonInclude.Include.NON_NULL)
	public String getNombreCurso() {
		return nombreCurso;
	}

	public void setNombreCurso(String nombreCurso) {
		this.nombreCurso = nombreCurso;
	}

	@JsonInclude(JsonInclude.Include.NON_NULL)
	public String getNombreInstructor() {
		return nombreInstructor;
	}

	public void setNombreInstructor(String nombreInstructor) {
		this.nombreInstructor = nombreInstructor;
	}
    
}
