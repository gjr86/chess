package chess;

import java.util.ArrayList;

public class Chess {

    enum Player { white, black }

    // Static fields because play() is static
    private static Board board;
    private static Player currentTurn;

    /**
     * Plays the next move for whichever player has the turn.
     *
     * @param move String for next move, e.g. "a2 a3"
     *
     * @return A ReturnPlay instance that contains the result of the move.
     *         See the section "The Chess class" in the assignment description for details of
     *         the contents of the returned ReturnPlay instance.
     */
    public static ReturnPlay play(String move) {
      move = move.trim();

        // Handle resign
        if (move.equals("resign")) {
            ReturnPlay.Message msg = (currentTurn == Player.white)
                    ? ReturnPlay.Message.RESIGN_BLACK_WINS
                    : ReturnPlay.Message.RESIGN_WHITE_WINS;
            return new ReturnPlay(board.toReturnPieces(), msg);
        }

        // Handle draw offer (simplified)
        if (move.endsWith("draw?")) {
            // Accepting draw will be handled by opponent move
            // For now just strip it off
            move = move.replace(" draw?", "");
        }

        // Parse move string: "a2 a3"
        String[] parts = move.split(" ");
        if (parts.length < 2) {
            return new ReturnPlay(board.toReturnPieces(), ReturnPlay.Message.ILLEGAL_MOVE);
        }

        String from = parts[0];
        String to = parts[1];

        char fromFile = from.charAt(0);
        int fromRank = Character.getNumericValue(from.charAt(1));
        char toFile = to.charAt(0);
        int toRank = Character.getNumericValue(to.charAt(1));

        // Find piece
        Piece piece = board.getPieceAt(fromFile, fromRank);
        if (piece == null || piece.getColor() != currentTurn) {
            return new ReturnPlay(board.toReturnPieces(), ReturnPlay.Message.ILLEGAL_MOVE);
        }

        // Check legality
        if (!piece.isLegalMove(toFile, toRank, board)) {
            return new ReturnPlay(board.toReturnPieces(), ReturnPlay.Message.ILLEGAL_MOVE);
        }

        // Tentatively move on copy of board
        Board copy = board.clone();
        copy.movePiece(fromFile, fromRank, toFile, toRank);

        // If move leaves your own king in check → illegal
        if (copy.isInCheck(currentTurn)) {
            return new ReturnPlay(board.toReturnPieces(), ReturnPlay.Message.ILLEGAL_MOVE);
        }

        // Commit move
        board.movePiece(fromFile, fromRank, toFile, toRank);

        // Check opponent state
        Player opponent = (currentTurn == Player.white) ? Player.black : Player.white;
        ReturnPlay.Message msg = null;

        if (board.isCheckmate(opponent)) {
            msg = (opponent == Player.white)
                    ? ReturnPlay.Message.CHECKMATE_BLACK_WINS
                    : ReturnPlay.Message.CHECKMATE_WHITE_WINS;
        } else if (board.isInCheck(opponent)) {
            msg = ReturnPlay.Message.CHECK;
        }

        // Switch turn
        currentTurn = opponent;

        return new ReturnPlay(board.toReturnPieces(), msg);
    }


    /**
     * This method should reset the game, and start from scratch.
     */
    public static void start() {
        board = new Board();
        board.setup();
        currentTurn = Player.white;
    }

}
