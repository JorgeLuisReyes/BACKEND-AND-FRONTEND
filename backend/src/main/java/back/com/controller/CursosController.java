package back.com.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import back.com.dto.CursosDTO;
import back.com.dto.ResponseDTO;
import back.com.service.CursosService;

/**
 * CursosController
 * @author jlrs
 */
@RestController
@RequestMapping("/cursos")
public class CursosController {
	
	@Autowired
    private CursosService cursosService;
	
	/**
     * getAll
     * @return
     */
    @GetMapping
    public ResponseDTO getAll() {
        return cursosService.getAllCursos();
    }
    
    /**
     * getById
     * @param id
     * @return
     */
    @GetMapping("/curso/{id}")
    public ResponseDTO getById(@PathVariable("id") Long id) {
    	return cursosService.getByCurso(id);
    }
	
    /**
     * post
     * @param cursosDTO
     * @return
     */
    @PostMapping
    public ResponseDTO post(@RequestBody @Valid CursosDTO cursosDTO) {
    	return cursosService.postCursos(cursosDTO);
    }
	
    /**
     * put
     * @param cursosDTO
     * @return
     */
    @PutMapping
    public ResponseDTO put(@RequestBody @Valid CursosDTO cursosDTO) {    	
    	return cursosService.putCursos(cursosDTO);    
    }

    /**
     * delete
     * @param cursosDTO
     * @return
     */
    @DeleteMapping("/curso/{id}")
    public ResponseDTO delete(@PathVariable("id") Long id) {    	
    	return cursosService.deleteCursos(id);    
    }
}
