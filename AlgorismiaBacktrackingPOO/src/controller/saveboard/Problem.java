/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.saveboard;

import java.util.logging.Level;
import java.util.logging.Logger;
import model.chesspieces.ChessFigure;
import transfer.SaveBoardInterface;

/**
 *
 * @author Bernat Galmés Rubert
 */
public class Problem implements SaveBoardInterface {

    private ChessFigure[] peses;
    private int boardSize;

    /**
     * Indica que s'ha trobat una solució bona
     */
    boolean completa;

    public Problem(ChessFigure[] peses, int boardSize) {
        this.peses = peses;
        this.boardSize = boardSize;
        this.completa = false;
    }
    
    public Problem() {
        this.completa = false;
    }
      
    @Override
    public int[][] solve(int[] figuresCodes, int boardSize) {
        this.peses = new ChessFigure[figuresCodes.length];
        for(int i = 0; i < figuresCodes.length; i++) {
            try {
                this.peses[i] = ChessFigure.getPesa(figuresCodes[i]);
            } catch (Exception ex) {
                Logger.getLogger(Problem.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        this.boardSize = boardSize;
        this.completa = false;
        
        int piezaactual = peses.length - 1;
        BoardStatus solution = solve(piezaactual, new BoardStatus(boardSize));
        if (completa == false) {
            return null;
        }
        return solution.getBoardCodes();
        
    }


    /**
     * Call this method to find a solution for the current object configuration.
     *
     * @return
     */
    public ChessFigure[][] solve() {
        this.completa = false;
        int piezaactual = peses.length - 1;
        BoardStatus solution = solve(piezaactual, new BoardStatus(boardSize));
        if (solution == null) {
            return null;
        }
        return solution.getBoard();
    }

    /**
     * Calcula una colocació de les peces que tenim al model de manera que no es
     * matin
     *
     * @param currentPieceNumber peça que colocam (cridar per la darrera peça de
     * la llista del model)
     * @param currentBoardStatus estat del tauler en el moment de la crida
     * @return L'estat resultant després de colocar 'currentPieceNumber
     */
    private BoardStatus solve(int currentPieceNumber, BoardStatus currentBoardStatus) {
        ChessFigure pactual = peses[currentPieceNumber];
        currentBoardStatus.pushPiece(pactual);

        BoardStatus solution = null;
        while (currentBoardStatus.hasUncheckedPositions() && !completa) {
            solution = currentBoardStatus.placePiece();

            // Si és la darrera pesa, és la solució final
            if (solution != null && currentPieceNumber == 0) {
                completa = true;
                return currentBoardStatus;

                // si és una solució parcial i té posicions no amenaçades intentam colocar la següent pesa                    
            } else if (solution != null && solution.hasUncheckedPositions()) {
                solution = solve(currentPieceNumber - 1, solution);

            }
        }

        if (!completa) {
            currentBoardStatus.popPiece();
        }

        return solution;
    }


}
