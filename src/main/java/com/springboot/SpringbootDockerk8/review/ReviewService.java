package com.springboot.SpringbootDockerk8.review;

import java.util.List;

public interface ReviewService {

    List<Review> getAllReviews(Long companyId);

    Review createReviews(Review review, Long companyId);

    Review getReviewByReviewId(Long companyId, Long reviewId);

    Review updateReview(Review review, Long companyId, Long reviewId);

    boolean deleteReview(Long companyId, Long reviewId);

}
