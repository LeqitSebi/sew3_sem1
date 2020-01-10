package slanitsch.ue05_MiniWiki;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Wiki_Syntax extends Application {
    private static final Pattern HEADER = Pattern.compile("([!]+)(.*)");
    private static final Pattern LIST = Pattern.compile("([*]+)(.*)");

    public static void main(String[] args) {
        System.out.println(header("!Heading Level 2"));
        System.out.println(kursiv("//kursiv// und //kursiv// "));
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Wiki-Syntax");

        Button button = new Button("Compile to HTML");
        TextArea textArea = new TextArea("Text hier eingeben");
        WebView webView = new WebView();

        BorderPane.setAlignment(button, Pos.CENTER);
        button.setOnAction(event -> webView.getEngine().loadContent(toHTML(textArea.getText()), "text/html"));


        textArea.setMinSize(200, 400);

        BorderPane main = new BorderPane();
        GridPane gridPane1 = new GridPane();

        gridPane1.add(textArea, 0, 0, 1, 1);
        gridPane1.add(webView, 1, 0, 1, 1);

        main.setPrefSize(1000, 500);
        main.setCenter(gridPane1);
        main.setBottom(button);

        primaryStage.setResizable(false);
        primaryStage.setScene(new Scene(main));
        primaryStage.show();

    }

    private String toHTML(String wiki) {
        StringBuilder b = new StringBuilder();
        String[] lines = wiki.split("\r|\n|\r\n");

        for (String line : lines) {
            line = line.trim();

            if (line.startsWith("!")) {
                line = header(line);
            } else if (line.startsWith("*")) {
                line = list(line);
            }

            line = kursiv(line);
            line = fett(line);

            b.append("<p>").append(line).append("</p>");
        }

        return b.toString();
    }

    public static String header(String s) {
        Matcher matcher = HEADER.matcher(s);
        String erg;
        if (matcher.matches()) {
            int level = matcher.group(1).length();
            if (level > 6) {
                return "Zu viele Rufzeichen (" + s + ")";
            }
            erg = "<h" + level + ">" + matcher.group(2) + "</h" + level + ">";
        } else {
            return s;
        }
        return erg;
    }

    public static String list(String s) {
        Matcher matcher = LIST.matcher(s);
        String erg;
        StringBuilder ulBegin = new StringBuilder();
        StringBuilder ulEnd = new StringBuilder();
        if (matcher.matches()) {
            int count = matcher.group(1).length();
            for (int i = 0; i < count; i++) {
                ulBegin.append("<ul>");
                ulEnd.append("</ul>");
            }
            erg = ulBegin.toString() + "<li>" + matcher.group(2) + "</li>" + ulEnd.toString();
        } else {
            return s;
        }
        return erg;
    }

    public static String kursiv(String s) {
        while (true) {
            String newS = s.replaceAll("(.*)//(.*?)//(.*)", "$1<i>$2</i>$3");
            if (newS.length() == s.length()) {
                return newS;
            }
            s = newS;
        }
    }

    public static String fett(String s) {
        while (true) {
            String newS = s.replaceAll("(.*)''(.*?)''(.*)", "$1<b>$2</b>$3");
            if (newS.length() == s.length()) {
                return newS;
            }
            s = newS;
        }
    }
}
