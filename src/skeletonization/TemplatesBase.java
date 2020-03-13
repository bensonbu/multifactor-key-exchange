package skeletonization;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Dasha on 22.03.2015.
 */
public class TemplatesBase {
    public static List<Template> mainTemplates = new ArrayList<Template>();
    public static List<Template> additionalTemplates = new ArrayList<Template>();

    public static void init() {
        mainTemplates.add(new Template(new int[][]{{-1, 255, 255}, {0, 0, 255}, {-1, 0, -1}}));
        mainTemplates.add(new Template(new int[][]{{-1, 0, -1}, {0, 0, 255}, {-1, 255, 255}}));
        mainTemplates.add(new Template(new int[][]{{-1, 0, -1}, {255, 0, 0}, {255, 255, -1}}));
        mainTemplates.add(new Template(new int[][]{{255, 255, -1}, {255, 0, 0}, {-1, 0, -1}}));
        mainTemplates.add(new Template(new int[][]{{255, 255, 255}, {0, 0, 0}, {-1, 0, -1}}));
        mainTemplates.add(new Template(new int[][]{{-1, 0, 255}, {0, 0, 255}, {-1, 0, 255}}));
        mainTemplates.add(new Template(new int[][]{{255, 0, -1}, {255, 0, 0}, {255, 0, -1}}));
        mainTemplates.add(new Template(new int[][]{{-1, 0, -1}, {0, 0, 0}, {255, 255, 255}}));

        additionalTemplates.add(new Template(new int[][]{{255, 255, 255}, {255, 0, 255}, {255, 255, 255}}));
        Template template = new Template(new int[][]{{255, 255, 255}, {255, 0, 255}, {1, 1, 1}});
        for (int i = 0; i < 4; i++) {
            additionalTemplates.add(template);
            template = template.rotate(3);
        }
        template = new Template(new int[][]{{255, 255, 255}, {255, 0, 255}, {0, 0, 255}});
        for (int i = 0; i < 4; i++) {
            additionalTemplates.add(template);
            template = template.rotate(3);
        }
        template = new Template(new int[][]{{255, 255, 255}, {255, 0, 255}, {255, 0, 0}});
        for (int i = 0; i < 4; i++) {
            additionalTemplates.add(template);
            template = template.rotate(3);
        }
    }

    public static boolean checkByMainTemplates(int[][] array) {
        for (Template template: mainTemplates) {
            if (checkByTemplate(array, template)) return true;
        }
        return false;
    }

    public static boolean checkByAdditionalTemplates(int[][] array) {
        for (Template template: additionalTemplates) {
            if (checkByTemplate(array, template)) return true;
        }
        return false;
    }

    private static boolean checkByTemplate(int[][] array, Template template) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (template.get(i, j) != -1 && template.get(i, j) != array[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

}
