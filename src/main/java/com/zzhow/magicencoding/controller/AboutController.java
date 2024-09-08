package com.zzhow.magicencoding.controller;

import com.zzhow.magicencoding.ui.Application;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.util.ResourceBundle;

/**
 * @author ZZHow
 * @date 2024/9/8
 */
public class AboutController {

    @FXML
    private Label Label1;
    @FXML
    private Label Label2;
    @FXML
    private Label Label3;

    @FXML
    public void initialize() {
        switchLanguage();
    }

    private void switchLanguage() {
        ResourceBundle bundle = Application.bundle;

        Label1.setText(bundle.getString("MagicEncoding"));
        Label2.setText(bundle.getString("features"));
        Label3.setText(bundle.getString("features_content"));
    }
}
