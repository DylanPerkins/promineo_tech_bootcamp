package anime_reviews.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import anime_reviews.controller.model.AnimeData;
import anime_reviews.controller.model.TagsData;
import anime_reviews.controller.model.UsersData;
import anime_reviews.service.AnimeService;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(path = "/anime-reviews", produces = "application/json")
@Slf4j
public class AnimeController {

    @Autowired
    private AnimeService animeService;

    // Create a new anime
    @PostMapping("/anime")
    public AnimeData createAnime(@RequestBody AnimeData animeData) {
        log.info("Creating anime: {}", animeData);

        return animeService.saveAnime(animeData);
    }

    // Get all anime and associated tags (if any)
    @GetMapping("/anime")
    public List<AnimeData> getAllAnime() {
        log.info("Getting all anime info");

        return animeService.retrieveAllAnime();
    }

    // Get a specific anime and associated tags (if any)
    @GetMapping("/anime/{animeId}")
    public AnimeData retrieveAnime(@PathVariable Long animeId) {
        log.info("Getting anime: {}", animeId);

        return animeService.retrieveAnimeById(animeId);
    }

    // Add a tag to an anime
    @PostMapping("/anime/{animeId}/tag/{tagId}")
    @ResponseStatus(HttpStatus.CREATED)
    public AnimeData addTagToAnime(@PathVariable Long animeId, @PathVariable Long tagId) {
        log.info("Adding tag {} to anime {}", tagId, animeId);

        return animeService.addTagToAnime(animeId, tagId);
    }

    // Create a new tag
    @PostMapping("/tag")
    @ResponseStatus(HttpStatus.CREATED)
    public TagsData createTag(@RequestBody TagsData tagsData) {
        log.info("Creating tag: {}", tagsData);

        return animeService.saveTag(tagsData);
    }

    // Get a tag's info
    @GetMapping("/tag/{tagId}")
    @ResponseStatus(HttpStatus.OK)
    public TagsData retrieveTag(@PathVariable Long tagId) {
        log.info("Getting tag: {}", tagId);

        return animeService.retrieveTagById(tagId);
    }

    // Create a new user
    @PostMapping("/user")
    @ResponseStatus(HttpStatus.CREATED)
    public UsersData createUser(@RequestBody UsersData usersData) {
        log.info("Creating user: {}", usersData);

        return animeService.saveUser(usersData);
    }

    // Get all of a user's info
    @GetMapping("/user/{userId}")
    @ResponseStatus(HttpStatus.OK)
    public UsersData retrieveUser(@PathVariable Long userId) {
        log.info("Getting user: {}", userId);

        return animeService.retrieveUserById(userId);
    }

    // The following 4 POST requests function to add anime to user's list

    // Add anime to user's watched list
    @PostMapping("/user/{userId}/watched/{animeId}")
    @ResponseStatus(HttpStatus.CREATED)
    public UsersData addWatchedAnime(@PathVariable Long userId, @PathVariable Long animeId) {
        log.info("Adding anime {} to user {}'s watched list", animeId, userId);

        return animeService.addWatchedAnime(userId, animeId);
    }

    // Add anime to user's watching list
    @PostMapping("/user/{userId}/watching/{animeId}")
    @ResponseStatus(HttpStatus.CREATED)
    public UsersData addWatchingAnime(@PathVariable Long userId, @PathVariable Long animeId) {
        log.info("Adding anime {} to user {}'s watching list", animeId, userId);

        return animeService.addWatchingAnime(userId, animeId);
    }

    // Add anime to user's want to watch list
    @PostMapping("/user/{userId}/want-to-watch/{animeId}")
    @ResponseStatus(HttpStatus.CREATED)
    public UsersData addWantToWatchAnime(@PathVariable Long userId, @PathVariable Long animeId) {
        log.info("Adding anime {} to user {}'s want to watch list", animeId, userId);

        return animeService.addWantToWatchAnime(userId, animeId);
    }

    // Add anime to user's wont watch list
    @PostMapping("/user/{userId}/wont-watch/{animeId}")
    @ResponseStatus(HttpStatus.CREATED)
    public UsersData addWontWatchAnime(@PathVariable Long userId, @PathVariable Long animeId) {
        log.info("Adding anime {} to user {}'s wont watch list", animeId, userId);

        return animeService.addWontWatchAnime(userId, animeId);
    }

    // The following 4 DELETE requests function to remove anime from user's list

    // Remove an anime from user's watched list
    @DeleteMapping("/user/{userId}/watched/{animeId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Map<String, String> removeWatchedAnime(@PathVariable Long userId, @PathVariable Long animeId) {
        log.info("Removing anime {} from user {}'s watched list", animeId, userId);
        animeService.removeWatchedAnimeByID(userId, animeId);

        return Map.of("message", "Anime ID deleted successfully from the user's watched list");
    }

    // Remove an anime from user's watching list
    @DeleteMapping("/user/{userId}/watching/{animeId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Map<String, String> removeWatchingAnime(@PathVariable Long userId, @PathVariable Long animeId) {
        log.info("Removing anime {} from user {}'s watching list", animeId, userId);
        animeService.removeWatchingAnimeByID(userId, animeId);

        return Map.of("message", "Anime ID deleted successfully from the user's watching list");
    }

    // Remove an anime from user's want to watch list
    @DeleteMapping("/user/{userId}/want-to-watch/{animeId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Map<String, String> removeWantToWatchAnime(@PathVariable Long userId, @PathVariable Long animeId) {
        log.info("Removing anime {} from user {}'s want to watch list", animeId, userId);
        animeService.removeWantToWatchAnimeByID(userId, animeId);

        return Map.of("message", "Anime ID deleted successfully from the user's want to watch list");
    }

    // Remove an anime from user's wont watch list
    @DeleteMapping("/user/{userId}/wont-watch/{animeId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Map<String, String> removeWontWatchAnime(@PathVariable Long userId, @PathVariable Long animeId) {
        log.info("Removing anime {} from user {}'s wont watch list", animeId, userId);
        animeService.removeWontWatchAnimeByID(userId, animeId);

        return Map.of("message", "Anime ID deleted successfully from the user's wont watch list");
    }

}
