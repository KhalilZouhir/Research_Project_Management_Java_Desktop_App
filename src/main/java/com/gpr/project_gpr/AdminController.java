package com.gpr.project_gpr;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class AdminController implements Initializable {
    public static String GlobalToken;
    Stage sstage;
    Parent root;
    Scene scene;
    @FXML
    private Button acceptbutton;

    @FXML
    private Button rejectbutton;
    @FXML
    private Label LabelIdUser;

    @FXML
    private Hyperlink LogOutLinkId;

    @FXML
    private Hyperlink MyRessourcesLinkId;

    @FXML
    private Hyperlink RequestCloseId;

    @FXML
    private Hyperlink RequestOpenId;

    @FXML
    private TableView<Request> UserPageProjectTable;

    Stage firstpageStage;

    @FXML
    private TableColumn<?, ?> colfifth;

    @FXML
    private TableColumn<Request, String> colfirst;
    @FXML
    private TableColumn<?, ?> colvisible;


    @FXML
    private TableColumn<?, ?> colforth;

    @FXML
    private TableColumn<Request, String> colsecond;

    @FXML
    private TableColumn<?, ?> colsiwth;

    @FXML
    private TableColumn<Request, String> colstatus;

    @FXML
    private TableColumn<Request, String> colthird;

    @FXML
    void AddProjectLinkIdOnAction(ActionEvent event) {

    }

    @FXML
    void LogOutLinkIdOnAction(ActionEvent event) {

    }

    @FXML
    void MyPublicProjectLinkIdOnAction(ActionEvent event) {

    }

    @FXML
    void MyRessourcesLinkIdOnAction(ActionEvent event) {

    }

    @FXML
    void RejectFunction(ActionEvent event) throws IOException {
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnetion();//conction database


        String insertFields = "update request set Status='rejected' ";
        String insertValues = " where short_name_request='"+nameSelected+"';";
        String insertToRegister = insertFields + insertValues;
        try {         Statement statement = connectDB.createStatement();
            statement.executeUpdate(insertToRegister);


        }
        catch (SQLException e){
            System.out.println(e);
        }

        FXMLLoader loader = new FXMLLoader(getClass().getResource("AdminPage.fxml"));
        root=loader.load();
        firstpageStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        firstpageStage.setResizable(false);
        firstpageStage.setScene(new Scene(root));
        firstpageStage.show();


    }

    String nameSelected;
    @FXML
    void validate(ActionEvent event) throws IOException {

        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnetion();//conction database
        String short_name_request = colfirst.getText();
        String long_name_request = colsecond.getText();
        String Desc_request = colforth.getText();
        String status = colstatus.getText();


        String insertFields = "update request set Status='valide' ";
        String insertValues = " where short_name_request='"+nameSelected+"';";
        String insertToRegister = insertFields + insertValues;
        PreparedStatement st;
        PreparedStatement st1;
        ResultSet r1;
        ResultSet r2;
        try {         Statement statement = connectDB.createStatement();
            statement.executeUpdate(insertToRegister);
            st1=connectDB.prepareStatement("select id_user from request where short_name_request=?");
            st1.setString(1,nameSelected);
            r1=st1.executeQuery();
            int id = 1;
            while(r1.next()){
                id=r1.getInt(1);
            }
//project creation
            st= connectDB.prepareStatement("insert into project(short_name_project,long_name_project,Desc_project,state_project) values(?,?,?,?)");

            st.setString(1, short_name_request);
            st.setString(2, long_name_request);
            st.setString(3, Desc_request);
            st.setString(4, "valid");
            st.executeUpdate();
            //groupe admin project creation
            st= connectDB.prepareStatement("insert into groups(name_group) values(?)");
            st.setString(1,short_name_request+"grp_admin");
            st.executeUpdate();
            //groupe memeber project
            st= connectDB.prepareStatement("insert into groups(name_group) values(?)");
            st.setString(1,short_name_request+"grp_member");
            st.executeUpdate();
            //update type user to admin
            st= connectDB.prepareStatement("update users set type=? where Id_User=?");
            st.setString(1,"adminproject");
            st.setInt(2,id);
            st.executeUpdate();
            //getting id project
            st= connectDB.prepareStatement("select id_project from project where short_name_project=?");
            st.setString(1,short_name_request);

            r2=st.executeQuery();
            int idp = 1;
            while(r2.next()){
                idp=r2.getInt(1);
            }
            //insert into associe
            st= connectDB.prepareStatement("insert into associe values(?,?)");
            st.setInt(1,idp);
            st.setInt(1,id);
            st.executeUpdate();
            //select idgroupe
            st= connectDB.prepareStatement("select id_group from groups where name_group=?");
            st.setString(1,short_name_request+"grp_admin");

            r2=st.executeQuery();
            int idg=1 ;
            while(r2.next()){
                idg=r2.getInt(1);
            }
            //insert into appartient
            st= connectDB.prepareStatement("insert into appartient values(?,?)");
            st.setInt(1,idg);
            st.setInt(2,id);
            st.executeUpdate();

        }
        catch (SQLException e){
            System.out.println(e);
        }

        FXMLLoader loader = new FXMLLoader(getClass().getResource("AdminPage.fxml"));
        root=loader.load();
        firstpageStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        firstpageStage.setResizable(false);
        firstpageStage.setScene(new Scene(root));
        firstpageStage.show();

    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loadpage();
        selecting ();

    }
    public ObservableList<Request>getLignes(){
        ObservableList<Request> project_requests_obslst = FXCollections.observableArrayList();
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnetion();
        PreparedStatement pr;



        ResultSet rs;
        try {pr= connectDB.prepareStatement("select short_name_request,long_name_request,Desc_request from request where type_request=?");
            pr.setString(1,"open");
            rs=pr.executeQuery();
            Request PRC;
            while (rs.next())
                {PRC=new  Request(rs.getString(1),rs.getString(2), rs.getString(3));
                project_requests_obslst .add(PRC);
            }

        }
        catch (SQLException e){
            System.out.println(e);
        }
        return  project_requests_obslst ;
    }

    private void loadpage(){
        ObservableList<Request> List=getLignes();
        colfirst.setCellValueFactory(new PropertyValueFactory<Request,String>("short_name_request"));
        colsecond.setCellValueFactory(new PropertyValueFactory<Request,String>("long_name_request"));
        colthird.setCellValueFactory(new PropertyValueFactory<Request,String>("Desc_request"));
        colstatus.setCellValueFactory(new PropertyValueFactory<Request,String>("state_request"));
        UserPageProjectTable.setItems(List);
        UserPageProjectTable.setRowFactory(tv->{
            TableRow<Request> myrow=new TableRow<>();
            myrow.setOnMouseClicked(event->
            {
                if(event.getClickCount()==1&&(!myrow.isEmpty()))
                { int myIndex=  UserPageProjectTable.getSelectionModel().getSelectedIndex();
                    nameSelected =UserPageProjectTable.getItems().get(myIndex).getShort_name_request();
                }});
            System.out.println(nameSelected);
            return myrow;

        });
    }
    private void selecting (){
        UserPageProjectTable.setRowFactory(tv->{
            TableRow<Request> myrow=new TableRow<>();
            myrow.setOnMouseClicked(event->
            {
                if(event.getClickCount()==1&&(!myrow.isEmpty()))
                { int myIndex=  UserPageProjectTable.getSelectionModel().getSelectedIndex();
                    nameSelected =UserPageProjectTable.getItems().get(myIndex).getShort_name_request();

                }
                System.out.println("this "+nameSelected);
            });

            return myrow;
        });



    }

    public int getIdUser(String username) {
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnetion();

        PreparedStatement st;
        ResultSet rs;
        int iduser = 0;
        try {
            st = connectNow.getConnetion().prepareStatement("select Id_User from users where username=?");
            st.setString(1, username);
            rs = st.executeQuery();

            while (rs.next()) {
                iduser = rs.getInt(1);

            }

        } catch (SQLException e) {
            System.out.println(e);

        }

        return iduser;
    }


}
