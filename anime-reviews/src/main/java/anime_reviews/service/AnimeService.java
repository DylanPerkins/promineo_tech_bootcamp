package anime_reviews.service;

import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import anime_reviews.controller.model.AnimeData;
import anime_reviews.controller.model.TagsData;
import anime_reviews.dao.AnimeDAO;
import anime_reviews.dao.AnimeReviewDAO;
import anime_reviews.dao.TagsDAO;
import anime_reviews.dao.UserDAO;
import anime_reviews.entity.Anime;
import anime_reviews.entity.Tags;

@Service
public class AnimeService {

    @Autowired
    private AnimeDAO animeDAO;

    @Autowired
    private TagsDAO tagsDAO;

    // @Autowired
    // private AnimeReviewDAO animeReviewDAO;

    // @Autowired
    // private UserDAO userDAO;

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

    // Helper Methods

    private Anime findAnimeById(Long animeId) {
        return animeDAO.findById(animeId)
                .orElseThrow(() -> new NoSuchElementException("Anime ID=" + animeId + " not found"));
    }

    private Tags findTagById(Long tagId) {
        return tagsDAO.findById(tagId)
                .orElseThrow(() -> new NoSuchElementException("Tag ID=" + tagId + " not found"));
    }

    public AnimeData addTagToAnime(Long animeId, Long tagId) {
        Anime anime = findAnimeById(animeId);
        Tags tag = findTagById(tagId);

        anime.addTag(tag);

        Anime savedAnime = animeDAO.save(anime);

        return new AnimeData(savedAnime);
    }
}
