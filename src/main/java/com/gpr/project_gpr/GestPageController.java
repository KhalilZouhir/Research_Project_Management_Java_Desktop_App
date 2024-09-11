package com.gpr.project_gpr;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GestPageController {
    public static String GlobalToken;
    Stage sstage ;
    Parent root;
    Scene scene;

    @FXML
    private Label LabelIdUser;

    @FXML
    private Hyperlink LogOutLinkId;

    @FXML
    private Hyperlink MyPublicProjectLinkId;

    @FXML
    private TableView<Project> PublicPageProfileTable;

    @FXML
    private BorderPane broderpenid;

    @FXML
    private TableColumn<Project, String> colfifth;

    @FXML
    private TableColumn<Project, String> colfirst;

    @FXML
    private TableColumn<Project, String> colforth;

    @FXML
    private TableColumn<Project, String> colsecond;

    @FXML
    private TableColumn<Project, String> colsiwth;

    @FXML
    private TableColumn<Project, String> colthird;

    @FXML
    void LogOutLinkIdOnAction(ActionEvent event) {
        sstage = (Stage) broderpenid.getScene().getWindow();
        sstage.close();

    }

    @FXML
    public void MyPublicProjectLinkIdOnAction(ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("GuestPage.fxml"));
        root=loader.load();
        UserPageController userpagecntrlr=loader.getController();
        userpagecntrlr.showprojectpublic();
        sstage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        sstage.setScene(new Scene(root));
        sstage.setResizable(false);

        sstage.show();

    }
    public void showprojectpublic(){

        ObservableList<Project> List=getpublicproject();

        colfirst.setCellValueFactory(new PropertyValueFactory<Project,String>("short_name_project"));
        colsecond.setCellValueFactory(new PropertyValueFactory<Project,String>("long_name_project"));
        colthird.setCellValueFactory(new PropertyValueFactory<Project,String>("theme_project"));
        colforth.setCellValueFactory(new PropertyValueFactory<Project,String>("licence_projectt"));
        colfifth.setCellValueFactory(new PropertyValueFactory<Project,String>("type_project"));
        colsiwth.setCellValueFactory(new PropertyValueFactory<Project,String>("desc_project"));

        PublicPageProfileTable.setItems(List);}

    public ObservableList<Project> getpublicproject(){
        ObservableList<Project> projects = FXCollections.observableArrayList();
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnetion();

        PreparedStatement st;
        ResultSet rs;
        try {st=connectNow.getConnetion().prepareStatement("select short_name_project,long_name_project,desc_project,theme_project,type_project,licence_projectt from project where visibility_project=?");
            st.setString(1,"public");
            rs=st.executeQuery();
            Project prjclass;
            while (rs.next())
            { prjclass=new Project(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6));

                projects.add(prjclass);
                System.out.println("it is working wohooo!");
            }

        }
        catch (SQLException e){
            System.out.println(e);
        }
        return  projects;
    }

}
