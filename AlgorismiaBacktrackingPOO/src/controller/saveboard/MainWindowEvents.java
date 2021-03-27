package controller.saveboard;

import model.chesspieces.ChessFigure;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import model.saveboard.BoardDefinition;
import transfer.SaveBoardInterface;
import view.saveboard.MainWindow;

/**
 *
 * @author Bernat Galmés Rubert
 */
public class MainWindowEvents implements ActionListener, ChangeListener {

    private MainWindow view;
    private BoardDefinition model;

    public MainWindowEvents(MainWindow view, BoardDefinition model) {
        this.view = view;
        this.model = model;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            String accio = e.getActionCommand();
            switch (accio) {
                case "addPiece" -> {
                    try {
                        this.addPiece();
                    } catch (ChessFigure.badSelection ex) {
                        Logger.getLogger(MainWindowEvents.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

                case "compute" -> {
                    SaveBoardInterface s = new Problem(model.getPieces().toArray(new ChessFigure[0]), model.getBoardSize());
                    int[] figuresCodes = new int[model.getPieces().size()];
                    for(int i = 0; i < model.numPieces(); i ++) {
                        figuresCodes[i] = model.getPiece(i).getCodi();
                    }
                    int[][] resultBoard = s.solve(figuresCodes, model.getBoardSize());
                    ChessFigure[][] board = new ChessFigure[model.getBoardSize()][model.getBoardSize()];
                    for(int i = 0; i < model.getBoardSize(); i ++) {
                        for(int j = 0; j < model.getBoardSize(); j ++) {
                            if (resultBoard[i][j] > 0) {
                                board[i][j] = ChessFigure.getPesa(resultBoard[i][j]);
                            }                            
                        }
                    }
                    view.reset();
                    view.colocaPeces(board);
                    break;
                }

                case "resetPieces" -> {
                    this.resetBoard();
                }

                default -> throw new badSelection();
            }
           
        } catch (ChessFigure.badSelection ex) {
            Logger.getLogger(MainWindowEvents.class.getName()).log(Level.SEVERE, null, ex);
            Logger.getLogger(MainWindowEvents.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(MainWindowEvents.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void addPiece() throws ChessFigure.badSelection {
        ChessFigure p_sel = ChessFigure.getPesa(view.getCurrentPiezeSelected());
        model.addPiece(p_sel);
        view.updateView();
    }
    
    private void resetBoard() {
        model.clearPieces();
        view.updateView();
    }

    @Override
    public void stateChanged(ChangeEvent ce) {
        javax.swing.JSpinner sp_boardSize = (javax.swing.JSpinner) ce.getSource();
        model.setBoardSize((int) sp_boardSize.getValue());
        view.updateView();
    }

    public class badSelection extends Exception {
    }
}
