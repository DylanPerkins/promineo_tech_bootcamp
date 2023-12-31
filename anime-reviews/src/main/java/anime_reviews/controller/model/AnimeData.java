package anime_reviews.controller.model;

import java.util.HashSet;
import java.util.Set;

import anime_reviews.entity.Anime;
import anime_reviews.entity.Tags;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AnimeData {
    private Long animeId;
    private String title;
    private String animationStudio;
    private Integer episodeCount;
    private Set<TagsData> tags = new HashSet<>();

    public AnimeData(Anime anime) {
        this.animeId = anime.getAnimeId();
        this.title = anime.getTitle();
        this.animationStudio = anime.getAnimationStudio();
        this.episodeCount = anime.getEpisodeCount();

        for (Tags tag : anime.getTags()) {
            this.tags.add(new TagsData(tag.getTagId(), tag.getTagName()));
        }
    }

    public Anime toAnime() {
        Anime anime = new Anime();

        anime.setAnimeId(animeId);
        anime.setTitle(title);
        anime.setAnimationStudio(animationStudio);
        anime.setEpisodeCount(episodeCount);

        for (TagsData tagData : tags) {
            anime.getTags().add(tagData.toTags());
        }

        return anime;
    }
}
