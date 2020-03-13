package skeletonization;

import java.awt.*;
import java.awt.image.BufferedImage;

import static binarization.Util.colorToRGB;
import static skeletonization.TemplatesBase.checkByAdditionalTemplates;
import static skeletonization.TemplatesBase.checkByMainTemplates;

/**
 * Created by Dasha on 24.03.2015.
 */
public class TemplatesMethod {
    private static boolean needContinue;
    public static BufferedImage makeSkeletonization(BufferedImage original) {
        TemplatesBase.init();

        BufferedImage temp = oneStageProcessing(original, 0);
        int times = 0;
        while (needContinue) {
            temp = oneStageProcessing(temp, 0);
            times++;
        }
        needContinue = false;
       // System.out.println(String.format("First stage of skeletonization finished after %d iterations", times));
        times = 0;
        while (needContinue) {
            temp = oneStageProcessing(temp, 1);
            times++;
        }
       // System.out.println(String.format("Second stage of skeletonization finished after %d iterations", times));
        return temp;
    }

    private static BufferedImage oneStageProcessing(BufferedImage original, int stageNumber) {
        int count = 0;
        BufferedImage result = original.getSubimage(0, 0, original.getWidth(), original.getHeight());

        for (int i = 1; i < original.getWidth() - 1; i++) {
            for (int j = 1; j < original.getHeight() - 1; j++) {
                int[][] array = new int[3][3];
                for (int index1 = -1; index1 <= 1; index1++) {
                    for (int index2 = -1; index2 <= 1; index2++) {
                        array[index1 + 1][index2 + 1] = new Color(original.getRGB(i + index1, j + index2)).getRed();
                    }
                }
                /*for (int x = 0; x < array.length; x++) {
                    for (int y = 0; y < array[x].length; y++) {
                        System.out.print(array[x][y] + " ");
                    }
                    System.out.println();
                }
                System.out.println("__________________");*/

                if ((stageNumber == 1 && checkByAdditionalTemplates(array)
                        || (stageNumber == 0 && checkByMainTemplates(array)))) {
                    int alpha = new Color(original.getRGB(i, j)).getAlpha();
                    result.setRGB(i, j, colorToRGB(alpha, 255, 255, 255));
                    count++;
                };
            }
        }
        needContinue = count > 0;
        return result;
    }
}
