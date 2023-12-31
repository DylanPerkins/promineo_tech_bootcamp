package anime_reviews.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import anime_reviews.controller.model.AnimeData;
import anime_reviews.service.AnimeService;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/anime-reviews")
@Slf4j
public class AnimeController {

    @Autowired
    private AnimeService animeService;

    @PostMapping("/anime")
    public AnimeData createAnime(AnimeData animeData) {
        log.info("Creating anime: {}", animeData);

        return animeService.saveAnime(animeData);
    }

    @GetMapping("/anime")
    public List<AnimeData> getAllAnime() {
        log.info("Getting all anime info");

        return animeService.retrieveAllAnime();
    }
}
