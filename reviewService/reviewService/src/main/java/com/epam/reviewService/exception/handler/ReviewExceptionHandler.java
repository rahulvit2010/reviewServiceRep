package com.epam.reviewService.exception.handler;

import com.epam.reviewService.errorresponse.ReviewErrorResponse;
import com.epam.reviewService.exception.NoContentFoundException;
import com.epam.reviewService.exception.ReviewNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class ReviewExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<ReviewErrorResponse> handleException(ReviewNotFoundException exc)
    {
        ReviewErrorResponse error= new ReviewErrorResponse();
        error.setStatusCode(HttpStatus.BAD_REQUEST.value());
        error.setMessage(exc.getMessage());
        error.setTimestamp(System.currentTimeMillis());
        return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);

    }


    @ExceptionHandler
    public ResponseEntity<ReviewErrorResponse> handleException(Exception exc)
    {
        ReviewErrorResponse error= new ReviewErrorResponse();
        error.setStatusCode(HttpStatus.BAD_REQUEST.value());
        error.setMessage(exc.getMessage());
        error.setTimestamp(System.currentTimeMillis());
        return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);

    }

    @ExceptionHandler
    public ResponseEntity<ReviewErrorResponse> handleException(NoContentFoundException exc)
    {
        ReviewErrorResponse error= new ReviewErrorResponse();
        error.setStatusCode(HttpStatus.OK.value());
        error.setMessage(exc.getMessage());
        error.setTimestamp(System.currentTimeMillis());
        return new ResponseEntity<>(error,HttpStatus.OK);
    }
}
