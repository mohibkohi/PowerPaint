/*
 * TCSS 305 - ButtonsAction
 * 
 */

package model;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;

import view.DrawingPanel;

/**
 * Class sync toggle buttons and radio buttons.
 * 
 * @author mohibkohi
 * @version 1.0
 */
public class ButtonsAction extends AbstractAction {

    /** A generated serialization ID. */
    private static final long serialVersionUID = -1485959042713904243L;

    /**
     * Drawing area.
     */
    private final DrawingPanel myDrawingArea;

    /**
     * Constructor ButtonsAction.
     * 
     * @param theName of the button.
     * @param theIcon of the button.
     * @param theDrawingArea area to draw.
     */
    public ButtonsAction(final String theName, final ImageIcon theIcon,
                         final DrawingPanel theDrawingArea) {
        super(theName);
        myDrawingArea = theDrawingArea;

        // small icons are usually assigned to the menu
        putValue(Action.SMALL_ICON, theIcon);

        final ImageIcon icon = (ImageIcon) theIcon;
        final Image largeImage =
                        icon.getImage().getScaledInstance(15, -1, java.awt.Image.SCALE_SMOOTH);

        final ImageIcon largeIcon = new ImageIcon(largeImage);

        putValue(Action.LARGE_ICON_KEY, largeIcon);

        // set a mnemonic on the first character of the name
        putValue(Action.MNEMONIC_KEY, KeyEvent.getExtendedKeyCodeForChar(theName.charAt(0)));

        // tool tips
        putValue(Action.SHORT_DESCRIPTION, theName + "Shape");

        // coordinate button selection
        putValue(Action.SELECTED_KEY, true);
    }

    /**
     * Buttons or Radio buttons action performed.
     * @param theEvent specific shape.
     */
    @Override
    public void actionPerformed(final ActionEvent theEvent) {
        myDrawingArea.setTool(myDrawingArea.newTool(theEvent.getActionCommand()));

    }
}
