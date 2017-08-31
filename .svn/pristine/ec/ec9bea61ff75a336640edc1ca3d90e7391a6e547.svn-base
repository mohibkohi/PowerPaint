/*
 * TCSS 305 - DrawingPanel
 * 
 */

package view;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.event.MouseInputAdapter;

import listeners.MyMouseListener;
import model.Ellipse;
import model.Line;
import model.Pencil;
import model.Rectangle;
import model.Shapes;
import model.Tool;

/**
 * Drawing area class, extends JPanel.
 * 
 * @author mohibkohi
 * @version 1.0.
 */
public class DrawingPanel extends JPanel {

    /**
     * The line width.
     */
    public static final int LINE_WIDTH = 5;

    /**
     * A generated serialization ID.
     */
    private static final long serialVersionUID = 1L;

    /**
     * The size in pixels of a side of one "square" on the grid.
     */
    private static final int WIDTH = 500;

    /**
     * The size in pixels of the directional markers drawn on vehicles in debug
     * mode.
     */
    private static final int HEIGHT = 400;

    /**
     * Setting uw color.
     */
    private static final int UW_COLOR = 51;

    /**
     * Setting uw color.
     */
    private static final int UW_COLOR_SECOND = 111;

    /**
     * List of the drawn shapes.
     */
    private final List<Shapes> myDrawnShapes;

    /**
     * My current drawing myTool.
     */
    private Tool myTool;

    /**
     * UW initial color.
     */
    private Color myColor = new Color(UW_COLOR, 0, UW_COLOR_SECOND);

    /**
     * Initial Stroke.
     */
    private int myStroke = LINE_WIDTH;

    /**
     * My perfect shape.
     */
    private boolean myPerfectShape;

    /**
     * Constructor drawing panel sets up components.
     */
    public DrawingPanel() {
        super(new BorderLayout());
        myDrawnShapes = new ArrayList<Shapes>();
        myTool = new Pencil();
        setUpComponents();
    }

    /**
     * 
     */
    private void setUpComponents() {
        final MouseInputAdapter mouseAdapter = new MyMouseListener(this);
        addMouseListener(mouseAdapter);
        addMouseMotionListener(mouseAdapter);

        setBackground(Color.white);

        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
    }

    /**
     * Undo all the list.
     */
    public void emptyTheList() {
        myDrawnShapes.clear();
        repaint();
    }

    /**
     * Returns the size of the arraylist shapes.
     * 
     * @return size of the list.
     */
    public int getListSize() {
        return myDrawnShapes.size();
    }

    /**
     * Adds a shape to the list.
     * 
     * @param theTool to add.
     */
    public void addShape(final Shapes theTool) {
        myDrawnShapes.add(theTool);
    }

    /**
     * 
     * @param theTool shape.
     */
    public void setTool(final Tool theTool) {
        myTool = theTool;
    }

    /**
     * 
     * @return myTool shape.
     */
    public Tool getTool() {
        return myTool;
    }

    /**
     * 
     * @param theStroke of the shape.
     */
    public void setStroke(final int theStroke) {
        myStroke = theStroke;
    }

    /**
     * 
     * @return myStroke of the shape.
     */
    public int getStroke() {
        return myStroke;
    }

    /**
     * 
     * @param theColor of the shape.
     */
    public void setColor(final Color theColor) {
        myColor = theColor;
    }

    /**
     * Paints the current path.
     * 
     * @param theGraphics The graphics context to use for painting.
     */
    @Override
    public void paintComponent(final Graphics theGraphics) {
        super.paintComponent(theGraphics);
        final Graphics2D g2d = (Graphics2D) theGraphics;

        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                             RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setPaint(myColor);
        g2d.setStroke(new BasicStroke(LINE_WIDTH));

        for (final Shapes i : myDrawnShapes) {
            g2d.setPaint(i.getColor());
            g2d.setStroke(new BasicStroke(i.getStroke()));
            g2d.draw(i.getShape());
        }
    }

    /**
     * 
     * @param thePerfect new perfect shapes.
     */
    public void setPrefectShape(final boolean thePerfect) {
        myPerfectShape = thePerfect;
    }

    /**
     * 
     * @return myPerfectShape new perfect shapes.
     */
    public boolean isPrefectShape() {
        return myPerfectShape;
    }

    /**
     * @return myColor of shape.
     */
    public Color getColor() {
        return myColor;
    }

    /**
     * Creates new reference to the new tool.
     * 
     * @param theTool current tool.
     * @return new reference of the tool
     */
    public Tool newTool(final String theTool) {

        Tool newTool = new Pencil();
        switch (theTool) {
            case "Pencil":
                newTool = new Pencil();
                break;
            case "Line":
                newTool = new Line();
                break;
            case "Rectangle":
                newTool = new Rectangle();
                break;
            case "Ellipse":
                newTool = new Ellipse();
                break;
            default:
                break;
        }
        return newTool;
    }

}
