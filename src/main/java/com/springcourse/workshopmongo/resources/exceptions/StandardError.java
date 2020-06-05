package com.springcourse.workshopmongo.resources.exceptions;

import java.io.Serializable;

public class StandardError implements Serializable {


    private Long instant;
    private Integer status;
    private String error;
    private String message;
    private String path;

    public StandardError() {
    }

    public StandardError(Long instant, Integer status, String error, String message, String path) {
        this.instant = instant;
        this.status = status;
        this.error = error;
        this.message = message;
        this.path = path;
    }

    public Long getInstant() {
        return instant;
    }

    public void setInstant(Long instant) {
        this.instant = instant;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

}
