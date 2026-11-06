package io.github.maksik2345.wikisearch.browser;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;

public class DesktopBrowserOpener implements BrowserOpener {

    @Override
    public void open(URI uri) throws BrowserException {
        try {
            Desktop.getDesktop().browse(uri);
        } catch (IOException e) {
            throw new BrowserException("Не удалось открыть браузер", e);
        }
    }
}
