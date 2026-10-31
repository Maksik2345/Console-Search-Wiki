package io.github.maxik2345.wikisearch;

import io.github.maxik2345.wikisearch.input.ConsoleInput;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            ConsoleInput input = new ConsoleInput(scanner);
            App app = new App(input);
            app.run();
        }
    }
}
