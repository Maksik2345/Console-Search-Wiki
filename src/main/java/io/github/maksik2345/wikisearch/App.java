package io.github.maksik2345.wikisearch;

import io.github.maksik2345.wikisearch.api.WikipediaApiException;
import io.github.maksik2345.wikisearch.api.WikipediaClient;
import io.github.maksik2345.wikisearch.input.ConsoleInput;
import io.github.maksik2345.wikisearch.model.Article;
import io.github.maksik2345.wikisearch.output.ConsolePrinter;
import io.github.maksik2345.wikisearch.parser.SearchResponseParser;

import java.util.List;
import java.util.Optional;

public class App {
    private final ConsoleInput input;
    private final WikipediaClient wikipediaClient;
    private final SearchResponseParser parser;
    private final ConsolePrinter consolePrinter;

    public App(
            ConsoleInput input,
            WikipediaClient wikipediaClient,
            SearchResponseParser parser,
            ConsolePrinter consolePrinter
    ) {
        this.input = input;
        this.wikipediaClient = wikipediaClient;
        this.parser = parser;
        this.consolePrinter = consolePrinter;
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
                    consolePrinter.printNoResults();
                    continue;
                }

                consolePrinter.printResults(articles);

                int choiceNumber = input.readChoice(articles.size());

                if (choiceNumber == 0) {
                    continue;
                }

                Article article = articles.get(choiceNumber - 1);
                System.out.printf("Вы выбрали: %s (id %d)%n", article.title(), article.pageId());
            } catch (WikipediaApiException e) {
                consolePrinter.printError(e.getMessage());
            }
        }

        consolePrinter.printGoodbye();
    }
}
