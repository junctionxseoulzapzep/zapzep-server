package com.example.zepzep.repository;

import com.example.zepzep.domain.LandMark;
import com.example.zepzep.domain.Ranker;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RankerRepository extends JpaRepository<Ranker, Long> {
    Optional<Ranker> findByLandMark(LandMark landmark);
}
