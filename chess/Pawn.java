package chess;

public class Pawn extends Piece {
    ReturnPiece.PieceType pieceType;
    ReturnPiece.PieceFile file;
    int rank;
    int moveCount=0;

    public Pawn(int rank, ReturnPiece.PieceFile file, Chess.Player color) {
        this.rank = rank;
        this.file = file;
        pieceType = (color == Chess.Player.white) ? ReturnPiece.PieceType.WP : ReturnPiece.PieceType.BP;
    }

    @Override
    public boolean move(int rank, ReturnPiece.PieceFile file) {
        boolean isValidMove = true;
        if (!isValidMove){
            System.out.println("invalid move");
            return false;
        }

        moveCount++;
        this.rank = rank;
        this.file = file;
        // update board
        return true;
    }

    public boolean isValidMove(int rank, ReturnPiece.PieceFile file){
        // use moveCount to see if it can move 2 spaces or just 1
        return true;
    }

    public void promote(ReturnPiece.PieceType pieceType){
        //creates a new piece of valid pieceType at the same location and gets rid of the pawn
    }
}
