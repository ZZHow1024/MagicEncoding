package com.zzhow.magicencoding.controller;

import com.zzhow.magicencoding.service.FileService;
import com.zzhow.magicencoding.service.impl.FileServiceImpl;
import com.zzhow.magicencoding.ui.About;
import com.zzhow.magicencoding.ui.Application;
import com.zzhow.magicencoding.utils.MessageBox;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.DragEvent;
import javafx.scene.input.TransferMode;

import java.io.*;
import java.nio.charset.Charset;
import java.util.List;
import java.util.ResourceBundle;
import java.util.SortedMap;

public class MainController {

    // 文件服务类
    private final FileService fileService = FileServiceImpl.getInstance();

    @FXML
    private Label Label1;
    @FXML
    private Label Label2;
    @FXML
    private Label Label3;
    @FXML
    private Label Label4;
    @FXML
    private Label Label5;
    @FXML
    private Label Label6;
    @FXML
    private Label Label7;
    @FXML
    private Button Button1;
    @FXML
    private Button Button2;
    @FXML
    private Button Button3;
    @FXML
    private Button Button4;
    @FXML
    private ChoiceBox<String> originChoiceBox;
    @FXML
    private ChoiceBox<String> targetChoiceBox;
    @FXML
    private ChoiceBox<String> languageSelector;
    @FXML
    private TextField pathTextField;
    @FXML
    private TextField endWithTextField;
    @FXML
    private ListView<String> filesListView;
    @FXML
    private CheckBox isOverwriteCheckBox;

    public void clearFilesPath() {
        fileService.clearTargetFileList();
        filesListView.setItems(null);
    }

    @FXML
    private void initialize() {
        SortedMap<String, Charset> stringCharsetSortedMap = Charset.availableCharsets();
        originChoiceBox.getItems().add("Auto");
        for (String charset : stringCharsetSortedMap.keySet()) {
            originChoiceBox.getItems().add(charset);
            targetChoiceBox.getItems().add(charset);
        }
        originChoiceBox.setValue("Auto");
        targetChoiceBox.setValue("UTF-8");
        languageSelector.getItems().addAll("简体中文", "繁體中文", "English");
        File config = new File(System.getProperty("user.dir") + "/MagicEncoding.conf");
        try (BufferedReader bf = new BufferedReader(new InputStreamReader(new FileInputStream(config)))) {
            String language = bf.readLine().split("=")[1];
            language = switch (language) {
                case "zh_Hans" -> "简体中文";
                case "zh_Hant" -> "繁體中文";
                case "en" -> "English";
                default -> "简体中文";
            };
            languageSelector.setValue(language);
            Application.language = language;
            switchLanguage();
        } catch (IOException e) {
            languageSelector.setValue("简体中文");
        }
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
        Label7.setText(Application.bundle.getString("Label7") + "0");
    }

    @FXML
    private void onFindFiles() {
        this.clearFilesPath();
        String absolutePath = pathTextField.getText();
        String endWith = endWithTextField.getText();

        filesListView.setItems(fileService.findFiles(absolutePath, endWith));
        Label7.setText(Application.bundle.getString("Label7")
                + fileService.getTargetFileList().size());
    }

    @FXML
    private void onTransform() {
        String absolutePath = pathTextField.getText();
        String originCharset = originChoiceBox.getValue();
        String targetCharset = targetChoiceBox.getValue();
        boolean isOverwrite = this.isOverwriteCheckBox.isSelected();

        if (fileService.transform(absolutePath, originCharset, targetCharset, isOverwrite)) {
            MessageBox.success(Application.bundle.getString("success1_headerText"),
                    "\"" + originCharset + "\" → \"" + targetCharset + "\""
                            + Application.bundle.getString("success1_contentText")
                            + fileService.getTargetFileList().size());
        } else {
            MessageBox.error(Application.bundle.getString("error3_headerText")
                    , Application.bundle.getString("error3_contentText"));
        }

        this.onFindFiles();
    }

    @FXML
    private void onAbout() {
        About.open();
    }

    @FXML
    private void switchLanguage() {
        String selectorValue = languageSelector.getValue();
        selectorValue = switch (selectorValue) {
            case "简体中文" -> "zh_Hans";
            case "繁體中文" -> "zh_Hant";
            case "English" -> "en";
            default -> "zh_Hans";
        };

        Application.setLanguage(selectorValue);
        File config = new File(System.getProperty("user.dir") + "/MagicEncoding.conf");
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(config, false)))) {
            bw.write("language=" + selectorValue);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

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