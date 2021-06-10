package back.com.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import back.com.Enum.EndPointCodeResponseEnum;
import back.com.dto.DetallesCursoDTO;
import back.com.dto.GenericDTO;
import back.com.dto.ResponseDTO;
import back.com.model.Cursos;
import back.com.model.DetallesCurso;
import back.com.model.Instructores;
import back.com.repository.CursosRepository;
import back.com.repository.DetallesCursoRepository;
import back.com.repository.InstructoresRepository;

/**
 * DetallesCursoService
 * @author jlrs
 */
@Service
public class DetallesCursoService {
	
	@Autowired
	private DetallesCursoRepository detallesCursoRepo;
	
	@Autowired
	private CursosRepository cursosRepo;
	
	@Autowired
	private InstructoresRepository instructoresRepo;

	ResponseDTO responseErrorDTO = new ResponseDTO();
	
	/**
	 * getAllDetallesCurso
	 * @return
	 */
	public ResponseDTO getAllDetallesCurso() {

		ResponseDTO responseDTO = new ResponseDTO();

		List<DetallesCurso> detallesCursoDB = new ArrayList<>();
		detallesCursoDB = detallesCursoRepo.findAll();

		if (detallesCursoDB.size() == 0) {

			GenericDTO genericDTO = new GenericDTO();
			genericDTO.setMessage("no existen registros.");

			EndPointCodeResponseEnum enumResult = EndPointCodeResponseEnum
					.getByCode(EndPointCodeResponseEnum.C0400.toString());

			responseDTO.setCode(enumResult.getValue());
			responseDTO.setStatus(enumResult.getStatus());
			responseDTO.setMessages(new ArrayList<>(Arrays.asList(genericDTO)));

			return responseDTO;
		}
		
		List<DetallesCursoDTO> detallesCursoDTO = new ArrayList<>();

        for (DetallesCurso detallesCurso : detallesCursoDB) {
        	
        	 DetallesCursoDTO detallesCursoDTOS = new DetallesCursoDTO();
        	 
        	 Optional<Cursos> cursosDB = cursosRepo.findById(detallesCurso.getIdCursos().getId());

             if (!cursosDB.isPresent()) 
            	 detallesCursoDTOS.setNombreCurso(cursosDB.get().getNombre());
                 
             Optional<Instructores> instructoresDB = instructoresRepo.findById(detallesCurso.getIdInstructores().getId());
             
             if (!instructoresDB.isPresent()) 
            	 detallesCursoDTOS.setNombreInstructor(instructoresDB.get().getNombre()+ " " + instructoresDB.get().getApellido());
            
            detallesCursoDTOS.setId(detallesCurso.getId());  	
         	detallesCursoDTOS.setIdCursos(detallesCurso.getIdCursos().getId());
         	detallesCursoDTOS.setIdInstructores(detallesCurso.getIdInstructores().getId());
         	detallesCursoDTOS.setSeccion(detallesCurso.getSeccion());
         	detallesCursoDTOS.setDias(detallesCurso.getDias());
         	detallesCursoDTOS.setHoraInicio(detallesCurso.getHoraInicio());
         	detallesCursoDTOS.setHoraFin(detallesCurso.getHoraFin());
         	detallesCursoDTOS.setFechaInicio(detallesCurso.getFechaInicio());
         	detallesCursoDTOS.setFechaFin(detallesCurso.getFechaFin());
         	detallesCursoDTOS.setStatus(detallesCurso.isStatus());
             
        	detallesCursoDTO.add(detallesCursoDTOS);
        }

        EndPointCodeResponseEnum enumResult = 
        		EndPointCodeResponseEnum.getByCode(EndPointCodeResponseEnum.C0200.toString());

        responseDTO.setCode(enumResult.getValue());
        responseDTO.setStatus(enumResult.getStatus());
        responseDTO.setData(detallesCursoDTO);

        return responseDTO;
	}
	
	/**
     * getByDetallesCurso
     * @param id
     * @return
     */
    public ResponseDTO getByDetallesCurso(Long id) {

        ResponseDTO responseDTO = new ResponseDTO();

        if (id == null) {

            GenericDTO genericDTO = new GenericDTO();
            genericDTO.setMessage("id de detalles del curso no puede ser nulo.");

            EndPointCodeResponseEnum enumResult = EndPointCodeResponseEnum
                    .getByCode(EndPointCodeResponseEnum.C0400.toString());

            responseDTO.setCode(enumResult.getValue());
            responseDTO.setStatus(enumResult.getStatus());
            responseDTO.setMessages(new ArrayList<>(Arrays.asList(genericDTO)));

            return responseDTO;
        }

        Optional<DetallesCurso> detallesCursoDB = detallesCursoRepo.findById(id);

        if (!detallesCursoDB.isPresent()) {

            GenericDTO genericDTO = new GenericDTO();
            genericDTO.setMessage("los detlles curso no existe.");

            EndPointCodeResponseEnum enumResult = EndPointCodeResponseEnum
                    .getByCode(EndPointCodeResponseEnum.C0400.toString());

            responseDTO.setCode(enumResult.getValue());
            responseDTO.setStatus(enumResult.getStatus());
            responseDTO.setMessages(new ArrayList<>(Arrays.asList(genericDTO)));

            return responseDTO;
        }

        DetallesCursoDTO detallesCursoDTO = new DetallesCursoDTO();

        detallesCursoDTO.setId(detallesCursoDB.get().getId());
        detallesCursoDTO.setIdCursos(detallesCursoDB.get().getIdCursos().getId());
        detallesCursoDTO.setIdInstructores(detallesCursoDB.get().getIdInstructores().getId());
        detallesCursoDTO.setSeccion(detallesCursoDB.get().getSeccion());
        detallesCursoDTO.setDias(detallesCursoDB.get().getDias());
        detallesCursoDTO.setFechaInicio(detallesCursoDB.get().getFechaInicio());
        detallesCursoDTO.setFechaFin(detallesCursoDB.get().getFechaFin());
        detallesCursoDTO.setHoraInicio(detallesCursoDB.get().getHoraInicio());
        detallesCursoDTO.setHoraFin(detallesCursoDB.get().getHoraFin());
        detallesCursoDTO.setStatus(false);
        

        EndPointCodeResponseEnum enumResult = 
        		EndPointCodeResponseEnum.getByCode(EndPointCodeResponseEnum.C0200.toString());

        responseDTO.setCode(enumResult.getValue());
        responseDTO.setStatus(enumResult.getStatus());
        responseDTO.setData(detallesCursoDTO);

        return responseDTO;
    }
	
    /**
     * postDetallesCurso
     * @param detallesCursoDTO
     * @return
     */
    @Transactional
    public ResponseDTO postDetallesCurso(DetallesCursoDTO detallesCurso) {

        ResponseDTO responseDTO = new ResponseDTO();

        
        DetallesCurso detallesCursoCreate = new DetallesCurso();

        detallesCursoCreate.setIdCursos(new Cursos(detallesCurso.getIdCursos()));
        detallesCursoCreate.setIdInstructores(new Instructores(detallesCurso.getIdInstructores()));
        detallesCursoCreate.setSeccion(detallesCurso.getSeccion());
        detallesCursoCreate.setDias(detallesCurso.getDias());
        detallesCursoCreate.setHoraInicio(detallesCurso.getHoraInicio());
        detallesCursoCreate.setHoraFin(detallesCurso.getHoraFin());
        detallesCursoCreate.setFechaInicio(detallesCurso.getFechaInicio());
        detallesCursoCreate.setFechaFin(detallesCurso.getFechaFin());
        detallesCursoCreate.setStatus(false);
        
        detallesCursoRepo.save(detallesCursoCreate);

        EndPointCodeResponseEnum enumResult = EndPointCodeResponseEnum
                .getByCode(EndPointCodeResponseEnum.C0201.toString());

        responseDTO.setCode(enumResult.getValue());
        responseDTO.setStatus(enumResult.getStatus());
        responseDTO.setData(new GenericDTO());

        return responseDTO;

    }
	
    /**
     * putDetallesCurso
     * @param detallesCursoDTO
     * @return
     */
    @Transactional
    public ResponseDTO putDetallesCurso(DetallesCurso detallesCurso) {

        ResponseDTO responseDTO = new ResponseDTO();

        if (detallesCurso.getId() == null) {

            GenericDTO genericDTO = new GenericDTO();
            genericDTO.setMessage("El id de los detalles del curso no puede ser nulo.");

            EndPointCodeResponseEnum enumResult = EndPointCodeResponseEnum
                    .getByCode(EndPointCodeResponseEnum.C0400.toString());

            responseDTO.setCode(enumResult.getValue());
            responseDTO.setStatus(enumResult.getStatus());
            responseDTO.setMessages(new ArrayList<>(Arrays.asList(genericDTO)));

            return responseDTO;
        }
            
        DetallesCurso detallesCursoUpdate = new DetallesCurso();

        detallesCursoUpdate.setId(detallesCurso.getId());
        detallesCursoUpdate.setIdCursos(detallesCurso.getIdCursos());
        detallesCursoUpdate.setIdInstructores(detallesCurso.getIdInstructores());
        detallesCursoUpdate.setSeccion(detallesCurso.getSeccion());
        detallesCursoUpdate.setDias(detallesCurso.getDias());
        detallesCursoUpdate.setHoraInicio(detallesCurso.getHoraInicio());
        detallesCursoUpdate.setHoraFin(detallesCurso.getHoraFin());
        detallesCursoUpdate.setFechaInicio(detallesCurso.getFechaInicio());
        detallesCursoUpdate.setFechaFin(detallesCurso.getFechaFin());
        detallesCursoUpdate.setStatus(false);

        detallesCursoRepo.save(detallesCursoUpdate);

        EndPointCodeResponseEnum enumResult = EndPointCodeResponseEnum
                .getByCode(EndPointCodeResponseEnum.C0202.toString());

        responseDTO.setCode(enumResult.getValue());
        responseDTO.setStatus(enumResult.getStatus());
        responseDTO.setData(new GenericDTO());

        return responseDTO;

    }
	
    /**
     * deleteDetallesCurso
     * @param detallesCursoDTO
     * @return
     */
    @Transactional
    public ResponseDTO deleteDetallesCurso(DetallesCurso detallesCurso) {

        ResponseDTO responseDTO = new ResponseDTO();

        if (detallesCurso.getId() == null) {

            GenericDTO genericDTO = new GenericDTO();
            genericDTO.setMessage("El id de detalles del curso no puede ser nulo.");

            EndPointCodeResponseEnum enumResult = EndPointCodeResponseEnum
                    .getByCode(EndPointCodeResponseEnum.C0400.toString());

            responseDTO.setCode(enumResult.getValue());
            responseDTO.setStatus(enumResult.getStatus());
            responseDTO.setMessages(new ArrayList<>(Arrays.asList(genericDTO)));

            return responseDTO;
        }
            
        DetallesCurso detallesCursoDelete = new DetallesCurso();

        detallesCursoDelete.setId(detallesCurso.getId());
        detallesCursoDelete.setIdCursos(detallesCurso.getIdCursos());
        detallesCursoDelete.setIdInstructores(detallesCurso.getIdInstructores());
        detallesCursoDelete.setSeccion(detallesCurso.getSeccion());
        detallesCursoDelete.setDias(detallesCurso.getDias());
        detallesCursoDelete.setHoraInicio(detallesCurso.getHoraInicio());
        detallesCursoDelete.setHoraFin(detallesCurso.getHoraFin());
        detallesCursoDelete.setFechaInicio(detallesCurso.getFechaInicio());
        detallesCursoDelete.setFechaFin(detallesCurso.getFechaFin());
        detallesCursoDelete.setStatus(true);

        detallesCursoRepo.save(detallesCursoDelete);

        EndPointCodeResponseEnum enumResult = EndPointCodeResponseEnum
                .getByCode(EndPointCodeResponseEnum.C0203.toString());

        responseDTO.setCode(enumResult.getValue());
        responseDTO.setStatus(enumResult.getStatus());
        responseDTO.setData(new GenericDTO());

        return responseDTO;

    }

}
