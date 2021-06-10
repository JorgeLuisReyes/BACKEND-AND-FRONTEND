package back.com.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import back.com.Enum.EndPointCodeResponseEnum;
import back.com.dto.GenericDTO;
import back.com.dto.InstructoresDTO;
import back.com.dto.ResponseDTO;
import back.com.model.Instructores;
import back.com.repository.InstructoresRepository;

/**
 * InstructoresService
 * @author jlrs
 */
@Service
public class InstructoresService {

	@Autowired
	private InstructoresRepository instructoresRepo;

	ResponseDTO responseErrorDTO = new ResponseDTO();
	
	/**
	 * getAllInstructores
	 * @return
	 */
	public ResponseDTO getAllInstructores() {

		ResponseDTO responseDTO = new ResponseDTO();

		List<Instructores> instructoresDB = new ArrayList<>();
		instructoresDB = instructoresRepo.findAll();

		if (instructoresDB.size() == 0) {

			GenericDTO genericDTO = new GenericDTO();
			genericDTO.setMessage("no existen Instructores.");

			EndPointCodeResponseEnum enumResult = EndPointCodeResponseEnum
					.getByCode(EndPointCodeResponseEnum.C0400.toString());

			responseDTO.setCode(enumResult.getValue());
			responseDTO.setStatus(enumResult.getStatus());
			responseDTO.setMessages(new ArrayList<>(Arrays.asList(genericDTO)));

			return responseDTO;
		}
		
		List<InstructoresDTO> instructoresDTO = new ArrayList<>();

        for (Instructores instructores : instructoresDB) {
        	instructoresDTO.add(instructores.getInstructoresResponseDTO());
        }

        EndPointCodeResponseEnum enumResult = 
        		EndPointCodeResponseEnum.getByCode(EndPointCodeResponseEnum.C0200.toString());

        responseDTO.setCode(enumResult.getValue());
        responseDTO.setStatus(enumResult.getStatus());
        responseDTO.setData(instructoresDTO);

        return responseDTO;
	}
	
	/**
     * getByInstructores
     * @param id
     * @return
     */
    public ResponseDTO getByInstructores(Long id) {

        ResponseDTO responseDTO = new ResponseDTO();

        if (id == null) {

            GenericDTO genericDTO = new GenericDTO();
            genericDTO.setMessage("id del instructores no puede ser nulo.");

            EndPointCodeResponseEnum enumResult = EndPointCodeResponseEnum
                    .getByCode(EndPointCodeResponseEnum.C0400.toString());

            responseDTO.setCode(enumResult.getValue());
            responseDTO.setStatus(enumResult.getStatus());
            responseDTO.setMessages(new ArrayList<>(Arrays.asList(genericDTO)));

            return responseDTO;
        }

        Optional<Instructores> instructoresDB = instructoresRepo.findById(id);

        if (!instructoresDB.isPresent()) {

            GenericDTO genericDTO = new GenericDTO();
            genericDTO.setMessage("El instructores no existe.");

            EndPointCodeResponseEnum enumResult = EndPointCodeResponseEnum
                    .getByCode(EndPointCodeResponseEnum.C0400.toString());

            responseDTO.setCode(enumResult.getValue());
            responseDTO.setStatus(enumResult.getStatus());
            responseDTO.setMessages(new ArrayList<>(Arrays.asList(genericDTO)));

            return responseDTO;
        }

        InstructoresDTO instructoresDTO = new InstructoresDTO();

        instructoresDTO.setId(instructoresDB.get().getId());
        instructoresDTO.setNombre(instructoresDB.get().getNombre());
        instructoresDTO.setApellido(instructoresDB.get().getApellido());
        instructoresDTO.setTelefono(instructoresDB.get().getTelefono());
        instructoresDTO.setEmail(instructoresDB.get().getEmail());
        instructoresDTO.setStatus(false);
        

        EndPointCodeResponseEnum enumResult = 
        		EndPointCodeResponseEnum.getByCode(EndPointCodeResponseEnum.C0200.toString());

        responseDTO.setCode(enumResult.getValue());
        responseDTO.setStatus(enumResult.getStatus());
        responseDTO.setData(instructoresDTO);

        return responseDTO;
    }
	
    /**
     * postInstructores
     * @param InstructoresDTO
     * @return
     */
    @Transactional
    public ResponseDTO postInstructores(InstructoresDTO instructoresDTO) {

        ResponseDTO responseDTO = new ResponseDTO();

        Instructores instructorForName = instructoresRepo.findByNombreIgnoreCase(instructoresDTO.getNombre());

        if (instructorForName != null) {

            GenericDTO genericDTO = new GenericDTO();
            genericDTO.setMessage("Nombre del instructores ya existe.");

            EndPointCodeResponseEnum enumResult = EndPointCodeResponseEnum
                    .getByCode(EndPointCodeResponseEnum.C0400.toString());

            responseDTO.setCode(enumResult.getValue());
            responseDTO.setStatus(enumResult.getStatus());
            responseDTO.setMessages(new ArrayList<>(Arrays.asList(genericDTO)));

            return responseDTO;

        }

        Instructores instructoresCreate = new Instructores();

        instructoresCreate.setNombre(instructoresDTO.getNombre());
        instructoresCreate.setApellido(instructoresDTO.getApellido());
        instructoresCreate.setTelefono(instructoresDTO.getTelefono());
        instructoresCreate.setEmail(instructoresDTO.getEmail());
        instructoresCreate.setStatus(false);
        
        instructoresRepo.save(instructoresCreate);

        EndPointCodeResponseEnum enumResult = EndPointCodeResponseEnum
                .getByCode(EndPointCodeResponseEnum.C0201.toString());

        responseDTO.setCode(enumResult.getValue());
        responseDTO.setStatus(enumResult.getStatus());
        responseDTO.setData(new GenericDTO());

        return responseDTO;

    }
    
    /**
     * putInstructores
     * @param instructoresDTO
     * @return
     */
    @Transactional
    public ResponseDTO putInstructores(InstructoresDTO instructoresDTO) {

        ResponseDTO responseDTO = new ResponseDTO();

        if (instructoresDTO.getId() == null) {

            GenericDTO genericDTO = new GenericDTO();
            genericDTO.setMessage("El id del instructor no puede ser nulo.");

            EndPointCodeResponseEnum enumResult = EndPointCodeResponseEnum
                    .getByCode(EndPointCodeResponseEnum.C0400.toString());

            responseDTO.setCode(enumResult.getValue());
            responseDTO.setStatus(enumResult.getStatus());
            responseDTO.setMessages(new ArrayList<>(Arrays.asList(genericDTO)));

            return responseDTO;
        }
            
        Instructores instructoresUpdate = new Instructores();

        instructoresUpdate.setId(instructoresDTO.getId());
        instructoresUpdate.setNombre(instructoresDTO.getNombre());
        instructoresUpdate.setApellido(instructoresDTO.getApellido());
        instructoresUpdate.setTelefono(instructoresDTO.getTelefono());
        instructoresUpdate.setEmail(instructoresDTO.getEmail());
        instructoresUpdate.setStatus(false);

        instructoresRepo.save(instructoresUpdate);

        EndPointCodeResponseEnum enumResult = EndPointCodeResponseEnum
                .getByCode(EndPointCodeResponseEnum.C0202.toString());

        responseDTO.setCode(enumResult.getValue());
        responseDTO.setStatus(enumResult.getStatus());
        responseDTO.setData(new GenericDTO());

        return responseDTO;

    }
    
    /**
     * deleteInstructores
     * @param instructoresDTO
     * @return
     */
    @Transactional
    public ResponseDTO deleteInstructores(InstructoresDTO instructoresDTO) {

        ResponseDTO responseDTO = new ResponseDTO();

        if (instructoresDTO.getId() == null) {

            GenericDTO genericDTO = new GenericDTO();
            genericDTO.setMessage("El id del Instructor no puede ser nulo.");

            EndPointCodeResponseEnum enumResult = EndPointCodeResponseEnum
                    .getByCode(EndPointCodeResponseEnum.C0400.toString());

            responseDTO.setCode(enumResult.getValue());
            responseDTO.setStatus(enumResult.getStatus());
            responseDTO.setMessages(new ArrayList<>(Arrays.asList(genericDTO)));

            return responseDTO;
        }
            
        Instructores instructoresUpdate = new Instructores();

        instructoresUpdate.setId(instructoresDTO.getId());
        instructoresUpdate.setNombre(instructoresDTO.getNombre());
        instructoresUpdate.setApellido(instructoresDTO.getApellido());
        instructoresUpdate.setTelefono(instructoresDTO.getTelefono());
        instructoresUpdate.setEmail(instructoresDTO.getEmail());
        instructoresUpdate.setStatus(true);

        instructoresRepo.save(instructoresUpdate);

        EndPointCodeResponseEnum enumResult = EndPointCodeResponseEnum
                .getByCode(EndPointCodeResponseEnum.C0203.toString());

        responseDTO.setCode(enumResult.getValue());
        responseDTO.setStatus(enumResult.getStatus());
        responseDTO.setData(new GenericDTO());

        return responseDTO;

    }
    
}
