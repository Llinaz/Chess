public class King extends ChessPiece{

    public King(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return this.color;
    }

    @Override
    public String getSymbol() {
        return "K";
    }

    public boolean isUnderAttack(ChessBoard board, int line, int column) {
        boolean isUnderAttack = false;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (board.board[i][j] != null) {
                    if (!board.board[i][j].getColor().equals(getColor())) {
                        if (board.board[i][j].canMoveToPosition(board,line, column, i, j)) {
                            isUnderAttack = true;
                        }
                    }
                }
            }
        }
        return isUnderAttack;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (toLine >= 0 && toLine < 8 && toColumn >= 0 && toColumn < 8) {
            if (((toColumn == column-1)&&((toLine==line-1) || (toLine==line-0) || (toLine==line+1)))
                    || ((toColumn == column-0)&&((toLine==line-1) || (toLine==line+1)))
                    || ((toColumn == column+1)&&((toLine==line-1) || (toLine==line-0) || (toLine==line+1)))
                    && (!isUnderAttack( chessBoard,  toLine,  toColumn)) && chessBoard.board[toLine][toColumn] == null) {
                return true;
            } else if (chessBoard.board[toLine][toColumn].getColor() != chessBoard.board[line][column].getColor()) {
                return true;
            } else {
                return false;
            }
        } else  {
            return false;
        }
    }
}

