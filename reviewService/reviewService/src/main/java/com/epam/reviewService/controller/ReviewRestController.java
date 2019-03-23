package com.epam.reviewService.controller;

import com.epam.reviewService.entity.Review;
import com.epam.reviewService.service.ReviewService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ReviewRestController {

    @Autowired
    ReviewService reviewService;


    @GetMapping(value = "/{productId}/reviews"
            , produces = MediaType.APPLICATION_JSON_VALUE
            , consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "it find all the reviews for the particular product ", response = ResponseEntity.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 400, message = "BAD_REQUEST")})
    public ResponseEntity<Object> findAll(@PathVariable int productId)
    {
        List<Review> reviews=reviewService.retreiveAll(productId);
        return new ResponseEntity<>(reviews, HttpStatus.OK);

    }


    @PostMapping(value="/{productId}/reviews"
            , produces = MediaType.APPLICATION_JSON_VALUE
            , consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "it Creates new review for a particular product ", response = ResponseEntity.class)
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "CREATED"),
            @ApiResponse(code = 400, message = "BAD_REQUEST"),
    })
    public ResponseEntity<Object> AddProductReview(@PathVariable int productId,@RequestBody Review review)
    {
        review.setProductId(productId);
        Review savedReview=reviewService.save(review);
        return new ResponseEntity<>(savedReview, HttpStatus.CREATED);
    }


    @PutMapping(value="/{productId}/reviews/{reviewId}"
            , produces = MediaType.APPLICATION_JSON_VALUE
            , consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "it updates existing product review ", response = ResponseEntity.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 400, message = "BAD_REQUEST")})
    public ResponseEntity<Object> updateProductReview(@PathVariable int productId, @PathVariable int reviewId,@RequestBody Review review)
    {
        Review savedProduct= reviewService.save(review);
        return  new ResponseEntity<>(savedProduct, HttpStatus.OK);
    }

    @DeleteMapping(value="/{productId}/reviews/{reviewId}"
            ,produces = MediaType.APPLICATION_JSON_VALUE
            , consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "it Delete existing product review ", response = ResponseEntity.class)
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "NO_CONTENT")})
    public ResponseEntity<Object> deleteProductReview(@PathVariable int productId,@PathVariable int reviewId)
    {
        reviewService.findByProductIdandReviewId(productId,reviewId);
        reviewService.deleteById(reviewId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }




}
