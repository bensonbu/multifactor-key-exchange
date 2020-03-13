package image.authentication;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.*;
import timer.AnnoyingBeep;

/**
 * Frame class for the Juzzle. Juzzle can be a applet, so MainFrame is not important and has no important code.
 *
 * @see     org.game.Juzzle.JuzzlePanel
 */
public class MainFrame extends JFrame
{
 /**
  * the main and only panel in this frame
  *
  * @see     org.game.Juzzle.JuzzlePanel
  */
 protected JuzzlePanel juzzlePanel = null;
public String imageNameFromId= null;
 /**
  * Main constructor for MainFrame. Simply call it to create the GUI and start the game.
  */
 public MainFrame(String imgname)
  {
  super("Image Puzzle");

  // get the screen resolution
  Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();

  int w = screen.width  - 50;
  int h = screen.height - 50;
      System.out.println("width mainframe:" + w +" * "+ h);
  // set the frame on center of the screen
  setSize(800,450);
  setLocation((screen.width - w)/2, (screen.height - h)/2);

  // create the main panel
  juzzlePanel = new JuzzlePanel();

  Container contentPane = getContentPane();
  contentPane.add(juzzlePanel);

  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  setVisible(true);

  // resize
  juzzlePanel.revalidate();
  // start the first game
  
  this.imageNameFromId = imgname;
  
  
  
  juzzlePanel.startGame(imageNameFromId);
  
  
        new AnnoyingBeep(this);

  
  
  
  
  }
}