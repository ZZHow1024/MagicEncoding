package com.zzhow.magicencoding.ui;

import com.zzhow.magicencoding.MainClass;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

/**
 * @author ZZHow
 * @date 2024/9/3
 */
public class About {
    public static void open() {
        Stage stage = new Stage();
        stage.setTitle("MagicEncoding 1.0.0 - About");
        Image icon = new Image(Objects.requireNonNull(MainClass.class.getResourceAsStream("/image/icon.png")));
        stage.getIcons().add(icon);
        stage.setResizable(false);
        try {
            Pane load = FXMLLoader.load(Objects.requireNonNull(About.class.getResource("about-view.fxml")));
            Scene scene = new Scene(load);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
