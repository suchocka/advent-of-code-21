package pl.suchocka.day01;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        Day01 day01 = new Day01();
        int result = day01.runStar2("src/main/java/pl/suchocka/day01/star1.txt");
        System.out.println(result);
    }
}
