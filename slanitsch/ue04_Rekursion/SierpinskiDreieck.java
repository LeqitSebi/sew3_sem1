package slanitsch.ue04_Rekursion;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.awt.*;

public class SierpinskiDreieck extends Application {

    public static void main(String[] args) {
        double current = System.currentTimeMillis();
        double after = System.currentTimeMillis();
        Application.launch(args);
        System.out.println(after-current);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Sierpinski Dreieck");

        Canvas canvas = new Canvas(1000, 1000);

        primaryStage.setResizable(false);
        primaryStage.setScene(new Scene(new BorderPane(canvas)));
        primaryStage.show();

        Point a = between(new Point(0, 0), new Point((int)canvas.getWidth(), 0));
        Point b = new Point((int)canvas.getWidth(), (int)canvas.getHeight());
        Point c = new Point(0, (int)canvas.getHeight());

        drawTriangle(canvas, a, b, c);
    }

    private void drawTriangle(Canvas canvas, Point a, Point b, Point c) {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.strokeLine(a.x, a.y, b.x, b.y);
        gc.strokeLine(b.x, b.y, c.x, c.y);
        gc.strokeLine(c.x, c.y, a.x, a.y);

        if(a.distance(b.x, b.y) < 2.0) {
            return;
        }

        Point ab = between(a, b);
        Point bc = between(b, c);
        Point ca = between(c, a);

        drawTriangle(canvas, a, ab, ca);
        drawTriangle(canvas, ab, b, bc);
        drawTriangle(canvas, c, ca, bc);
    }

    public static Point between(Point a, Point b) {
        return new Point((a.x + b.x) / 2, (a.y + b.y) / 2);
    }
}
