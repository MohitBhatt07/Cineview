package Cineview.Cineview;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;

@Service
public class MovieService {

  @Autowired
  private MovieRepository movieRepo;

  public List<Movie> allMovies(){  
    return movieRepo.findAll();
  }

  public Optional<Movie> singleMovie(String id){
    return movieRepo.findMovieByImdbId(id);
  }
}
