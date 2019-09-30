package slanitsch.ue01_collectionbonus;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Comparator;

public class PathComparator_D implements Comparator<Path> {
    private int nullZunehmendEinsAbnehmend;

    public PathComparator_D(int nullZunehmendEinsAbnehmend) {
        this.nullZunehmendEinsAbnehmend = nullZunehmendEinsAbnehmend;
    }

    @Override
    public int compare(Path a, Path b) {
        File f1 = a.toFile();
        File f2 = b.toFile();

        try {
            if (f1.isDirectory() && f2.isDirectory()) {
                return a.getName(a.getNameCount() - 1).compareTo(b.getName(b.getNameCount() - 1));
            } else if (f1.isFile() && f2.isFile()) {
                if (this.nullZunehmendEinsAbnehmend == 0) {
                    return Long.compare(Files.size(b), Files.size(a));
                } else if (this.nullZunehmendEinsAbnehmend == 1) {
                    return Long.compare(Files.size(a), Files.size(b));
                }
            }
        } catch (IOException e) {
            //
        }
        return 0;
    }
}
