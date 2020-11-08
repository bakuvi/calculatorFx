package sample;


import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label label_field;

    @FXML
    private Button clear_btn;

    @FXML
    private Button plus_minus_btn;

    @FXML
    private Button percent_btn;

    @FXML
    private Button division_btn;

    @FXML
    private Button btn_7;

    @FXML
    private Button comma_btn;

    @FXML
    private Button btn_9;

    @FXML
    private Button multiply_btn;

    @FXML
    private Button btn_4;

    @FXML
    private Button btn_1;

    @FXML
    private Button btn_0;

    @FXML
    private Button btn_5;

    @FXML
    private Button btn_6;

    @FXML
    private Button minus_btn;

    @FXML
    private Button btn_2;

    @FXML
    private Button btn_3;

    @FXML
    private Button plus_btn;

    @FXML
    private Button btn_8;

    @FXML
    private Button equals_btn;
    String str_num = "";
    private float firstNum;
    private char operation;

    @FXML
    void initialize() {
        btn_0.setOnAction(actionEvent -> {
            addNumber(0);
        });
        btn_1.setOnAction(actionEvent -> {
            addNumber(1);
        });
        btn_2.setOnAction(actionEvent -> {
            addNumber(2);
        });
        btn_3.setOnAction(actionEvent -> {
            addNumber(3);
        });
        btn_4.setOnAction(actionEvent -> {
            addNumber(4);
        });
        btn_5.setOnAction(actionEvent -> {
            addNumber(5);
        });
        btn_6.setOnAction(actionEvent -> {
            addNumber(6);
        });
        btn_7.setOnAction(actionEvent -> {
            addNumber(7);
        });
        btn_8.setOnAction(actionEvent -> {
            addNumber(8);
        });
        btn_9.setOnAction(actionEvent -> {
            addNumber(9);
        });
        plus_btn.setOnAction(actionEvent -> {
            mathAction('+');
        });
        minus_btn.setOnAction(actionEvent -> {
            mathAction('-');
        });
        multiply_btn.setOnAction(actionEvent -> {
            mathAction('*');
        });
        division_btn.setOnAction(actionEvent -> {
            mathAction('/');
        });
        equals_btn.setOnAction(actionEvent -> {
            if (this.operation == '+' || this.operation == '-' || this.operation == '*' || this.operation == '/') {
                equalMethod();
            }
        });

        comma_btn.setOnAction(actionEvent1 -> {
            if (!str_num.contains(".")) {
                str_num += ".";
                label_field.setText(str_num);
            }
        });
        percent_btn.setOnAction(event -> {
            if(this.str_num != "") {
                float num = Float.parseFloat(str_num) * 0.1f;
                str_num = Float.toString(num);
                label_field.setText(str_num);
            }
        });
        plus_minus_btn.setOnAction(event -> {
            if(this.str_num != "") {
                float num = Float.parseFloat(str_num) * -1;
                str_num = Float.toString(num);
                label_field.setText(str_num);
            }
        });
        clear_btn.setOnAction(event -> {
            label_field.setText("0");
            str_num = "";
            firstNum = 0;
            operation = 'A';
        });
    }

    private void equalMethod() {
        float res = 0;
        switch (operation) {
            case '+':
                res = firstNum + Float.parseFloat(str_num);
                break;
            case '-':
                res = firstNum - Float.parseFloat(str_num);
                break;
            case '/':
                if (Integer.parseInt(str_num) != 0)
                    res = firstNum / Float.parseFloat(str_num);
                else res = 0;
                break;
            case '*':
                res = firstNum * Float.parseFloat(str_num);
                break;
        }
        label_field.setText(Float.toString(res));
        str_num = "";
        firstNum = 0;
        operation = 'A';
    }

    private void mathAction(char op) {
        if (this.operation != '+' && this.operation != '-' && this.operation != '*' && this.operation != '/') {
            firstNum = Float.parseFloat(str_num);
            label_field.setText(String.valueOf(op));
            str_num = "";
            operation = op;
        }
    }

    private void addNumber(int number) {
        str_num += number;
        label_field.setText(str_num);


    }
}
