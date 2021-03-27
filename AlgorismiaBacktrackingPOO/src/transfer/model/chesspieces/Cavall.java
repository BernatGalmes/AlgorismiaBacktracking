/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transfer.model.chesspieces;

import java.awt.Image;
import java.awt.Toolkit;
import transfer.Config;


/**
 *
 * @author bernat
 */
public class Cavall extends ChessFigure{
    
    public Cavall() {
        this.t_mov = T_mov.unari;
        MovX= new int[]{+2, +1, -1, -2, -2, -1, +1, +2};
        MovY= new int[]{-1, -2, -2, -1, +1, +2, +2, +1};
        this.codi = Config.FIGURES_KNIGHT_CODE;
    }
    
    @Override
    public Image FiguraFBlanc() {
         Toolkit t = Toolkit.getDefaultToolkit ();
        return t.getImage("resources/imatges/Fons_Blanc/Cavall.gif");
    }

    @Override
    public Image FiguraFNegre() {
         Toolkit t = Toolkit.getDefaultToolkit ();
        return t.getImage("resources/imatges/Fons_Negre/Cavall.gif");
    }

    @Override
    public String toString() {
        return "Cavall";
    }
}
