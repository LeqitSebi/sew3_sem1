package slanitsch.ue04_Rekursion;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


/**
 * Demonstriert ein triviales Zeichnen auf einer Canvas
 *
 * @author DI Franz Breunig, Februar 2017
 */
public class DemoSimpleDrawing extends Application {

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("JavaFX Demo: simple drawing on canvas");

        Canvas canvas = new Canvas(400, 100);

        primaryStage.setResizable(false);
        primaryStage.setScene(new Scene(new BorderPane(canvas)));
        primaryStage.show();

        draw2DShapes(canvas);
    }


    /**
     * Zeichnet ein einziges mal beim Start auf die Canvas.
     *
     * @param canvas
     */
    private void draw2DShapes(Canvas canvas) {
        GraphicsContext gc = canvas.getGraphicsContext2D();

        double w = canvas.getWidth();
        double h = canvas.getHeight();

        // blaue Linie (von links oben nach rechts unten)
        gc.setStroke(Color.BLUE);
        gc.strokeLine(0,0, w,h);

        // dicke rosa zu 50% deckende Linie (von rechts oben nach links unten)
        gc.setStroke(Color.rgb(255, 128, 128, 0.5));
        gc.setLineWidth(8.5);
        gc.strokeLine(0,h, w, 0);
    }
}