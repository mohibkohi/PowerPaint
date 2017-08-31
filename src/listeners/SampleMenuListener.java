/*
 * TCSS 305 - SampleMenuListener
 * 
 */

package listeners;

import javax.swing.JMenuItem;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

import view.DrawingPanel;

/**
 * SampleMenuListener a menu listener.
 * 
 * @author mohibkohi
 * @version 1.0.
 */
public class SampleMenuListener implements MenuListener {

    /**
     * Filed panel.
     */
    private final DrawingPanel myPanel;

    /**
     * Field menu item.
     */
    private final JMenuItem myMenuItem;

    /**
     * Constructor menu Listener.
     * 
     * @param theJmenu menu to update.
     * @param thePanel which has the shapes.
     */
    public SampleMenuListener(final JMenuItem theJmenu, final DrawingPanel thePanel) {
        myPanel = thePanel;
        myMenuItem = theJmenu;
    }

    @Override
    public void menuSelected(final MenuEvent theEvent) {
        if (myPanel.getListSize() > 0) {
            myMenuItem.setEnabled(true);
        } else {
            myMenuItem.setEnabled(false);
        }
    }

    @Override
    public void menuDeselected(final MenuEvent theEvent) {
    }

    @Override
    public void menuCanceled(final MenuEvent theEvent) {
    }
}
