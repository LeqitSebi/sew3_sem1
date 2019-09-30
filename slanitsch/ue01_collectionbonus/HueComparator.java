package slanitsch.ue01_collectionbonus;

import java.awt.*;
import java.util.Comparator;

public class HueComparator implements Comparator<Color> {
    @Override
    public int compare(Color o1, Color o2) {
        float[] c1 = o1.RGBtoHSB(o1.getRed(),o1.getGreen(),o1.getBlue(),null);
        float[] c2 = o1.RGBtoHSB(o2.getRed(),o2.getGreen(),o2.getBlue(),null);

        return Float.compare(c1[0],c2[0]);
    }
}
