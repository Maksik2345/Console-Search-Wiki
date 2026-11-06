package io.github.maksik2345.wikisearch.browser;

import io.github.maksik2345.wikisearch.output.ConsolePrinter;

import java.net.URI;

public class ConsoleLinkPrinter implements BrowserOpener{

    private final ConsolePrinter consolePrinter;

    public ConsoleLinkPrinter(ConsolePrinter consolePrinter) {
        this.consolePrinter = consolePrinter;
    }

    @Override
    public void open(URI uri) throws BrowserException {
        consolePrinter.printLink(uri);
    }
}
