module org.example.lokaverkefnid {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.lokaverkefnid to javafx.fxml;
    exports org.example.lokaverkefnid;
}