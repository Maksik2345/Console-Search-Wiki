package io.github.maksik2345.wikisearch.browser;

import java.net.URI;

public interface BrowserOpener {
    void open(URI uri) throws BrowserException;
}