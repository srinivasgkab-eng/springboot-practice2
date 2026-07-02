package com.example.rating_service.repo;

import com.example.rating_service.model.Rating;
import org.hibernate.type.descriptor.converter.spi.JpaAttributeConverter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RatingRepo extends JpaRepository<Rating, Long> {

     Rating findByMovieName(String name);

     List<Rating> findAllByRatingBetween(double min, double max);

}
