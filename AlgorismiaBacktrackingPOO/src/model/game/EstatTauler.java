package model.game;

import utils.PositionCode;
import model.chesspieces.ChessFigure;
import model.chesspieces.Rei;

/**
 * 
 * @author Bernat Galmés Rubert
 */
public class EstatTauler {
    private ChessFigure[][] tauler;
    
    public EstatTauler(int n) {
        this.tauler = new ChessFigure[n][n];
    }
    
    public void colocarPesa(String codiPosicio, ChessFigure pesa)
    {
        PositionCode pos = new PositionCode(codiPosicio);
        tauler[pos.getRow()-1][pos.getColumn()-1] = pesa;                
    }
    
    public int findGuanyador(){
        boolean j1jugant = false;
        boolean j2jugant = false;
        
        for (ChessFigure[] fila : tauler){
            for (ChessFigure p : fila) {
                if (p instanceof Rei) {
                    if (p.getJugador() == 1) {
                        j1jugant = true;
                    
                    }else {
                        j2jugant = true;
                    }
                }
            }
        }
        
        if (j1jugant && j2jugant){
            return -1;
        } else if (!j1jugant){
            return 2;
        } else{
            return 1;
        }
    }
    
    public boolean hasRei(int jugador ){
        for (ChessFigure[] fila : tauler){
            for (ChessFigure p : fila) {
                if (p instanceof Rei) {
                    if (p.getJugador() == jugador) {
                        return true;
                    
                    }
                }
            }
        }
        
        return false;
    }
    
    public ChessFigure[][] getTauler() {
        return tauler;
    }
    
    
}
