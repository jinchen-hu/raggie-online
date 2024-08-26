package com.raggie.base.exception;

public enum CommonError {
    UNKOWN_ERROR("Execution exception. Please retry"),
    PARAMS_ERROR("Illegal arguments"),
    OBJECT_NULL("Empty object"),
    QUERY_NULL("Query result is null"),
    REQUEST_NULL("Request parameter is null"),;

    private String message;

    public String getMessage() {
        return message;
    }
    CommonError(String message) {
        this.message = message;
    }
}
