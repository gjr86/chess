package chess;

public class Queen extends Piece implements HorizontalMoving, DiagonalMoving {
    ReturnPiece.PieceType pieceType;
    ReturnPiece.PieceFile file;
    int rank;

    public Queen(int rank, ReturnPiece.PieceFile file, Chess.Player color) {
        this.rank = rank;
        this.file = file;
        pieceType = (color == Chess.Player.white) ? ReturnPiece.PieceType.WQ : ReturnPiece.PieceType.BQ;
    }

    public boolean isValidMove(int rank, ReturnPiece.PieceFile file){
        return DiagonalMoving.isValidMove(rank, file) || HorizontalMoving.isValidMove(rank, file);
    }
}