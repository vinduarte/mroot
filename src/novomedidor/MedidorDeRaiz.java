package novomedidor;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/*
 PROXIMO
 Editor de escalas - para zoom e direção

 */
/**
 *
 * @author viniciusduarte
 */
public class MedidorDeRaiz implements ActionListener {

    private final MotherFrame frame;
    private final PhotoPanel photoPanel;
    private final JPanel otherPanel;
    private final JButton loadPicture, reset, resultButton;
    private final JButton loadNormalizers;
    private final JFileChooser fileChooser;
    private final JTextArea informationText;
    private final TextField tFieldValorX;
    private final TextField tFieldValorY;
    private final JLabel jLabel1, jLabel2, jLabel3, jLabel4;
    private final javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton zoomMais;
    private javax.swing.JButton zoomMenos;
    private javax.swing.JButton zoomOriginal;
    private javax.swing.JButton jButtonBaixo;
    private javax.swing.JButton jButtonCima;
    private javax.swing.JButton jButtonDireita;
    private javax.swing.JButton jButtonEsquerda;

    private MedidorDeRaiz() {
        
        frame = MotherFrame.getInstance();
        
        Dimension gDimension = new Dimension();
        gDimension.height = frame.getHeight();
        gDimension.width = frame.getWidth() / 2;

        photoPanel = new PhotoPanel();
        photoPanel.setPreferredSize(gDimension);

        otherPanel = new JPanel();
        otherPanel.setPreferredSize(gDimension);
        loadPicture = new JButton("Carregar Imagem");
        loadPicture.addActionListener(this);

        loadNormalizers = new JButton("Config. x, y");
        loadNormalizers.addActionListener(this);

        fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);

        informationText = new JTextArea(18, 20);
        informationText.setEditable(false);
        informationText.setText("Passo 1:\nConfigure parametros iniciais,"
                + "\nPrimeiro horizontalmente,\ndepois verticalmente."
                + "\n\n\n\n\nAutor: Vinícius Duarte Lopes"
                + "\nEmail: vin.duartelopes@gmail.com"
                + "\nCelular: (31) 98841-8467\n"
                + "Versão de Teste Inicial");

        tFieldValorX = new TextField(18);
        tFieldValorY = new TextField(18);
        tFieldValorX.setText("10.0");
        tFieldValorY.setText("10.0");
        photoPanel.setNormalizerX(10.0);
        photoPanel.setNormalizerY(10.0);

        reset = new JButton("Reset");
        reset.addActionListener(this);

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1.setText("Valores em cm:");
        jLabel2.setText("Resultados em cm:");
        jScrollPane1 = new javax.swing.JScrollPane();
        jScrollPane1.setViewportView(informationText);
        resultButton = new javax.swing.JButton();
        resultButton.setText("Gerar resultados");
        resultButton.addActionListener(this);

        zoomMais = new javax.swing.JButton();
        zoomMenos = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        zoomOriginal = new javax.swing.JButton();

        zoomMais.setText("+");
        zoomMais.addActionListener(this);
        zoomMenos.setText("-");
        zoomMenos.addActionListener(this);
        jLabel3.setText("Zoom:");

        zoomOriginal.setText("Zoom original");
        zoomOriginal.addActionListener(this);

        jButtonBaixo = new javax.swing.JButton();
        jButtonCima = new javax.swing.JButton();
        jButtonEsquerda = new javax.swing.JButton();
        jButtonDireita = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        jButtonBaixo.setText("↓");
        jButtonBaixo.addActionListener(this);
        jButtonCima.setText("↑");
        jButtonCima.addActionListener(this);
        jButtonEsquerda.setText("←");
        jButtonEsquerda.addActionListener(this);
        jButtonDireita.setText("→");
        jButtonDireita.addActionListener(this);
        jLabel4.setText("Direção:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(otherPanel);
        otherPanel.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createSequentialGroup()
                                                        .addContainerGap()
                                                        .addComponent(jLabel3)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(zoomMais, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(zoomMenos, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(layout.createSequentialGroup()
                                                        .addComponent(tFieldValorX, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(tFieldValorY, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addComponent(loadNormalizers)
                                                .addGroup(layout.createSequentialGroup()
                                                        .addGap(7, 7, 7)
                                                        .addComponent(jLabel1)))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(resultButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(zoomOriginal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(reset, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(loadPicture, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(layout.createSequentialGroup()
                                        .addContainerGap()
                                        .addComponent(jLabel2))
                                .addGroup(layout.createSequentialGroup()
                                        .addGap(4, 4, 4)
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButtonEsquerda, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(jButtonCima, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jButtonBaixo, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButtonDireita, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 387, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(21, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(tFieldValorX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(tFieldValorY, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(loadNormalizers)
                                        .addGap(20, 20, 20)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(jLabel3)
                                                .addComponent(zoomMais)
                                                .addComponent(zoomMenos)))
                                .addGroup(layout.createSequentialGroup()
                                        .addComponent(loadPicture)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(reset)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(zoomOriginal)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(resultButton)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                        .addGap(19, 19, 19)
                                        .addComponent(jLabel4))
                                .addGroup(layout.createSequentialGroup()
                                        .addGap(29, 29, 29)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(jButtonEsquerda)
                                                .addComponent(jButtonDireita)))
                                .addGroup(layout.createSequentialGroup()
                                        .addGap(12, 12, 12)
                                        .addComponent(jButtonCima)
                                        .addGap(18, 18, 18)
                                        .addComponent(jButtonBaixo)))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 314, Short.MAX_VALUE))
        );

        frame.add(photoPanel);
        frame.add(otherPanel);
        frame.setLayout(new GridLayout(1,2));
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        MedidorDeRaiz medidorDeRaiz = new MedidorDeRaiz();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loadPicture) {
            int returnVal;
            returnVal = fileChooser.showOpenDialog(loadPicture);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                System.out.println(fileChooser.getSelectedFile().toString());
                photoPanel.setFloorPlan(fileChooser.getSelectedFile());
                photoPanel.reset();
                informationText.setText("Medições reiniciadas"
                        + "\nProceda ao passo 1 novamente."
                        + "\nPasso 1:\nConfigure parametros iniciais,"
                        + "\nPrimeiro horizontalmente,\ndepois verticalmente."
                        + "\n\n\n\n\nAutor: Vinícius Duarte Lopes"
                        + "\nEmail: vin.duartelopes@gmail.com\n"
                        + "Versão de Teste Inicial");
                tFieldValorX.setText("10.0");
                tFieldValorY.setText("10.0");
            }
        } else if (e.getSource() == loadNormalizers) {
            photoPanel.setNormalizerX(Double.parseDouble(tFieldValorX.getText()));
            photoPanel.setNormalizerY(Double.parseDouble(tFieldValorY.getText()));
            informationText.setText("Configurados X e Y\n"
                    + "X: " + photoPanel.getNormalizerX() + "\n"
                    + "Y: " + photoPanel.getNormalizerY() + "\n");
        } else if (e.getSource() == reset) {
            photoPanel.reset();
            informationText.setText("Medições reiniciadas"
                    + "\nProceda ao passo 1 novamente."
                    + "\nPasso 1:\nConfigure parametros iniciais,"
                    + "\nPrimeiro horizontalmente,\ndepois verticalmente."
                    + "\n\n\n\n\nAutor: Vinícius Duarte Lopes"
                    + "\nEmail: vin.duartelopes@gmail.com\n"
                    + "Versão de Teste Inicial");
            tFieldValorX.setText("10.0");
            tFieldValorY.setText("10.0");
        } else if (e.getSource() == resultButton) {
            if (!"".equals(photoPanel.calculateInCentimeters())) {
                informationText.setText(photoPanel.calculateInCentimeters());
            } else {
                informationText.setText("Não há resultados\npara serem mostrados.");
            }
        } else if (e.getSource() == zoomMais) {
            photoPanel.escalaMais();
        } else if (e.getSource() == zoomMenos) {
            photoPanel.escalaMenos();
        } else if (e.getSource() == zoomOriginal) {
            photoPanel.setEscalaDefault();
        } else if (e.getSource() == jButtonEsquerda) {
            photoPanel.setTransfEsquerda();
        } else if (e.getSource() == jButtonDireita) {
            photoPanel.setTransfDireita();
        } else if (e.getSource() == jButtonBaixo) {
            photoPanel.setTransfBaixo();
        } else if (e.getSource() == jButtonCima) {
            photoPanel.setTransfCima();
        }
    }
}
