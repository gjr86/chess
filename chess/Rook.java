package chess;

public class Rook extends Piece implements HorizontalMoving {
    ReturnPiece.PieceType pieceType;
    ReturnPiece.PieceFile file;
    int rank;

    public Rook(int rank, ReturnPiece.PieceFile file, Chess.Player color) {
        this.rank = rank;
        this.file = file;
        pieceType = (color == Chess.Player.white) ? ReturnPiece.PieceType.WR : ReturnPiece.PieceType.BR;
    }

    public boolean isValidMove(int rank, ReturnPiece.PieceFile file){
        return HorizontalMoving.isValidMove(rank, file);
    }
}
