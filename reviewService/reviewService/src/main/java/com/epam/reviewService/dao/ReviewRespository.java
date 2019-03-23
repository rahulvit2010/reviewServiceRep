package com.epam.reviewService.dao;

import com.epam.reviewService.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ReviewRespository extends JpaRepository<Review,Integer> {

    List<Review> findAllByProductId(int productId);
    
    Optional<Review> findByIdAndProductId(int reviewId,int productId);


}
