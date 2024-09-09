package com.zzhow.magicencoding.controller;

import com.zzhow.magicencoding.service.FileService;
import com.zzhow.magicencoding.service.impl.FileServiceImpl;
import com.zzhow.magicencoding.ui.About;
import com.zzhow.magicencoding.utils.MessageBox;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.DragEvent;
import javafx.scene.input.TransferMode;

import java.io.File;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.SortedMap;

public class MainController {

    // 文件服务类
    private final FileService fileService = FileServiceImpl.getInstance();

    @FXML
    private ChoiceBox<String> originChoiceBox;
    @FXML
    private ChoiceBox<String> targetChoiceBox;
    @FXML
    private TextField pathTextField;
    @FXML
    private TextField endWithTextField;
    @FXML
    private ListView<String> filesListView;
    @FXML
    private Label fileNumber;
    @FXML
    private CheckBox isOverwriteCheckBox;

    public void clearFilesPath() {
        fileService.clearTargetFileList();
        filesListView.setItems(null);
    }

    @FXML
    private void initialize() {
        originChoiceBox.getItems().addAll("GBK", "UTF-8");
        originChoiceBox.setValue("GBK");
        targetChoiceBox.getItems().addAll("UTF-8", "GBK");
        targetChoiceBox.setValue("UTF-8");
        languageSelector.getItems().addAll("简体中文", "繁體中文", "English");

        String language = Locale.getDefault().toLanguageTag();

        if (language.contains("zh")) {
            if (language.contains("Hans"))
                language = "zh_CN";
            else if (language.contains("Hant"))
                language = "zh_TW";
            else if (language.contains("CN"))
                language = "zh_CN";
            else 
                language = "zh_TW";
        } else {
            language = "en_US";
        }

        language = switch (language) {
            case "zh_CN" -> "简体中文";
            case "zh_TW" -> "繁體中文";
            case "en_US" -> "English";
            default -> "简体中文";
        };
        languageSelector.setValue(language);
        Application.language = language;
        switchLanguage();
    }

    @FXML
    private void handleDragOver(DragEvent event) {
        if (event.getGestureSource() != event.getTarget() // 是否从外部拖拽
                && event.getDragboard().hasFiles()) { // 是否拖拽了文件
            event.acceptTransferModes(TransferMode.COPY_OR_MOVE);  // 接受拖拽的文件
        }
        event.consume();
    }

    @FXML
    private void onDragFile(DragEvent event) {
        List<File> files = event.getDragboard().getFiles();
        if (!files.isEmpty()) {
            pathTextField.setText(files.get(0).getAbsolutePath());
        }
    }

    @FXML
    private void onReset() {
        this.clearFilesPath();
        pathTextField.setText("");
        endWithTextField.setText("");
        fileNumber.setText("文件数目：0");
    }

    @FXML
    private void onFindFiles() {
        this.clearFilesPath();
        String absolutePath = pathTextField.getText();
        String endWith = endWithTextField.getText();

        filesListView.setItems(fileService.findFiles(absolutePath, endWith));
        fileNumber.setText("文件数目：" + fileService.getTargetFileList().size());
    }

    @FXML
    private void onTransform() {
        String absolutePath = pathTextField.getText();
        String originCharset = originChoiceBox.getValue();
        String targetCharset = targetChoiceBox.getValue();
        boolean isOverwrite = this.isOverwriteCheckBox.isSelected();

        if (fileService.transform(absolutePath, originCharset, targetCharset, isOverwrite)) {
            MessageBox.success("执行成功", "已将" + fileService.getTargetFileList().size()
                    + "个文件从 \"" + originCharset + "\" 转为 \"" + targetCharset + "\"");
        } else {
            MessageBox.error("执行失败", "请重试");
        }
    }

    @FXML
    private void onAbout() {
        About.open();
    }

    @FXML
    private void switchLanguage() {
        String selectorValue = languageSelector.getValue();
        selectorValue = switch (selectorValue) {
            case "简体中文" -> "zh_CN";
            case "繁體中文" -> "zh_TW";
            case "English" -> "en_US";
            default -> "zh_Hans";
        };

        Application.setLanguage(selectorValue);

        ResourceBundle bundle = Application.bundle;

        // 更新界面上的文本
        Label1.setText(bundle.getString("Label1"));
        Label2.setText(bundle.getString("Label2"));
        Label3.setText(bundle.getString("Label3"));
        Label4.setText(bundle.getString("Label4"));
        Label5.setText(bundle.getString("Label5"));
        Label6.setText(bundle.getString("Label6"));
        Label7.setText(bundle.getString("Label7") + fileService.getTargetFileList().size());
        Button1.setText(bundle.getString("Button1"));
        Button2.setText(bundle.getString("Button2"));
        Button3.setText(bundle.getString("Button3"));
        Button4.setText(bundle.getString("Button4"));
        isOverwriteCheckBox.setText(bundle.getString("isOverwriteCheckBox"));
    }
}