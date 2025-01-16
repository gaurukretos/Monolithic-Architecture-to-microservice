package com.springboot.SpringbootDockerk8.review;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ReviewRepository extends JpaRepository<Review, Long> {

    @Query(value = "SELECT * FROM REVIEW WHERE company_id = ?1", nativeQuery = true)
    List<Review> findReviewByCompanyId(Long company_id);

}
