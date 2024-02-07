package anime_reviews.service;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import anime_reviews.controller.model.AnimeData;
import anime_reviews.controller.model.AnimeReviewData;
import anime_reviews.controller.model.TagsData;
import anime_reviews.controller.model.UsersData;
import anime_reviews.dao.AnimeDAO;
import anime_reviews.dao.AnimeReviewDAO;
import anime_reviews.dao.TagsDAO;
import anime_reviews.dao.UserDAO;
import anime_reviews.entity.Anime;
import anime_reviews.entity.AnimeReview;
import anime_reviews.entity.Tags;
import anime_reviews.entity.Users;

@Service
public class AnimeService {

    @Autowired
    private AnimeDAO animeDAO;

    @Autowired
    private TagsDAO tagsDAO;

    @Autowired
    private AnimeReviewDAO animeReviewDAO;

    @Autowired
    private UserDAO userDAO;

    @Transactional(readOnly = true)
    public List<AnimeData> retrieveAllAnime() {
        List<Anime> animeList = animeDAO.findAll();
        List<AnimeData> animeDataList = new LinkedList<>();

        for (Anime anime : animeList) {
            AnimeData animeData = new AnimeData(anime);

            animeDataList.add(animeData);
        }

        return animeDataList;
    }

    @Transactional(readOnly = false)
    public AnimeData saveAnime(AnimeData animeData) {
        Anime anime = animeData.toAnime();

        Anime savedAnime = animeDAO.save(anime);

        return new AnimeData(savedAnime);
    }

    @Transactional(readOnly = false)
    public TagsData saveTag(TagsData tagsData) {
        Tags tag = tagsData.toTags();

        Tags savedTag = tagsDAO.save(tag);

        return new TagsData(savedTag);
    }

    @Transactional(readOnly = false)
    public UsersData saveUser(UsersData usersData) {
        Users user = usersData.toUsers();

        Users savedUser = userDAO.save(user);

        return new UsersData(savedUser);
    }

    @Transactional(readOnly = false)
    public AnimeReviewData saveReview(Long userId, Long animeId, AnimeReviewData animeReviewData) {
        Users user = findUserById(userId);
        Anime anime = findAnimeById(animeId);

        AnimeReview animeReview = animeReviewData.toAnimeReview(user, anime);

        AnimeReview savedAnimeReview = animeReviewDAO.save(animeReview);

        return new AnimeReviewData(savedAnimeReview);
    }

    @Transactional(readOnly = true)
    public AnimeData retrieveAnimeById(Long animeId) {
        Anime anime = findAnimeById(animeId);

        return new AnimeData(anime);
    }

    @Transactional(readOnly = true)
    public TagsData retrieveTagById(Long tagId) {
        Tags tag = findTagById(tagId);

        return new TagsData(tag);
    }

    @Transactional(readOnly = false)
    public AnimeData addTagToAnime(Long animeId, Long tagId) {
        Anime anime = findAnimeById(animeId);
        Tags tag = findTagById(tagId);

        anime.addTag(tag);

        Anime savedAnime = animeDAO.save(anime);

        return new AnimeData(savedAnime);
    }

    @Transactional(readOnly = true)
    public UsersData retrieveUserById(Long userId) {
        Users user = findUserById(userId);

        UsersData usersData = new UsersData(user.getUserId(), user.getUsername(), user.getWatchedAnime(),
                user.getWatchingAnime(), user.getWantToWatch(), user.getWontWatch(), user.getAnimeReviews());

        usersData.removeNullValues();

        return usersData;
    }

    @Transactional(readOnly = false)
    public UsersData addWatchedAnime(Long userId, Long animeId) {
        if (userId == null || animeId == null) {
            throw new IllegalArgumentException("User ID and Anime ID must not be null");
        }

        Users user = findUserById(userId);

        if (user == null) {
            throw new NoSuchElementException("User ID=" + userId + " not found");
        }

        if (user.getWatchedAnime() == null) {
            user.setWatchedAnime(new HashSet<>());
        }

        user.getWatchedAnime().add(animeId);

        Users savedUser = userDAO.save(user);

        return new UsersData(savedUser);
    }

    @Transactional(readOnly = false)
    public UsersData addWatchingAnime(Long userId, Long animeId) {
        if (userId == null || animeId == null) {
            throw new IllegalArgumentException("User ID and Anime ID must not be null");
        }

        Users user = findUserById(userId);

        if (user == null) {
            throw new NoSuchElementException("User ID=" + userId + " not found");
        }

        if (user.getWatchingAnime() == null) {
            user.setWatchingAnime(new HashSet<>());
        }

        user.getWatchingAnime().add(animeId);

        Users savedUser = userDAO.save(user);

        return new UsersData(savedUser);
    }

    @Transactional(readOnly = false)
    public UsersData addWantToWatchAnime(Long userId, Long animeId) {
        if (userId == null || animeId == null) {
            throw new IllegalArgumentException("User ID and Anime ID must not be null");
        }

        Users user = findUserById(userId);

        if (user == null) {
            throw new NoSuchElementException("User ID=" + userId + " not found");
        }

        if (user.getWantToWatch() == null) {
            user.setWantToWatch(new HashSet<>());
        }

        user.getWantToWatch().add(animeId);

        Users savedUser = userDAO.save(user);

        return new UsersData(savedUser);
    }

    @Transactional(readOnly = false)
    public UsersData addWontWatchAnime(Long userId, Long animeId) {
        if (userId == null || animeId == null) {
            throw new IllegalArgumentException("User ID and Anime ID must not be null");
        }

        Users user = findUserById(userId);

        if (user == null) {
            throw new NoSuchElementException("User ID=" + userId + " not found");
        }

        if (user.getWontWatch() == null) {
            user.setWontWatch(new HashSet<>());
        }

        user.getWontWatch().add(animeId);

        Users savedUser = userDAO.save(user);

        return new UsersData(savedUser);
    }

    @Transactional(readOnly = false)
    public void removeWatchingAnimeByID(Long userId, Long animeId) {
        Users user = findUserById(userId);

        user.getWatchingAnime().remove(animeId);

        userDAO.save(user);
    }

    @Transactional(readOnly = false)
    public void removeWatchedAnimeByID(Long userId, Long animeId) {
        Users user = findUserById(userId);

        user.getWatchedAnime().remove(animeId);
        
        userDAO.save(user);
    }

    @Transactional(readOnly = false)
    public void removeWantToWatchAnimeByID(Long userId, Long animeId) {
        Users user = findUserById(userId);

        user.getWantToWatch().remove(animeId);
        
        userDAO.save(user);
    }

    @Transactional(readOnly = false)
    public void removeWontWatchAnimeByID(Long userId, Long animeId) {
        Users user = findUserById(userId);

        user.getWontWatch().remove(animeId);
        
        userDAO.save(user);
    }

    // Helper Methods

    private Users findUserById(Long userId) {
        return userDAO.findById(userId)
                .orElseThrow(() -> new NoSuchElementException("User ID=" + userId + " not found"));
    }

    private Anime findAnimeById(Long animeId) {
        return animeDAO.findById(animeId)
                .orElseThrow(() -> new NoSuchElementException("Anime ID=" + animeId + " not found"));
    }

    private Tags findTagById(Long tagId) {
        return tagsDAO.findById(tagId)
                .orElseThrow(() -> new NoSuchElementException("Tag ID=" + tagId + " not found"));
    }

    public void deleteReviewById(Long userId, Long animeId, Long reviewId) {
        Users user = findUserById(userId);
        Anime anime = findAnimeById(animeId);

        AnimeReview review = animeReviewDAO.findById(reviewId)
                .orElseThrow(() -> new NoSuchElementException("Review ID=" + reviewId + " not found"));

        if (!review.getUser().getUserId().equals(user.getUserId())
                && !review.getAnime().getAnimeId().equals(anime.getAnimeId())) {
            throw new IllegalArgumentException("Review ID=" + reviewId + " does not belong to User ID=" + userId
                    + " and Anime ID=" + animeId);
        }

        animeReviewDAO.delete(review);
    }

}
