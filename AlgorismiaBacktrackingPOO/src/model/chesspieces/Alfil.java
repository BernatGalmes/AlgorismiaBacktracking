package model.chesspieces;

import java.awt.Image;
import java.awt.Toolkit;
import transfer.Config;


/**
 *
 * @author bernat
 */
public class Alfil extends ChessFigure {

    public Alfil() {
        this.t_mov = T_mov.infinit;
        this.MovX= new int[]{+1, -1, -1, +1};
        this.MovY = new int[]{+1, +1, -1, -1};
        this.codi = Config.FIGURES_BISHOP_CODE;
    }
        
    @Override
    public Image FiguraFBlanc() {
         Toolkit t = Toolkit.getDefaultToolkit ();
        return t.getImage("resources/imatges/Fons_Blanc/Alfil.gif");
    }

    @Override
    public Image FiguraFNegre() {
         Toolkit t = Toolkit.getDefaultToolkit ();
        return t.getImage("resources/imatges/Fons_Negre/Alfil.gif");
    }
    
    @Override
    public String toString() {
        return "Alfil";
    }
}
