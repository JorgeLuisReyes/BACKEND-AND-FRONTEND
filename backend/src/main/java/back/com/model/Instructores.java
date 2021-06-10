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

import back.com.dto.InstructoresDTO;

/**
 * tabla Instructores
 * @author jlrs
 */
@Entity
@Table(name = "instructores", catalog = "back", schema = "prueba")
public class Instructores implements Serializable {
	private static final long serialVersionUID = 1L;
	
	
	/**
	 * tabla Instructores
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
    @Column(name = "apellido")
	private String apellido;
	@Basic(optional = false)
    @Column(name = "telefono")
	private Long telefono;
	@Basic(optional = false)
    @Column(name = "email")
	private String email;
	@Basic(optional = false)
    @Column(name = "status")
    private boolean status;
	
	//@OneToMany(cascade = CascadeType.ALL, mappedBy = "id_instructores", fetch = FetchType.LAZY)
	//private List<Instructores> instructoresList;
	 
	/**
	 * Contrustores
	 */
	
	public Instructores() {
	}
	
	public Instructores(Long id) {
		this.id = id;
	}
	
	public Instructores(Long id, String nombre) {
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

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public Long getTelefono() {
		return telefono;
	}

	public void setTelefono(Long telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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
        if (!(object instanceof Instructores)) {
            return false;
        }
        Instructores other = (Instructores) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "back.com.model.Instructores[ id=" + id + " ]";
    }
	
    @Transient
    public InstructoresDTO getInstructoresResponseDTO() {

    	InstructoresDTO instructoresDTO = new InstructoresDTO();

    	instructoresDTO.setId(this.id);   	
    	instructoresDTO.setNombre(this.nombre);
    	instructoresDTO.setApellido(this.apellido);
    	instructoresDTO.setTelefono(this.telefono);
    	instructoresDTO.setEmail(this.email);
    	instructoresDTO.setStatus(this.status);
        
        return instructoresDTO;
    }
	
	
	
	
	
}
