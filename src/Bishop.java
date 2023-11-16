public class Bishop extends ChessPiece {

    public Bishop(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return this.color;
    }

    @Override
    public String getSymbol() {
        return "B";
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (toLine != line && toColumn != column) {
            if (toLine >= 0 && toLine < 8 && toColumn >= 0 && toColumn < 8) {
                if (((Math.abs(line-toLine) == Math.abs(column-toColumn)) || ((toLine - line) == -1 * (toColumn - column)))
                        && isClearDiagonal(chessBoard, line, column, toLine, toColumn)) {
                    return true;
                } else {
                    return  false;
                }
            } else {
                return false;
            }
        }
        return false;
    }

    private boolean isClearDiagonal(ChessBoard chessBoard, int line, int column, int toLine, int toColumn){
        int l = 0;
        int k = 0;
        boolean isClear = true;
        for (int i = 1; i < Math.abs(toLine - line); i = i +1) {
            if (toLine > line) {
                l = line + i;
                if (toColumn > column) {
                    k = column + i;
                } else {
                    k = column - i;
                }
            } else {
                l = line - 1;
                if (toColumn > column) {
                    k = column + i;
                } else {
                    k = column - i;
                }
            } if (chessBoard.board[l][k] == null) {
                isClear = true;
            } else {
                if (l == toLine && k == toColumn && chessBoard.board[toLine][toColumn].getColor() != chessBoard.board[line][column].getColor()) {
                    isClear = true;
                } else {
                    isClear = false;
                    return isClear;
                }
            }
        }
        return isClear;
    }
}
