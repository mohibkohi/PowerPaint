/*
 * TCSS 305 - PowerPaintGUI
 * 
 */

package view;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

/**
 * The graphical user interface for the powerPoint program.
 *
 * @author mohibkohi
 * @version 1.0.
 */
public class PowerPaintGUI extends JFrame {

    /**
     * The serial version UID.
     */
    private static final long serialVersionUID = 1L;

    /**
     * A UWT icon from an image file.
     */
    private static final ImageIcon UW = new ImageIcon("./images/uw.png");

    /**
     * Menu bar instance of MenuBar class.
     */
    private final MenuBar myMenu;

    /**
     * Drawing area.
     */
    private final DrawingPanel myDrawingArea;

    /**
     * Constructs a new PowerPointGUI, using the files in the current working
     * directory.
     */
    public PowerPaintGUI() {
        super("PowerPaint");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        setIconImage(UW.getImage());

        myDrawingArea = new DrawingPanel();
        myMenu = new MenuBar(myDrawingArea, this);
        
        setUpComponents();
        setLocationRelativeTo(null);
        pack();
        setVisible(true);
    }

    /**
     * Lay out the components.
     */
    public final void setUpComponents() {
        add(myMenu.createToolBar(), BorderLayout.SOUTH);
        setJMenuBar(myMenu);
        add(myDrawingArea, BorderLayout.CENTER);
    }
}
