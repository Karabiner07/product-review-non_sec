package com.tarun.productreview.service;

import com.tarun.productreview.entity.Product;
import com.tarun.productreview.entity.Review;
import com.tarun.productreview.entity.User;

import java.util.List;

public interface ReviewService {

    public Review createReview(User user, Product product, String Comment);

    public List<Review> fetchAllReviewByProductId(Long productId);

    public Long countByProductId(Long productId);

}