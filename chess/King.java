package chess;

public class King extends Piece {
    ReturnPiece.PieceType pieceType;
    ReturnPiece.PieceFile file;
    int rank;

    public King(int rank, ReturnPiece.PieceFile file, Chess.Player color) {
        this.rank = rank;
        this.file = file;
        pieceType = (color == Chess.Player.white) ? ReturnPiece.PieceType.WK : ReturnPiece.PieceType.BK;
    }

    public boolean isValidMove(int rank, ReturnPiece.PieceFile file){
        return DiagonalMoving.isValidMove(rank, file) || HorizontalMoving.isValidMove(rank, file);
    }
}
