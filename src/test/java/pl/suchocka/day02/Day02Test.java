package pl.suchocka.day02;

import org.junit.jupiter.api.Test;
import pl.suchocka.day01.Day01;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class Day02Test {

    @Test
    void run() throws IOException {
        int result = new Day02().run("src/main/java/pl/suchocka/day02/star1-example.txt");
        assertEquals(900, result);
    }
}