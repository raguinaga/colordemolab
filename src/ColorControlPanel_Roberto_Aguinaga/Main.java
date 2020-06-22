package ColorControlPanel_Roberto_Aguinaga;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Main extends Application {

    /**
     *  start launches
     * @param stage Stage reference
     */
    @Override
    public void start(Stage stage) {
        // Create slider controls for rgb values
        Slider redSlider = new Slider();
        Slider greenSlider = new Slider();
        Slider blueSlider = new Slider();

        // Create lables for sliders
        Label redSliderLabel = new Label("Red:");
        Label greenSliderLabel = new Label("Green:");
        Label blueSliderLabel = new Label("Blue:");

        //Create a textarea and textfield control
        TextArea textBox = new TextArea();
        TextField userRGBValue = new TextField();

        // Create an HBox
        HBox slidersBox = new HBox(10, redSliderLabel, redSlider);
        // Create scene
        Scene scene = new Scene();
        // Set title and launch stage
        stage.setTitle("Color Demo");
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
