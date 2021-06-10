package back.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import back.com.model.DetallesCurso;

/**
 * DetallesCursoRepository
 * @author jlrs
 */
@Repository
public interface DetallesCursoRepository extends JpaRepository<DetallesCurso, Long> {
	
	

}
