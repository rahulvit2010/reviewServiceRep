package com.epam.reviewService.service;

import com.epam.reviewService.entity.Review;

import java.util.List;

public interface ReviewService {

    public List<Review> retreiveAll(int ProductId);

    public Review findByProductIdandReviewId(int productId,int reviewId);

    public Review save(Review review);

    public void deleteById(int reviewId);
}
