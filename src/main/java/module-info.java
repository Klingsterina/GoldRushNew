/** Main module for the GoldRush application. */
module vidmot.goldrush {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;
    requires java.desktop;

    opens vidmot to javafx.fxml;
    exports vidmot;
}