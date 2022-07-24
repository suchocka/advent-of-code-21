package pl.suchocka.day03;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Day03 {

    public int run(String fileName) throws IOException {
        List<String> inputs = readInput(fileName);
        Report report = generateReport(inputs);
        return report.getPowerConsumption();
    }

    private Report generateReport(List<String> inputs) {
        Integer[][] matrix = mapInputsToMatrix(inputs);
        StringBuilder gammaRate = new StringBuilder();
        StringBuilder epsilonRate = new StringBuilder();
        for (int col = 0; col < inputs.get(0).length(); col++) {
            int oneCounter = 0;
            int zeroCounter = 0;
            for (int row = 0; row < inputs.size(); row++) {
                if (matrix[row][col] == 0) {
                    zeroCounter++;
                } else {
                    oneCounter++;
                }
            }
            boolean oneDominates = oneCounter > zeroCounter;
            gammaRate.append(oneDominates ? 1 : 0);
            epsilonRate.append(oneDominates ? 0 : 1);
        }
        return new Report(binaryToDecimal(gammaRate.toString()), binaryToDecimal(epsilonRate.toString()));
    }

    private Integer[][] mapInputsToMatrix(List<String> inputs) {
        return inputs.stream()
                .map(line -> line.chars().mapToObj(x -> x - '0').toArray(Integer[]::new))
                .toArray(Integer[][]::new);
    }

    private static int binaryToDecimal(String binary) {
        return Integer.parseInt(binary, 2);
    }

    private static List<String> readInput(String fileName) throws IOException {
        return Files.readAllLines(Path.of(fileName));
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    static class Report {
        private Integer gammaRate;
        private Integer epsilonRate;

        public int getPowerConsumption() {
            return getGammaRate() * getEpsilonRate();
        }
    }
}
