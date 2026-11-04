package io.github.maksik2345.wikisearch;

import com.google.gson.Gson;
import io.github.maksik2345.wikisearch.api.WikipediaClient;
import io.github.maksik2345.wikisearch.browser.BrowserOpener;
import io.github.maksik2345.wikisearch.browser.ConsoleLinkPrinter;
import io.github.maksik2345.wikisearch.browser.DesktopBrowserOpener;
import io.github.maksik2345.wikisearch.input.ConsoleInput;
import io.github.maksik2345.wikisearch.output.ConsolePrinter;
import io.github.maksik2345.wikisearch.parser.SearchResponseParser;

import java.awt.*;
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
            Gson gson = new Gson();
            SearchResponseParser parser = new SearchResponseParser(gson);
            ConsolePrinter consolePrinter = new ConsolePrinter();
            BrowserOpener browserOpener = createBrowserOpener(consolePrinter);
            App app = new App(
                    input,
                    wikipediaClient,
                    parser,
                    consolePrinter,
                    browserOpener);
            app.run();
        }
    }

    private static BrowserOpener createBrowserOpener(ConsolePrinter printer) {
        if (Desktop.isDesktopSupported()
                && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
            return new DesktopBrowserOpener();
        }
        return new ConsoleLinkPrinter(printer);
    }
}