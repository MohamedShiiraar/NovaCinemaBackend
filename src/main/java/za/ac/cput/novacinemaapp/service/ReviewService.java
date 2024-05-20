package za.ac.cput.novacinemaapp.service;

/*  ReviewService.java
 *   Service for Review
 *   Author: Musaddiq McWhite (219369151)
 *   19 May 2024
 * */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.novacinemaapp.domain.Review;
import za.ac.cput.novacinemaapp.repository.ReviewRepository;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ReviewService implements IReviewService {
    private ReviewRepository repository;

    @Autowired
    ReviewService(ReviewRepository repository) {this.repository = repository;}

    @Override
    public Review create(Review review) {return repository.save(review);}
    @Override
    public Review read(String reviewId) {return repository.findReviewByReviewId(reviewId);}
    @Override
    public Review update(Review review) {return repository.save(review);}
    @Override
    public Set<Review> getAll() {return repository.findAll().stream().collect(Collectors.toSet());}

}
