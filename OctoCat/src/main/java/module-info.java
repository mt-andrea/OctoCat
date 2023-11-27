module com.mycompany.octocat {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.mycompany.octocat to javafx.fxml;
    exports com.mycompany.octocat;
}
