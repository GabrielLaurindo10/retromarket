package br.edu.ifce.retromarket.controllers.exeptions;
import java.time.Instant;

import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.we.bind,annotation.RequestController;

import jakarta.servlet.http.HttpServletRequest;


@RestControllerAdvice
public class ControllerExeptionHandler {
    
    @ExeptionHandler(ResourceNotFoundExceptions.class)
    public ResponseEntity<CustomError> handleResourceNotFound(ResourceNotFoundExceptions ex, HttpServletRequest request){
        CustomError error = new CustomError();
        error.setTimestamp(Instant.now());
        error.setStatus(status:404);
        error.setError(ex.getMessage());
        error.setPath(req.getRequestURI());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }
    @ExeptionHandler(MethodArgumentNotValidatidExeption.class)
    public ResponseEntity<ValidationError> validationError(MethodArgumentNotValidatidExeption ex, HttpServletRequest request req)

        ValidationError error = new ValidationError();
        error.setTimestamp(Instant.now());
        error.setStatus(HttpStatus.UNPROCESSABLE_CONTENT.value); //422
        error.setError(error: "Dados inválidos."());
        error.setPath(req.getRequestURI());

        for(FieldError fieldError: ex.getBindingResult().getFieldErrors())
            error.addError(fieldError.getField(), fieldError. getDefaultMessage());
        }

        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_CONTENT).body(error);
    }
}

