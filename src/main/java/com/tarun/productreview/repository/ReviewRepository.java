package com.tarun.productreview.repository;

import com.tarun.productreview.entity.Product;
import com.tarun.productreview.entity.Review;
import com.tarun.productreview.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
    public boolean existsByUserAndProduct(User user, Product product);





    @Query(
            value = "select * from review r where r.product_id = ?1",
            nativeQuery = true
    )
    public List<Review> findAllReviewByProductId(Long productId);


    public Long countReviewByProduct_ProductId(Long productId);

}