/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.chesspieces;

import java.awt.Image;
import java.awt.Toolkit;
import transfer.Config;

/**
 *
 * @author Bernardo
 */
public class Peo extends ChessFigure {

    public Peo() {
        this.t_mov = T_mov.infinit;
        MovX = new int[]{0, 0};
        MovY = new int[]{-1, +1};
        this.codi = Config.FIGURES_PAWN_CODE;
    }

    @Override
    public Image FiguraFBlanc() {
        Toolkit t = Toolkit.getDefaultToolkit();
        return t.getImage("resources/imatges/Fons_Blanc/Gat.gif");
    }

    @Override
    public Image FiguraFNegre() {
        Toolkit t = Toolkit.getDefaultToolkit();
        return t.getImage("resources/imatges/Fons_Negre/Gat.gif");
    }

    @Override
    public String toString() {
        return "Gat";
    }

}
