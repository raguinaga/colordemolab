package ColorControlPanel_Roberto_Aguinaga;

import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    /**
     *  start launches gui app
     * @param stage Stage reference
     */
    @Override
    public void start(Stage stage) {
        /* Create an array of sliders
         * Element 0 represents Red values
         * Element 1 represents Green values
         * Element 2 represents Blue values
         */
        Slider[] rgbSlideArray = new Slider[3];

        /* Create sliders with min values of 0, maxes of 255 and a
         * starting value of zero. Also set tick units, orientation,
         * tick values, and slider width to 512 pixels.
         */
        for (int i = 0; i < rgbSlideArray.length; i++) {
            rgbSlideArray[i] = new Slider(0, 255, 0);
            rgbSlideArray[i].setOrientation(Orientation.HORIZONTAL);
            rgbSlideArray[i].setMajorTickUnit(15);
            rgbSlideArray[i].setMinorTickCount(5);
            rgbSlideArray[i].setShowTickMarks(true);
            rgbSlideArray[i].setShowTickLabels(true);
            rgbSlideArray[i].setPrefWidth(512);
        }


        // Create labels for sliders
        Label redSliderLabel = new Label("Red:");
        Label greenSliderLabel = new Label("Green:");
        Label blueSliderLabel = new Label("Blue:");

        //Create a textarea, textfield and button controls
        TextArea textBox = new TextArea();
        TextField userRGBValue = new TextField();
        Button applyRGBValue = new Button("Apply RGB Value");

        // Create HBoxes for sliders and their labels
        HBox redHbox = new HBox(10, redSliderLabel,
                rgbSlideArray[0]);
        HBox greenHbox = new HBox(10, greenSliderLabel,
                rgbSlideArray[1]);
        HBox blueHbox = new HBox(10, blueSliderLabel, rgbSlideArray[2]);
        HBox buttonHBox = new HBox(userRGBValue,applyRGBValue);

        // Create a VBox to house the Hboxes
        VBox vbox = new VBox(2,redHbox,greenHbox,blueHbox,
                buttonHBox, textBox);

        // Create scene with Vbox as the root node.
        Scene scene = new Scene(vbox);

        // Set title and launch stage
        stage.setTitle("Color Demo");
        stage.setScene(scene);
        stage.show();
    }

    /**
     *  Main launches launch.
     * @param args
     */
    public static void main(String[] args) {
        launch(args);
    }
}
