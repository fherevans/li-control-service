package mx.santander.liquidez.control.efectivo.dali.model;

import org.springframework.http.HttpStatus;

public class ControllerException extends Exception {
    private static final long serialVersionUID = -6948261425279510384L;
    
    private HttpStatus httpStatus = HttpStatus.ACCEPTED;
    private String code = "0";
    private String message = "";
    private String description = "";
    private String level = "";
    private String moreInfo = "";
    
    public ControllerException(
            HttpStatus httpStatus, 
            String code, 
            String message,
            String description, 
            String level, 
            String moreInfo) {
        this.httpStatus = httpStatus;
        this.code = code;
        this.message = message;
        this.description = description;
        this.level = level;
        this.moreInfo = moreInfo;
    }

    public HttpStatus getHttpStatus() {
        return this.httpStatus;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public String getDescription() {
        return description;
    }

    public String getLevel() {
        return level;
    }

    public String getMoreInfo() {
        return moreInfo;
    }

    @Override
    public String toString() {
        return "ControllerException ["
                + "httpStatus=" + getHttpStatus() + 
                ", code=" + getCode() + 
                ", message=" + getMessage() +
                ", description=" + getDescription() + 
                ", level=" + getLevel() + 
                ", moreInfo=" + getMoreInfo() + 
                "]";
    }

}
