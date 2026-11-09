package org.example.week09.week09_jpa_project.repository;

import org.example.week09.week09_jpa_project.entity.Game;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

//Q3: 여기서 Game은 이 repo에서 다룰 클래스이고,Long은 PK(@ID) 타입이다.
public interface GameRepository extends JpaRepository<Game, Long> {
    /*Q4(기본 제공 메소드):
    *save(entity): 저장하거나 수정한다.
    *findById(id): id를 통한 조건검색
    *findAll(): 전체 조회
    * deleteById(id): id를 통한 지정 삭제
    * count(): 전체 개수를 센다
    * */

    List<Game> findByGenre(String genre);

    List<Game> findByGenreAndPlatform(String genre, String platform);

    List<Game> findByPlatformOrderByRatingDesc(String platform);
    /*Q6:
    기본메소드는 아무것도 작성하지 않아도 바로 사용할 수 있다.
    Query메소드는 규칙에 맞게 메서드 이름만 선언하면, JPA가 해석해서 자동으로 SQL을 만들어준다.

     */
}