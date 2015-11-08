package novomedidor;

import javax.swing.JFrame;

/**
 *
 * @author viniciusduarte
 */
public class MotherFrame extends JFrame {
    
    private static final MotherFrame frame = new MotherFrame();
    
    private MotherFrame(){
        super.setTitle("Medidor de Raiz");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setVisible(true);
    }
    
    public static MotherFrame getInstance(){
        return frame;
    }
    
}
