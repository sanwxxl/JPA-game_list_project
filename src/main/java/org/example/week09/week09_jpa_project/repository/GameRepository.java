package org.example.week09.week09_jpa_project.repository;

import org.example.week09.week09_jpa_project.entity.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Long> {
}