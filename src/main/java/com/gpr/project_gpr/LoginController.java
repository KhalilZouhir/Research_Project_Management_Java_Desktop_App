package com.gpr.project_gpr;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class LoginController {
    Stage firstpageStage;
    Parent root;
    private Stage registerStage;
    @FXML
    private Label LoginMessageLabel;
    @FXML
    private TextField usernameTextField;
    @FXML
    private TextField enterPasswordField;
    @FXML
    private Button backbutton;
    @FXML
    public void loginButtonOnAction(ActionEvent event) throws IOException {

        String TokenBdd=usernameTextField.getText();
        if (usernameTextField.getText().isBlank() == false && enterPasswordField.getText().isBlank() == false) {
            DatabaseConnection connectNow = new DatabaseConnection();
            Connection connectDB = connectNow.getConnetion();
            PreparedStatement st;
            ResultSet rs;
            String verifyLogin = "select username ,Type from users where username='" + usernameTextField.getText() + "' and MDP ='" + enterPasswordField.getText() + "'";
            try {

                 st= connectDB.prepareStatement(verifyLogin);
                 rs=st.executeQuery();


                while (rs.next()) {

                    String usertype=rs.getString(2);
                    if ( usertype.equals("guest")){
                       FXMLLoader loader = new FXMLLoader(getClass().getResource("GuestPage.fxml"));
                        root=loader.load();
                        GestPageController gestpagecntrlr=loader.getController();
                        gestpagecntrlr.showprojectpublic();
                        firstpageStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                        firstpageStage.setResizable(false);
                        firstpageStage.setScene(new Scene(root));
                        firstpageStage.show();
                    } else if(usertype.equals("user")) {
                        FXMLLoader loader = new FXMLLoader(getClass().getResource("userpage.fxml"));
                        root = loader.load();
                        UserPageController userpagecntrlr = loader.getController();
                        userpagecntrlr.GlobalToken = usernameTextField.getText();
                        userpagecntrlr.showuserprofile(usernameTextField.getText());
                        userpagecntrlr.LabelIdUser.setText(TokenBdd);
                        firstpageStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                        firstpageStage.setResizable(false);
                        firstpageStage.setScene(new Scene(root));
                        firstpageStage.show();
                    }else if(usertype.equals("admin")) {
                        FXMLLoader loader = new FXMLLoader(getClass().getResource("AdminPage.fxml"));
                        root = loader.load();
                        AdminController adminpagecntrlr = loader.getController();

                        firstpageStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                        firstpageStage.setResizable(false);
                        firstpageStage.setScene(new Scene(root));
                        firstpageStage.show();
                    }
                    else{
                        LoginMessageLabel.setText("invalid value");}}
            }
            catch (Exception e) {
                System.out.println(e);
            }

        } else {
            LoginMessageLabel.setText("fill the blanks");
        }
    }



    public void signuplink(ActionEvent event) throws IOException { //button dyal sign up
        Parent root = FXMLLoader.load(getClass().getResource("sign_up.fxml"));
        registerStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        registerStage.setScene(new Scene(root));
        registerStage.setResizable(false);

        registerStage.show();}
    @FXML
    void backbuttonOnAction(ActionEvent event) throws IOException {    //BUTTON TO GO BACK
        Parent root = FXMLLoader.load(getClass().getResource("FirstPage.fxml"));
        firstpageStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        firstpageStage.setScene(new Scene(root));
        firstpageStage.setResizable(false);
        firstpageStage.show();

    }



}
