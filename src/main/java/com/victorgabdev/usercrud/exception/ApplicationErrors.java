package com.victorgabdev.usercrud.exception;

import java.time.LocalDateTime;


public class ApplicationErrors {

    private String message;
    private int status;
    private LocalDateTime timestamp;
    private String path;
    private String error;

    /*
    public ApplicationErrors(String message, int status, LocalDateTime timestamp, String path, String error) {
        this.message = message;
        this.status = status;
        this.timestamp = timestamp;
        this.path = path;
        this.error = error;
    }

     */

    public ApplicationErrors(String message, int status, LocalDateTime timestamp, String path, String error) {
        this.message = message;
        this.status = status;
        this.timestamp = timestamp;
        this.path = path;
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
