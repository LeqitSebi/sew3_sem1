package slanitsch.ue01_collectionbonus;

import java.nio.file.Path;
import java.io.File;
import java.nio.file.Paths;
import java.util.Comparator;

public class comparePaths implements Comparator<Path> {
    private Path Pfad;

    public static void main(String[] args) {
        Path p1 = Paths.get("/home/sebastian/Documents/unsorted/nwt_scripts.txt");
        Path p2 = Paths.get("/home/sebastian/Documents/unsorted/screen_files.txt");
        System.out.println(p2.compareTo(p1));
    }

    @Override
    public int compare(Path o1, Path o2) {
        File f1 = new File(String.valueOf(o1));
        File f2 = new File(String.valueOf(o2));
        return Long.compare(f1.length(), f2.length());
    }
}
