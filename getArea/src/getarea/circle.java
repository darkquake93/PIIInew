/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package getarea;

/**
 *
 * @author k1336511
 */
public class circle implements shape {
private double radius = 1.0;	
    public circle() {}
    public circle(double radius) {
    setRadius(radius); /**you need to implement this method**/
    }
    public double getRadius() {
    return(radius);
    }
    public void setRadius(double r) {
        this.radius = r;
    }
    public double getArea() {
    return(Math.PI * radius * radius);
    }
}

