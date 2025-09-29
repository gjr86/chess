package chess;

public abstract class Piece {
    ReturnPiece.PieceType pieceType;
    ReturnPiece.PieceFile file;
    int rank;

    public boolean move(int rank, ReturnPiece.PieceFile file) {
        boolean isValidMove = true;
        if (!isValidMove){
            System.out.println("invalid move");
            return false;
        }

        this.rank = rank;
        this.file = file;
        // update board
        return true;
    }

    public abstract boolean isValidMove(int rank, ReturnPiece.PieceFile file);
}
