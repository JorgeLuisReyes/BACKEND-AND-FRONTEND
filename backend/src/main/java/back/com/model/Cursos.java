package back.com.model;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import back.com.dto.CursosDTO;

/**
 * tabla Cursos
 * @author jlrs
 */
@Entity
@Table(name = "cursos", catalog = "back", schema = "prueba")
public class Cursos implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * tabla Cursos
	 */
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
	@Basic(optional = false)
    @Column(name = "nombre")
	private String nombre;
	@Basic(optional = false)
    @Column(name = "status")
    private boolean status;
	
	//@OneToMany(cascade = CascadeType.ALL, mappedBy = "idCurso", fetch = FetchType.LAZY)
    //private List<Cursos> cursosList;
	
	/**
	 * Contrustores
	 */

	public Cursos() {
	}
	
	public Cursos(Long id) {
		this.id = id;
	}

	public Cursos(Long id, String nombre) {
		this.id = id;
		this.nombre = nombre;
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

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public boolean getStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
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
        if (!(object instanceof Cursos)) {
            return false;
        }
        Cursos other = (Cursos) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "back.com.model.Cursos[ id=" + id + " ]";
    }
    
    @Transient
    public CursosDTO getCursosResponseDTO() {

    	CursosDTO cursosDTO = new CursosDTO();

    	cursosDTO.setId(this.id);    	
    	cursosDTO.setNombre(this.nombre);
    	cursosDTO.setStatus(this.status);
        
        return cursosDTO;
    }

}


