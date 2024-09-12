module com.zzhow.magicencoding {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires com.github.albfernandez.juniversalchardet;
    requires java.sql;


    opens com.zzhow.magicencoding to javafx.fxml;
    exports com.zzhow.magicencoding;
    exports com.zzhow.magicencoding.controller;
    opens com.zzhow.magicencoding.controller to javafx.fxml;
    exports com.zzhow.magicencoding.ui;
    opens com.zzhow.magicencoding.ui to javafx.fxml;
}