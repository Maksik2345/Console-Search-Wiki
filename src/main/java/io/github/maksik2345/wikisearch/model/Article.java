package io.github.maksik2345.wikisearch.model;

import com.google.gson.annotations.SerializedName;

public record Article(
        String title,
        @SerializedName("pageid") int pageId,
        String snippet
) {}
