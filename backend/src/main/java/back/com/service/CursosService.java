package back.com.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import back.com.Enum.EndPointCodeResponseEnum;
import back.com.dto.CursosDTO;
import back.com.dto.GenericDTO;
import back.com.dto.ResponseDTO;
import back.com.model.Cursos;
import back.com.repository.CursosRepository;

/**
 * CursosService
 * @author jlrs
 */
@Service
public class CursosService {

	@Autowired
	private CursosRepository cursosRepo;

	ResponseDTO responseErrorDTO = new ResponseDTO();

	/**
	 * getAllCursos
	 * @return
	 */
	public ResponseDTO getAllCursos() {

		ResponseDTO responseDTO = new ResponseDTO();

		List<Cursos> cursosDB = new ArrayList<>();
		cursosDB = cursosRepo.findAll();

		if (cursosDB.size() == 0) {

			GenericDTO genericDTO = new GenericDTO();
			genericDTO.setMessage("no existen registros.");

			EndPointCodeResponseEnum enumResult = EndPointCodeResponseEnum
					.getByCode(EndPointCodeResponseEnum.C0400.toString());

			responseDTO.setCode(enumResult.getValue());
			responseDTO.setStatus(enumResult.getStatus());
			responseDTO.setMessages(new ArrayList<>(Arrays.asList(genericDTO)));

			return responseDTO;
		}
		
		List<CursosDTO> cursosDTO = new ArrayList<>();

        for (Cursos cursos : cursosDB) {
        	cursosDTO.add(cursos.getCursosResponseDTO());
        }

        EndPointCodeResponseEnum enumResult = 
        		EndPointCodeResponseEnum.getByCode(EndPointCodeResponseEnum.C0200.toString());

        responseDTO.setCode(enumResult.getValue());
        responseDTO.setStatus(enumResult.getStatus());
        responseDTO.setData(cursosDTO);

        return responseDTO;
	}
	
	/**
     * getByCurso
     * @param id
     * @return
     */
    public ResponseDTO getByCurso(Long id) {

        ResponseDTO responseDTO = new ResponseDTO();

        if (id == null) {

            GenericDTO genericDTO = new GenericDTO();
            genericDTO.setMessage("id del curso no puede ser nulo.");

            EndPointCodeResponseEnum enumResult = EndPointCodeResponseEnum
                    .getByCode(EndPointCodeResponseEnum.C0400.toString());

            responseDTO.setCode(enumResult.getValue());
            responseDTO.setStatus(enumResult.getStatus());
            responseDTO.setMessages(new ArrayList<>(Arrays.asList(genericDTO)));

            return responseDTO;
        }

        Optional<Cursos> cursosDB = cursosRepo.findById(id);

        if (!cursosDB.isPresent()) {

            GenericDTO genericDTO = new GenericDTO();
            genericDTO.setMessage("El curso no existe.");

            EndPointCodeResponseEnum enumResult = EndPointCodeResponseEnum
                    .getByCode(EndPointCodeResponseEnum.C0400.toString());

            responseDTO.setCode(enumResult.getValue());
            responseDTO.setStatus(enumResult.getStatus());
            responseDTO.setMessages(new ArrayList<>(Arrays.asList(genericDTO)));

            return responseDTO;
        }

        CursosDTO cursosDTO = new CursosDTO();

        cursosDTO.setId(cursosDB.get().getId());
        cursosDTO.setNombre(cursosDB.get().getNombre());
        cursosDTO.setStatus(false);
        

        EndPointCodeResponseEnum enumResult = 
        		EndPointCodeResponseEnum.getByCode(EndPointCodeResponseEnum.C0200.toString());

        responseDTO.setCode(enumResult.getValue());
        responseDTO.setStatus(enumResult.getStatus());
        responseDTO.setData(cursosDTO);

        return responseDTO;
    }
    
    /**
     * postCursos
     * @param CursosDTO
     * @return
     */
    @Transactional
    public ResponseDTO postCursos(CursosDTO cursosDTO) {

        ResponseDTO responseDTO = new ResponseDTO();

        Cursos cursosForName = cursosRepo.findByNombreIgnoreCase(cursosDTO.getNombre());

        if (cursosForName != null) {

            GenericDTO genericDTO = new GenericDTO();
            genericDTO.setMessage("Nombre del curso ya existe.");

            EndPointCodeResponseEnum enumResult = EndPointCodeResponseEnum
                    .getByCode(EndPointCodeResponseEnum.C0400.toString());

            responseDTO.setCode(enumResult.getValue());
            responseDTO.setStatus(enumResult.getStatus());
            responseDTO.setMessages(new ArrayList<>(Arrays.asList(genericDTO)));

            return responseDTO;

        }

        Cursos cursosCreate = new Cursos();

        cursosCreate.setNombre(cursosDTO.getNombre());
        cursosCreate.setStatus(false);
        
        cursosRepo.save(cursosCreate);

        EndPointCodeResponseEnum enumResult = EndPointCodeResponseEnum
                .getByCode(EndPointCodeResponseEnum.C0201.toString());

        responseDTO.setCode(enumResult.getValue());
        responseDTO.setStatus(enumResult.getStatus());
        responseDTO.setData(new GenericDTO());

        return responseDTO;

    }
    
    /**
     * putCursos
     * @param cursosDTO
     * @return
     */
    @Transactional
    public ResponseDTO putCursos(CursosDTO cursosDTO) {

        ResponseDTO responseDTO = new ResponseDTO();

        if (cursosDTO.getId() == null) {

            GenericDTO genericDTO = new GenericDTO();
            genericDTO.setMessage("El id curso no puede ser nulo.");

            EndPointCodeResponseEnum enumResult = EndPointCodeResponseEnum
                    .getByCode(EndPointCodeResponseEnum.C0400.toString());

            responseDTO.setCode(enumResult.getValue());
            responseDTO.setStatus(enumResult.getStatus());
            responseDTO.setMessages(new ArrayList<>(Arrays.asList(genericDTO)));

            return responseDTO;
        }
            
        Cursos cursosUpdate = new Cursos();

        cursosUpdate.setId(cursosDTO.getId());
        cursosUpdate.setNombre(cursosDTO.getNombre());
        cursosUpdate.setStatus(false);

        cursosRepo.save(cursosUpdate);

        EndPointCodeResponseEnum enumResult = EndPointCodeResponseEnum
                .getByCode(EndPointCodeResponseEnum.C0202.toString());

        responseDTO.setCode(enumResult.getValue());
        responseDTO.setStatus(enumResult.getStatus());
        responseDTO.setData(new GenericDTO());

        return responseDTO;

    }
	
    /**
     * deleteCursos
     * @param cursosDTO
     * @return
     */
    @Transactional
    public ResponseDTO deleteCursos(CursosDTO cursosDTO) {

        ResponseDTO responseDTO = new ResponseDTO();

        if (cursosDTO.getId() == null) {

            GenericDTO genericDTO = new GenericDTO();
            genericDTO.setMessage("El id curso no puede ser nulo.");

            EndPointCodeResponseEnum enumResult = EndPointCodeResponseEnum
                    .getByCode(EndPointCodeResponseEnum.C0400.toString());

            responseDTO.setCode(enumResult.getValue());
            responseDTO.setStatus(enumResult.getStatus());
            responseDTO.setMessages(new ArrayList<>(Arrays.asList(genericDTO)));

            return responseDTO;
        }
            
        Cursos cursosUpdate = new Cursos();

        cursosUpdate.setId(cursosDTO.getId());
        cursosUpdate.setNombre(cursosDTO.getNombre());
        cursosUpdate.setStatus(true);

        cursosRepo.save(cursosUpdate);

        EndPointCodeResponseEnum enumResult = EndPointCodeResponseEnum
                .getByCode(EndPointCodeResponseEnum.C0203.toString());

        responseDTO.setCode(enumResult.getValue());
        responseDTO.setStatus(enumResult.getStatus());
        responseDTO.setData(new GenericDTO());

        return responseDTO;

    }

}
