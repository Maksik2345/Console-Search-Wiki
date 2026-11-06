package io.github.maksik2345.wikisearch.api;

import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.time.Duration;

public class WikipediaClient {

    private static final String BASE_URL = "https://ru.wikipedia.org/w/api.php";
    private static final String USER_AGENT = "ConsoleSearchWiki/1.0 (https://github.com/Maksik2345/Console-Search-Wiki)";
    private static final String SEARCH_PARAMS = "?action=query&list=search&utf8=&format=json&srsearch=";


    private final HttpClient httpClient;

    public WikipediaClient(HttpClient httpClient) {
        this.httpClient = httpClient;
    }

    public String search(String query) throws WikipediaApiException {
        String encodedQuery = URLEncoder.encode(query, StandardCharsets.UTF_8);
        URI uri = URI.create(BASE_URL + SEARCH_PARAMS + encodedQuery);
        HttpRequest request = HttpRequest.newBuilder()
                .uri(uri)
                .header("User-Agent", USER_AGENT)
                .GET()
                .timeout(Duration.ofSeconds(10))
                .build();

        try {
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() != 200) {
                throw new WikipediaApiException("Сервер вернул код " + response.statusCode());
            }

            return response.body();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new WikipediaApiException("Запрос был прерван", e);
        } catch (IOException e) {
            throw new WikipediaApiException("Не удалось связаться с Википедией", e);
        }
    }
}
