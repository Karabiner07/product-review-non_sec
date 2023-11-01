package com.tarun.productreview.service;

import com.tarun.productreview.entity.Product;
import com.tarun.productreview.entity.Review;
import com.tarun.productreview.entity.User;
import com.tarun.productreview.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ReviewServiceImpl implements ReviewService{

    @Autowired
    private ReviewRepository reviewRepository;


    @Override
    public Review createReview(User user, Product product, String comment) {

        if (reviewRepository.existsByUserAndProduct(user, product)){
            throw new ReviewAlreadyExistsExeption("A review already exists for this product by your username");
        }

        Review review = new Review();
        review.setUser(user);
        review.setProduct(product);
        review.setReviewComment(comment);

        return reviewRepository.save(review);
    }

    @Override
    public List<Review> fetchAllReviewByProductId(Long productId) {
        return reviewRepository.findAllReviewByProductId(productId);
    }

    @Override
    public Long countByProductId(Long productId) {
        return reviewRepository.countReviewByProduct_ProductId(productId);
    }
}