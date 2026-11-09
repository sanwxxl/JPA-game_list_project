package org.example.week09.week09_jpa_project.entity;

import jakarta.persistence.*;



@Entity //Q1: DB테이블과 연결되는 클래스라는결 알려주는 annotaition이다.

//Q2: JPA가 클래스는 테이블로, 필드는 컬럼으로, 객체 하나는 행 하나로 연결한다. 클래스 이름이 기본적으로 테이블 이름이 되고,@Table, @Column으로 바꿀 수도 있다.
@Table(name = "game_list")
public class Game {

    @Id //Q1: 이 field가 PK(기본키)임을 알려주는 것이다.
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Q1: PK값을 직접 넣지 않아도 DB가 알아서 자동으로 만들어준다.
    private Long id;

    @Column(nullable = false, length = 100)
    private String title;

    @Column(length = 50)
    private String genre;

    @Column(length = 50)
    private String platform;

    private Integer price;

    @Column(name = "release_year")
    private Integer releaseYear;

    private Double rating;

    protected Game() {
    }

    public Game(String title, String genre, String platform, Integer price, Integer releaseYear, Double rating) {
        this.title = title;
        this.genre = genre;
        this.platform = platform;
        this.price = price;
        this.releaseYear = releaseYear;
        this.rating = rating;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(Integer releaseYear) {
        this.releaseYear = releaseYear;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }
}