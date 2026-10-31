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
        String hint = "от 1 до " + max + ", 0 — новый поиск";

        while (true) {
            System.out.print("Выберите номер статьи (" + hint + "): ");

            if (!scanner.hasNextLine()) {
                return 0;
            }

            String line = scanner.nextLine().trim();

            try {
                int answer = Integer.parseInt(line);

                if (answer < 0 || answer > max) {
                    System.out.println("Некорректный ввод. Введите число " + hint + ".");
                    continue;
                }

                return answer;
            } catch (NumberFormatException e) {
                System.out.println("Некорректный ввод. Введите число " + hint + ".");
            }
        }
    }
}
