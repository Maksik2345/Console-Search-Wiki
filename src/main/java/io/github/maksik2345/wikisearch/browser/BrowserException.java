package io.github.maksik2345.wikisearch.browser;

import java.io.IOException;

public class BrowserException extends IOException {
    public BrowserException(String message) {
        super(message);
    }

    public BrowserException(String message, Throwable cause) {
        super(message, cause);
    }
}
