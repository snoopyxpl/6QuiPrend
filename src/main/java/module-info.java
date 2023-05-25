module com.example.sixquiprend {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.sixquiprend to javafx.fxml;
    exports com.example.sixquiprend;
    exports com.example.sixquiprend.Controller;
    opens com.example.sixquiprend.Controller to javafx.fxml;
}