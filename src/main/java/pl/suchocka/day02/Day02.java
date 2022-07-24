package pl.suchocka.day02;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.javatuples.Pair;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class Day02 {

    public int run(String fileName) throws IOException {
        List<Move> actions = getActionsFromFile(fileName);
        Position position = calculatePosition(actions);
        return position.getHorizontalPosition() * position.getDepth();
    }

    private Position calculatePosition(List<Move> moves) {
        int horizontalPosition = 0;
        int depth = 0;
        int aim = 0;
        for (Move move : moves) {
            int x = move.getValue();
            switch (move.getActionType()) {
                case FORWARD:
                    horizontalPosition += x;
                    depth += aim * x;
                    break;
                case DOWN:
                    aim += x;
                    break;
                case UP:
                    aim -= x;
                    break;
            }
        }
        return new Position(horizontalPosition, depth);
    }

    private List<Move> getActionsFromFile(String fileName) throws IOException {
        List<Move> result = new LinkedList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            for (String line; (line = br.readLine()) != null; ) {
                String[] parts = line.split(" ");
                ActionType actionType = ActionType.valueOf(parts[0].toUpperCase());
                Integer value = Integer.valueOf(parts[1]);
                result.add(new Move(actionType, value));
            }
        }
        return result;
    }

    @Data
    @AllArgsConstructor
    static class Move {
        private ActionType actionType;
        private Integer value;
    }
}
