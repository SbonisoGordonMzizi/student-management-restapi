package co.za.tech.studentmanagementsystem.exceptionHandler;

import co.za.tech.studentmanagementsystem.runtimeexception.StudentRuntimeExeption;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class InternalExceptionHandler {


    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String,String> apiValidationExceptionHandler(MethodArgumentNotValidException exception){
        HashMap<String,String> responseForInvalidStudentRequest = new HashMap<>();
        exception.getBindingResult().getFieldErrors().forEach(error -> {
            responseForInvalidStudentRequest.put(error.getField(),error.getDefaultMessage());
        });

        return responseForInvalidStudentRequest;
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(StudentRuntimeExeption.class)
    public Map<String,String> StudentExceptionHandler(StudentRuntimeExeption exeption){
        HashMap<String,String> studentNotFoundResponse = new HashMap<>();
        studentNotFoundResponse.put("Error-Message",exeption.getMessage());
        return studentNotFoundResponse;
    }
}
