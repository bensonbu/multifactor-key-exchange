package image.authentication;

import images.AzureImages;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.awt.image.*;
import java.io.*;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.filechooser.*;


/**
 * the main panel for Juzzle, it containt the ControlPanel and the PuzzlePanel
 *
 * @see org.game.Juzzle.ControlPanel
 * @see org.game.Juzzle.PuzzlePanel
 */
public class JuzzlePanel extends JDesktopPane {

    
   
    public static  String splittedFilename = null;
    /**
     * text as HTML for the about dialog
     */
    public static final String ABOUT_TEXT
            = "Puzzle";

    /**
     * counter for the user images. Used for names of the images:<br>
     * <br>
     * user image 1<br>
     * user image 2<br>
     * user image 3<br>
     * .
     * ..<br>
     *
     */
    protected static int userImage = 1;

    /**
     * reference to the ScrollPanel of the PuzzlePanel
     */
    protected JScrollPane pzp_jsp = null;
    /**
     * reference to the PuzzlePanel
     */
    protected PuzzlePanel pzp = null;
    /**
     * reference to the Frame of the ControlPanel
     */
    protected JInternalFrame controlFrame = null;
    /**
     * reference to the ControlPanel
     */
    protected ControlPanel controlPanel = null;

    /**
     * reference to the StartDialog
     */
    protected StartDialog startDialog = null;

    /**
     * reference to the callback function for the menu
     */
    protected MenuListener menuListener = new MenuListener();

    /**
     * reference to file chooser to load user images
     */
    protected JFileChooser jfc = null;

    /**
     * simply constructor
     */
    public JuzzlePanel() {
        super();

        // create the control panel
        controlPanel = new ControlPanel();

        // create puzzle panel and the scroller for it
        pzp = new PuzzlePanel(controlPanel);
        pzp_jsp = new JScrollPane(pzp);
        pzp_jsp.setBorder(new BevelBorder(BevelBorder.LOWERED));
        pzp_jsp.setOpaque(false);
        pzp_jsp.getViewport().setOpaque(false);

        // set the puzzle panel scroller as default layer, that mean under the ControlPanel frame
        add(pzp_jsp, JDesktopPane.DEFAULT_LAYER);
        addComponentListener(new JuzzlePanelResizer());

        // creates the frame for the ControlPanel
        controlFrame = new JInternalFrame("Preview", true, true, true, true);
//  controlFrame.setMinimumSize(new Dimension(200, 200));
        controlFrame.putClientProperty("JInternalFrame.isPalette", Boolean.TRUE);
        controlFrame.getContentPane().add(controlPanel);
        controlFrame.setLocation(10, 10);
        controlFrame.pack();
     //   add(controlFrame);
      //  controlFrame.setVisible(true);
        
        

        // creates the menu bar for the ControlPanel
        JMenuBar jmb = new JMenuBar();
        JMenu jm = null;

        jm = new JMenu("File");
        jm.add(createMenuItem("New", "new.gif"));
      //  jm.add(createMenuItem("Open", "open.gif"));
      //  jm.add(createMenuItem("Reset", "reset.gif"));
      //  jm.addSeparator();
      //  jm.add(createMenuItem("About", "about.gif"));
     //   jm.addSeparator();
        jm.add(createMenuItem("Quit", "quit.gif"));
        jmb.add(jm);

        jm = new JMenu("View");
        jm.add(createMenuItem2("Antialiasing", true));
        jm.add(createMenuItem2("Outline", true));
        jm.add(createMenuItem2("Shadow", true));
        jmb.add(jm);

      //  controlFrame.setJMenuBar(jmb);

        // show the start dialog for image selection and game start
        //startDialog = new StartDialog();
        
       // startGame();
        
        
        
        
        
        
    }

    /**
     * help function. Creates a menu item and adds the callback function to it.
     *
     * @param name label for menu item
     * @param icon icon for menu item
     * @return the menu item
     */
    protected JMenuItem createMenuItem(String name, String icon) {
        JMenuItem jmi = new JMenuItem(name, AzureImages.getIcon(icon));
        jmi.addActionListener(menuListener);
        return jmi;
    }

    /**
     * help function. Creates a checked menu item and adds the callback function
     * to it.
     *
     * @param name label for menu item
     * @param set checked or not
     * @return the checked menu item
     */
    protected JCheckBoxMenuItem createMenuItem2(String name, boolean set) {
        JCheckBoxMenuItem jmi = new JCheckBoxMenuItem(name, set);
        jmi.addActionListener(menuListener);
        return jmi;
    }

    /**
     * load the use image and add it to the StartDialog list
     */
    public void loadImageForGame() {
        // creates the file chooser with file filter
        if (jfc == null) {
            jfc = new JFileChooser();
            jfc.addChoosableFileFilter(new ImageFileFilter());
        }

        // show modal dialog
        int state = jfc.showOpenDialog(this);
        
        
        File file = jfc.getSelectedFile();

        System.out.println("selected File: " + file.getName());

        if (file != null && state == JFileChooser.APPROVE_OPTION) {
            // create the ImageDescription
            ImageIcon ii = new ImageIcon(file.getPath());

            System.out.println("selected ImageIcon : " + file.getPath());

            ImageIcon iis = AzureImages.scaleIcon(ii, 80);

            ImageDescription id = new ImageDescription(ii, iis, "User image " + (userImage++));

            System.out.println("User image " + (userImage++));

            startDialog.addToImageList(id);
            // start a new game
           // startGame();
        }
    }

    /**
     * starts a new game and reset the system with new parameters
     */
    public void startGame(String imageName) {
        // show the StartDialog
     //   if (startDialog.showDialog(this)) {
          //  Dimension div = startDialog.getSelectedDivision();
            
            
           
            
            //ImageIcon imageIcon = startDialog.getSelectedImage().imageIcon;
ImageIcon imageIcon = new ImageIcon("src/images/image1/"+imageName+".jpg");

        //System.out.println("haiiiiiiiiiiiiiiiiiiii:   "+"src/images/image1/"+imageName+".jpg");


            Image image = imageIcon.getImage();

          //  String sp = imageIcon.getDescription();

          //  String fileName = sp.substring(sp.lastIndexOf('/') + 1, sp.length());

          //  splittedFilename = fileName;
            
          //  System.out.println("print splitted filename  " + fileName);

           // System.out.println("image Icon: from puzzle part list  " + imageIcon.getDescription());
          //  System.out.println("image Icon width  height:" + imageIcon.getIconWidth() + " * " + imageIcon.getIconHeight());
            
            

            BufferedImage bimage = new BufferedImage(imageIcon.getIconWidth(), imageIcon.getIconHeight(), BufferedImage.TYPE_INT_RGB);
            bimage.getGraphics().drawImage(image, 0, 0, null);
//  int pxc = 8, pyc = 10;
//  int pxc = 2, pyc = 3;

            // set the game parameters to the PuzzlePanel
            pzp.setGame(bimage, 2, 2);

           // System.out.println("satgame parameter:  " + 2 + " * " + 2);

            controlPanel.setImage(image);

            // controlFrame.setVisible(true);
         //   pzp.repaint();
            
            
     //   }
        
        
        
        
    }

    /**
     * callback function for the menu items
     */
    public class MenuListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            // start a new game
            if (e.getActionCommand().equals("New")) {
            //    startGame();
            } // load user image
            else if (e.getActionCommand().equals("Open")) {
                loadImageForGame();
            } // reset the current game
            else if (e.getActionCommand().equals("Reset")) {
                pzp.resetGame();
            } // shows the about dialog
            else if (e.getActionCommand().equals("About")) {
                JOptionPane.showMessageDialog(JuzzlePanel.this, ABOUT_TEXT);
            } // exit the program
            else if (e.getActionCommand().equals("Quit")) {
                System.exit(0);
            } // disable or enable antialiasing
            else if (e.getActionCommand().equals("Antialiasing")) {
                pzp.setAntialiasing(((JCheckBoxMenuItem) e.getSource()).isSelected());
            } // disable or enable pieces outlines
            else if (e.getActionCommand().equals("Outline")) {
                pzp.setOutline(((JCheckBoxMenuItem) e.getSource()).isSelected());
            } // disable or enable pieces shadow while dragging
            else if (e.getActionCommand().equals("Shadow")) {
                pzp.setShadow(((JCheckBoxMenuItem) e.getSource()).isSelected());
            }
        }
    }

    /**
     * needed to resize the puzzle panel scroller, because the layout for the
     * JDesktopPane is null.
     */
    public class JuzzlePanelResizer extends ComponentAdapter {

        public void componentShown(ComponentEvent e) {
            pzp_jsp.setSize(getSize());
            pzp_jsp.revalidate();
        }

        public void componentResized(ComponentEvent e) {
            pzp_jsp.setSize(getSize());
            pzp_jsp.revalidate();
        }
    }

    /**
     * file filter for image loading. Loads only JPEG and GIF
     */
    public class ImageFileFilter extends javax.swing.filechooser.FileFilter {

        /**
         * every directory and files with endings *.jpg, *.jpeg, *.gif are
         * accepted
         *
         * @param f the file
         * @return accepted or not
         */
        public boolean accept(File f) {
            return (f.getName().endsWith(".jpg") || f.getName().endsWith(".jpeg") || f.getName().endsWith(".gif") || f.isDirectory());
        }

        /**
         * return the string to display it in the file chooser dialog
         *
         * @return the description string
         */
        public String getDescription() {
            return "Images (*.jpg;*.jpeg;*.gif)";
        }
    }
    
    
    
    
    public void controlFrameDispose()
    {
        controlFrame.dispose();
    }
    
    
}
