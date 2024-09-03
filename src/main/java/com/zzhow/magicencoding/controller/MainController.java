package com.zzhow.magicencoding.controller;

import com.zzhow.magicencoding.service.FileService;
import com.zzhow.magicencoding.service.impl.FileServiceImpl;
import com.zzhow.magicencoding.ui.About;
import com.zzhow.magicencoding.utils.MessageBox;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

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

    public void initialize() {
        originChoiceBox.getItems().addAll("GBK", "UTF-8");
        originChoiceBox.setValue("GBK");
        targetChoiceBox.getItems().addAll("UTF-8", "GBK");
        targetChoiceBox.setValue("UTF-8");
    }

    public void clearFilesPath() {
        fileService.clearTargetFileList();
        filesListView.setItems(null);
    }

    @FXML
    private void onReset() {
        this.clearFilesPath();
        pathTextField.setText("");
        endWithTextField.setText("");
    }

    @FXML
    private void onFindFiles() {
        this.clearFilesPath();
        String absolutePath = pathTextField.getText();
        String endWith = endWithTextField.getText();

        filesListView.setItems(fileService.findFiles(absolutePath, endWith));
    }

    @FXML
    private void onTransform() {
        String absolutePath = pathTextField.getText();
        String originCharset = originChoiceBox.getValue();
        String targetCharset = targetChoiceBox.getValue();

        if (fileService.transform(absolutePath, originCharset, targetCharset)) {
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

}