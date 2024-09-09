package com.zzhow.magicencoding.ui;

import com.zzhow.magicencoding.MainClass;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Locale;
import java.util.Objects;
import java.util.ResourceBundle;

public class Application extends javafx.application.Application {
    public static String language;
    public static ResourceBundle bundle;

    public static void setLanguage(String language) {
        Application.language = language;
        bundle = ResourceBundle.getBundle("MessagesBundle", new Locale(language.split("_")[0], language.split("_")[1]));
    }

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("main-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 700, 535);
        stage.setTitle("MagicEncoding");
        stage.setScene(scene);
        Image icon = new Image(Objects.requireNonNull(MainClass.class.getResourceAsStream("/image/icon.png")));
        stage.getIcons().add(icon);
        stage.setResizable(false);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}