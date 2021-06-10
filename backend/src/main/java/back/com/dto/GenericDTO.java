package back.com.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

public class GenericDTO {

    private String catalogue;
    private Long id;
    private String   code;
    private String name;
    private String field;
    private String message;
    private String requestNum;
    private Long idVessel;
    private String type;
    private String rif;
    private String shippingAgent;
    private String centerCost;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("catalogue")
    public String getCatalogue() {
        return catalogue;
    }

    public void setCatalogue(String catalogue) {
        this.catalogue = catalogue;
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("code")
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }


    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getRequestNum() {
        return requestNum;
    }

    public void setRequestNum(String requestNum) {
        this.requestNum = requestNum;
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("idVessel")
	public Long getIdVessel() {
		return idVessel;
	}

	public void setIdVessel(Long idVessel) {
		this.idVessel = idVessel;
	}

    @JsonInclude(JsonInclude.Include.NON_NULL)
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@JsonInclude(JsonInclude.Include.NON_NULL)
	public String getRif() {
		return rif;
	}

	public void setRif(String rif) {
		this.rif = rif;
	}

	@JsonInclude(JsonInclude.Include.NON_NULL)
	public String getShippingAgent() {
		return shippingAgent;
	}

	public void setShippingAgent(String shippingAgent) {
		this.shippingAgent = shippingAgent;
	}

	@JsonInclude(JsonInclude.Include.NON_NULL)
	public String getCenterCost() {
		return centerCost;
	}

	public void setCenterCost(String centerCost) {
		this.centerCost = centerCost;
	}
	
}