package io.github.maxik2345.wikisearch.input;

import java.util.Optional;
import java.util.Scanner;

public class ConsoleInput {
    private final Scanner scanner;
    private static final String EXIT_COMMAND = "exit";

    public ConsoleInput(Scanner scanner) {
        this.scanner = scanner;
    }

    /**
     * Возвращает непустой поисковый запрос или пустой Optional, если пользователь хочет выйти.
     */
    public Optional<String> readQuery() {
        while (true) {
            System.out.println("Введите поисковый запрос (exit для выхода)");

            if (!scanner.hasNextLine()) {
                return Optional.empty();
            }

            String line = scanner.nextLine().trim();

            if (line.equalsIgnoreCase(EXIT_COMMAND)) {
                return Optional.empty();
            }

            if (line.isEmpty()) {
                System.out.println("Строка пустая");
                continue;
            }

            return Optional.of(line);
        }
    }

    /**
     * Возвращает номер статьи от 1 до max, или 0 — «назад к поиску».
     */
    public int readChoice(int max) {
        return 0;
    }
}
