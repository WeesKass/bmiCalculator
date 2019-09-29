package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Controller {

    @FXML
    private TextField weightTextField;

    @FXML
    private TextField heightTextField;

    @FXML
    private Button calculateButton;

    @FXML
    private ImageView imageView;

    @FXML
    private Label bmiLabel;

    private Image underWeight = new Image("sample/images/underWeight.png");
    private Image normal = new Image("sample/images/normal.png");
    private Image overWeight =new Image("sample/images/overWeight.png");
    private Image obesity = new Image("sample/images/obesity.png");



    @FXML
    void calculateIsPressed(ActionEvent event) {
        Double bmi = Double.valueOf(weightTextField.getText())/(Math.pow(Double.valueOf(heightTextField.getText()), 2));
        bmiLabel.setText(String.format("%.2f",bmi));
        if (bmi<19){
            imageView.setImage(underWeight);
        }else if (18<bmi && bmi<25){
            imageView.setImage(normal);
        }else if (25<bmi && bmi <30){
            imageView.setImage(overWeight);
        }else if (bmi>29){
            imageView.setImage(obesity);
        }
    }

    public void initialize() {
        heightTextField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\d{0,3}([\\.]\\d{0,2})?")) {
                heightTextField.setText(oldValue);
            }
        });
        weightTextField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\d{0,3}([\\.]\\d{0,2})?")) {
                weightTextField.setText(oldValue);
            }
        });

        imageView.setImage(new Image("sample/images/index.jpeg"));
    }

}
