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
public class rectangle implements shape {
    private double length, width, area;
    public rectangle() {
        this.length = 1.0;
        this.width = 2.0;
    } /**error here**/
    public rectangle(double length, double width)
    {
        setLength(length);
        setWidth(width);
    }
    public double getLength() {
    return(length);
    }
    public void setLength(double length) { /**error here**/
    this.length = length;
    }
    public double getWidth() { /**error here**/
        return width;
    }
    public void setWidth(double width) {
    this.width = width;
    }
    public double getArea() {
        area = length * width;
    return area; /**error here**/
    }
}

