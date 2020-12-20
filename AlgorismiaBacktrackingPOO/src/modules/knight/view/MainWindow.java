package modules.knight.view;

import core.view.CellDrawable;
import core.view.ChessBoardPanel;
import java.awt.event.ActionListener;
import javax.swing.event.ChangeListener;
import modules.knight.model.BoardDefinition;

/**
 *
 * @author Bernat Galmés Rubert
 */
public class MainWindow extends javax.swing.JFrame {

    private final ChessBoardPanel tauler;
    private final BoardDefinition model;

    public MainWindow(BoardDefinition model) {
        this.model = model;
        initComponents();
        tauler = (ChessBoardPanel) T;
    }

    public void attachActionLister(ActionListener actionListener) {
        this.btn_compute.setActionCommand("compute");
        this.btn_compute.addActionListener(actionListener);
    }
    
    public void attachChangeListener(ChangeListener changeListener) {
        this.sp_boardSize.addChangeListener(changeListener);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        T = new core.view.ChessBoardPanel(BoardDefinition.INI_BOARD_SIZE);
        panel_options = new javax.swing.JPanel();
        sp_boardSize = new javax.swing.JSpinner();
        jLabel2 = new javax.swing.JLabel();
        lb_boardSize = new javax.swing.JLabel();
        btn_compute = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Chess");
        setAlwaysOnTop(true);
        setResizable(false);

        T.setPreferredSize(new java.awt.Dimension(500, 500));

        javax.swing.GroupLayout TLayout = new javax.swing.GroupLayout(T);
        T.setLayout(TLayout);
        TLayout.setHorizontalGroup(
            TLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 601, Short.MAX_VALUE)
        );
        TLayout.setVerticalGroup(
            TLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 634, Short.MAX_VALUE)
        );

        sp_boardSize.setModel(new javax.swing.SpinnerNumberModel(8, 3, 20, 1));

        jLabel2.setText("Select board size:");

        lb_boardSize.setText("Board_size");

        javax.swing.GroupLayout panel_optionsLayout = new javax.swing.GroupLayout(panel_options);
        panel_options.setLayout(panel_optionsLayout);
        panel_optionsLayout.setHorizontalGroup(
            panel_optionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_optionsLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panel_optionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(lb_boardSize)
                    .addComponent(sp_boardSize, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(426, 426, 426))
        );
        panel_optionsLayout.setVerticalGroup(
            panel_optionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_optionsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sp_boardSize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lb_boardSize)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btn_compute.setBackground(new java.awt.Color(19, 16, 200));
        btn_compute.setFont(new java.awt.Font("Ubuntu", 1, 13)); // NOI18N
        btn_compute.setForeground(new java.awt.Color(242, 242, 242));
        btn_compute.setText("Compute");

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(panel_options, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btn_compute, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41)))
                .addComponent(T, javax.swing.GroupLayout.PREFERRED_SIZE, 601, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(panel_options, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_compute))
                    .addComponent(T, javax.swing.GroupLayout.PREFERRED_SIZE, 634, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    javax.swing.JPanel T;
    javax.swing.JButton btn_compute;
    javax.swing.JLabel jLabel2;
    javax.swing.JMenu jMenu1;
    javax.swing.JMenu jMenu2;
    javax.swing.JMenuBar jMenuBar1;
    javax.swing.JLabel lb_boardSize;
    javax.swing.JPanel panel_options;
    javax.swing.JSpinner sp_boardSize;
    // End of variables declaration//GEN-END:variables
    
    public void updateView() {
        if (model.getBoardSize() != tauler.getN()){
            tauler.changeSize(model.getBoardSize());
            lb_boardSize.setText("Board_size: " + model.getBoardSize());
        }
        
    }

    public void colocaPeces(CellDrawable[][] pecesColocades) {
        for (int iFila = 0; iFila < pecesColocades.length; iFila++) {
            CellDrawable[] fila = pecesColocades[iFila];
            for (int iColumna = 0; iColumna < fila.length; iColumna++) {
                CellDrawable pesa = fila[iColumna];
                if (pesa != null) {
                    tauler.colocarPesa(iColumna, iFila, pesa);
                }
            }
        }
    }
    public void reset() {
        tauler.resetBoard();
    }
}
