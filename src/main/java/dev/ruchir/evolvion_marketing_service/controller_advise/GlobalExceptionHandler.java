package dev.ruchir.evolvion_marketing_service.controller_advise;

import dev.ruchir.evolvion_marketing_service.controller_advise.custom.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(LeadNotFoundException.class)
    public ErrorResponse handleLeadNotFoundException(LeadNotFoundException ex, WebRequest request) {
        return new ErrorResponse(
                ex.getMessage(),
                "LEAD_NOT_FOUND",
                LocalDateTime.now(),
                HttpStatus.NOT_FOUND,
                UUID.randomUUID().toString(),
                null
        );
    }

    @ExceptionHandler(LeadAlreadyExistsException.class)
    public ErrorResponse handleLeadAlreadyExistsException(LeadAlreadyExistsException ex, WebRequest request) {
        return new ErrorResponse(
                ex.getMessage(),
                "LEAD_ALREADY_EXISTS",
                LocalDateTime.now(),
                HttpStatus.CONFLICT,
                UUID.randomUUID().toString(),
                null
        );
    }

    @ExceptionHandler(CampaignNotFoundException.class)
    public ErrorResponse handleCampaignNotFoundException(CampaignNotFoundException ex, WebRequest request) {
        return new ErrorResponse(
                ex.getMessage(),
                "CAMPAIGN_NOT_FOUND",
                LocalDateTime.now(),
                HttpStatus.NOT_FOUND,
                UUID.randomUUID().toString(),
                null
        );
    }

    @ExceptionHandler(CampaignAlreadyExistsException.class)
    public ErrorResponse handleCampaignAlreadyExistsException(CampaignAlreadyExistsException ex, WebRequest request) {
        return new ErrorResponse(
                ex.getMessage(),
                "CAMPAIGN_ALREADY_EXISTS",
                LocalDateTime.now(),
                HttpStatus.CONFLICT,
                UUID.randomUUID().toString(),
                null
        );
    }

    @ExceptionHandler(ContentNotFoundException.class)
    public ErrorResponse handleContentNotFoundException(ContentNotFoundException ex, WebRequest request) {
        return new ErrorResponse(
                ex.getMessage(),
                "CONTENT_NOT_FOUND",
                LocalDateTime.now(),
                HttpStatus.NOT_FOUND,
                UUID.randomUUID().toString(),
                null
        );
    }

    @ExceptionHandler(ContentAlreadyExistsException.class)
    public ErrorResponse handleContentAlreadyExistsException(ContentAlreadyExistsException ex, WebRequest request) {
        return new ErrorResponse(
                ex.getMessage(),
                "CONTENT_ALREADY_EXISTS",
                LocalDateTime.now(),
                HttpStatus.CONFLICT,
                UUID.randomUUID().toString(),
                null
        );
    }

    @ExceptionHandler(InvalidContentDataException.class)
    public ErrorResponse handleInvalidContentDataException(InvalidContentDataException ex, WebRequest request) {
        return new ErrorResponse(
                ex.getMessage(),
                "INVALID_CONTENT_DATA",
                LocalDateTime.now(),
                HttpStatus.BAD_REQUEST,
                UUID.randomUUID().toString(),
                null
        );
    }

    @ExceptionHandler(Exception.class)
    public ErrorResponse handleGenericException(Exception ex, WebRequest request) {
        return new ErrorResponse(
                "An unexpected error occurred",
                "INTERNAL_SERVER_ERROR",
                LocalDateTime.now(),
                HttpStatus.INTERNAL_SERVER_ERROR,
                UUID.randomUUID().toString(),
                null
        );
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ErrorResponse handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error ->
                errors.put(error.getField(), error.getDefaultMessage())
        );
        return new ErrorResponse(
                "Validation failed",
                "VALIDATION_ERROR",
                LocalDateTime.now(),
                HttpStatus.BAD_REQUEST,
                UUID.randomUUID().toString(),
                errors
        );
    }
}
