public class Queen extends ChessPiece {

    public Queen(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return this.color;
    }

    @Override
    public String getSymbol() {
        return "Q";
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (toLine >= 0 && toLine < 8 && toColumn >= 0 && toColumn < 8) {
            if (((((toLine -line == toColumn -column) || (toLine -line == -1*toColumn -column))
                    && isClearDiagonal(chessBoard,line,column,toLine,toColumn))
                    && (toLine!=line && toColumn!=column) ||  ((toLine != line && toColumn == column )
                    && isClearLine(chessBoard,line,column,toLine,toColumn))
                    || ((toLine == line && toColumn != column)
                    && isClearColumn(chessBoard,line,column,toLine,toColumn)))) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    private boolean isClearDiagonal(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        int n=0;
        int m=0;
        boolean isClear = true;
        for (int i = 1;i<=Math.abs(toLine-line);i=i+1) {
            if(toLine>line)  {
                n=line+i;
                if(toColumn > column)  {
                    m=column+i;
                }else {
                    m=column-i;
                }
            }else{
                n=line-i;
                if(toColumn > column) {
                    m=column+i;
                }else {
                    m=column-i;}}
            if (chessBoard.board[n][m]==null) {
                isClear=true;
            } else {
                if (n== toLine && m== toColumn && chessBoard.board[toLine][toColumn].getColor() !=chessBoard.board[line][column].getColor()) {
                    isClear=true;
                } else {
                    isClear = false;
                }
            }
        }
        return isClear;
    }
    boolean isClearLine(ChessBoard chessBoard,int line, int column, int toLine, int toColumn) {
        int n=0;
        boolean isClear = true;
        for (int i = 1;i<=Math.abs(toLine-line);i=i+1) {
            if(toLine > line) {
                n=line+i;
            }else {
                n=line-i;
            }
            if (chessBoard.board[n][column] == null)  {
                isClear=true;
            } else {
                if (n== toLine && chessBoard.board[toLine][toColumn].getColor() !=chessBoard.board[line][column].getColor()) {
                    isClear=true;
                } else {
                    isClear=false;
                }
            }
        }
        return isClear;
    }
    boolean isClearColumn(ChessBoard chessBoard,int line, int column, int toLine, int toColumn) {
        int n=0;
        boolean isClear = true;
        for (int i = 1;i<=Math.abs(toColumn-column);i=i+1) {
            if(toColumn > column) {
                n=column+i;
            }else {
                n=column-i;
            }
            if (chessBoard.board[line][n] == null) {
                isClear=true;
            } else {
                if (n == toColumn && chessBoard.board[toLine][toColumn].getColor() !=chessBoard.board[line][column].getColor()) {
                    isClear=true;
                } else {
                    isClear=false;
                }
            }
        }
        return isClear;
    }
}
