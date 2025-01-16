package com.springboot.SpringbootDockerk8.review.reviewserviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.springboot.SpringbootDockerk8.company.Company;
import com.springboot.SpringbootDockerk8.company.CompanyRepository;
import com.springboot.SpringbootDockerk8.company.CompanyService;
import com.springboot.SpringbootDockerk8.review.Review;
import com.springboot.SpringbootDockerk8.review.ReviewController;
import com.springboot.SpringbootDockerk8.review.ReviewRepository;
import com.springboot.SpringbootDockerk8.review.ReviewService;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ReviewServiceImpl implements ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private CompanyService companyService;

    private ReviewServiceImpl(ReviewRepository reviewRepository, CompanyService companyService) {
        this.reviewRepository = reviewRepository;
        this.companyService = companyService;
        // this.reviewService = reviewService;
    }

    @Override
    public List<Review> getAllReviews(Long companyId) {
        List<Review> reviews = reviewRepository.findReviewByCompanyId(companyId);
        return reviews;
    }

    @Override
    public Review createReviews(Review review, Long companyId) {
        Company company = companyService.getCompanyById(companyId);
        if (company != null) {
            review.setCompany(company);
            reviewRepository.save(review);
            return review;

        } else {
            return review;
        }
    }

    @Override
    public Review getReviewByReviewId(Long companyId, Long reviewId) {
        List<Review> reviews = reviewRepository.findReviewByCompanyId(companyId);

        return reviews.stream().filter(r -> r.getId().equals(reviewId)).findFirst().orElse(null);
    }

    @Override
    public Review updateReview(Review review, Long companyId, Long reviewId) {
        Company company = companyService.getCompanyById(companyId);
        if (company != null && companyService.getCompanyById(company.getId()).equals(companyId)) {
            review.setCompany(companyService.getCompanyById(companyId));
            review.setId(reviewId);
            reviewRepository.save(review);
        } else {
            throw new EntityNotFoundException("Company with ID " + companyId + " not found.");
        }
        return review;

    }

    @Override
    public boolean deleteReview(Long companyId, Long reviewId) {

        if (companyId != null && reviewRepository.existsById(reviewId)) {
            Review review = reviewRepository.findById(reviewId).orElse(null);
            Company company = review.getCompany();
            company.getReviews().remove(review);
            review.setCompany(null);
            companyService.updateCompany(company, reviewId);
            reviewRepository.deleteById(reviewId);
            return true;

        } else {
            return false;
        }
    }

}
