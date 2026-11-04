package io.github.maksik2345.wikisearch.output;

import io.github.maksik2345.wikisearch.model.Article;

import java.util.List;

public class ConsolePrinter {

    public void printResults(List<Article> articles) {
        System.out.println("Найдено статей: " + articles.size());
        System.out.println("");

        for (int i = 0; i < articles.size(); i++) {
            Article article = articles.get(i);

            System.out.printf("%d. %s%n", i + 1, article.title());
            System.out.println("    " + cleanSnippet(articles.get(i).snippet()) + " ...");
            System.out.println("");
        }
    }

    public void printNoResults() {
        System.out.println("Ничего не найдено");
    }

    public void printError(String message) {
        System.out.println("Ошибка: " + message);
    }

    public void printGoodbye() {
        System.out.println("Программа завершилась");
    }

    private String cleanSnippet(String snippet) {
        if (snippet == null) {
            return "";
        }

        return snippet
                .replaceAll("<[^>]+>", "")
                .replace("&quot;", "\"")
                .replace("&amp;", "&");
    }
}
