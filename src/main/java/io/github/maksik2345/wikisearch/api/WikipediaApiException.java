package io.github.maksik2345.wikisearch.api;

public class WikipediaApiException extends Exception {

    public WikipediaApiException(String message) {
        super(message);
    }

    public WikipediaApiException(String message, Throwable cause) {
        super(message, cause);
    }
}
