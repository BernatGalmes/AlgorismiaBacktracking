package model.chesspieces;

import java.util.ArrayList;
import java.util.List;
import model.game.BoardPosition;
import transfer.Config;
import view.comuns.CellDrawable;

public abstract class ChessFigure implements CellDrawable {

    protected int MovX[];
    protected int MovY[];
    protected int codi;
    protected T_mov t_mov;

    // jugador de la pesa 1 (blanc) o 2 (negre)
    protected int jugador;

    protected int[] position = new int[]{-1, -1};

    public void setPosition(int fila, int columna) {
        position = new int[]{fila, columna};
    }

    public boolean estaColocada() {
        return position[0] != -1;
    }

    public int[] getPosition() {
        return position;
    }

    public int[] getMovX() {
        return MovX;
    }

    public int[] getMovY() {
        return MovY;
    }

    public int getCodi() {
        return codi;
    }

    public T_mov getT_mov() {
        return this.t_mov;
    }

    public int getJugador() {
        return jugador;
    }

    public void setJugador(int jugador) {
        this.jugador = jugador;
    }

    @Override
    public String toString() {
        return "Pesa{" + "MovX=" + MovX + ", MovY=" + MovY + '}';
    }

    public List<BoardPosition> getMovements(int x, int y, int boardSize) {
        List<BoardPosition> res = new ArrayList<>();
        for (int numMov = 0; numMov < this.MovX.length; numMov++) {
            if (this.t_mov == T_mov.infinit) {
                int nextX = x + this.MovX[numMov];
                int nextY = y + this.MovY[numMov];
                while (nextX >= 0 && nextX < boardSize && nextY >= 0 && nextY < boardSize) {
                    res.add(new BoardPosition(nextX, nextY));
                    nextX += this.MovX[numMov];
                    nextY += this.MovY[numMov];
                }
            } else {
                int nextX = x + this.MovX[numMov];
                int nextY = y + this.MovY[numMov];
                if (nextX >= 0 && nextX < boardSize && nextY >= 0 && nextY < boardSize) {
                    res.add(new BoardPosition(nextX, nextY));
                }
            }
        }

        return res;
    }

    ///
    ///Funcions estàtiques de ChessFigure
    ///
    public static enum T_mov {
        unari, infinit
    }

    public static ChessFigure getPesa(int codi) throws badSelection {
        switch (codi) {
            case Config.FIGURES_KNIGHT_CODE:
                return new Cavall();
            case Config.FIGURES_QUEEN_CODE:
                return new Reina();
            case Config.FIGURES_BISHOP_CODE:
                return new Alfil();
            case Config.FIGURES_ROOK_CODE:
                return new Torre();
            case Config.FIGURES_KING_CODE:
                return new Rei();
            case Config.FIGURES_PAWN_CODE:
                return new Peo();
            case Config.FIGURES_INVENTED_1_CODE:
                return new Cagat();
            default:
                throw new badSelection();
        }
    }

    public static ChessFigure getPesa(String nomPesa) throws badSelection {
        ChessFigure pesa;
        System.out.println(nomPesa);
        switch (nomPesa) {
            case "bishop":
                pesa = new Alfil();
                break;
            case "knight":
                case "kight":
                pesa = new Cavall();
                break;
            case "pawnn":
                pesa = new Peo();
                break;
            case "king":
                pesa = new Rei();
                break;
            case "queen":
                pesa = new Reina();
                break;
            case "rook":
                pesa = new Torre();
                break;
            default:
                throw new badSelection();
        }

        return pesa;
    }

    public static ChessFigure getPesa(String nomPesa, int jugador) throws badSelection {
        ChessFigure pesa = getPesa(nomPesa);

        pesa.setJugador(jugador);
        return pesa;
    }

    public static class badSelection extends Exception {

    }
}
