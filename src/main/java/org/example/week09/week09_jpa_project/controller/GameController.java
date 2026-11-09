package org.example.week09.week09_jpa_project.controller;

import org.example.week09.week09_jpa_project.dto.GameRequest;
import org.example.week09.week09_jpa_project.dto.GameResponse;
import org.example.week09.week09_jpa_project.service.GameService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/games")
public class GameController {

    private final GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @PostMapping
    public GameResponse create(@RequestBody GameRequest request) {
        return gameService.create(request);
    }

    @GetMapping
    public List<GameResponse> findAll() {
        return gameService.findAll();
    }

    @GetMapping("/{id}")
    public GameResponse findById(@PathVariable Long id) {
        return gameService.findById(id);
    }

    @GetMapping("/search/genre")
    public List<GameResponse> findByGenre(@RequestParam String genre) {
        return gameService.findByGenre(genre);
    }

    @GetMapping("/search/genre-platform")
    public List<GameResponse> findByGenreAndPlatform(@RequestParam String genre, @RequestParam String platform) {
        return gameService.findByGenreAndPlatform(genre, platform);
    }

    @GetMapping("/search/platform-rating")
    public List<GameResponse> findByPlatformSortByRating(@RequestParam String platform) {
        return gameService.findByPlatformSortByRating(platform);
    }


    @PutMapping("/{id}")
    public GameResponse update(@PathVariable Long id, @RequestBody GameRequest request) {
        return gameService.update(id, request);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        gameService.delete(id);
        return "삭제 완료: id=" + id;
    }
}