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

import back.com.dto.InstructoresDTO;
import back.com.dto.ResponseDTO;
import back.com.service.InstructoresService;

/**
 * CursosController
 * @author jlrs
 */
@RestController
@RequestMapping("/instructores")
public class InstructoresController {
	
	@Autowired
    private InstructoresService instructoresService;
	
	/**
     * getAll
     * @return
     */
    @GetMapping
    public ResponseDTO getAll() {
        return instructoresService.getAllInstructores();
    }
	
    /**
     * getById
     * @param id
     * @return
     */
    @GetMapping("/instructor/{id}")
    public ResponseDTO getById(@PathVariable("id") Long id) {
    	return instructoresService.getByInstructores(id);
    }
    
    /**
     * post
     * @param instructoresDTO
     * @return
     */
    @PostMapping
    public ResponseDTO post(@RequestBody @Valid InstructoresDTO instructoresDTO) {
    	return instructoresService.postInstructores(instructoresDTO);
    }    
    
    /**
     * put
     * @param instructoresDTO
     * @return
     */
    @PutMapping
    public ResponseDTO put(@RequestBody @Valid InstructoresDTO instructoresDTO) {    	
    	return instructoresService.putInstructores(instructoresDTO);    
    }

    /**
     * delete
     * @param instructoresDTO
     * @return
     */
    @DeleteMapping
    public ResponseDTO delete(@RequestBody @Valid InstructoresDTO instructoresDTO) {    	
    	return instructoresService.deleteInstructores(instructoresDTO);    
    }  
    
}
