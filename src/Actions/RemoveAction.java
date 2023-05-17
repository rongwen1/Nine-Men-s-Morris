package src.Actions;

import src.Board;
import src.MillDetector;
import src.Players.Player;
import src.Position;
import src.Token;


/**
 * This class represents a remove action.
 */
public class RemoveAction extends Action{
    Player opponent;
    Position position;

    /**
     * Constructor for a remove action.
     * @param opponent The opponent of the player.
     * @param position The position of the token to be removed.
     */
    public RemoveAction(Player opponent, Position position) {
        this.opponent = opponent;
        this.position = position;
    }

    /**
     * Executes the remove action.
     * @param board The board on which the action is executed.
     * @return True if the action was executed successfully, false otherwise.
     */
    @Override
    public boolean execute(Board board) {
        boolean success;
        MillDetector millDetector = MillDetector.getInstance();
        if (!board.isPositionEmpty(position) && board.getToken(position).getOwner() == opponent &&
                !millDetector.isMill(position)) {
            success = true;
            Token tokenRemoved = position.getOccupyingToken();
            board.removeToken(position);
            opponent.removeToken(tokenRemoved);
        } else {
            success = false;
        }

        // Prints the description of the action
        System.out.println(description(success));

        return success;
    }


    /**
     * Returns a description of the remove action.
     * @param success True if the action was executed successfully, false otherwise.
     * @return A description of the remove action.
     */
    @Override
    public String description(boolean success) {
        if (success) {
            return "Remove token " + opponent.getTokenColor() + " from " + position;
        } else {
            return "Invalid move";
        }
    }
}
