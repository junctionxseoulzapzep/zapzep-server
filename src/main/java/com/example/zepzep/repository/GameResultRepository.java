package com.example.zepzep.repository;

import com.example.zepzep.domain.GameResult;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameResultRepository extends JpaRepository<GameResult,Long> {
}
