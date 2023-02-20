package com.koreait.koreaitsugang.web.advice;

import com.koreait.koreaitsugang.exception.CustomValidationException;
import com.koreait.koreaitsugang.web.dto.CMRespDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionAdvice {

    public ResponseEntity<?> validationError(CustomValidationException e) {
        return ResponseEntity.badRequest()
                .body(new CMRespDto<>(HttpStatus.BAD_REQUEST.value(), "Validation Error", e.getErrorMap()));
    }
}
