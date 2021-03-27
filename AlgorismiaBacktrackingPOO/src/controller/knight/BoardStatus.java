package controller.knight;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import model.chesspieces.Cavall;
import model.game.BoardPosition;

/**
 * 
 * @author Bernat Galmés Rubert
 */
public class BoardStatus {
    
    private final int boardSize;
    
    private final int[][] availablePositions;
    private final BoardPosition currentPosition;
    private final Stack<BoardPosition> movements;
    
    // Construct an empty board status
    public BoardStatus(int n, BoardPosition initPosition) {
        boardSize = n;
        currentPosition = initPosition;
        this.availablePositions = new int[n][n];
        for (int i=0; i < boardSize; i++){
            for (int j=0; j < boardSize; j++){
                availablePositions[i][j] = -1;
            }                        
        }
        availablePositions[initPosition.x][initPosition.y] = 0;
        this.movements = this.getAvailableMovements(new Cavall());        
    }

    // Construct a partial solution board status
    public BoardStatus(int[][] availablePositions, BoardPosition currentPosition, int n) {
        this.availablePositions = availablePositions;
        this.currentPosition = currentPosition;
        this.boardSize = n;
        this.movements = this.getAvailableMovements(new Cavall());
    }
    
    private Stack<BoardPosition> getAvailableMovements(Cavall cavall) {  
        List<BoardPosition> positions = cavall.getMovements(currentPosition.x, currentPosition.y, boardSize);
        Stack<BoardPosition> res = new Stack<>();
        for (BoardPosition p : positions) {
            if (availablePositions[p.x][p.y] == -1){
                res.push(p);
            }
        }     
        
        return res;
    }
    public BoardStatus moveKnight(int nMov) {        
        // Get an available valid position
        BoardPosition position = findValidMovement();
        
        int[][] nextAvailablePositions = Arrays.stream(availablePositions).map(int[]::clone).toArray(int[][]::new);

        nextAvailablePositions[currentPosition.x][currentPosition.y] = nMov;
        
        return new BoardStatus(nextAvailablePositions, position, this.boardSize);
    }
   
            
    private BoardPosition findValidMovement() {
        return this.movements.pop();
    } 
    
    public boolean canMove() {
        return !this.movements.isEmpty();
    }
    
    public int[][] geBoard() {
        return availablePositions;
    }
        
}
