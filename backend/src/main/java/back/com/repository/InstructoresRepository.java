package back.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import back.com.model.Instructores;


/**
 * InstructoresRepository
 * @author jlrs
 */
@Repository
public interface InstructoresRepository extends JpaRepository<Instructores, Long> {
	
	/**
	 * findByForNameIgnoreCase
	 * @param Name
	 * @return
	 */
	Instructores findByNombreIgnoreCase(String Name);

}
