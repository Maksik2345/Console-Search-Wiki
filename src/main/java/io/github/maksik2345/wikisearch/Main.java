package io.github.maksik2345.wikisearch;

import io.github.maksik2345.wikisearch.api.WikipediaClient;
import io.github.maksik2345.wikisearch.input.ConsoleInput;

import java.net.http.HttpClient;
import java.time.Duration;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            ConsoleInput input = new ConsoleInput(scanner);
            HttpClient httpClient = HttpClient.newBuilder()
                    .connectTimeout(Duration.ofSeconds(10))
                    .build();
            WikipediaClient wikipediaClient = new WikipediaClient(httpClient);
            App app = new App(input, wikipediaClient);
            app.run();
        }
    }
}
