package back.com.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import back.com.dto.DetallesCursoDTO;

/**
 * tabla DetallesCurso
 * @author jlrs
 */
@Entity
@Table(name = "detalles", catalog = "back", schema = "prueba")
public class DetallesCurso implements Serializable {
	private static final long serialVersionUID = 1L;
	
	/**
	 * tabla detalles
	 */
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
	@Basic(optional = false)
    @Column(name = "seccion")
    private String seccion;
	@Basic(optional = false)
    @Column(name = "dias")
	private Long dias;
	@Basic(optional = false)
    @Column(name = "hora_inicio")
    private String horaInicio;
	@Basic(optional = false)
    @Column(name = "hora_fin")
    private String horaFin;
    @Column(name = "fecha_inicio")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaInicio;
    @Column(name = "fecha_fin")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaFin;
	@Basic(optional = false)
    @Column(name = "status")
    private boolean status;
	
	
    @JoinColumn(name = "id_curso", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Cursos idCursos;
    
    @JoinColumn(name = "id_instructores", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Instructores idInstructores;
    
    /**
	 * Contrustores
	 */
    
    public DetallesCurso() {
	}
    
    public DetallesCurso(Long id) {
		this.id = id;
	}
    
    public DetallesCurso(Long id, String seccion) {
		this.id = id;
		this.seccion = seccion;
	}
    
    public DetallesCurso(Long id, String seccion, Cursos idCursos, Instructores idInstructores) {
		this.id = id;
		this.seccion = seccion;
		this.idCursos = idCursos;
		this.idInstructores = idInstructores;
	}
    
    public DetallesCurso(Long id, String seccion, Long dias, String horaInicio, String horaFin, Date fechaInicio,
			Date fechaFin, Cursos idCursos, Instructores idInstructores) {
		this.id = id;
		this.seccion = seccion;
		this.dias = dias;
		this.horaInicio = horaInicio;
		this.horaFin = horaFin;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.idCursos = idCursos;
		this.idInstructores = idInstructores;
	}

	/**
     * Getters and Setters
     */
    
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSeccion() {
		return seccion;
	}

	public void setSeccion(String seccion) {
		this.seccion = seccion;
	}

	public Long getDias() {
		return dias;
	}

	public void setDias(Long dias) {
		this.dias = dias;
	}

	public String getHoraInicio() {
		return horaInicio;
	}

	public void setHoraInicio(String horaInicio) {
		this.horaInicio = horaInicio;
	}

	public String getHoraFin() {
		return horaFin;
	}

	public void setHoraFin(String horaFin) {
		this.horaFin = horaFin;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public Cursos getIdCursos() {
		return idCursos;
	}

	public void setIdCursos(Cursos idCursos) {
		this.idCursos = idCursos;
	}

	public Instructores getIdInstructores() {
		return idInstructores;
	}

	public void setIdInstructores(Instructores idInstructores) {
		this.idInstructores = idInstructores;
	}

	/**
	 * utiles
	 */
	
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof DetallesCurso)) {
            return false;
        }
        DetallesCurso other = (DetallesCurso) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "back.com.model.DetallesCurso[ id=" + id + " ]";
    }
    
    @Transient
    public DetallesCursoDTO getDetallesCursoResponseDTO() {

    	DetallesCursoDTO detallesCursoDTO = new DetallesCursoDTO();

    	detallesCursoDTO.setId(this.id);    	
    	detallesCursoDTO.setIdCursos(this.idCursos.getId());
    	detallesCursoDTO.setIdInstructores(this.idInstructores.getId());
    	detallesCursoDTO.setSeccion(this.seccion);
    	detallesCursoDTO.setDias(this.dias);
    	detallesCursoDTO.setHoraInicio(this.horaInicio);
    	detallesCursoDTO.setHoraFin(this.horaFin);
    	detallesCursoDTO.setFechaInicio(this.fechaInicio);
    	detallesCursoDTO.setFechaFin(this.fechaFin);
    	detallesCursoDTO.setStatus(this.status);
        
        return detallesCursoDTO;
    }

}
