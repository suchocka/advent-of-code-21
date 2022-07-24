package pl.suchocka;

import pl.suchocka.day03.Day03;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Integer result = new Day03().run("src/main/java/pl/suchocka/day03/star1.txt");
        System.out.println(result);
    }
}