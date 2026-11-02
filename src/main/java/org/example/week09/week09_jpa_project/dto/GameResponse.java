package org.example.week09.week09_jpa_project.dto;

import org.example.week09.week09_jpa_project.entity.Game;

public class GameResponse {

    private Long id;
    private String title;
    private String genre;
    private String platform;
    private Integer price;
    private Integer releaseYear;
    private Double rating;

    public GameResponse(Game game) {
        this.id = game.getId();
        this.title = game.getTitle();
        this.genre = game.getGenre();
        this.platform = game.getPlatform();
        this.price = game.getPrice();
        this.releaseYear = game.getReleaseYear();
        this.rating = game.getRating();
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
    }

    public String getPlatform() {
        return platform;
    }

    public Integer getPrice() {
        return price;
    }

    public Integer getReleaseYear() {
        return releaseYear;
    }

    public Double getRating() {
        return rating;
    }
}
