package com.example.zepzep.repository;

import com.example.zepzep.domain.GameResult;
import com.example.zepzep.domain.LandMark;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameResultRepository extends JpaRepository<GameResult,Long> {
}
