package slanitsch.ue01_collectionbonus;

import java.nio.file.Path;
import java.io.File;
import java.nio.file.Paths;
import java.util.Comparator;

public class comparePaths implements Comparator<Path> {
    private Path Pfad;

    public final static Comparator<Path> compareEndings = (p1, p2) -> {
        String ending1 = p1.toString().split(".")[1];
        String ending2 = p2.toString().split(".")[1];
        if (ending1.equals(ending2)){
            return 0;
        }else{
            return sortalphabet(ending1, ending2);
        }
    };


    @Override
    public int compare(Path o1, Path o2) {
        File f1 = new File(String.valueOf(o1));
        File f2 = new File(String.valueOf(o2));
        return Long.compare(f1.length(), f2.length());
    }

    public static int sortalphabet(String s1, String s2){
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) < s2.charAt(i)){
                return -1;
            }else if(s1.charAt(i) > s2.charAt(i)){
                return 1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        Path p1 = Paths.get("/home/sebastian/Documents/unsorted/nwt_scripts.txt");
        Path p2 = Paths.get("/home/sebastian/Documents/unsorted/screen_files.txt");
        System.out.println();
    }
}
