package org.example;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.util.Duration;

public class Controller {

    @FXML
    private Button makeCoffeeBtn;

    @FXML
    private TextField studentNameTxtField;

    @FXML
    private TextField tasteOfCoffeeTxtField;

    @FXML
    private Slider coffeeSlider;

    @FXML
    private Text quantityOfCoffeeText;

    @FXML
    private Slider cupVolumeSlider;

    @FXML
    private Slider sugarQuantitySlider;

    @FXML
    private Slider kettleVolumeSlider;

    @FXML
    private Slider waterTemperatureSlider;

    @FXML
    private Text studentNameText;

    @FXML
    private Text cupVolumeText;

    @FXML
    private Text tasteOfCoffeeText;

    @FXML
    private Text sugarQuantityText;

    @FXML
    private Text kettleVolumeText;

    @FXML
    private Text kettleTemperatureText;

    @FXML
    private Text resultCounterOfCoffeeCup;

    @FXML
    private Text unexpectedText;

    private  int  coffeeCupNumber = 0;
    @FXML
    private void click(ActionEvent event) throws InterruptedException {
        boolean correctness = true;
        // Check student name entering
        if(coffeeCupNumber>5)
        {
            unexpectedText.setText("МНОГО КОФЕ ВРЕДНО...");
        }
        if(coffeeCupNumber>10)
        {
            unexpectedText.setText("больше кофе не получишь)))))");
            correctness = false;
        }
        if(studentNameTxtField.getText().isEmpty())
        {
            studentNameText.setText("ВВЕДИТЕ ИМЯ!!!!");
            correctness = false;
        }
        // Check coffee taste entering
        if(tasteOfCoffeeTxtField.getText().isEmpty())
        {
            tasteOfCoffeeText.setText("ВВЕДИТЕ ВКУС КОФЕ!!!");
            correctness = false;
        }
        // Check water temperature entering
        if(waterTemperatureSlider.getValue()<91)
        {
            kettleTemperatureText.setText("ТЕМПЕРАТУРА СЛИШКОМ МАЛА!!!");
            correctness = false;
        }
        if(correctness)
        {

            studentNameText.setText(studentNameTxtField.getText());
            cupVolumeText.setText("Кружка объёмом  " + String.valueOf((int)cupVolumeSlider.getValue())+"  мл.");
            tasteOfCoffeeText.setText("Вкус  " + tasteOfCoffeeTxtField.getText());
            quantityOfCoffeeText.setText("Количество кофе  " + String.valueOf((int)coffeeSlider.getValue())+"  ед.");
            sugarQuantityText.setText("Количество сахара  " + String.valueOf((int)sugarQuantitySlider.getValue())+ "  ед.");
            kettleVolumeText.setText("Объем чайника  " + String.valueOf((int)kettleVolumeSlider.getValue())+"  мл.");
            kettleTemperatureText.setText("Температура воды  "+String.valueOf((int)waterTemperatureSlider.getValue())+ "  градусов");

            Coffee coffee = new Coffee(5*(int)coffeeSlider.getValue(),tasteOfCoffeeTxtField.getText());
            Sugar sugar = new Sugar(5*(int)sugarQuantitySlider.getValue());
            Cup cup = new Cup(100+((int)cupVolumeSlider.getValue()/10),(int)cupVolumeSlider.getValue(),"");
            Kettle kettle = new Kettle(200+((int)kettleVolumeSlider.getValue()/10),(int)kettleVolumeSlider.getValue(), (int)waterTemperatureSlider.getValue());
            Student student = new Student(studentNameTxtField.getText());
            student.makeCoffee(sugar,coffee,kettle,cup);

            coffeeCupNumber++;
            resultCounterOfCoffeeCup.setText("Приготовлено  "+ coffeeCupNumber +"  ед. кофе");

        }
    }
}
