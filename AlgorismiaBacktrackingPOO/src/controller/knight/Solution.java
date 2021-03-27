package controller.knight;

import model.game.BoardPosition;

/**
 *
 * @author Bernat Galmés Rubert
 */
public class Solution {
    
    private BoardPosition initialPosition;
    private int boardSize;

    
    /**
     * Indica que s'ha trobat una solució bona
     */
    boolean hasSolution;
    
    public Solution(BoardPosition initialPosition, int boardSize) {
        this.initialPosition = initialPosition;
        this.boardSize = boardSize;
        this.hasSolution = false;
    }
    
    /**
     * Call this method to find a solution for the current object configuration.
     * 
     * @return 
     */
    public int[][] findSolution(){
        this.hasSolution = false;
        BoardStatus solution = findSolution(1, new BoardStatus(boardSize, this.initialPosition));
        if (solution == null){
            return null;
        }
        return solution.geBoard();
    }
     
    
    
    /**
     * Calcula una sequencia de moviments que ha de fer el cavall per a visitar 
     * totes les caselles unicament una vegada.
     * 
     * @param nMovement Nombre del moviment del cavall de la crida
     * @param currentBoardStatus estat del tauler en el moment de la crida
     * @return estat del tauler amb la solució. Si no hi ha
     */
    private BoardStatus findSolution(int nMovement, BoardStatus currentBoardStatus) {

        BoardStatus solution = null;
        while(currentBoardStatus.canMove() && !hasSolution) {
            solution = currentBoardStatus.moveKnight(nMovement);
            
            // Si és la darrera pesa, és la solució final
            if (nMovement == (boardSize * boardSize) -1) { 
                    hasSolution = true;
                    return solution;

            // si és una solució parcial i té posicions no amenaçades intentam colocar la següent pesa                    
            } else if(solution.canMove()) { 
                solution = findSolution(nMovement+1, solution);

            }
        }

        return solution;
    }
    
}
