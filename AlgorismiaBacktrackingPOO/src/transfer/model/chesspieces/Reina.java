package transfer.model.chesspieces;

import java.awt.Image;
import java.awt.Toolkit;
import transfer.Config;

/**
 *
 * @author bernat
 */
public class Reina extends ChessFigure{
    
    public Reina() {
        this.t_mov = T_mov.infinit;
        MovX = new int[]{+1, -1, -1, +1,  0,  0, +1, -1};
        MovY = new int[]{+1, -1, +1, -1, +1, -1,  0,  0};
        this.codi = Config.FIGURES_QUEEN_CODE;
    }
    
   @Override
    public Image FiguraFBlanc() {
        Toolkit t = Toolkit.getDefaultToolkit ();
        return t.getImage("resources/imatges/Fons_Blanc/Reina.gif");
    }

    @Override
    public Image FiguraFNegre() {
         Toolkit t = Toolkit.getDefaultToolkit ();
        return t.getImage("resources/imatges/Fons_Negre/Reina.gif");
    }

    @Override
    public String toString() {
        return "Reina";
    }
}
