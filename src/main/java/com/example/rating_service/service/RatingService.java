package com.example.rating_service.service;

import com.example.rating_service.exception.NotFoundException;
import com.example.rating_service.model.Rating;
import com.example.rating_service.repo.RatingRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RatingService {

    @Autowired
    RatingRepo ratingRepo;

    public Rating updateAverage(String name, double newRating){
        Rating existing =  ratingRepo.findByName(name);
        if(existing == null){
            //throw new NotFoundException("Movie is not found "+name);
            existing = new Rating();
            existing.setName(name);
            existing.setAvgRating(newRating);
            existing.setCount(1);

        } else {
            int ratingsCount = existing.getCount() + 1;
            double newAvg = ((existing.getAvgRating() * existing.getCount()) + newRating) / ratingsCount;
            existing.setAvgRating(newAvg);
            existing.setCount(ratingsCount);

        }
        return ratingRepo.save(existing);

    }

    public Rating fetchRating(String name){
        Rating existing =  ratingRepo.findByName(name);
        if(existing == null) {
            throw new NotFoundException("Movie is not found " + name);
        }

        return existing;
    }

}
