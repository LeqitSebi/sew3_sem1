package slanitsch.ue00;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FigureTest {
    public static void main(String[] args) throws IOException {
        readFigures(Paths.get("resources/file.txt"));
    }

    private static void readFigures(Path file) throws IOException {
        try (BufferedReader in = Files.newBufferedReader(file, StandardCharsets.UTF_8)) {

            String line;
            while ((line = in.readLine()) != null) {
                if (semicolon(line) == 0) {
                    System.out.println("Kreis: " + "Radius = " + line);
                }

                if (semicolon(line) == 1) {
                    String[] nums = line.split(";");
                    double a = Double.parseDouble(nums[0]);
                    double b = Double.parseDouble(nums[1]);

                    System.out.println("Rechteck: " + "Seite a = " + a + ", Seite b = " + b);
                }

                if (semicolon(line) == 2) {
                    String[] nums = line.split(";");
                    double a = Double.parseDouble(nums[0]);
                    double b = Double.parseDouble(nums[1]);
                    double c = Double.parseDouble(nums[2]);

                    System.out.println("Dreieck: " + "Seite a = " + a + ", Seite b = " + b + ", Seite c = " + c);
                }
            }
        }
    }

    private static int semicolon(String line) {
        int counter = 0;

        for (int i = 0; i < line.length(); i++) {
            if (line.charAt(i) == ';') {
                counter++;
            }
        }
        return counter;
    }
}
