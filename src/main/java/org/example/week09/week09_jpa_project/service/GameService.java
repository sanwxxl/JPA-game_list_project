package org.example.week09.week09_jpa_project.service;

import org.example.week09.week09_jpa_project.dto.GameRequest;
import org.example.week09.week09_jpa_project.dto.GameResponse;
import org.example.week09.week09_jpa_project.entity.Game;
import org.example.week09.week09_jpa_project.repository.GameRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class GameService {

    private final GameRepository gameRepository;

    public GameService(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    public GameResponse create(GameRequest request) {
        Game game = new Game(
                request.getTitle(),
                request.getGenre(),
                request.getPlatform(),
                request.getPrice(),
                request.getReleaseYear(),
                request.getRating()
        );
        Game saved = gameRepository.save(game);
        return new GameResponse(saved);
    }

    public List<GameResponse> findAll() {
        List<Game> games = gameRepository.findAll();
        List<GameResponse> result = new ArrayList<>();
        for (Game game : games) {
            result.add(new GameResponse(game));
        }
        return result;
    }

    public GameResponse findById(Long id) {
        Game game = findGame(id);
        return new GameResponse(game);
    }

    public GameResponse update(Long id, GameRequest request) {
        Game game = findGame(id);
        game.setTitle(request.getTitle());
        game.setGenre(request.getGenre());
        game.setPlatform(request.getPlatform());
        game.setPrice(request.getPrice());
        game.setReleaseYear(request.getReleaseYear());
        game.setRating(request.getRating());
        Game saved = gameRepository.save(game);
        return new GameResponse(saved);
    }

    public void delete(Long id) {
        findGame(id);
        gameRepository.deleteById(id);
    }

    private Game findGame(Long id) {
        Optional<Game> result = gameRepository.findById(id);
        if (result.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "게임을 찾을 수 없습니다. id=" + id);
        }
        return result.get();
    }
}