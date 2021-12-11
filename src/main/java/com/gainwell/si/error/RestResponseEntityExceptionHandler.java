package com.gainwell.si.error;

import com.gainwell.si.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @Autowired
    Utils utils;


    @ExceptionHandler({IllegalArgumentException.class, ExecutionException.class, InterruptedException.class,
            IllegalStateException.class, IOException.class})
    public ResponseEntity<Object> handleIllegalArgumentException(final RuntimeException ex, final WebRequest request) {
        logger.info("> handleIllegalArgumentException");
        logger.warn("- IllegalArgumentException: ", ex);
        final ExceptionDetail detail = new ExceptionDetailBuilder().exception(ex).httpStatus(HttpStatus.BAD_REQUEST)
                .webRequest(request).build();
        logger.info("< handleIllegalArgumentException");
        return handleExceptionInternal(ex, detail, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }

}
