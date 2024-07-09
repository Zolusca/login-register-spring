package com.zolusca.Exceptions;

import com.zolusca.DTO.Responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class ExceptionResponseHandler {

    @ExceptionHandler(AlreadyExistException.class)
    public ResponseEntity<ApiResponses<String>> alreadyExist(AlreadyExistException err){
        List<String> error = Collections.singletonList(err.getMessage());

        ApiResponses<String> responses = new ApiResponses<>();
        responses.setCode(HttpStatus.CONFLICT.value());
        responses.setError(error);
        responses.setData(null);

        return new ResponseEntity<>(responses,HttpStatus.CONFLICT);
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity<ApiResponses<List<String>>> methodArgumentValidationException(MethodArgumentNotValidException errors){

        List<String> errorsData = errors.getAllErrors().stream()
                .map(t -> t.getDefaultMessage())
                .collect(Collectors.toList());

        ApiResponses<List<String>> apiErrorException = new ApiResponses<>();
        apiErrorException.setCode(HttpStatus.BAD_REQUEST.value());
        apiErrorException.setError(errorsData);

        return new ResponseEntity<>(apiErrorException,HttpStatus.BAD_REQUEST);
    }

}
