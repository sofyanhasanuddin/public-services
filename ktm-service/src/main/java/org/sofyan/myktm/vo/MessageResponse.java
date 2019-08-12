package org.sofyan.myktm.vo;

public class MessageResponse {

    private static final String SUCCESS = "success";
    private static final String ERROR = "error";

    private String message;
    private String status;
    private Object data;

    private MessageResponse() {
    }

    private MessageResponse(String status, String message) {
        this.status = status;
        this.message = message;
    }

    private MessageResponse(String status, String message, Object data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public static MessageResponse success(String message) {
        return new MessageResponse(SUCCESS, message);
    }

    public static MessageResponse success(String message, Object data) {
        return new MessageResponse(SUCCESS, message, data);
    }

    public static MessageResponse error(String message) {
        return new MessageResponse(ERROR, message);
    }

    public static MessageResponse error(String message, Object data) {
        return new MessageResponse(ERROR, message, data);
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

}
