/*
 * TCSS 305 - AbstractRecOrEllipse
 * 
 */
package model;

import java.awt.Shape;
import java.awt.geom.Point2D;
import java.awt.geom.RectangularShape;

/**
 * Abstract Rectangle or Ellipse.
 * @author mohibkohi
 * @version 1.0.
 */
public abstract class AbstractRecOrEllipse extends AbstractTool implements Tool {
    
    /**
     * The path being created.
     */
    private final RectangularShape myPath;

    /**
     * Set my perfect shape.
     */
    private boolean myPerfectShape;
    
    /**
     * Constructor initializes the shape.
     * @param theShape to draw.
     */
    public AbstractRecOrEllipse(final RectangularShape theShape) {
        super();
        myPath = theShape;
    }
    
    /**
     * Set start point of the shape.
     * @param thePoint to start drawing from.
     * @param thePerfect draw perfect shape if true false otherwise.
     */
    public void setPressed(final Point2D thePoint, final boolean thePerfect) {
        myPerfectShape = thePerfect;
        myStart = thePoint;
        myPath.setFrameFromDiagonal(myStart.getX(), myStart.getY(), 
                                    myStart.getX(), myStart.getY());
    }


    /**
     * Resizes the shape as mouse moved.
     * @param thePoint to move the shape.
     */
    public void setDragged(final Point2D thePoint) {
        myEnd = thePoint;
        double movingXDistance;
        double movingYDistance;
        movingXDistance = myEnd.getX() - myStart.getX();
        movingYDistance = myEnd.getY() - myStart.getY();

        if (myPerfectShape) {
            if (movingXDistance > 0 || movingXDistance == 0) {
                if (movingYDistance < 0) {
                    moveMyShapFirstOrThirdQuad(movingYDistance, movingXDistance);
                } else {
                    moveMyShapSecondOrFourthQuad(movingXDistance, movingYDistance);
                }
            } else if (movingXDistance < 0) {
                if (movingYDistance < 0 || movingYDistance == 0) {
                    moveMyShapSecondOrFourthQuad(movingXDistance, movingYDistance);
                } else {
                    moveMyShapFirstOrThirdQuad(movingYDistance, movingXDistance);
                }
            }

        } else {
            myPath.setFrameFromDiagonal(myStart.getX(), myStart.getY(),
                    myEnd.getX(), myEnd.getY());
        }
    }

    /**
     * Draws the shape in the first or third quadrant, based on x and y 
     * values of the mouse event.
     * @param theYDistance the x difference.
     * @param theXDistance the y difference.
     */
    private void moveMyShapFirstOrThirdQuad(final double theYDistance, 
                                            final double theXDistance) {        
        if (Math.abs(theYDistance) > Math.abs(theXDistance)) {
            myPath.setFrameFromDiagonal(myStart.getX(), myStart.getY(),
                                        theXDistance + myStart.getX(),
                                        myStart.getY() - theXDistance);
        } else {
            myPath.setFrameFromDiagonal(myStart.getX(), myStart.getY(),
                                        myStart.getX() - theYDistance,
                                        myStart.getY() + theYDistance);
        }
    }

    /**
     * Draws the shape in the second or fourth quadrant, based on x and y 
     * values of the mouse event.
     * @param theYDistance the x difference.
     * @param theXDistance the y difference.
     */
    private void moveMyShapSecondOrFourthQuad(final double theYDistance, 
                                              final double theXDistance) {
        if (Math.abs(theYDistance) > Math.abs(theXDistance)) {
            myPath.setFrameFromDiagonal(myStart.getX(), myStart.getY(),
                    myStart.getX() + theXDistance,
                    myStart.getY() + theXDistance);
        } else {
            myPath.setFrameFromDiagonal(myStart.getX(), myStart.getY(),
                    myStart.getX() + theYDistance,
                    myStart.getY() + theYDistance);
        }
    }

    /**
     * Return the shape.
     * @return the shape.
     */
    @Override
    public Shape getShape() {
        return myPath;
    }
}
