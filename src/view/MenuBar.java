/*
 * TCSS 305 - MenuBar
 * 
 */

package view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JColorChooser;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JSlider;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import listeners.SampleMenuListener;
import model.ButtonsAction;

/**
 * MenuBar class extends JMenuBar, adds a menu bar to the frame.
 * 
 * @author mohibkohi
 * @version 1.0.
 */
public class MenuBar extends JMenuBar {

    /** A generated serialization ID. */
    private static final long serialVersionUID = -368853769852963099L;

    /**
     * A UWT icon from an image file.
     */
    private static final ImageIcon PENCIL = new ImageIcon("./images/pencil_bw.gif");

    /**
     * A UWT icon from an image file.
     */
    private static final ImageIcon LINE = new ImageIcon("./images/line_bw.gif");

    /**
     * A UWT icon from an image file.
     */
    private static final ImageIcon RECTANGLE = new ImageIcon("./images/rectangle_bW.gif");

    /**
     * A UWT icon from an image file.
     */
    private static final ImageIcon ELLIPSE = new ImageIcon("./images/ellipse_bw.gif");

    /**
     * Pencil instance field name.
     */
    private static final String PENCIL_N = "Pencil";

    /**
     * Line name.
     */
    private static final String LINE_N = "Line";

    /**
     * Rectangle name.
     */
    private static final String RECTANGLE_N = "Rectangle";

    /**
     * Ellipse instance field name.
     */
    private static final String ABOUT = "About...";

    /**
     * A UWT icon from an image file.
     */
    private static final ImageIcon UW = new ImageIcon("./images/uw.png");

    /**
     * Ellipse name.
     */
    private static final String ELLIPSEE_N = "Ellipse";

    /**
     * The initial frames at which the thickness will be drawn.
     */
    private static final int INITIAL_FRAMES = 5;

    /**
     * The maximum frames at which the thickness will be drawn.
     */
    private static final int MAX_FRAMES = 20;

    /**
     * The minor tick spacing for the FPS slider.
     */
    private static final int MINOR_TICK_SPACING = 1;

    /**
     * The major tick spacing for the FPS slider.
     */
    private static final int MAJOR_TICK_SPACING = 5;

    /**
     * List of buttons.
     */
    private List<ButtonsAction> myButtonActions;

    /**
     * Drawing area.
     */
    private final DrawingPanel myDrawingArea;

    /**
     * Instance myColor.
     */
    private Color myColor;

    /**
     * Power point gui.
     */
    private final PowerPaintGUI myGUI;

    /**
     * Constructor initializes the drawing area and gui.
     * 
     * @param theDrawingArea to draw shape.
     * @param theGUI to add buttons and menu.
     */
    public MenuBar(final DrawingPanel theDrawingArea, final PowerPaintGUI theGUI) {
        super();
        myDrawingArea = theDrawingArea;
        myGUI = theGUI;
        createMenuBar();
    }

    /**
     * Method to create the menu bar.
     */
    private void createMenuBar() {

        createFileMenu();
        createOptionsMenu();
        createToosMenu();
        crateHelpMenu();
    }

    /**
     * Create file menu.
     */
    private void createFileMenu() {
        final JMenu fileMenu = new JMenu("File");

        final JMenuItem undoMenuItem = new JMenuItem("Undo all changes");
        undoMenuItem.setMnemonic(KeyEvent.VK_U);
        fileMenu.setMnemonic(KeyEvent.VK_F);

        fileMenu.addMenuListener(new SampleMenuListener(undoMenuItem, myDrawingArea));

        if (undoMenuItem.isEnabled()) {
            undoMenuItem.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(final ActionEvent theEvent) {
                    myDrawingArea.emptyTheList();
                }
            });
        }

        final JMenuItem exitMenuItem = new JMenuItem("Exit");
        exitMenuItem.setMnemonic(KeyEvent.VK_X);

        exitMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent theEvent) {
                myGUI.dispose();
            }
        });

        fileMenu.add(undoMenuItem);
        fileMenu.addSeparator();
        fileMenu.add(exitMenuItem);
        add(fileMenu);
    }

    /**
     * Create option menu.
     */
    private void createOptionsMenu() {
        final JMenu optionsMenu = new JMenu("Options");
        optionsMenu.setMnemonic(KeyEvent.VK_O);

        final JCheckBoxMenuItem squreOrCircleCheck =
                        new JCheckBoxMenuItem("Square/Circle only");
        squreOrCircleCheck.setMnemonic(KeyEvent.VK_S);

        squreOrCircleCheck.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent theEvent) {
                if (squreOrCircleCheck.getState()) {
                    myDrawingArea.setPrefectShape(true);
                } else {
                    myDrawingArea.setPrefectShape(false);
                }
            }
        });

        final JMenu thicknessMenuItem = new JMenu("Thickness");
        thicknessMenuItem.setMnemonic(KeyEvent.VK_T);

        final JSlider thicknessSlider =
                        new JSlider(SwingConstants.HORIZONTAL, 0, MAX_FRAMES, INITIAL_FRAMES);
        thicknessSlider.setMajorTickSpacing(MAJOR_TICK_SPACING);
        thicknessSlider.setMinorTickSpacing(MINOR_TICK_SPACING);
        
        thicknessSlider.setPaintLabels(true);
        thicknessSlider.setPaintTicks(true);
        thicknessSlider.addChangeListener(new ChangeListener() {
            /** Called in response to slider events in this window. */
            @Override
            public void stateChanged(final ChangeEvent theEvent) {
                myDrawingArea.setStroke(thicknessSlider.getValue());
            }
        });

        thicknessMenuItem.add(thicknessSlider);

        final JMenuItem colorMenuItem = new JMenuItem("Color...");
        colorMenuItem.setMnemonic(KeyEvent.VK_C);
        colorMenuItem.setIcon(new IconClass(myDrawingArea.getColor()));

        colorMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent theEvent) {
                myColor = JColorChooser.showDialog(myGUI, "Choose a color", myColor);
                if (myColor == null) {
                    myColor = Color.lightGray;
                }
                colorMenuItem.setIcon(new IconClass(myColor));
                myDrawingArea.setColor(myColor);
                repaint();
            }
        });
        optionsMenu.add(squreOrCircleCheck);
        optionsMenu.addSeparator();
        optionsMenu.add(thicknessMenuItem);
        optionsMenu.addSeparator();
        optionsMenu.add(colorMenuItem);
        add(optionsMenu);
    }

    /**
     * A helper method to make a ToolBar.
     * 
     * @return the example Tool Bar
     */
    public JToolBar createToolBar() {

        final JToolBar toolbar = new JToolBar();

        final ButtonGroup buttonGroup = new ButtonGroup();

        for (final ButtonsAction i : myButtonActions) {
            final JToggleButton toggleButt = new JToggleButton(i);
            buttonGroup.add(toggleButt);
            toolbar.add(toggleButt);
        }
       // buttonGroup.clearSelection();
        return toolbar;
    }

    /**
     * Create the menu for tools.
     */
    private void createToosMenu() {
        final JMenu toolsMenu = new JMenu("Tools");
        final ButtonGroup jRadioGroup = new ButtonGroup();

        toolsMenu.setMnemonic(KeyEvent.VK_T);

        myButtonActions = new ArrayList<ButtonsAction>();

        myButtonActions.add(new ButtonsAction(PENCIL_N, PENCIL, myDrawingArea));
        myButtonActions.add(new ButtonsAction(LINE_N, LINE, myDrawingArea));
        myButtonActions.add(new ButtonsAction(RECTANGLE_N, RECTANGLE, myDrawingArea));
        myButtonActions.add(new ButtonsAction(ELLIPSEE_N, ELLIPSE, myDrawingArea));

        for (final ButtonsAction i : myButtonActions) {
            final JRadioButtonMenuItem btn = new JRadioButtonMenuItem(i);
            btn.setIcon(null);
            jRadioGroup.add(btn);
            toolsMenu.add(btn);
        }

        add(toolsMenu);
    }

    /**
     * Create help menu.
     */
    private void crateHelpMenu() {
        final JMenu helpMenu = new JMenu("Help");
        helpMenu.setMnemonic(KeyEvent.VK_H);

        final JMenuItem aboutMenu = new JMenuItem(ABOUT);
        aboutMenu.setMnemonic(KeyEvent.VK_A);

        aboutMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent theEvent) {
                JOptionPane.showMessageDialog(null,
                                              "TCSS 305 PowerPoint\nWinter 2016\nMohib Kohi",
                                              ABOUT, JOptionPane.PLAIN_MESSAGE, UW);
            }
        });
        helpMenu.add(aboutMenu);
        add(helpMenu);
    }

}
