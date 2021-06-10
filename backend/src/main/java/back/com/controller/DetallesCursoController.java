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

import back.com.dto.DetallesCursoDTO;
import back.com.dto.ResponseDTO;
import back.com.model.DetallesCurso;
import back.com.service.DetallesCursoService;

/**
 * DetallesCursoController
 * @author jlrs
 */
@RestController
@RequestMapping("/detalles")
public class DetallesCursoController {

	@Autowired
    private DetallesCursoService detallesCursoService;
	
	/**
     * getAll
     * @return
     */
    @GetMapping
    public ResponseDTO getAll() {
        return detallesCursoService.getAllDetallesCurso();
    }
    
    /**
     * getById
     * @param id
     * @return
     */
    @GetMapping("/curso/{id}")
    public ResponseDTO getById(@PathVariable("id") Long id) {
    	return detallesCursoService.getByDetallesCurso(id);
    }
	
    /**
     * post
     * @param detallesCursoDTO
     * @return
     */
    @PostMapping
    public ResponseDTO post(@RequestBody @Valid DetallesCursoDTO detallesCurso) {
    	return detallesCursoService.postDetallesCurso(detallesCurso);
    }
	
    /**
     * put
     * @param detallesCursoDTO
     * @return
     */
    @PutMapping
    public ResponseDTO put(@RequestBody @Valid DetallesCurso detallesCurso) {    	
    	return detallesCursoService.putDetallesCurso(detallesCurso);    
    }

    /**
     * delete
     * @param detallesCursoDTO
     * @return
     */
    @DeleteMapping
    public ResponseDTO delete(@RequestBody @Valid DetallesCurso detallesCurso) {    	
    	return detallesCursoService.deleteDetallesCurso(detallesCurso);    
    }
	
}
