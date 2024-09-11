package com.gpr.project_gpr;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;


public class RegisterController {
    @FXML
    private TextField EmailFIeld;

    @FXML
    private TextField FirstnameTextField;

    @FXML
    private Button cancelButton;

    @FXML
    private TextField lastnameTextField;

    @FXML
    private Button registerbutton;

    @FXML
    private Label registrationMessageLabel;

    @FXML
    private TextField setPasswordField;

    @FXML
    private TextField usernameTextField;
    @FXML
    private Label registerlabelid;

    public Stage registerStage1;
    public void registerbuttonaction(ActionEvent event) throws IOException {
        if (usernameTextField.getText().isBlank() == false && setPasswordField.getText().isBlank() == false
                &&EmailFIeld.getText().isBlank() == false && FirstnameTextField.getText().isBlank() == false&&lastnameTextField.getText().isBlank() == false) {
            registerUser();
            Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
            registerStage1 = (Stage) ((Node) event.getSource()).getScene().getWindow();
            registerStage1.setScene(new Scene(root));
            registerStage1.show();}
        else{registerlabelid.setText("Fill The Blanks");}}


    public void  cancelButtonAction(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
        registerStage1 = (Stage) ((Node) event.getSource()).getScene().getWindow();
        registerStage1.setScene(new Scene(root));
        registerStage1.show();}

    public void registerUser(){
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnetion();
        String firstname=FirstnameTextField.getText();
        String lastname=lastnameTextField.getText();
        String username=usernameTextField.getText();
        String password=setPasswordField.getText();
        String email=EmailFIeld.getText();
        String insertFields="INSERT INTO users(Name, Surname, username,MDP,Email)values('";
        String insertValues =firstname+"','"+lastname+"','"+username+"','"+password+"','"+email+"')";
        String insertToRegister=insertFields+insertValues;
        try {
            Statement statement = connectDB.createStatement();
            statement.executeUpdate(insertToRegister);
        }
        catch (SQLException e) {
            System.out.println(e);
        }
    }



}