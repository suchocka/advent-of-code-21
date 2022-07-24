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
        return getPowerConsumption(report);
    }

    private Report generateReport(List<String> inputs) {
        int[][] matrix = mapInputsToMatrix(inputs);
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
            if (oneCounter > zeroCounter) {
                gammaRate.append(1);
                epsilonRate.append(0);
            } else {
                gammaRate.append(0);
                epsilonRate.append(1);
            }
            oneCounter = 0;
            zeroCounter = 0;
        }
        return new Report(binaryToDecimal(gammaRate.toString()), binaryToDecimal(epsilonRate.toString()));
    }

    private int[][] mapInputsToMatrix(List<String> inputs) {
        int[][] matrix = new int[inputs.size()][inputs.get(0).length()];
        for (int row = 0; row < inputs.size(); row++) {
            String input = inputs.get(row);
            String[] numbers = input.split("");
            for (int col = 0; col < input.length(); col++) {
                matrix[row][col] = Integer.parseInt(numbers[col]);
            }
        }
        return matrix;
    }

    private int getPowerConsumption(Report report) {
        return report.getGammaRate() * report.getEpsilonRate();
    }

    private int binaryToDecimal(String binary) {
        return Integer.parseInt(binary, 2);
    }

    private List<String> readInput(String fileName) throws IOException {
        return Files.readAllLines(Path.of(fileName));
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    static class Report {
        private Integer gammaRate;
        private Integer epsilonRate;
    }
}
