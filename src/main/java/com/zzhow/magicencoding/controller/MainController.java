package com.zzhow.magicencoding.controller;

import com.zzhow.magicencoding.service.FileService;
import com.zzhow.magicencoding.service.impl.FileServiceImpl;
import com.zzhow.magicencoding.ui.About;
import com.zzhow.magicencoding.utils.MessageBox;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.DragEvent;
import javafx.scene.input.TransferMode;

import java.io.File;
import java.util.List;

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