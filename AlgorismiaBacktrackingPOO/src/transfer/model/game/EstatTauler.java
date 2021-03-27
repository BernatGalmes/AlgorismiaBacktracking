/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transfer.model.game;

import transfer.model.chesspieces.ChessFigure;
import transfer.model.chesspieces.Rei;
import utils.PositionCode;


/**
 *
 * @author berna
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
