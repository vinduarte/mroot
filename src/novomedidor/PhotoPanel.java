/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package novomedidor;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.geom.GeneralPath;
import javax.swing.JPanel;
import java.awt.event.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author viniciusduarte
 *
 *
 * LINK QUE VI PARA ESCALA
 *
 * http://www.coderanch.com/t/338284/GUI/java/zoom-zoom-picture-swing
 *
 * google: java zooming image
 */
public class PhotoPanel extends JPanel {

    private MouseHandler mouseHandler = new MouseHandler();
    GeneralPath path = null;
    GeneralPath pathNormalizer = null;
    private boolean drawing = false;
    private boolean newLine = false;
    private boolean normalizerFinished = false;
    private int normalizerCounter = 0;
    private Point previous;
    private BufferedImage floorPlan;
    private double normalizerX, normalizerY;
    private int pixX, pixY;
    double propX, propY;
    List<MyLine> lineList = new ArrayList<>();
    private JLabel semImagem;
    private double escala;
    private final double INDICE_ESCALA = 0.05;
    private double transfPosX, transfPosY;

    public int getPixX() {
        return pixX;
    }

    public int getPixY() {
        return pixY;
    }

    public double getPropX() {
        return propX;
    }

    public double getPropY() {
        return propY;
    }

    public double getNormalizerX() {
        return normalizerX;
    }

    public void setNormalizerX(double normalizerX) {
        this.normalizerX = normalizerX;
    }

    public double getNormalizerY() {
        return normalizerY;
    }

    public void setNormalizerY(double normalizerY) {
        this.normalizerY = normalizerY;
    }

    public void escalaMais() {
        if (escala < 10.0) {
            escala += INDICE_ESCALA;
        }
        repaint();
    }

    public void escalaMenos() {
        if (escala > 0.0) {
            escala -= INDICE_ESCALA;
        }
        repaint();
    }

    public void setEscalaDefault() {
        escala = 1.0;
        repaint();
    }

    public void setTransfDefault() {
        transfPosX = 0.0;
        transfPosY = 0.0;
    }

    public void setTransfEsquerda() {
        if (transfPosX > 0.0) {
            transfPosX -= 25.0;
        }
        repaint();
    }
    
    public void setTransfDireita(){
        // Qual é o limite aqui?
        if (transfPosX < 2000.0) { 
            transfPosX += 25.0;
        }
        repaint();
    }
    
    public void setTransfBaixo() {
        // Qual é o limite aqui?
        if (transfPosY > -2000.0) {
            transfPosY += 25.0;
        }
        repaint();
    }
    
    public void setTransfCima() {
        if (transfPosY > 0.0) {
            transfPosY -= 25.0;
        }
        repaint();
    }

    public PhotoPanel() {
        escala = 1.0;
        transfPosX = transfPosY = 0.0;
        semImagem = new javax.swing.JLabel();
        semImagem.setText("NENHUMA IMAGEM CARREGADA");
        semImagem.setForeground(Color.red);
        this.add(semImagem);

        this.addMouseListener(mouseHandler);
        this.addMouseMotionListener(mouseHandler);
        // IMAGEM INICIAL
        try {
            floorPlan = ImageIO.read(new File("images/gray.jpg"));
            this.remove(semImagem);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Erro ao carregar imagem.\n");
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setStroke(new BasicStroke(3,
                BasicStroke.CAP_ROUND, BasicStroke.JOIN_BEVEL));

        if (floorPlan != null) {
            //colocando a posicao inicial na tela e pegando uma instancia do transformador
            AffineTransform at = AffineTransform.
                    getTranslateInstance(transfPosX, transfPosY);
            //double escala = INDICE_ESCALA / 100.0;
            //double sx = ((double) floorPlan.getWidth()) * escala ;
            //double sy = ((double) floorPlan.getHeight()) * escala;
            at.scale(escala, escala);
            System.out.println("Meu teste: " + floorPlan.getWidth()
                    + " " + floorPlan.getHeight());
            g2d.drawRenderedImage(floorPlan, at);
        }
        if (pathNormalizer != null) {
            g2d.setColor(Color.red);
            g2d.draw(pathNormalizer);
        }
        if (path != null) {
            g2d.setColor(Color.black);
            g2d.draw(path);
        }
    }

    public void setFloorPlan(File f) {
        try {
            floorPlan = ImageIO.read(f);
            this.remove(semImagem);
        } catch (IOException ex) {
            this.add(semImagem);
        }
        this.repaint();
    }

    private class MouseHandler extends MouseAdapter {

        @Override
        public void mousePressed(MouseEvent e) {
            Point p = e.getPoint();
            double tamanho;
            if (!normalizerFinished) {
                if (!drawing) {
                    pathNormalizer = new GeneralPath();
                    pathNormalizer.moveTo(p.x, p.y);
                    previous = new Point(p.x, p.y);
                    drawing = true;
                } else {
                    // Codigo para medir em duas dimensoes
                    if (normalizerCounter == 0) {
                        // Linha X primeiro
                        pathNormalizer.lineTo(p.x, previous.y);
                        pixX = p.x < previous.x ? (previous.x - p.x) : (p.x - previous.x);
                        normalizerCounter++;
                    } else if (normalizerCounter == 1) {
                        pathNormalizer.moveTo(previous.x, previous.y);
                        pathNormalizer.lineTo(previous.x, p.y);
                        pixY = p.y < previous.y ? (previous.y - p.y) : (p.y - previous.y);
                        normalizerCounter++;
                    } else {
                        drawing = false;
                        normalizerFinished = true;
                        pathNormalizer.reset();
                        pixelToCentimetersConfig();
                    }
                }

            } else {
                if (!drawing) {
                    path = new GeneralPath();
                    path.moveTo(p.x, p.y);
                    previous = new Point(p.x, p.y);
                    drawing = true;
                } else {
                    if (!newLine) {
                        path.lineTo(p.x, p.y);
                        tamanho = Math.sqrt((p.x - previous.x) * (p.x - previous.x)
                                + (p.y - previous.y) * (p.y - previous.y));
                        newLine = true;
                        // Adicionando nova linha
                        lineList.add(new MyLine(previous, p));
                    } else {
                        path.moveTo(p.x, p.y);
                        previous = new Point(p.x, p.y);
                        newLine = false;
                    }
                }
            }
            repaint();
        }
    }

    public void pixelToCentimetersConfig() {
        if (pixX != 0 && pixY != 0) {
            propX = (double) pixX / normalizerX;
            propY = (double) pixY / normalizerY;
        }
    }

    public String printLineList() {
        String str;
        str = new String();
        for (MyLine m : lineList) {
            str += m.toString() + "\n";
        }
        return str;
    }

    public String calculateInCentimeters() {
        String result;
        result = "";
        double distX, distY, dist;

        pixelToCentimetersConfig();
        for (MyLine m : lineList) {
            distX = (m.getP2().getX() - m.getP1().getX()) / propX;
            distY = (m.getP1().getY() - m.getP2().getY()) / propY;
            dist = Math.sqrt(distX * distX + distY * distY);
            result += String.format("%.2f", dist) + "\n";
        }

        return result;
    }

    public void reset() {
        if (path != null) {
            path.reset();
        }
        if (pathNormalizer != null) {
            pathNormalizer.reset();
        }
        drawing = false;
        newLine = false;
        normalizerFinished = false;
        normalizerCounter = 0;
        normalizerX = 10.0;
        normalizerY = 10.0;
        pixX = 0;
        pixY = 0;
        propX = 0.0;
        propY = 0.0;
        lineList.clear();
        repaint();
    }
}
