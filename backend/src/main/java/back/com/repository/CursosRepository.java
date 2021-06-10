package back.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import back.com.model.Cursos;

/**
 * CursosRepository
 * @author jlrs
 */
@Repository
public interface CursosRepository extends JpaRepository<Cursos, Long> {
	
	/**
	 * findByForNameIgnoreCase
	 * @param Name
	 * @return
	 */
	Cursos findByNombreIgnoreCase(String Name);

}
