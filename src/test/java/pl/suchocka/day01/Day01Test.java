package pl.suchocka.day01;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class Day01Test {

    @Test
    void run() throws IOException {
        int result = new Day01().run("src/main/java/pl/suchocka/day01/star1-example.txt");
        assertEquals(7, result);
    }

    @Test
    void runStar2() throws IOException {
        int result = new Day01().runStar2("src/main/java/pl/suchocka/day01/star1-example.txt");
        assertEquals(5, result);
    }

}