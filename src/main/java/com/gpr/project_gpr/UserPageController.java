package com.gpr.project_gpr;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import java.util.Date;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import org.w3c.dom.CDATASection;

import javax.xml.transform.Result;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.ResourceBundle;



import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.ResourceBundle;
import java.sql.*;



public class UserPageController implements Initializable{
    @FXML
    private TextArea AgendaTextId1;
    @FXML
    private TextField Addprojectcolfifth;

    @FXML
    private TextField Addprojectcolfirst;

    @FXML
    private TextField Addprojectcolforth;

    @FXML
    private TextField Addprojectcolsecond;

    @FXML
    private TextField Addprojectcolseventh;

    @FXML
    private TextField Addprojectcolsiwth;

    @FXML
    private TextField Addprojectcolthird;
    @FXML
    private Label SubmitlabelId;
    @FXML
    private TableColumn<Project, String> colfifth;
    @FXML
    private TableColumn<Project, String> colseventh;

    @FXML
    private Button SubmitAddProject;
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
    public static String GlobalToken;
    Stage sstage;
    Parent root;
    Scene scene;
    @FXML
    private TableView<User> UserPageProfileTable;
    @FXML
    private TableView<Project> UserPageProjectTable;


    @FXML
    private TableColumn<User, String> colemail;

    @FXML
    private TableColumn<User, String> colfirstname;

    @FXML
    private TableColumn<User, String> collastname;

    @FXML
    private TableColumn<User, String> colusername;
    @FXML
    public Label LabelIdUser;
    @FXML
    private Label labeluserpage;
    @FXML
    private Hyperlink MyProfileLinkId;
    @FXML
    private Hyperlink MyProjectLinkId;
    @FXML
    private BorderPane broderpenid;

    @FXML
    private TableView<Project> PublicPageProfileTable;

    @FXML
    private Hyperlink MyPublicProjectLinkId;
    @FXML
    private Hyperlink AddProjectLinkId;
    @FXML
    private Hyperlink MyAgendaLinkId;
    @FXML
    private Hyperlink MyRessourcesLinkId;
    @FXML
    private Hyperlink LogOutLinkId;

    //link
    @FXML
    public void MyPublicProjectLinkIdOnAction(ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("PublicProjectUser.fxml"));
        root = loader.load();
        UserPageController userpagecntrlr = loader.getController();
        userpagecntrlr.showprojectpublic();
        sstage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        sstage.setScene(new Scene(root));
        sstage.setResizable(false);

        sstage.show();

    }


    @FXML
    public void MyAgendaLinkIdOnAction(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("AgendaUser.fxml"));
        root = loader.load();
        UserPageController userpagecntrlr = loader.getController();
        userpagecntrlr.showAgenda1();
        sstage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        sstage.setScene(new Scene(root));
        sstage.setResizable(false);

        sstage.show();
    }

    @FXML
    public void LogOutLinkIdOnAction(ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("userpage.fxml"));
        root = loader.load();
        UserPageController userpagecntrlr = loader.getController();
        userpagecntrlr.showprojectpublic();
        sstage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        sstage.setScene(new Scene(root));
        sstage.setResizable(false);

        sstage.show();
    }






/////////////////////////////////////////////////////////////////////////////////////


    public ObservableList<User> getuser(String username) {
        ObservableList<User> userprofile = FXCollections.observableArrayList();
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnetion();

        PreparedStatement st;
        ResultSet rs;
        try {
            st = connectNow.getConnetion().prepareStatement("select Surname,Name,Email from users where username=?");
            st.setString(1, username);
            rs = st.executeQuery();
            User usrclass;
            while (rs.next()) {
                usrclass = new User(rs.getString("Surname"), rs.getString("Name"), rs.getString("Email"));
                userprofile.add(usrclass);
                System.out.println("problem!");
            }

        } catch (SQLException e) {
            System.out.println(e);
        }
        return userprofile;
    }

    public void showuserprofile(String username) {
        ObservableList<User> List = getuser(username);
        colfirstname.setCellValueFactory(new PropertyValueFactory<User, String>("Name"));
        collastname.setCellValueFactory(new PropertyValueFactory<User, String>("Surname"));
        colemail.setCellValueFactory(new PropertyValueFactory<User, String>("Email"));
        UserPageProfileTable.setItems(List);

    }


    @FXML
    private TableColumn<?, ?> colemail1;

    @FXML
    private TableColumn<?, ?> colemail11;

    @FXML
    private TableColumn<?, ?> colemail12;


    @FXML
    public void AddProjectLinkIdOnAction(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("AddProject.fxml"));
        sstage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        sstage.setScene(new Scene(root));
        sstage.setResizable(false);

        sstage.show();
    }

    @FXML
    public void MyRessourcesLinkIdOnAction(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Ressource.fxml"));
        sstage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        sstage.setScene(new Scene(root));
        sstage.setResizable(false);

        sstage.show();
    }


/////////////////////////////////////////////////////////////////////////////////////


    @FXML
    public void MyProjectLinkIdOnAction(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ProjectUser.fxml"));
        root = loader.load();
        UserPageController userpagecntrlr = loader.getController();
        int id = getIdUser(GlobalToken);
        userpagecntrlr.showprojectprofile(id);

        sstage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        sstage.setScene(new Scene(root));
        sstage.setResizable(false);

        sstage.show();
    }


    @FXML
    void MyProfileLinkIdOnAction(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("userpage.fxml"));
        root = loader.load();
        UserPageController userpagecntrlr = loader.getController();
        userpagecntrlr.showuserprofile(UserPageController.GlobalToken);
        Stage firstpageStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        firstpageStage.setResizable(false);
        firstpageStage.setScene(new Scene(root));
        firstpageStage.show();
    }

    public ObservableList<Project> getproject(int Id_User) {
        ObservableList<Project> projetprofile = FXCollections.observableArrayList();
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnetion();

        PreparedStatement st;
        ResultSet rs;
        try {
            st = connectNow.getConnetion().prepareStatement("select short_name_project,long_name_project,desc_project,theme_project,type_project,licence_projectt from project, associe where project.id_project=associe.id_project and associe.id_user=?");
            st.setInt(1, Id_User);
            rs = st.executeQuery();
            Project prjclass;
            while (rs.next()) {
                prjclass = new Project(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
                projetprofile.add(prjclass);
                System.out.println("good!");
            }

        } catch (SQLException e) {
            System.out.println(e);
        }
        return projetprofile;
    }

    public void showprojectprofile(int Id_User) {

        ObservableList<Project> List = getproject(Id_User);

        colfirst.setCellValueFactory(new PropertyValueFactory<Project, String>("short_name_project"));
        colsecond.setCellValueFactory(new PropertyValueFactory<Project, String>("long_name_project"));
        colthird.setCellValueFactory(new PropertyValueFactory<Project, String>("theme_project"));
        colforth.setCellValueFactory(new PropertyValueFactory<Project, String>("licence_projectt"));
        colfifth.setCellValueFactory(new PropertyValueFactory<Project, String>("type_project"));
        colsiwth.setCellValueFactory(new PropertyValueFactory<Project, String>("desc_project"));

        UserPageProjectTable.setItems(List);
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

    public ObservableList<Project> getpublicproject() {
        ObservableList<Project> projects = FXCollections.observableArrayList();
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnetion();

        PreparedStatement st;
        ResultSet rs;
        try {
            st = connectNow.getConnetion().prepareStatement("select short_name_project,long_name_project,desc_project,theme_project,type_project,licence_projectt from project where visibility_project=?");
            st.setString(1, "public");
            rs = st.executeQuery();
            Project prjclass;
            while (rs.next()) {
                prjclass = new Project(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));

                projects.add(prjclass);
                System.out.println("it is working wohooo!");
            }

        } catch (SQLException e) {
            System.out.println(e);
        }
        return projects;
    }

    public void showprojectpublic() {

        ObservableList<Project> List = getpublicproject();

        colfirst.setCellValueFactory(new PropertyValueFactory<Project, String>("short_name_project"));
        colsecond.setCellValueFactory(new PropertyValueFactory<Project, String>("long_name_project"));
        colthird.setCellValueFactory(new PropertyValueFactory<Project, String>("theme_project"));
        colforth.setCellValueFactory(new PropertyValueFactory<Project, String>("licence_projectt"));
        colfifth.setCellValueFactory(new PropertyValueFactory<Project, String>("type_project"));
        colsiwth.setCellValueFactory(new PropertyValueFactory<Project, String>("desc_project"));

        PublicPageProfileTable.setItems(List);
    }

    public void addprojectDemande(String username) {

        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnetion();

        PreparedStatement st;
        ResultSet rs;
        String short_name_request = Addprojectcolfirst.getText();
        String long_name_request = Addprojectcolsecond.getText();
        String Desc_request = Addprojectcolseventh.getText();
        String theme_request = Addprojectcolthird.getText();
        String type_project_request = Addprojectcolforth.getText();
        String licence_request = Addprojectcolfifth.getText();
        String visibility = Addprojectcolsiwth.getText();

        try {
            st = connectNow.getConnetion().prepareStatement("insert into request(short_name_request,long_name_request,Desc_request,theme_request,type_project_request,licence_request,visibility,type_request,id_User) values(?,?,?,?,?,?,?,?,?)");
            st.setString(8, "addproject");
            st.setInt(9, getIdUser(username));
            st.setString(1, short_name_request);
            st.setString(2, long_name_request);
            st.setString(3, Desc_request);
            st.setString(4, theme_request);
            st.setString(5, type_project_request);
            st.setString(6, licence_request);
            st.setString(7, visibility);

            st.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e);
        }

    }

    public Stage registerStage1;

    public void Submitbuttonaction(ActionEvent event) throws IOException {
        if (Addprojectcolfirst.getText().isBlank() == false && Addprojectcolsecond.getText().isBlank() == false && Addprojectcolseventh.getText().isBlank() == false
                && Addprojectcolthird.getText().isBlank() == false && Addprojectcolforth.getText().isBlank() == false && Addprojectcolfifth.getText().isBlank() == false && Addprojectcolsiwth.getText().isBlank() == false) {
            addprojectDemande(GlobalToken);
            System.out.println("Data Sent correctly!");
            Parent root = FXMLLoader.load(getClass().getResource("AddProject.fxml"));
            registerStage1 = (Stage) ((Node) event.getSource()).getScene().getWindow();
            registerStage1.setScene(new Scene(root));
            registerStage1.show();

        } else {
            SubmitlabelId.setText("Fill The Blanks");
        }
    }

    @FXML
    private Button buttonsaveid;

    @FXML
    private Button buttonsendid;

    @FXML
    private TextArea AgendaTextId;

    @FXML
    private Button ButtonSaveId;

    public String showallAgenda(String username) {
        String ag = new String();
        try {
            DatabaseConnection connectNow = new DatabaseConnection();
            Connection connectDB = connectNow.getConnetion();
            PreparedStatement st1;
            st1 = connectNow.getConnetion().prepareStatement("Select Agenda from users where username=?");
            st1.setString(1, username);
            ResultSet rs = st1.executeQuery();
            while (rs.next()) {
                ag = rs.getString(1);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return ag;
    }

    public void addAgenda(String username) {
        Calendar cal = Calendar.getInstance();
        Date date = cal.getTime();
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnetion();
        PreparedStatement st;
        PreparedStatement st2;
        ResultSet rs1;
        String Agenda = AgendaTextId.getText();
        String ag = new String();
        String old_agenda = new String();

        String mydate = date.toString();

        try {
            st2 = connectNow.getConnetion().prepareStatement("select Agenda from users where username=?");
            st2.setString(1, username);
            rs1 = st2.executeQuery();
            while (rs1.next()) {
                old_agenda = rs1.getString(1);
                System.out.println(old_agenda);
            }
            st = connectNow.getConnetion().prepareStatement("Update users set Agenda=? where username=?");
            String AgendaDate = Agenda + " " + mydate;
            String new_Agenda = old_agenda + "\n " + AgendaDate;
            st.setString(1, new_Agenda);
            st.setString(2, username);
            st.executeUpdate();

            System.out.println("agenda updated!");
        } catch (SQLException e) {
            System.out.println(e);
        }

    }

    public void showAgenda1() {

        AgendaTextId1.setText(showallAgenda(GlobalToken));


    }

    public void Savebuttonaction(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("AgendaUser.fxml"));

        addAgenda(GlobalToken);

        System.out.println("good");
        root = loader.load();
        UserPageController userpagecntrlr = loader.getController();
        userpagecntrlr.showAgenda1();

        System.out.println("you can see the memo");
        registerStage1 = (Stage) ((Node) event.getSource()).getScene().getWindow();
        registerStage1.setScene(new Scene(root));
        registerStage1.show();


    }


////////RESOOURCES/////*
@FXML
private TextArea agendaid;


    @FXML
    private TextArea messagerieid;


    @FXML
    private Button notvalidatebtn;
    Stage firstpageStage;

    @FXML
    private Button validatebtn;


    String nameSelected;
    @FXML
    void validate(ActionEvent event) throws IOException {

        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnetion();//conction database
        int myindex= id_table.getSelectionModel().getSelectedIndex();
        int id=Integer.parseInt(String.valueOf(id_table.getItems().get(myindex).getId_project()));
        String msgrie=messagerieid.getText();
        String agnd=agendaid.getText();
        PreparedStatement st;

        PreparedStatement st2;


        try{st=connectDB.prepareStatement("update ressources set content_ressource=? where type_ressource = 'messagerie' and id_project=? ; ");
            st.setString(1,msgrie);
            st.setInt(2,id);
            st.executeUpdate();
          /*  st2=connectDB.prepareStatement("update ressources set content_ressource=? where type_ressource = 'agenda' and id_project=? ; ");
            st2.setString(1,agnd);
            st2.setInt(2,id);
            st2.executeUpdate();*/


        } catch (SQLException e) {
            e.printStackTrace();
        }



        FXMLLoader loader = new FXMLLoader(getClass().getResource("testing.fxml"));
        root=loader.load();
        firstpageStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        firstpageStage.setResizable(false);
        firstpageStage.setScene(new Scene(root));
        firstpageStage.show();

    }



    @FXML
    void agendabtnOnaction(ActionEvent event) throws IOException {

        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnetion();//conction database
        int myindex= id_table.getSelectionModel().getSelectedIndex();
        int id=Integer.parseInt(String.valueOf(id_table.getItems().get(myindex).getId_project()));
        String msgrie=messagerieid.getText();
        String agnd=agendaid.getText();
        PreparedStatement st;

        PreparedStatement st2;


        try{/*st=connectDB.prepareStatement("update ressources set content_ressource=? where type_ressource = 'messagerie' and id_project=? ; ");
            st.setString(1,msgrie);
            st.setInt(2,id);
            st.executeUpdate();*/
            st2=connectDB.prepareStatement("update ressources set content_ressource=? where type_ressource = 'agenda' and id_project=? ; ");
            st2.setString(1,agnd);
            st2.setInt(2,id);
            st2.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
        }



        FXMLLoader loader = new FXMLLoader(getClass().getResource("testing.fxml"));
        root=loader.load();
        firstpageStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        firstpageStage.setResizable(false);
        firstpageStage.setScene(new Scene(root));
        firstpageStage.show();
    }



    @FXML
    private TableColumn<Projet_request_class, String> NameProjectid;

    @FXML
    private TableColumn<Projet_request_class, String> StateColid;
    @FXML
    private TableColumn<Projet_request_class, String> StateColid1;

    @FXML
    private TableView<Projet_request_class> id_table;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loadpage();
        selecting ();

    }
    public ObservableList<Projet_request_class>getLignes(){
        ObservableList<Projet_request_class> project_requests_obslst = FXCollections.observableArrayList();
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnetion();//conction database

        String query="select id_project ,content_ressource from ressources where  type_ressource = 'messagerie' ;";
        String query2="select id_project ,content_ressource from ressources where type_ressource = 'agenda' ;";
        Statement st;
        ResultSet rs;
        Statement st2;
        ResultSet rs2;
        try {st=connectDB.createStatement();
            rs=st.executeQuery(query);
            Projet_request_class PRC;
            st2=connectDB.createStatement();
            rs2=st2.executeQuery(query2);
            while (rs.next()&&rs2.next())
            {PRC=new  Projet_request_class(rs.getString("id_project"),rs.getString("content_ressource"),rs2.getString("content_ressource") );
                project_requests_obslst.add(PRC);
            }

        }
        catch (SQLException e){
            System.out.println(e);
        }
        return  project_requests_obslst ;
    }

    private void loadpage(){
        ObservableList<Projet_request_class> List=getLignes();
        NameProjectid.setCellValueFactory(new PropertyValueFactory<Projet_request_class,String>("id_project"));
        StateColid.setCellValueFactory(new PropertyValueFactory<Projet_request_class,String>("content_ressource"));
        StateColid1.setCellValueFactory(new PropertyValueFactory<Projet_request_class,String>("agenda_ressource"));

        id_table.setItems(List);
        id_table.setRowFactory(tv->{
            TableRow<Projet_request_class> myrow=new TableRow<>();
            myrow.setOnMouseClicked(event->
            {
                if(event.getClickCount()==1&&(!myrow.isEmpty()))
                { int myIndex=  id_table.getSelectionModel().getSelectedIndex();
                    nameSelected =id_table.getItems().get(myIndex).getId_project();
                    messagerieid.setText(id_table.getItems().get(myIndex).getContent_ressource());
                    agendaid.setText(id_table.getItems().get(myIndex).getAgenda_ressource());
                }});
            System.out.println(nameSelected);
            return myrow;

        });
    }
    private void selecting (){
        id_table.setRowFactory(tv->{
            TableRow<Projet_request_class> myrow=new TableRow<>();
            myrow.setOnMouseClicked(event->
            {
                if(event.getClickCount()==1&&(!myrow.isEmpty()))
                { int myIndex=  id_table.getSelectionModel().getSelectedIndex();
                    nameSelected =id_table.getItems().get(myIndex).getId_project();
                    messagerieid.setText(id_table.getItems().get(myIndex).getContent_ressource());
                    agendaid.setText(id_table.getItems().get(myIndex).getAgenda_ressource());
                }
                System.out.println("this "+nameSelected);
            });

            return myrow;
        });



    }











    
}



