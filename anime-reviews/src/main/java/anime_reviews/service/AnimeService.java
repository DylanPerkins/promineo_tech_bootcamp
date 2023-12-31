package anime_reviews.service;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import anime_reviews.controller.model.AnimeData;
import anime_reviews.dao.AnimeDAO;
import anime_reviews.dao.AnimeReviewDAO;
import anime_reviews.dao.UserDAO;
import anime_reviews.entity.Anime;

@Service
public class AnimeService {

    @Autowired
    private AnimeDAO animeDAO;

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
}
