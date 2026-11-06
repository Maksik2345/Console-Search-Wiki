package io.github.maksik2345.wikisearch.parser;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import io.github.maksik2345.wikisearch.api.WikipediaApiException;
import io.github.maksik2345.wikisearch.model.Article;
import io.github.maksik2345.wikisearch.model.SearchResponse;

import java.util.List;

public class SearchResponseParser {

    private final Gson gson;

    public SearchResponseParser(Gson gson) {
        this.gson = gson;
    }

    public List<Article> parse(String json) throws WikipediaApiException {
        try {
            SearchResponse response = gson.fromJson(json, SearchResponse.class);

            if (response == null || response.query() == null || response.query().search() == null) {
                throw new WikipediaApiException("Некорректный ответ сервера");
            }

            return response.query().search();
        } catch (JsonSyntaxException e) {
            throw new WikipediaApiException("Некорректный ответ сервера", e);
        }
    }
}
