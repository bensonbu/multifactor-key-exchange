package threefactoratm;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;

public class SecureKey {

    public static String passPhrase = "azureifotech";

    public static String storageDir = "D:";
    public static String storageName1 = "Server1";
    public static String storageName2 = "Server2";

    public static String serverpath1 = storageDir + File.separator + storageName1 + File.separator;

    public static String serverpath2 = storageDir + File.separator + storageName2 + File.separator;

    public static int genid = 0;
    
    public static int bal = 0;
    
   public static int numWarningBeeps = 10;
   
    public static boolean solved = false;

    public static String generateNumber2(int length) {
        String result = "";
        int random;
        while (true) {
            random = (int) ((Math.random() * (15)));
            if (result.length() == 0 && random == 0) {
                random += 15;
                result += random;
            } else if (!result.contains(Integer.toString(random))) {
                result += Integer.toString(random);
            }
            if (result.length() >= length) {
                break;
            }
        }
        return result;
    }

    public static int generateNumber(int length) {
        String result = "";
        int random;
        while (true) {
            random = (int) ((Math.random() * (13)));
            if (result.length() == 0 && random == 0) {
                random += 1;
                result += random;
            } else if (!result.contains(Integer.toString(random))) {
                result += Integer.toString(random);
            }
            if (result.length() >= length) {
                break;
            }
        }
        return Integer.parseInt(result);
    }

    public static int generatePIN() {

        //generate a 4 digit integer 1000 <10000
        int randomPIN = (int) (Math.random() * 9000) + 1000;

        //Store integer in a string
        return randomPIN;

    }

    public void copyDirectory(File sourceLocation, File targetLocation)
            throws IOException {

        if (sourceLocation.isDirectory()) {
            if (!targetLocation.exists()) {
                targetLocation.mkdir();
            }

            String[] children = sourceLocation.list();
            for (int i = 0; i < children.length; i++) {
                copyDirectory(new File(sourceLocation, children[i]),
                        new File(targetLocation, children[i]));
            }
        } else {

            InputStream in = new FileInputStream(sourceLocation);
            OutputStream out = new FileOutputStream(targetLocation);

            // Copy the bits from instream to outstream
            byte[] buf = new byte[1024];
            int len;
            while ((len = in.read(buf)) > 0) {
                out.write(buf, 0, len);
            }
            in.close();
            out.close();
        }
    }

    public static void writeFile(String srcPath, String destPath) throws IOException {

        InputStream in = new FileInputStream(srcPath);
        OutputStream out = new FileOutputStream(destPath);

        // Copy the bits from instream to outstream
        byte[] buf = new byte[1024];
        int len;
        while ((len = in.read(buf)) > 0) {
            out.write(buf, 0, len);
        }
        in.close();
        out.close();

    }

}
