package model.queens;

import model.chesspieces.ChessFigure;
import model.chesspieces.Reina;
import java.util.ArrayList;

/**
 *
 * @author Bernat Galmés Rubert
 */
public class BoardDefinition {
    public static final int INI_BOARD_SIZE = 8;
    
    private ArrayList<ChessFigure> pieces;
    private int boardSize = INI_BOARD_SIZE;
    
    public BoardDefinition() {
        this.updatePieces();
    }
    
    
    public void addPiece(ChessFigure p) {
        getPieces().add(p);
    }
    
    public void clearPieces() {
        this.getPieces().clear();
    }
    
    public int numPieces() {
        return this.getPieces().size();
    }
    
    /**
     * @return the boardSize
     */
    public int getBoardSize() {
        return boardSize;
    }

    /**
     * @param boardSize the boardSize to set
     */
    public void setBoardSize(int boardSize) {
        this.boardSize = boardSize;
        this.updatePieces();
    }

    /**
     * @return the pieces
     */
    public ArrayList<ChessFigure> getPieces() {
        return pieces;
    }
    
    private void updatePieces() {
        pieces = new ArrayList<>();
        for (int i=0; i < this.boardSize; i++){
           pieces.add(new Reina());
        }
    }

}
