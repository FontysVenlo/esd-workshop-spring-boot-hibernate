package com.ESD.steamed.userGame;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserGameRepository extends JpaRepository<UserGame, Long> {
    List<UserGame> findByUser_Id(Long userId);

    Optional<UserGame> findByUser_IdAndGame_Id(Long userId, Long gameId);

    boolean existsByUser_IdAndGame_Id(Long userId, Long gameId);
}
