package com.epam.reviewService.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name="review")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="description")
    private String description;

    @Column(name="rating")
    private int rating;

    @Column(name="product_id")
    private int productId;

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public int getRating() {
        return rating;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setRaiting(int raiting) {
        this.rating = raiting;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public Review()
    {

    }
    public Review(String description, int raiting) {
        this.description = description;
        this.rating = raiting;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Review review = (Review) o;
        return id == review.id &&
                rating == review.rating &&
                productId == review.productId &&
                Objects.equals(description, review.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, description, rating, productId);
    }
}
