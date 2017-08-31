/*
 * TCSS 305 - Tool
 * 
 */

package model;

import java.awt.Shape;
import java.awt.geom.Point2D;

/**
 * Interface Tool.
 * 
 * @author mohibkohi
 * @version 1.0.
 */
public interface Tool {

    /**
     * Set start point of the shape.
     * 
     * @param thePoint to start drawing from.
     * @param thePerfect draw perfect shape if true false otherwise.
     */
    void setPressed(final Point2D thePoint, final boolean thePerfect);

    /**
     * Set end point of the shape.
     * 
     * @param thePoint to start drawing from.
     */
    void setDragged(final Point2D thePoint);

    /**
     * Return the shape.
     * 
     * @return the shape.
     */
    Shape getShape();

    /**
     * Return the name of the shape.
     * 
     * @return string representation of the shape.
     */
    String toString();
}
