package com.example.rating_service.controller;

import com.example.rating_service.model.Rating;

import com.example.rating_service.model.RatingRequest;
import com.example.rating_service.service.RatingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@Slf4j
@RequestMapping("/ratings")
public class RatingController {
  @Autowired
  RatingService ratingService;

  @GetMapping("/{name}")
  public ResponseEntity<Rating> getRating(@PathVariable String name){
      Rating rating = ratingService.fetchRating(name);
      //return new ResponseEntity<>(rating, HttpStatus.OK);
      log.info("Returned rating for movie {}", name);
      return ResponseEntity.ok(rating);
  }

  @PostMapping("/")
   public ResponseEntity<Rating> updateRating(@RequestBody RatingRequest ratingRequest){
      Rating updated = ratingService.updateAverage(ratingRequest.getName(), ratingRequest.getRating());
      log.info("new average for movie {}"+ratingRequest.getName());
      return ResponseEntity.ok(updated);
      // return Map.of(ratingRequest.getName(), newAverage);
  }


}
