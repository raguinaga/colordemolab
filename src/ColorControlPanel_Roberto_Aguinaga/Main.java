// Main package
package ColorControlPanel_Roberto_Aguinaga;

// Begin javaFX imports
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.geometry.Insets;

public class Main extends Application {
    /* Const values for sliders to ensure consistency?
     *  Also provide some static ints to hold the changing rgb values */
    private final double SLIDER_WIDTH = 512;
    private final Orientation SLIDER_ORIENTATION =
            Orientation.HORIZONTAL;
    private final double MAJOR_TICK_UNIT = 15;
    private final int MINOR_TICK_COUNT = 5;
    private static int redValue = 0;
    private static int greenValue = 0;
    private static int blueValue = 0;

    /**
     * start launches gui app
     *
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
            rgbSlideArray[i].setOrientation(SLIDER_ORIENTATION);
            rgbSlideArray[i].setMajorTickUnit(MAJOR_TICK_UNIT);
            rgbSlideArray[i].setMinorTickCount(MINOR_TICK_COUNT);
            rgbSlideArray[i].setShowTickMarks(true);
            rgbSlideArray[i].setShowTickLabels(true);
            rgbSlideArray[i].setPrefWidth(SLIDER_WIDTH);
        }

        // Create labels for sliders
        Label redSliderLabel = new Label("Red:");
        Label greenSliderLabel = new Label("Green:");
        Label blueSliderLabel = new Label("Blue:");

        // Create textArea, textField and button controls
        TextArea bigTextBox = new TextArea("Sample text(You can " +
                "put your own words here!).");
        TextField hexTextBox = new TextField("Please enter a hex " +
                "value here.");
        Button applyRGBValueButton = new Button("Apply RGB Value");

        // Create HBoxes for sliders and their labels
        HBox redHbox = new HBox(10, redSliderLabel,
                rgbSlideArray[0]);
        HBox greenHbox = new HBox(10, greenSliderLabel,
                rgbSlideArray[1]);
        HBox blueHbox = new HBox(10, blueSliderLabel,
                rgbSlideArray[2]);
        HBox buttonHBox = new HBox(hexTextBox, applyRGBValueButton);

        // Create a VBox to house the HBoxes, add padding.
        VBox vbox = new VBox(10, redHbox, greenHbox, blueHbox,
                buttonHBox, bigTextBox);
        vbox.setPadding(new Insets(10));

        // Register event handlers for the sliders, note that the
        // handlers make calls to another method.
        // Red slider
        rgbSlideArray[0].valueProperty().addListener(
                (observable, oldValue, newValue) ->
                {
                    redValue = newValue.intValue();
                    bigTextBox.setStyle(makeInlineStyle(redValue,
                            greenValue, blueValue));
                });

        // Green slider
        rgbSlideArray[1].valueProperty().addListener(
                (observable, oldValue, newValue) ->
                {
                    greenValue = newValue.intValue();
                    bigTextBox.setStyle(makeInlineStyle(redValue,
                            greenValue, blueValue));
                });

        // Blue slider
        rgbSlideArray[2].valueProperty().addListener(
                (observable, oldValue, newValue) ->
                {
                    blueValue = newValue.intValue();
                    bigTextBox.setStyle(makeInlineStyle(redValue,
                            greenValue, blueValue));
                });
        // Register a handler for the textfield input / button
        applyRGBValueButton.setOnAction(event ->
        {
            String userInput = hexTextBox.getText();
            bigTextBox.setStyle(makeInlineStyle(userInput));
            try {

            } catch (Exception e) {
                bigTextBox.setText("Gotbad hex value " +
                        "input. Try again!\nUse 000000 format, " +
                        "do not include the pound (hashtag for you " +
                        "youths).");
            }
        });

        // Create scene with Vbox as the root node.
        Scene scene = new Scene(vbox);

        // Set title and launch stage
        stage.setTitle("Color Demonstrator");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Main launches launch.
     *
     * @param args Command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    /**
     * This method formats a string for use with javafx's inline
     * styling of text colors. It uses the rgb(n,n,n) format, where n
     * is an integer value from 0 to 255.
     *
     * @param r The red color value
     * @param g The green color value
     * @param b The blue color value
     * @return
     */
    private String makeInlineStyle(int r, int g, int b) {
        String styleString;
        return styleString = String.format("-fx-text-fill: rgb" +
                "(%d,%d,%d);", r, g, b);
    }

    private String makeInlineStyle(String textBoxInput) {
        String tempString = "";
        try {
            tempString = "-fx-text-fill: #" + textBoxInput
        } catch (Exception e) {

        }
        return tempString;
    }
}
