package back.com.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class ResponseDTO {

    private Long code;
    private String status;
    private List<GenericDTO> messages;
    private Object data;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("code")
    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("status")
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("messages")
    public List<GenericDTO> getMessages() {
        return messages;
    }

    public void setMessages(List<GenericDTO> messages) {
        this.messages = messages;
    }
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("data")
    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}


