package com.example.typing.exception;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ApiError implements Serializable {

    private static final long serialVersionUID = 1L;

    private String massage;

    @JsonProperty("documentation_url")
    private String documentationUrl;

    public String getMassage() {
        return massage;
    }

    public void setMassage(String massage) {
        this.massage = massage;
    }

    public String getDocumentationUrl() {
        return documentationUrl;
    }

    public void setDocumentationUrl(String documentationUrl) {
        this.documentationUrl = documentationUrl;
    }


}
