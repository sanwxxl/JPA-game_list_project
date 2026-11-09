package org.example.week09.week09_jpa_project.service;

import org.example.week09.week09_jpa_project.dto.GameRequest;
import org.example.week09.week09_jpa_project.dto.GameResponse;
import org.example.week09.week09_jpa_project.entity.Game;
import org.example.week09.week09_jpa_project.repository.GameRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
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

    //Q7: save는 entity의 처리방식을 보고 결정한다. id가 비어있으면 등록하고, id가 이미 존재하면 수정한다.
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

    //Q5(Optional인 이유): 는 id가 DB에 존재하지 않을 수도 있기때문에 NullPointerException이 날수도 있기때문에 있을수도 있고 없을수도 있는 optional로 해서 사용하는것이다.
    public GameResponse findById(Long id) {
        Game game = findGame(id);
        return new GameResponse(game);
    }

    public List<GameResponse> findByGenre(String genre) {
        List<Game> games = gameRepository.findByGenre(genre);
        List<GameResponse> result = new ArrayList<>();
        for (Game game : games) {
            result.add(new GameResponse(game));
        }
        return result;
    }

    public List<GameResponse> findByGenreAndPlatform(String genre, String platform) {
        List<Game> games = gameRepository.findByGenreAndPlatform(genre, platform);
        List<GameResponse> result = new ArrayList<>();
        for (Game game : games) {
            result.add(new GameResponse(game));
        }
        return result;
    }

    public List<GameResponse> findByPlatformSortByRating(String platform) {
        List<Game> games = gameRepository.findByPlatformOrderByRatingDesc(platform);
        List<GameResponse> result = new ArrayList<>();
        for (Game game : games) {
            result.add(new GameResponse(game));
        }
        return result;
    }

    @Transactional
    //Q8: 트랜젝션 안에서 동작하는것이 dirty checking 이고, 조회한 entity의 값만 바꾸기만 해도 JPA가 자동으로 업데이트 해주는 기능이다. 따로 save를 다시 호출할 필요가 없다.
    public GameResponse update(Long id, GameRequest request) {
        Game game = findGame(id);
        game.setTitle(request.getTitle());
        game.setGenre(request.getGenre());
        game.setPlatform(request.getPlatform());
        game.setPrice(request.getPrice());
        game.setReleaseYear(request.getReleaseYear());
        game.setRating(request.getRating());
        return new GameResponse(game);
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