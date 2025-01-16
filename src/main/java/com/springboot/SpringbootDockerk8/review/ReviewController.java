package com.springboot.SpringbootDockerk8.review;

import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.SpringbootDockerk8.review.reviewserviceimpl.ReviewServiceImpl;

@RestController
@RequestMapping("/companies/{companyId}")
public class ReviewController {

    private ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping("/reviews")
    public ResponseEntity<List<Review>> getAllReviews(@PathVariable Long companyId) {
        List<Review> reviews = reviewService.getAllReviews(companyId);
        return new ResponseEntity<>(reviews, HttpStatus.OK);
    }

    @PostMapping("/reviews")
    public ResponseEntity<Review> createReview(@RequestBody Review review, @PathVariable Long companyId) {
        Review review2 = reviewService.createReviews(review, companyId);
        return new ResponseEntity<>(review2, HttpStatus.CREATED);
    }

    @GetMapping("reviews/{reviewId}")
    public ResponseEntity<Review> getReviewsByReviewId(@PathVariable Long companyId, @PathVariable Long reviewId) {
        Review review = reviewService.getReviewByReviewId(companyId, reviewId);
        return new ResponseEntity<>(review, HttpStatus.OK);
    }

    @PutMapping("/reviews/{reviewId}")
    public ResponseEntity<Review> updateReviws(@RequestBody Review review,
            @PathVariable Long companyId, @PathVariable Long reviewId) {
        Review reviews = reviewService.updateReview(review, companyId, reviewId);
        return new ResponseEntity<>(reviews, HttpStatus.OK);

    }

    @DeleteMapping("/reviews/{reviwsId}")
    public ResponseEntity<String> deleteReview(@PathVariable Long companyId, @PathVariable Long reviewId) {

        boolean isReviewIsDeleted = reviewService.deleteReview(companyId, reviewId);
        if (isReviewIsDeleted) {
            return new ResponseEntity<>("Review is deleted successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Review is not deleted", HttpStatus.NOT_FOUND);
        }
    }

}
