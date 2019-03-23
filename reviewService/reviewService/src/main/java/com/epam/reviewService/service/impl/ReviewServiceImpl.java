package com.epam.reviewService.service.impl;

import com.epam.reviewService.dao.ReviewRespository;
import com.epam.reviewService.entity.Review;
import com.epam.reviewService.exception.ReviewNotFoundException;
import com.epam.reviewService.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewServiceImpl implements ReviewService {

    @Autowired
    ReviewRespository reviewRespository;

    @Override
    public List<Review> retreiveAll(int productId) {
        return reviewRespository.findAllByProductId(productId);
        /*return Optional.ofNullable(reviewRespository.findAll()).orElseThrow(
                ()-> new NoContentFoundException("Sorry, there are no records found"));*/
    }

    @Override
    public Review findByProductIdandReviewId(int productId,int reviewId) {
        return reviewRespository.findByIdAndProductId(reviewId,productId)
                .orElseThrow(
                ()-> new ReviewNotFoundException("Sorry Product review  not found ")
        );
    }

    @Override
    public Review save(Review review) {

        return reviewRespository.save(review);
    }


    @Override
    public void deleteById(int reviewId) {
        reviewRespository.deleteById(reviewId);

    }
}
