package com.zzhow.magicencoding.utils;

import com.zzhow.magicencoding.MainClass;
import com.zzhow.magicencoding.ui.Application;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.util.Objects;

/**
 * @author ZZHow
 * @date 2024/9/3
 */
public class MessageBox {

    public static void alert(Alert.AlertType type, String title, String headerText, String contentText) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(headerText);
        alert.setContentText(contentText);

        Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
        Image icon = new Image(Objects.requireNonNull(MainClass.class.getResourceAsStream("/image/icon.png")));
        stage.getIcons().add(icon);

        alert.showAndWait();
    }

    public static void error(String headerText, String contentText) {
        alert(Alert.AlertType.ERROR,
                Application.bundle.getString("error"),
                headerText,
                contentText);
    }

    public static void success(String headerText, String contentText) {
        alert(Alert.AlertType.INFORMATION,
                Application.bundle.getString("success"),
                headerText,
                contentText);
    }

}
