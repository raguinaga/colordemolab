package ColorControlPanel_Roberto_Aguinaga;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Slider;
import javafx.scene.control.TextArea;

public class Main extends Application {

    /**
     *  start launches
     * @param stage Stage reference
     */
    @Override
    public void start(Stage stage) {
        // Create slider controls for rgb values
        Slider sliderRed = new Slider();
        Slider sliderGreen = new Slider();
        Slider sliderBlue = new Slider();

        //Create a textbox area
        TextArea textBox = new TextArea();
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
