package com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository;

import com.codeclan.example.WhiskyTracker.models.Whisky;

import java.util.List;

public interface WhiskyRepositoryCustom {

//    TODO: Put method prototypes for custom queries in here

//    List<Whisky> findWhiskiesThatHaveDistilleryNameAndWhiskyAge(int age);
//    List<Whisky> findWhiskiesThatHaveDistilleryNameAndWhiskyAge(String name);
    List<Whisky> findWhiskiesThatHaveDistilleryNameAndWhiskyAge(String name, int age);

    List<Whisky> findWhiskiesByRegion(String region);
}
