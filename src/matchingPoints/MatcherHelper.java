package matchingPoints;

import com.google.common.collect.Iterators;

import java.awt.*;
import java.util.NoSuchElementException;
import java.util.Set;

import static java.lang.Math.abs;

/**
 * Created by Dasha on 29.03.2015.
 */
public class MatcherHelper {
    public int calculateMatchedPoints(Set<Point> points1, Set<Point> points2) {
        int countMatchedPoints = 0;
        for(Point p : points1){
            try {
                Iterators.find(points2.iterator(), point -> abs(point.getX() - p.getX()) < 15 && abs(point.getY() - p.getY()) < 15);
                countMatchedPoints++;
            } catch (NoSuchElementException ex) {

            }
        }
        return countMatchedPoints;
    }
}
