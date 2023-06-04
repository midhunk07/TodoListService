package com.midhun.programming.todoListService.exception;

import java.util.List;

import lombok.Data;

@Data
public class ErrorDetails extends Exception {
    private String message;
    private List<String> details;
    private boolean suppressStackTrace = false;

    public ErrorDetails(String message, List<String> details) {
        super(message, null, true, false);
        this.message = message;
        this.details = details;
        this.suppressStackTrace = true;
    }

    public ErrorDetails(String message, List<String> details, boolean suppressStackTrace) {
        super(message, null, suppressStackTrace, !suppressStackTrace);
        this.message = message;
        this.details = details;
        this.suppressStackTrace = suppressStackTrace;
    }

    @Override
    public String toString() {
        return this.suppressStackTrace ? getLocalizedMessage() : super.toString();
    }
}