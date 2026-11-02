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