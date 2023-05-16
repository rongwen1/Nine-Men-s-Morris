package src;

import src.Players.Player;

public class MillDetector {
    private static MillDetector instance = null;
    private final Board board = Board.getInstance();

    private MillDetector() {
    }

    public static MillDetector getInstance() {
        if (instance == null) {
            instance = new MillDetector();
        }
        return instance;
    }

    public boolean isMill(Position position) {
        return isMillHorizontal(position) || isMillVertical(position);
    }

    private boolean isMillHorizontal(Position position) {
        if (position.getOccupyingToken() == null) {
            return false;
        }
        Token token = position.getOccupyingToken();
        int x = position.getX();
        int y = position.getY();
        Player owner = token.getOwner();

        boolean isPartOfMill = false;

        Position left = null;
        Position middle = null;
        Position right = null;

        switch (y) {
            case 0, 6:
                left = board.getPosition(0, y);
                middle = board.getPosition(3, y);
                right = board.getPosition(6, y);
                break;
            case 1, 5:
                left = board.getPosition(1, y);
                middle = board.getPosition(3, y);
                right = board.getPosition(5, y);
                break;
            case 2, 4:
                left = board.getPosition(2, y);
                middle = board.getPosition(3, y);
                right = board.getPosition(4, y);
                break;
            case 3:
                if (x == 0 || x == 1 || x == 2) {
                    left = board.getPosition(0, y);
                    middle = board.getPosition(1, y);
                    right = board.getPosition(2, y);
                } else if (x == 4 || x == 5 || x == 6) {
                    left = board.getPosition(4, y);
                    middle = board.getPosition(5, y);
                    right = board.getPosition(6, y);
                }
        }

        if (left != null && middle != null && right != null) {
            if (left.getOccupyingToken() != null
                    && middle.getOccupyingToken() != null
                    && right.getOccupyingToken() != null) {
                if (left.getOccupyingToken().getOwner() == owner
                        && middle.getOccupyingToken().getOwner() == owner
                        && right.getOccupyingToken().getOwner() == owner) {
                    isPartOfMill = true;
                }
            }
        }

        return isPartOfMill;
    }


    private boolean isMillVertical(Position position) {
        if (position.getOccupyingToken() == null) {
            return false;
        }
        Token token = position.getOccupyingToken();
        int x = position.getX();
        int y = position.getY();
        Player owner = token.getOwner();

        boolean isPartOfMill = false;

        Position top = null;
        Position middle = null;
        Position bottom = null;

        switch (x) {
            case 0, 6:
                top = board.getPosition(x, 0);
                middle = board.getPosition(x, 3);
                bottom = board.getPosition(x, 6);
                break;
            case 1, 5:
                top = board.getPosition(x, 1);
                middle = board.getPosition(x, 3);
                bottom = board.getPosition(x, 5);
                break;
            case 2, 4:
                top = board.getPosition(x, 2);
                middle = board.getPosition(x, 3);
                bottom = board.getPosition(x, 4);
                break;
            case 3:
                if (y == 0 || y == 1 || y == 2) {
                    top = board.getPosition(x, 0);
                    middle = board.getPosition(x, 1);
                    bottom = board.getPosition(x, 2);
                } else if (y == 4 || y == 5 || y == 6) {
                    top = board.getPosition(x, 4);
                    middle = board.getPosition(x, 5);
                    bottom = board.getPosition(x, 6);
                }
        }

        if (top != null && middle != null && bottom != null) {
            if (top.getOccupyingToken() != null
                    && middle.getOccupyingToken() != null
                    && bottom.getOccupyingToken() != null) {
                if (top.getOccupyingToken().getOwner() == owner
                        && middle.getOccupyingToken().getOwner() == owner
                        && bottom.getOccupyingToken().getOwner() == owner) {
                    isPartOfMill = true;
                }
            }
        }

        return isPartOfMill;
    }
}