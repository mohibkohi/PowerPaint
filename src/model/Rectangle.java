/*
 * TCSS 305 - Rectangle
 * 
 */

package model;

import java.awt.geom.Rectangle2D;

/**
 * Class Rectangle.
 * 
 * @author mohibkohi
 * @version 1.0.
 */
public class Rectangle extends AbstractRecOrEllipse {

    /**
     * Constructor sets the initial path. Calls super to pass a new rectangle.
     */
    public Rectangle() {
        super(new Rectangle2D.Double());
    }

    /**
     * Return the name of the shape.
     * 
     * @return string representation of the shape.
     */
    public String toString() {
        return "Rectangle";
    }

}
