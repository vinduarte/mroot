/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
 Zoom no panel
 Traducao

 Embelezar!!!!
 
 */
/**
 *
 * @author viniciusduarte
 */
public class MedidorDeRaiz implements ActionListener {

    /**
     * @param args the command line arguments
     */
    private final MotherFrame frame;
    private final PhotoPanel photoPanel;
    private final JPanel otherPanel;
    private final JButton loadPicture, reset, resultButton;
    private final JButton loadNormalizers;
    private final JFileChooser fileChooser;
    private final JTextArea informationText;
    private final TextField tFieldValorX;
    private final TextField tFieldValorY;
    private final JLabel jLabel1, jLabel2, jLabel3;
    private final javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton zoomMais;
    private javax.swing.JButton zoomMenos;
    private javax.swing.JButton zoomOriginal;

    private MedidorDeRaiz() {
        Dimension gDimension = new Dimension();
        frame = MotherFrame.getInstance();

        gDimension.height = frame.getHeight();
        gDimension.width = frame.getWidth() / 2;

        photoPanel = new PhotoPanel();
        photoPanel.setPreferredSize(gDimension);

        otherPanel = new JPanel();
        otherPanel.setPreferredSize(gDimension);
        loadPicture = new JButton("Carregar Imagem");
        loadPicture.addActionListener(this);
        //otherPanel.add(loadPicture);

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
        // otherPanel.add(informationText);

        tFieldValorX = new TextField(18);
        tFieldValorY = new TextField(18);
        tFieldValorX.setText("10.0");
        tFieldValorY.setText("10.0");
        photoPanel.setNormalizerX(10.0);
        photoPanel.setNormalizerY(10.0);

        // otherPanel.add(tFieldValorX);
        // otherPanel.add(tFieldValorY);
        // otherPanel.add(loadNormalizers);
        reset = new JButton("Reset");
        reset.addActionListener(this);

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1.setText("Valores em cm");
        jLabel2.setText("Resultados em cm");
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(otherPanel);
        otherPanel.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(tFieldValorX, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(tFieldValorY, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(9, 9, 9)
                                        .addComponent(jLabel1))
                                    .addComponent(loadNormalizers)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(52, 52, 52)
                                                .addComponent(zoomMais, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(6, 6, 6)
                                                .addComponent(jLabel3)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(zoomMenos, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel2)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(reset, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(loadPicture, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(zoomOriginal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(resultButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tFieldValorX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tFieldValorY, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(loadNormalizers)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(zoomMais)
                            .addComponent(zoomMenos))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(loadPicture)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(reset)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(resultButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(zoomOriginal)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 422, Short.MAX_VALUE)
                .addGap(14, 14, 14))
        );

        frame.add(photoPanel);
        frame.add(otherPanel);
        frame.setLayout(new GridLayout(1, 2));
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
            /*
             + "PixX: " + photoPanel.getPixX() + "\n"
             + "PixY: " + photoPanel.getPixY() + "\n"
             + "PropX: " + photoPanel.getPropX() + "\n"
             + "PropY: " + photoPanel.getPropY() + "\n"
             + "Lista:\n" + photoPanel.printLineList() + "\n"
             + "Resultado:\n" + photoPanel.calculateInCentimeters())
             ;*/
        } else if (e.getSource() == reset) {
            photoPanel.reset();
            informationText.setText("Medições reiniciadas"
                    + "\nProceda ao passo 1 novamente."
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
            System.out.println("Cliquei MAIS");
            photoPanel.escalaMais();
            //informationText.setText("CHOLA MAIS");
        } else if (e.getSource() == zoomMenos) {
            System.out.println("Cliquei MENOS");
            //informationText.setText("CHOLA MENOS");
            photoPanel.escalaMenos();
        } else if(e.getSource() == zoomOriginal){
            photoPanel.setEscalaDefault();
        }
    }
}