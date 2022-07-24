package pl.suchocka.day03;

import org.junit.jupiter.api.Test;
import pl.suchocka.day02.Day02;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class Day03Test {

    @Test
    void run() throws IOException {
        int result = new Day03().run("src/main/java/pl/suchocka/day03/star1-example.txt");
        assertEquals(198, result);
    }
}