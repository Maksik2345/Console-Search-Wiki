package io.github.maksik2345.wikisearch;

import io.github.maksik2345.wikisearch.api.WikipediaApiException;
import io.github.maksik2345.wikisearch.api.WikipediaClient;
import io.github.maksik2345.wikisearch.input.ConsoleInput;

import java.util.Optional;

public class App {
    private final ConsoleInput input;
    private final WikipediaClient wikipediaClient;

    public App(ConsoleInput input, WikipediaClient wikipediaClient) {
        this.input = input;
        this.wikipediaClient = wikipediaClient;
    }

    public void run() {
        while (true) {
            Optional<String> query = input.readQuery();

            if (query.isEmpty()) {
                break;
            }

            try {
                String json = wikipediaClient.search(query.get());
                System.out.println(json);
            } catch (WikipediaApiException e) {
                System.out.println(e.getMessage());
            }
        }

        System.out.println("Программа завершилась");
    }
}
