package com.cineview.cineview;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {
  
  @Autowired
  ReviewRepository reviewRepo;

  @Autowired
  MongoTemplate mongoTemplate;
  
  public List<Review> getReviews(){
    return reviewRepo.findAll();
  }

  public Review createReview(String reviewBody , String imdbId){
    Review currReview = reviewRepo.insert(new Review(reviewBody));
    mongoTemplate.update(Movie.class).
                  matching(Criteria.where("imdbId").is(imdbId)).
                  apply(new Update().push("reviewIds").value(currReview)).
                  first();
    return currReview;
  } 
}
