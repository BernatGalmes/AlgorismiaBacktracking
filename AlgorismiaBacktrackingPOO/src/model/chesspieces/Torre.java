package model.chesspieces;

import java.awt.Image;
import java.awt.Toolkit;
import transfer.Config;

/**
 *
 * @author bernat
 */
public class Torre extends ChessFigure{

    public Torre() {
        this.t_mov = T_mov.infinit;
        MovX = new int[]{+1, -1,  0,  0};
        MovY = new int[]{ 0,  0, -1, +1};
        this.codi = Config.FIGURES_ROOK_CODE;
    }
    
    @Override
    public Image FiguraFBlanc() {
         Toolkit t = Toolkit.getDefaultToolkit ();
        return t.getImage("resources/imatges/Fons_Blanc/Torre.gif");
    }

    @Override
    public Image FiguraFNegre() {
        Toolkit t = Toolkit.getDefaultToolkit ();
        return t.getImage("resources/imatges/Fons_Negre/Torre.gif");
    }
    @Override
    public String toString() {
        return "Torre";
    }
}
