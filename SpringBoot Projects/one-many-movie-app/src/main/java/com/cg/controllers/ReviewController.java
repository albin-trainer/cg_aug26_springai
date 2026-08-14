package com.cg.controllers;

import com.cg.entities.Movie;
import com.cg.entities.Review;
import com.cg.repositories.MovieRepository;
import com.cg.repositories.ReviewRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/movies")
public class ReviewController {

    private final ReviewRepository reviewRepository;
    private final MovieRepository movieRepository;

    public ReviewController(ReviewRepository reviewRepository, MovieRepository movieRepository) {
        this.reviewRepository = reviewRepository;
        this.movieRepository = movieRepository;
    }

    @PostMapping("/{movieId}/reviews")
   // @ResponseStatus(HttpStatus.CREATED)
    public Review addReview(@PathVariable Long movieId, @RequestBody Review review) {
        Movie movie = movieRepository.findById(movieId)
                .orElseThrow(() -> new RuntimeException("Movie not found with id: " + movieId));
                //mapping done here .....
                review.setMovie(movie);
        return reviewRepository.save(review);
    }
}
