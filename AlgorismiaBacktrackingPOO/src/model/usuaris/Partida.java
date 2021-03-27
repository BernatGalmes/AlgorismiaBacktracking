/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.usuaris;

import model.chesspieces.ChessFigure;
import model.game.EstatTauler;
import model.usuaris.Jugador;


/**
 *
 * @author berna
 */
public class Partida {
    private Jugador jugador1;
    private Jugador jugador2;
    private EstatTauler estatActual;

    public Partida(Jugador jugador1, Jugador jugador2) {
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
    }

    public void setEstatActual(EstatTauler estatActual) {
        this.estatActual = estatActual;
    }
    
    public boolean isGuanyador(Jugador jugador){
        int nJugador = (jugador == this.jugador1) ? 1 : 2;
        return estatActual.hasRei(nJugador);
    }
    public boolean isPerdedor(Jugador jugador){
        int nJugador = (jugador == this.jugador1) ? 1 : 2;
        return !estatActual.hasRei(nJugador);
    }
    
    public boolean isNoAcabada(){
        return estatActual.hasRei(1) && estatActual.hasRei(2) ;
    }
    
    
    public ChessFigure[][] getColocacioPecesEstat(){
        return this.estatActual.getTauler();
    }
}
