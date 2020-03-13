package frontend;
import javax.swing.*;
import java.awt.*;

/**
 * Created by Tonya on 02.05.2015.
 */
public class WindowApp extends JFrame {

    public static void createGUI(String firstImageName, String secondImageName,
                          String branchPointsOfFirstImage, String branchPointsOfSecondImage,
                          String endPointsOfFirstImage, String endPointsOfSecondImage,
                          String percents) {

        JFrame frame = new JFrame("Finger Print Application");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        JPanel firstImagePanel = new JPanel(new FlowLayout());
        firstImagePanel.setBorder(BorderFactory.createTitledBorder("First Image"));

        JLabel firstImage = new JLabel();
        firstImage.setHorizontalAlignment(SwingConstants.LEFT);
        firstImage.setIcon(new javax.swing.ImageIcon(firstImageName));
        firstImage.setText("<html>Number of Branch Points: " + branchPointsOfFirstImage +
                        "<br> Number of End Points: " + endPointsOfFirstImage + "</br>" +
                        "</html>"
        );
        firstImagePanel.add(firstImage);
        mainPanel.add(firstImagePanel, BorderLayout.NORTH);

        JPanel secondImagePanel = new JPanel(new FlowLayout());
        secondImagePanel.setBorder(BorderFactory.createTitledBorder("Second Image"));

        JLabel secondImage = new JLabel();
        secondImage.setHorizontalAlignment(SwingConstants.RIGHT);
        secondImage.setIcon(new javax.swing.ImageIcon(secondImageName));
        secondImage.setText("<html>Number of Branch Points: " + branchPointsOfSecondImage +
                        "<br> Number of End Points: " + endPointsOfSecondImage + "</br>" +
                        "</html>"
        );
        secondImagePanel.add(secondImage);
        mainPanel.add(secondImagePanel, BorderLayout.CENTER);

        JPanel percentPanel = new JPanel(new FlowLayout());
        percentPanel.setBorder(BorderFactory.createTitledBorder("Matching Percent"));
        JLabel percentLabel = new JLabel("Finger Prints match on "+percents+"%");
        percentPanel.add(percentLabel);
        mainPanel.add(percentPanel, BorderLayout.SOUTH);

        frame.getContentPane().add(mainPanel);
        frame.setPreferredSize(new Dimension(450, 485));
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }
}
