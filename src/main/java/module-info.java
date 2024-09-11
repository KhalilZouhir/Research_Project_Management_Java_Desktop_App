module com.gpr.project_gpr {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires javafx.graphics;
    requires mysql.connector;


    opens com.gpr.project_gpr to javafx.fxml;
    exports com.gpr.project_gpr;
}