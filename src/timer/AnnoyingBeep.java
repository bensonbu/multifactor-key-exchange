/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timer;

/**
 *
 * @author Azure
 */
import image.authentication.MainFrame;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import threefactoratm.FingerAuth;
import threefactoratm.Login;
import threefactoratm.SecureKey;

/**
 * Schedule a task that executes once every second.
 */
public class AnnoyingBeep {

    Toolkit toolkit;
    Timer timer;
    MainFrame mf;

    public AnnoyingBeep(MainFrame mf) {

        this.mf = mf;
        toolkit = Toolkit.getDefaultToolkit();
        timer = new Timer();
        timer.schedule(new RemindTask(),
                0, //initial delay
                1 * 2000);  //subsequent rate
    }

    class RemindTask extends TimerTask {

        int numWarningBeeps = SecureKey.numWarningBeeps;

        public void run() {

           // if
            if (numWarningBeeps == 0) {
                this.cancel();
                mf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                mf.setVisible(false);
                
                JOptionPane.showMessageDialog(null,  "Time's up! Please Login in and try again");
            }

            if (SecureKey.solved) {
                this.cancel();
                mf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                mf.setVisible(false);

                JOptionPane.showMessageDialog(null, "Wait! Authenticating..........  ");
                FingerAuth iris = new FingerAuth();
                iris.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                iris.setVisible(true);
            }

          //  if (numWarningBeeps > 0) {
            System.out.println("Beep!");
            mf.setTitle(String.valueOf(numWarningBeeps));
            numWarningBeeps--;
                //System.out.println(numWarningBeeps);
            // this.cancel();
            // } else {
            //   toolkit.beep();
            //  mf.setTitle("Time's up!");
            //   mf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

               // JOptionPane.showMessageDialog(null,  "Time's up! Please Login in and try again");
//SecureKey.numWarningBeeps = -1;
            //  this.cancel();
            // }
        }
    }

}
