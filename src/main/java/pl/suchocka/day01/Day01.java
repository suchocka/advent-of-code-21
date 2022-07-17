package pl.suchocka.day01;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

public class Day01 {

    public int runStar2(String fileName) throws IOException {
        List<Integer> values = readInput(fileName);
        int increases = 0;
        for (int i = 0; i < values.size() - 3; i++) {
            int sum1 = values.get(i) + values.get(i+1) + values.get(i+2);
            int sum2 = values.get(i+1) + values.get(i+2) + values.get(i+3);
            if (sum1 < sum2) {
                increases++;
            }
        }
        return increases;
    }

    public int run(String fileName) throws IOException {
        List<Integer> values = readInput(fileName);
        int increases = 0;
        for (int i = 1; i < values.size(); i++) {
            if (values.get(i) > values.get(i - 1)) {
                increases++;
            }
        }
        return increases;
    }

    private List<Integer> readInput(String fileName) throws IOException {
        List<String> inputs = Files.readAllLines(Path.of(fileName));
        return inputs.stream().map(Integer::parseInt).collect(Collectors.toList());
    }
}
