package com.springboot.SpringbootDockerk8.review;

import java.util.List;

public interface ReviewService {

    List<Review> getAllReviews(Long companyId);

    Review createReviews(Review review, Long companyId);

}
