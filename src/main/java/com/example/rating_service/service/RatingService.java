package com.example.rating_service.service;

import com.example.rating_service.model.Rating;
import com.example.rating_service.repo.RatingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RatingService {

    @Autowired
    RatingRepo ratingRepo;

    public void updateAverage(String name, double rating){
        Rating existing =     ratingRepo.findByMovieName(name);
        if(existing == null){
            throw new
        }
    }

}
