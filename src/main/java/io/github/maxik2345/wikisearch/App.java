package io.github.maxik2345.wikisearch;

import io.github.maxik2345.wikisearch.input.ConsoleInput;

import java.util.Optional;

public class App {
    private final ConsoleInput input;

    public App(ConsoleInput input) {
        this.input = input;
    }

    public void run() {
        while (true) {
            Optional<String> query = input.readQuery();

            if (query.isEmpty()) {
                break;
            }

            System.out.println("Вы ввели: " + query.get());
            input.readChoice(3);
        }

        System.out.println("Программа завершилась");
    }
}
