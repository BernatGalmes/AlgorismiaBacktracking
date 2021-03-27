package controller.knight;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import model.knight.BoardDefinition;
import view.knight.MainWindow;

/**
 *
 * @author Bernat Galmés Rubert
 */
public class MainWindowEvents implements ActionListener, ChangeListener {

    private MainWindow view;
    private BoardDefinition model;

    public MainWindowEvents(MainWindow view, BoardDefinition model) {
        this.view = view;
        this.model = model;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            String accio = e.getActionCommand();
            switch (accio) {
                case "compute" -> {
//                    view.reset();
//                    view.colocaPeces(content);
                }

                default -> throw new badSelection();
            }
           
        } catch (badSelection ex) {
            Logger.getLogger(MainWindowEvents.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void stateChanged(ChangeEvent ce) {
        javax.swing.JSpinner sp_boardSize = (javax.swing.JSpinner) ce.getSource();
        model.setBoardSize((int) sp_boardSize.getValue());
        view.updateView();
    }

    public class badSelection extends Exception {
    }
}
