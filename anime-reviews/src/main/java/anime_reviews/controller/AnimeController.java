package anime_reviews.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import anime_reviews.controller.model.AnimeData;
import anime_reviews.controller.model.TagsData;
import anime_reviews.service.AnimeService;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(path = "/anime-reviews", produces = "application/json")
@Slf4j
public class AnimeController {

    @Autowired
    private AnimeService animeService;

    @PostMapping("/anime")
    public AnimeData createAnime(@RequestBody AnimeData animeData) {
        log.info("Creating anime: {}", animeData);

        return animeService.saveAnime(animeData);
    }

    @GetMapping("/anime")
    public List<AnimeData> getAllAnime() {
        log.info("Getting all anime info");

        return animeService.retrieveAllAnime();
    }

    @PostMapping("/tag")
    @ResponseStatus(HttpStatus.CREATED)
    public TagsData createTag(@RequestBody TagsData tagsData) {
        log.info("Creating tag: {}", tagsData);

        return animeService.saveTag(tagsData);
    }
}
