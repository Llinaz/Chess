public class Pawn extends ChessPiece {

    public Pawn(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return this.color;
    }

    @Override
    public String getSymbol() {
        return "P";
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (toLine != line) {
            if (toLine >= 0 && toLine < 8 && toColumn == column) {
                if (((this.color.equals("White") && line == 1 && toLine == (line + 2))
                        && chessBoard.board[line + 2][column] == null && chessBoard.board[line + 1][column] == null)
                        || ((this.color.equals("Black") && line == 6 && toLine == (line - 2))
                        && chessBoard.board[line - 2][column] == null && chessBoard.board[line - 1][column] == null)) {
                    return true;
                } else if (((this.color.equals("White") && line == 1 && toLine == (line + 1))
                        && chessBoard.board[line +1][column] == null)
                        || ((this.color.equals("Black") && line == 6 && toLine == (line - 1))
                        && chessBoard.board[line -1][column] == null)) {
                    return true;
                } else {
                    return false;
                }
            } else if (toLine >= 0 && toLine < 8 &&
                    (((toLine == line + 1) && (this.getColor() == "White") && (chessBoard.board[line + 1][column + 1].getColor() != "White"
                            || chessBoard.board[line + 1][column - 1].getColor() != "White"))
                            || ((toLine == line -1) && (this.getColor() == "Black") && (chessBoard.board[line - 1][column - 1].getColor() != "Black"
                            || chessBoard.board[line - 1][column - 1].getColor() != "Black")))) {
                return true;
            }
        } else {
            return false;
        }
        return false;
    }
}


