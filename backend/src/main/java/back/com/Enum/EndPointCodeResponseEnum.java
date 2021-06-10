package back.com.Enum;

public enum EndPointCodeResponseEnum {

    /** El request fue exitoso*/
    C0200("C0200", 200L , "OK"),
    /** El request fue exitoso y se agrego un registro nuevo*/
    C0201("C0201", 201L, "Created"),
    /** El request fue exitoso y se modifico un registro existente*/
    C0202("C0202", 202L, "Updated"),
    /** El request fue exitoso y se modifico un registro existente*/
    C0203("C0203", 203L, "Deleted"),    
    /* El request esta bien formado pero la entidad no fue precesada por que existe un error en algun campo*/
    C0204("C0204", 204L, "The server successfully processed the request and is not returning any content"),
    /** Indicando Datos de entrada erroneos*/
    C0400("C0400", 400L, "Bad Request"),
    /** Firma invalida*/
    C0401("C0400", 401L, "Unauthorized"),
    /**	Indicando no recursos en contrados en BD*/
    C0404("C0404", 404L, "Not Found"),
    /**	Not Acceptable */
    C0406("C0406", 406L, "El servidor no es capaz de devolver los datos en ninguno de los formatos aceptados por el cliente."),
    C0500("C0500", 500L, "Internal Server Error"),
    C0600("C0600", 600L, "External api is not available"),
    OTRO("OTRO", 500L, "Error Unknow");

    String code;
    Long value;
    String status;

    EndPointCodeResponseEnum(String code, Long value, String status) {
        this.code = code;
        this.value = value;
        this.status = status;
    }

    public Long getValue() {
        return this.value;
    }

    public String getStatus() {
        return this.status;
    }

    public static EndPointCodeResponseEnum getByCode(String code){
        switch (code){
            case "C0200" : return EndPointCodeResponseEnum.C0200;
            case "C0201" : return EndPointCodeResponseEnum.C0201;
            case "C0202" : return EndPointCodeResponseEnum.C0202;
            case "C0203" : return EndPointCodeResponseEnum.C0203;
            case "C0204" : return EndPointCodeResponseEnum.C0204;
            case "C0400" : return EndPointCodeResponseEnum.C0400;
            case "C0401" : return EndPointCodeResponseEnum.C0401;
            case "C0404" : return EndPointCodeResponseEnum.C0404;
            case "C0406" : return EndPointCodeResponseEnum.C0406;
            case "C0500" : return EndPointCodeResponseEnum.C0500;
            case "C0600" : return EndPointCodeResponseEnum.C0600;
            default : return EndPointCodeResponseEnum.OTRO;
        }
    }
}