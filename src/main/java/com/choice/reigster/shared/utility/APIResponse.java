package com.choice.reigster.shared.utility;

import lombok.Data;

import java.io.Serializable;

@Data
public class APIResponse implements Serializable {

    private String status;
    private String message;
    private Object data;
    private Object object;
    public void setData(Object data) {
        this.data = data;
    }
    public void setMessage(String message) {
        this.message = message;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    public APIResponse(String status, Object data) {
        this.status = status;
        this.data = data;
    }
    public APIResponse(String status, String message) {
        this.status = status;
        this.message = message;
    }

    public APIResponse() {

    }
}
