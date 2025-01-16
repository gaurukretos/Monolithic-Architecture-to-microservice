package com.springboot.SpringbootDockerk8.review.reviewserviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.SpringbootDockerk8.company.Company;
import com.springboot.SpringbootDockerk8.company.CompanyRepository;
import com.springboot.SpringbootDockerk8.company.CompanyService;
import com.springboot.SpringbootDockerk8.review.Review;
import com.springboot.SpringbootDockerk8.review.ReviewRepository;
import com.springboot.SpringbootDockerk8.review.ReviewService;

@Service
public class ReviewServiceImpl implements ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private CompanyService companyService;

    private ReviewServiceImpl(ReviewRepository reviewRepository, CompanyService companyService) {
        this.reviewRepository = reviewRepository;
        this.companyService = companyService;
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

}
