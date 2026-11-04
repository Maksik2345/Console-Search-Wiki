package io.github.maksik2345.wikisearch.model;

import com.google.gson.annotations.SerializedName;

import java.net.URI;

public record Article(
        String title,
        @SerializedName("pageid") int pageId,
        String snippet
) {
    private static final String ARTICLE_URL = "https://ru.wikipedia.org/w/index.php?curid=";

    public URI url() {
        return URI.create(ARTICLE_URL + pageId);
    }
}
