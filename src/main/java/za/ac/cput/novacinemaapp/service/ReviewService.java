package za.ac.cput.novacinemaapp.service;

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
    public Review read(String id) {return repository.findById(id).orElse(null);}

    @Override
    public Review update(Review review) {return repository.save(review);}

    @Override
    public Set<Review> getall() {return repository.findAll().stream().collect(Collectors.toSet());}

}
