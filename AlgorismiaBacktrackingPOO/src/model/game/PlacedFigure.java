package model.game;

import model.chesspieces.ChessFigure;

/**
 *
 * @author Bernat Galmés Rubert
 */
public class PlacedFigure {

    public BoardPosition position;
    public ChessFigure piece;

    public PlacedFigure(ChessFigure piece) {
        this.piece = piece;
    }

    public PlacedFigure(BoardPosition position, ChessFigure piece) {
        this.position = position;
        this.piece = piece;
    }
}
