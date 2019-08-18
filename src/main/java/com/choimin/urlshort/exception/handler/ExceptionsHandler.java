package com.choimin.urlshort.exception.handler;

import com.choimin.urlshort.exception.EmptyUrlException;
import com.choimin.urlshort.exception.UrlFormatException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@ControllerAdvice
public class ExceptionsHandler {

    @ExceptionHandler({EmptyUrlException.class})
    @ResponseBody
    public ResponseEntity<ErrorStatus> emptyUrlExceptionHendler(HttpServletRequest req, EmptyUrlException e){
        ErrorStatus errorStatus= new ErrorStatus();
        errorStatus.setCode(ErrorCode.CODE_0000.getCode());
        errorStatus.setDescription(ErrorCode.CODE_0000.getDescription());
        errorStatus.setDetail(e.getMessage());

        return new ResponseEntity<ErrorStatus>(errorStatus,HttpStatus.BAD_REQUEST);
     }


    @ExceptionHandler({UrlFormatException.class})
    @ResponseBody
    public ResponseEntity<ErrorStatus> urlFormatExceptionHendler(HttpServletRequest req, UrlFormatException e){
        ErrorStatus errorStatus= new ErrorStatus();
        errorStatus.setCode(ErrorCode.CODE_0000.getCode());
        errorStatus.setDescription(ErrorCode.CODE_0000.getDescription());
        errorStatus.setDetail(e.getMessage());

        return new ResponseEntity<ErrorStatus>(errorStatus,HttpStatus.BAD_REQUEST);
    }

} // CLASS END
