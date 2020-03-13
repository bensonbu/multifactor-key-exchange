package image.authentication;

import javax.swing.*;

/**
 * this class contains the image, the scaled version of this image and the name for the image
 *
 * @see     org.game.Juzzle.images.JuzzleImages
 */
public class ImageDescription
{
 /**
  * the image itself
  */
 public ImageIcon imageIcon        = null;
 /**
  * the scaled image
  */
 public ImageIcon imageIcon_scaled = null;
 /**
  * the name of the image
  */
 public String name                = null;

 /**
  * simply constructor
  *
  * @param imageIcon        image itself
  * @param imageIcon_scaled scaled image version
  * @param name             image name
  */
 public ImageDescription(ImageIcon imageIcon, ImageIcon imageIcon_scaled, String name)
  {
  this.imageIcon        = imageIcon;
  this.imageIcon_scaled = imageIcon_scaled;
  this.name             = name;
  }

 /**
  * return the image name
  *
  * @return the name of the image
  */
 public String toString()
  {
  return name;
  }
}