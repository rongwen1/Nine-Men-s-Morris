package src.Actions;

import src.Board;
import src.Position;
import src.Token;


/**
 * This class represents a move action.
 */
public class MoveAction extends Action {
    private final Token token;
    private final Position moveToPosition;
    private final Position initialPosition;

    /**
     * Constructor for a move action.
     * @param token The token to be moved.
     * @param initialPosition The initial position of the token.
     * @param moveToPosition The position to which the token is to be moved.
     */
    public MoveAction(Token token, Position initialPosition, Position moveToPosition) {
        this.token = token;
        this.moveToPosition = moveToPosition;
        this.initialPosition = initialPosition;
    }

    /**
     * Executes the move action.
     * @param board The board on which the action is executed.
     * @return True if the action was executed successfully, false otherwise.
     */
    @Override
    public boolean execute(Board board) {
        boolean success;
        if (board.isPositionEmpty(moveToPosition) && initialPosition.isAdjacentTo(moveToPosition)) {
            success = true;
            board.moveToken(token, initialPosition, moveToPosition);
            token.setPosition(moveToPosition);
        } else {
            success = false;
        }

        System.out.println(description(success));

        return success;
    }

    /**
     * Returns a description of the move action.
     * @param success True if the action was executed successfully, false otherwise.
     * @return A description of the move action.
     */
    @Override
    public String description(boolean success) {
        if (success) {
            return "Move token " + token.getOwner().getTokenColor() + " from " + initialPosition + " to " + moveToPosition;
        } else {
            return "Invalid move";
        }
    }
}
