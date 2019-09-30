package slanitsch.ue01_collectionbonus;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Comparator;
import java.util.Set;

public class PathSizeComperator implements Comparator<Path> {

    @Override
    public int compare(Path o1, Path o2) {
        try {
            return Long.compare(Files.size(o1), Files.size(o2));
        } catch (IOException ignore){

        }
        return 0;
    }

}
