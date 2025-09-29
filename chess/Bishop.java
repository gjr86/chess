package chess;

public class Bishop extends Piece implements DiagonalMoving {
    ReturnPiece.PieceType pieceType;
    ReturnPiece.PieceFile file;
    int rank;

    public Bishop(int rank, ReturnPiece.PieceFile file, Chess.Player color) {
        this.rank = rank;
        this.file = file;
        pieceType = (color == Chess.Player.white) ? ReturnPiece.PieceType.WB : ReturnPiece.PieceType.BB;
    }

    public boolean isValidMove(int rank, ReturnPiece.PieceFile file){
        return DiagonalMoving.isValidMove(rank, file);
    }
}
