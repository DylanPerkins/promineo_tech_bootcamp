package anime_reviews.controller.model;

import anime_reviews.entity.Tags;

public class TagsData {
    private Long tagId;
    private String tagName;

    public TagsData(Tags tag) {
        this.tagId = tag.getTagId();
        this.tagName = tag.getTagName();
    }

    public TagsData(Long tagId, String tagName) {
        this.tagId = tagId;
        this.tagName = tagName;
    }

    public Tags toTags() {
        Tags tag = new Tags();

        tag.setTagId(tagId);
        tag.setTagName(tagName);

        return tag;
    }

}
