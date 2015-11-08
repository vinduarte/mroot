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
        this.setBounds(0, 0, 920, 840);
        this.setVisible(true);
    }
    
    public static MotherFrame getInstance(){
        return frame;
    }
    
}
