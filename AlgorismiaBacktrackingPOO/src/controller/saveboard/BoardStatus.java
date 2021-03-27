package controller.saveboard;

import model.game.PlacedFigure;
import java.util.List;
import java.util.Stack;
import model.chesspieces.ChessFigure;
import model.game.BoardPosition;

/**
 *
 * @author Bernat Galmés Rubert
 */
public class BoardStatus {

    private final int boardSize;

    private final Stack<BoardPosition> availablePositions;
    private final Stack<PlacedFigure> boardPieces;

    // Construct an empty board status
    public BoardStatus(int n) {
        availablePositions = new Stack<>();
        boardSize = n;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                availablePositions.push(new BoardPosition(i, j));
            }
        }
        boardPieces = new Stack<>();
    }

    // Construct a partial solution board status
    public BoardStatus(Stack<BoardPosition> availablePositions, Stack<PlacedFigure> boardPieces, int n) {
        this.availablePositions = availablePositions;
        this.boardPieces = boardPieces;
        this.boardSize = n;
    }

    public boolean isValid() {
        return this.hasUncheckedPositions();
    }

    /**
     * Place the last pushed piece on a valid position of the board.
     * Get a new board boardStatus with the piece placed.
     *
     * @return BoardStatus The board status after placing the piece in its
     * position. Return null if the piece can be placed in any place
     */
    public BoardStatus placePiece() {
        // Get an available valid position
        PlacedFigure placedPiece = boardPieces.pop();
        BoardPosition position = findValidPosition(placedPiece.piece);
        placedPiece.position = position;
        boardPieces.push(placedPiece);
        if (position == null) { // la pesa no es pot colocar
            return null;
        }
        
        // Create next board status
        List<BoardPosition> killPositions = placedPiece.piece.getMovements(position.x, position.y, this.boardSize);
        
        // Get the positions where future pieces can be placed
        Stack<BoardPosition> nextAvailablePositions = new Stack<>();
        for (BoardPosition pos : availablePositions) {
            if (!killPositions.contains(pos)) {
                nextAvailablePositions.push(pos);
            }
        }

        return new BoardStatus(nextAvailablePositions, boardPieces, this.boardSize);
    }

    public boolean hasUncheckedPositions() {
        return !this.availablePositions.isEmpty();
    }

    public ChessFigure[][] getBoard() {
        ChessFigure[][] board = new ChessFigure[this.boardSize][this.boardSize];
        for (PlacedFigure p : this.boardPieces) {
            board[p.position.x][p.position.y] = p.piece;
        }
        return board;
    }

    
    public int[][] getBoardCodes() {
        int[][] board = new int[this.boardSize][this.boardSize];
        for (PlacedFigure p : this.boardPieces) {
            board[p.position.x][p.position.y] = p.piece.getCodi();
        }
        return board;
    }
    
    public void pushPiece(ChessFigure piece) {
        this.boardPieces.push(new PlacedFigure(piece));
    }

    public void popPiece() {
        this.boardPieces.pop();
    }

    private BoardPosition findValidPosition(ChessFigure piece) {
        boolean isValidPosition = false;
        BoardPosition position = null;
        while (!isValidPosition && !availablePositions.isEmpty()) {
            position = availablePositions.pop();
            // Check if piece kill anyone in this position
            isValidPosition = isValidPosition(piece, position);
        }

        return (isValidPosition) ? position : null;
    }

    // Check if piece kill anyone
    private boolean isValidPosition(ChessFigure piece, BoardPosition position) {
        List<BoardPosition> killPositions = piece.getMovements(position.x, position.y, this.boardSize);
        for (PlacedFigure boardPiece : boardPieces) {
            if (killPositions.contains(boardPiece.position)) {
                return false;
            }
        }
        return true;
    }

}
