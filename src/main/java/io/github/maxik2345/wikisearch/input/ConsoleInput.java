package io.github.maxik2345.wikisearch.input;

import java.util.Optional;
import java.util.Scanner;

public class ConsoleInput {
    private final Scanner scanner;

    public ConsoleInput(Scanner scanner){
        this.scanner = scanner;
    }

    /** Возвращает непустой поисковый запрос или пустой Optional, если пользователь хочет выйти. */
    public Optional<String> readQuery(){
        return Optional.empty();
    }

    /** Возвращает номер статьи от 1 до max, или 0 — «назад к поиску». */
    public int readChoice(int max){
        return 0;
    }
}
