package com.tarun.productreview.controller;

import com.tarun.productreview.entity.Product;
import com.tarun.productreview.entity.Review;
import com.tarun.productreview.entity.User;
import com.tarun.productreview.repository.ProductRepository;
import com.tarun.productreview.repository.UserRepository;
import com.tarun.productreview.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin("*")
@RestController
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProductRepository productRepository;


    @PostMapping("/post/userId/{userid}/productId/{productid}/{comment}")
    public ResponseEntity<Object> postReview(
            @PathVariable("userid") Long userId,
            @PathVariable("productid") Long productId,
            @PathVariable("comment") String reviewComment
    )
    {

        Map<String, Object> map = new HashMap<>();

        if(userRepository.existsUserByUserId(userId)){
            User user = userRepository.findUserByUserId(userId);
            Product product = productRepository.findByProductId(productId);
            reviewService.createReview(user, product, reviewComment);

            map.put("message", "Review Posted Successfully");
            return new ResponseEntity<>(map, HttpStatus.OK);
        }

        map.put("message", "Review Already Exists On this product with your username !!");
        return new ResponseEntity<>(map, HttpStatus.CONFLICT);
    }


    @GetMapping("/review/productId/{productId}")
    public List<Review> fetchAllReviewByProductId(@PathVariable("productId") Long productId){
        return reviewService.fetchAllReviewByProductId(productId);
    }

    @GetMapping("review/count/productId/{productId}")
    public ResponseEntity<Long> getReviewCountByProductId(@PathVariable("productId") Long productId) {


        long reviewCount = reviewService.countByProductId(productId);
        return ResponseEntity.ok(reviewCount);
    }


}