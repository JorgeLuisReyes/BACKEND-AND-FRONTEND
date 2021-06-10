package back.config;

import back.com.Enum.EndPointCodeResponseEnum;
import back.com.dto.GenericDTO;
import back.com.dto.ResponseDTO;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.List;


@ControllerAdvice
@CrossOrigin(origins = "*")
@RestController
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {


    @Override
    protected ResponseEntity<Object>
    handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                 HttpHeaders headers,
                                 HttpStatus status, WebRequest request) {

        ResponseDTO responseDTO = new ResponseDTO();
        List<GenericDTO> genericDTOS = new ArrayList<>();
        EndPointCodeResponseEnum enumResult = EndPointCodeResponseEnum.getByCode(EndPointCodeResponseEnum.C0400.toString());
        responseDTO.setCode(enumResult.getValue());
        responseDTO.setStatus(enumResult.getStatus());
        ex.getBindingResult()
                .getFieldErrors()
                .forEach(
                        x -> {
                            if (!(genericDTOS.stream().anyMatch(genericDTO -> genericDTO.getField().equals(x.getField())))) {
                                GenericDTO generic = new GenericDTO();
                                generic.setField(x.getField());
                                generic.setMessage(x.getDefaultMessage());

                                genericDTOS.add(generic);
                            }
                        });
        responseDTO.setMessages(genericDTOS);
        responseDTO.setData(new GenericDTO());
        return new ResponseEntity<>(responseDTO, headers, status);

    }
}
