package slanitsch.ue03_RegExp;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HTMLStringTools {
    /**
     * liefert eine Map mit allen HTML Tags und deren Häufigkeit in dem File
     * @param fileName Pfad des HTML Files als Sting
     * @return Map<String, Double>
     */
    static Map<String, Double> getHtmlTagStatistic(String fileName) {
        Map<String, Double> erg = new HashMap<>();
        List<String> allTags = new LinkedList<>();
        String content = "";
        try {
            content = new Scanner(new File(fileName)).useDelimiter("\\Z").next();
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }
        Matcher m = Pattern.compile("<[a-z]+([ ][a-z]+=\".+\")?>").matcher(content);
        while (m.find()) {
            allTags.add(m.group());
        }
        List<String> listTags = new LinkedList<>();
        for (String s : allTags) {
            int indexOfSpace = s.indexOf(" ");
            String tag = s;
            if (indexOfSpace != -1) {
                tag = tag.substring(0, indexOfSpace) + ">";
            }
            if (!listTags.contains(tag)) {
                listTags.add(tag);
            }
        }
        for (String s : listTags) {
            Pattern tag = Pattern.compile(s.substring(0, s.length() - 1) + "([ ][a-z]+=\".+\")?>");
            Matcher matcher = tag.matcher(content);
            double count = 0;
            while (matcher.find()) {
                count++;
            }
            erg.put(s, count);
        }
        return erg;
    }

    /**
     * liefert ein Set mit allen Links in der Datei
     * @param fileName Pfad der HTML Datei als String
     * @return Set<String>
     */
    static Set<String> getAbsolutLinks(String fileName) {
        Set<String> erg = new TreeSet<>();
        String content = "";
        try {
            content = new Scanner(new File(fileName)).useDelimiter("\\Z").next();
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }
        Matcher m = Pattern.compile("\"https?://.+\"").matcher(content);
        while (m.find()) {
            erg.add(m.group().substring(1, m.group().length() - 1));
        }
        return erg;
    }

    /**
     * liefert ein Set mit allen Domains der Datei
     * @param fileName Pfad der HTML Datei als String
     * @return Set<String>
     */
    static Set<String> getDomains(String fileName) {
        Set<String> links = getAbsolutLinks(fileName);
        Object[] linksArray = links.toArray();
        Set<String> erg = new TreeSet<>();
        for (Object o : linksArray) {
            String s = (String) o;
            String[] split = s.split("/");
            erg.add(split[2]);
        }
        return erg;
    }
}