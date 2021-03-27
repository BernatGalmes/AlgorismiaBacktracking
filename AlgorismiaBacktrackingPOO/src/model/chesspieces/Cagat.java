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
public class Cagat extends ChessFigure {
    
    public Cagat() {
        this.t_mov = T_mov.infinit;
        this.MovX= new int[]{0, +1, -1};
        this.MovY = new int[]{-1, -1, -1};
        this.codi = Config.FIGURES_INVENTED_1_CODE;
    }

    @Override
    public Image FiguraFBlanc() {
        Toolkit t = Toolkit.getDefaultToolkit();
        return t.getImage("resources/imatges/Fons_Blanc/Cagat.gif");
    }

    @Override
    public Image FiguraFNegre() {
        Toolkit t = Toolkit.getDefaultToolkit();
        return t.getImage("resources/imatges/Fons_Negre/Cagat.gif");
    }

    @Override
    public String toString() {
        return "Cagat";
    }
}
