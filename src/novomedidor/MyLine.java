/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package novomedidor;

import java.awt.Point;

/**
 *
 * @author viniciusduarte
 */
public class MyLine {
    
    private Point p1,p2;

    public Point getP1() {
        return p1;
    }

    public void setP1(Point p1) {
        this.p1 = p1;
    }

    public Point getP2() {
        return p2;
    }

    public void setP2(Point p2) {
        this.p2 = p2;
    }

    public MyLine(Point p1, Point p2) {
        this.p1 = p1;
        this.p2 = p2;
    }

    @Override
    public String toString() {
        return "MyLine{" + "p1=(" + p1.x + ',' + p1.y + "), p2=(" + 
                p2.x + ','  + p2.y + ")}";
    }
    
    
}
