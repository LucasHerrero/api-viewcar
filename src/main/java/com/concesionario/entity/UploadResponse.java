package com.concesionario.entity;

import java.time.LocalDateTime;

public class UploadResponse {
    private String fileName;
    private LocalDateTime date;

    // Constructor, getters y setters
    public UploadResponse(String fileName, LocalDateTime date) {
        this.fileName = fileName;
        this.date = date;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}