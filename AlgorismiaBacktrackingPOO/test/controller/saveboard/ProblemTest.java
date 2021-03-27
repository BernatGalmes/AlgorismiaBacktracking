/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.saveboard;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.chesspieces.ChessFigure;
import model.game.BoardPosition;
import model.game.PlacedFigure;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import transfer.Config;
import transfer.SaveBoardInterface;


/**
 *
 * @author Bernat Galmés Rubert
 */
public class ProblemTest {
    
    public ProblemTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of solve method, of class Problem.
     */
    @Test
    public void testCase1() {
        System.out.println("Case 1");
        int[] figuresCodes = new int[]{ Config.FIGURES_QUEEN_CODE, 
            Config.FIGURES_BISHOP_CODE, 
            Config.FIGURES_BISHOP_CODE};
        int boardSize = 3;
        testSolveCorrectConfiguration(figuresCodes, boardSize);        
    }
    
    /**
     * Test of solve method, of class Problem.
     */
    @Test
    public void testCase2() {
        System.out.println("Case 2");
        int[] figuresCodes = new int[]{  
            Config.FIGURES_BISHOP_CODE, 
            Config.FIGURES_BISHOP_CODE,
            Config.FIGURES_QUEEN_CODE};
        int boardSize = 3;
        testSolveCorrectConfiguration(figuresCodes, boardSize);
    }
    /**
     * Test of solve method, of class Problem.
     */
    @Test
    public void testCase3() {
        System.out.println("Case 3: N Queens");
        int boardSize = 10;
        int[] figuresCodes = new int[boardSize];        
        for (int i = 0; i < boardSize; i++) {
            figuresCodes[i] = Config.FIGURES_QUEEN_CODE;
        }
        testSolveCorrectConfiguration(figuresCodes, boardSize);
    }
    
        /**
     * Test of solve method, of class Problem.
     */
    @Test
    public void testCase4() {
        System.out.println("Case 4: Impossible case");
        int boardSize = 10;
        int[] figuresCodes = new int[boardSize + 1];        
        for (int i = 0; i < boardSize + 1; i++) {
            figuresCodes[i] = Config.FIGURES_QUEEN_CODE;
        }
        testSolveIncorrectConfiguration(figuresCodes, boardSize);
    }
    
    /**
     * Test of solve method, of class Problem.
     */
    @Test
    public void testCase5() {
        System.out.println("Case 5: All pieces");
        int boardSize = 8;        
        int nAlfils = 3;
        int nReines = 2;
        int nTorres = 2;
        int nCavalls = 2;
        int nKings = 3;
        
        int[] figuresCodes = new int[nAlfils + nReines + nTorres + nCavalls + nKings];
        for (int i = 0; i < nAlfils; i++) {
            figuresCodes[i] = Config.FIGURES_BISHOP_CODE;
        }
        int accumFigures = nAlfils;
        
        for (int i = accumFigures; i < accumFigures + nReines; i++) {
            figuresCodes[i] = Config.FIGURES_QUEEN_CODE;
        }
        accumFigures += nReines;
        
        for (int i = accumFigures; i < accumFigures + nTorres; i++) {
            figuresCodes[i] = Config.FIGURES_ROOK_CODE;
        }
        accumFigures += nTorres;
        
        for (int i = accumFigures; i < accumFigures + nCavalls; i++) {
            figuresCodes[i] = Config.FIGURES_KNIGHT_CODE;
        }
        accumFigures += nCavalls;

        for (int i = accumFigures; i < accumFigures + nKings; i++) {
            figuresCodes[i] = Config.FIGURES_KING_CODE;
        }
        
        testSolveCorrectConfiguration(figuresCodes, boardSize);
    }
    
        /**
     * Test of solve method, of class Problem.
     */
    @Test
    public void testCase6() {
        System.out.println("Case 6: All pieces incorrect");
        int boardSize = 8;
        
        int nAlfils = 3;
        int nReines = 2;
        int nTorres = 2;
        int nCavalls = 2;
        int nKings = 4;
        int[] figuresCodes = new int[nAlfils + nReines + nTorres + nCavalls + nKings];
        
        for (int i = 0; i < nAlfils; i++) {
            figuresCodes[i] = Config.FIGURES_BISHOP_CODE;
        }
        int accumFigures = nAlfils;
        
        for (int i = accumFigures; i < accumFigures + nReines; i++) {
            figuresCodes[i] = Config.FIGURES_QUEEN_CODE;
        }
        accumFigures += nReines;
        
        for (int i = accumFigures; i < accumFigures + nTorres; i++) {
            figuresCodes[i] = Config.FIGURES_ROOK_CODE;
        }
        accumFigures += nTorres;
        
        for (int i = accumFigures; i < accumFigures + nCavalls; i++) {
            figuresCodes[i] = Config.FIGURES_KNIGHT_CODE;
        }
        accumFigures += nCavalls;

        for (int i = accumFigures; i < accumFigures + nKings; i++) {
            figuresCodes[i] = Config.FIGURES_KING_CODE;
        }
        
        testSolveIncorrectConfiguration(figuresCodes, boardSize);
    }
//    /**
//     * Test of solve method, of class Problem.
//     */
//    @Test
//    public void testCase7() {
//        System.out.println("Case 7: Big board");
//        int boardSize = 10;
//        int[] figuresCodes = new int[10 + 2 + 2 + 4]; 
//        
//        for (int i = 0; i < 10; i++) {
//            figuresCodes[i] = Config.FIGURES_BISHOP_CODE;
//        }
//        int accumFigures = 10;
//        
//        for (int i = accumFigures; i < accumFigures + 2; i++) {
//            figuresCodes[i] = Config.FIGURES_QUEEN_CODE;
//        }
//        accumFigures += 2;
//        
//        for (int i = accumFigures; i < accumFigures + 2; i++) {
//            figuresCodes[i] = Config.FIGURES_ROOK_CODE;
//        }
//        accumFigures += 2;
//        
//        for (int i = accumFigures; i < accumFigures + 4; i++) {
//            figuresCodes[i] = Config.FIGURES_KNIGHT_CODE;
//        }
//        
//        testSolveCorrectConfiguration(figuresCodes, boardSize);
//    }
    
    private void testSolveCorrectConfiguration(int[] figuresCodes, int boardSize) {
        long startTime = System.nanoTime();

        SaveBoardInterface instance = new Problem();
        int[][] result = instance.solve(figuresCodes, boardSize);

        long duration = (System.nanoTime() - startTime);
        System.out.println("Time spend: " + (duration / 1e9) + " s");

        assertNotEquals(result, null);
        try {
            List<PlacedFigure> boardFigures = toFiguresList(result);
            assertEquals(boardFigures.size(), figuresCodes.length);
            assertTrue(isCorrectBoard(boardFigures, boardSize));
            
        } catch (Exception ex) {
            Logger.getLogger(ProblemTest.class.getName()).log(Level.SEVERE, null, ex);
            fail("Ploblem converting board format.");
        }
    }
    
    private void testSolveIncorrectConfiguration(int[] figuresCodes, int boardSize) {
        long startTime = System.nanoTime();
        SaveBoardInterface instance = new Problem();
        int[][] result = instance.solve(figuresCodes, boardSize);
        long duration = (System.nanoTime() - startTime);
        System.out.println("Time spend: " + (duration / 1e9) + " s");
        assertNull(result);
    }
    
    private List<PlacedFigure> toFiguresList(int[][] boardCodes) throws Exception{
        List<PlacedFigure> pecesColocades = new ArrayList<>();
        for(int i = 0; i < boardCodes.length; i ++) {
            for(int j = 0; j < boardCodes.length; j ++) {
                if (boardCodes[i][j] > 0) {
                    PlacedFigure placedFigure = new PlacedFigure(
                        new BoardPosition(i, j),
                            ChessFigure.getPesa(boardCodes[i][j])                        
                    );
                    pecesColocades.add(placedFigure);
                }                            
            }
        }
        return pecesColocades;
    }
    
    private boolean isCorrectBoard(List<PlacedFigure> pecesColocades, int boardSize) {
        for (PlacedFigure currFigure : pecesColocades) {
            List<BoardPosition> movements = currFigure.piece.getMovements(currFigure.position.x, currFigure.position.y, boardSize);
            
            for (PlacedFigure otherFigure : pecesColocades) {
                if (movements.contains(otherFigure.position)) {
                    return false;
                }
            }
        }
        
        return true;
    }
    
}
