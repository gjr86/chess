package chess;

public class Knight extends Piece {
    ReturnPiece.PieceType pieceType;
    ReturnPiece.PieceFile file;
    int rank;

    public Knight(int rank, ReturnPiece.PieceFile file, Chess.Player color) {
        this.rank = rank;
        this.file = file;
        pieceType = (color == Chess.Player.white) ? ReturnPiece.PieceType.WN : ReturnPiece.PieceType.BN;
    }

    public boolean isValidMove(int rank, ReturnPiece.PieceFile file){
        return true;
    }
}
