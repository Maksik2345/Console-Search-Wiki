package io.github.maksik2345.wikisearch;

import io.github.maksik2345.wikisearch.api.WikipediaApiException;
import io.github.maksik2345.wikisearch.api.WikipediaClient;
import io.github.maksik2345.wikisearch.input.ConsoleInput;
import io.github.maksik2345.wikisearch.model.Article;
import io.github.maksik2345.wikisearch.parser.SearchResponseParser;

import java.util.List;
import java.util.Optional;

public class App {
    private final ConsoleInput input;
    private final WikipediaClient wikipediaClient;
    private final SearchResponseParser parser;

    public App(ConsoleInput input, WikipediaClient wikipediaClient, SearchResponseParser parser) {
        this.input = input;
        this.wikipediaClient = wikipediaClient;
        this.parser = parser;
    }

    public void run() {
        while (true) {
            Optional<String> query = input.readQuery();

            if (query.isEmpty()) {
                break;
            }

            try {
                String json = wikipediaClient.search(query.get());
                List<Article> articles = parser.parse(json);

                if (articles.isEmpty()) {
                    System.out.println("Ничего не найдено");
                    continue;
                }

                for (Article article : articles) {
                    System.out.println(article.title());
                }
            } catch (WikipediaApiException e) {
                System.out.println(e.getMessage());
            }
        }

        System.out.println("Программа завершилась");
    }
}
