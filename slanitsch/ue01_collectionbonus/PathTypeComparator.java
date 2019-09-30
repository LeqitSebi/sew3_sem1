package slanitsch.ue01_collectionbonus;

import java.io.File;
import java.nio.file.Path;
import java.util.Comparator;

public class PathTypeComparator implements Comparator<Path> {
    @Override
    public int compare(Path o1, Path o2) {

        File f1 = o1.toFile();
        File f2 = o2.toFile();

        if (f1.isDirectory() && !f2.isDirectory()) {
            return 1;

        } else if (f1.isDirectory() && f2.isDirectory()) {
            return -1;

        }
        if (f1.isFile() && !f2.isFile()) {
            return 1;

        } else if (f1.isFile() && f2.isFile()) {
            return -1;

        }
        return Long.compare(f1.lastModified(), f2.lastModified());
    }
}

