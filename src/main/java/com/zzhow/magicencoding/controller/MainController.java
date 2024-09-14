package com.zzhow.magicencoding.controller;

import com.zzhow.magicencoding.enums.TextEncodingType;
import com.zzhow.magicencoding.enums.TimeOperationType;
import com.zzhow.magicencoding.service.FileService;
import com.zzhow.magicencoding.service.TextService;
import com.zzhow.magicencoding.service.TimeService;
import com.zzhow.magicencoding.service.impl.FileServiceImpl;
import com.zzhow.magicencoding.service.impl.TextServiceImpl;
import com.zzhow.magicencoding.service.impl.TimeServiceImpl;
import com.zzhow.magicencoding.ui.About;
import com.zzhow.magicencoding.ui.Application;
import com.zzhow.magicencoding.utils.MessageBox;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.DragEvent;
import javafx.scene.input.TransferMode;

import java.io.*;
import java.nio.charset.Charset;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class MainController {

    // 文件服务类
    private final FileService fileService = FileServiceImpl.getInstance();
    // 文本服务类
    private final TextService textService = TextServiceImpl.getInstance();
    // 时间服务类
    private final TimeService timeService = TimeServiceImpl.getInstance();
    // 字符编码索引
    private int textSelectedIndex = 0;
    // 主页索引
    private int selectedIndex = 0;

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
    @FXML
    private TabPane textTabPane;
    @FXML
    private TextArea decodingText;
    @FXML
    private TextArea encodingText;
    @FXML
    private Label urlCharsetText;
    @FXML
    private ChoiceBox<String> urlCharset;
    @FXML
    private TextField nowTimestampS;
    @FXML
    private TextField nowTimestampMs;
    @FXML
    private TabPane tabPane;
    @FXML
    private TextField timeTextField1;
    @FXML
    private TextField timeTextField2;
    @FXML
    private TextField timeTextField3;
    @FXML
    private TextField timeTextField4;
    @FXML
    private TextField timeTextField5;
    @FXML
    private TextField timeTextField6;
    @FXML
    private TextField timeTextField7;
    @FXML
    private TextField timeTextField8;
    @FXML
    private ChoiceBox<String> secondTypeChoiceBox;
    @FXML
    private ChoiceBox<String> timeOperationType;
    @FXML
    private Tab tab1;
    @FXML
    private Tab tab2;
    @FXML
    private Tab tab3;
    @FXML
    private Button textReset;
    @FXML
    private Label timeLabel1;
    @FXML
    private Label timeLabel2;
    @FXML
    private Label timeLabel3;
    @FXML
    private Label timeLabel4;
    @FXML
    private Label timeLabel5;
    @FXML
    private Label timeLabel6;
    @FXML
    private Label timeLabel7;
    @FXML
    private Label timeLabel8;
    @FXML
    private Label timeLabel9;
    @FXML
    private Button timeButton1;
    @FXML
    private Button timeButton2;
    @FXML
    private Button timeButton3;
    @FXML
    private TitledPane timeTitlePane;


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

        urlCharset.getItems().addAll("UTF-8", "GBK");
        urlCharset.setValue("UTF-8");

        secondTypeChoiceBox.getItems().addAll("秒", "毫秒");
        secondTypeChoiceBox.setValue("秒");
        timeOperationType.getItems().addAll("向前", "向后");
        timeOperationType.setValue("向前");

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
    private void onTextTabPaneClicked() {
        SingleSelectionModel<Tab> selectionModel = textTabPane.getSelectionModel();

        if (this.textSelectedIndex != selectionModel.getSelectedIndex()) {
            if (this.textSelectedIndex == TextEncodingType.URL.getValue()) {
                urlCharsetText.setVisible(false);
                urlCharset.setVisible(false);
            }
            this.textSelectedIndex = selectionModel.getSelectedIndex();
            if (this.textSelectedIndex == TextEncodingType.URL.getValue()) {
                urlCharsetText.setVisible(true);
                urlCharset.setVisible(true);
            }
            selectionModel.select(this.textSelectedIndex);
            decodingText.clear();
            encodingText.clear();
            encodingText.setPromptText(selectionModel.getSelectedItem().getText());
        }
    }

    @FXML
    private void onTabPaneClicked() {
        SingleSelectionModel<Tab> selectionModel = this.tabPane.getSelectionModel();

        if (this.selectedIndex != selectionModel.getSelectedIndex()) {
            this.selectedIndex = selectionModel.getSelectedIndex();
            if (selectionModel.getSelectedIndex() == 2)
                this.onRefreshTimestamp();
        }
    }

    @FXML
    private void onRefreshTimestamp() {
        this.nowTimestampS.setText(System.currentTimeMillis() / 1000 + "");
        this.nowTimestampMs.setText(System.currentTimeMillis() + "");
    }

    @FXML
    private void onTimeReset() {
        timeTextField1.clear();
        timeTextField2.clear();
        timeTextField3.clear();
        timeTextField4.clear();
        timeTextField5.clear();
        timeTextField6.clear();
        timeTextField7.clear();
        timeTextField8.clear();
    }

    @FXML
    private void onTimestampToTime() {
        String text = timeTextField1.getText();
        TimeUnit timeUnit = secondTypeChoiceBox.getSelectionModel().getSelectedIndex() == 0 ? TimeUnit.SECONDS : TimeUnit.MILLISECONDS;
        if (text == null || text.isEmpty())
            return;
        try {
            long timestamp = Long.parseLong(text);
            timeTextField2.setText(timeService.timestampToTime(timestamp, timeUnit));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @FXML
    private void onTimeToTimestamp() {
        String text = timeTextField2.getText();
        TimeUnit timeUnit = secondTypeChoiceBox.getSelectionModel().getSelectedIndex() == 0 ? TimeUnit.SECONDS : TimeUnit.MILLISECONDS;
        if (text == null || text.isEmpty())
            return;

        try {
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            LocalDateTime localDateTime = LocalDateTime.parse(timeTextField2.getText(), dateTimeFormatter);
            timeTextField1.setText(timeService.timeToTimestamp(localDateTime, timeUnit));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @FXML
    private void onTimeOperate() {
        int selectedIndex = timeOperationType.getSelectionModel().getSelectedIndex();
        if (timeTextField2.getText().isEmpty())
            if (!timeTextField1.getText().isEmpty())
                this.onTimestampToTime();
            else {
                ResourceBundle bundle = Application.bundle;
                MessageBox.error(bundle.getString("error4_headerText"), bundle.getString("error4_contentText"));
                return;
            }

        String time = timeTextField2.getText();
        TimeOperationType type = TimeOperationType.valueOf(selectedIndex);
        String year = timeTextField3.getText();
        String month = timeTextField4.getText();
        String day = timeTextField5.getText();
        String hour = timeTextField6.getText();
        String minute = timeTextField7.getText();
        String second = timeTextField8.getText();

        String res = timeService.timeOperate(type, time, year, month, day, hour, minute, second);
        timeTextField2.setText(res);
        this.onTimeToTimestamp();
    }

    @FXML
    private void onEncodeText() {
        String originalText = decodingText.getText();
        String originalCharset = urlCharset.getValue();
        SingleSelectionModel<Tab> selectionModel = textTabPane.getSelectionModel();
        TextEncodingType type = TextEncodingType.valueOf(selectionModel.getSelectedIndex());

        encodingText.setText(textService.encodeText(originalText, originalCharset, type));
    }

    @FXML
    private void onDecodeText() {
        String text = encodingText.getText();
        String originalCharset = urlCharset.getValue();
        SingleSelectionModel<Tab> selectionModel = textTabPane.getSelectionModel();
        TextEncodingType type = TextEncodingType.valueOf(selectionModel.getSelectedIndex());

        decodingText.setText(textService.decodeText(text, originalCharset, type));
    }

    @FXML
    private void onTextReset() {
        decodingText.clear();
        encodingText.clear();
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
            this.onFindFiles();
        } else {
            MessageBox.error(Application.bundle.getString("error3_headerText")
                    , Application.bundle.getString("error3_contentText"));
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
        Label4.setText(bundle.getString("charset"));
        Label5.setText(bundle.getString("Label5"));
        Label6.setText(bundle.getString("Label6"));
        Label7.setText(bundle.getString("Label7") + fileService.getTargetFileList().size());
        Button1.setText(bundle.getString("reset"));
        Button2.setText(bundle.getString("Button2"));
        Button3.setText(bundle.getString("Button3"));
        Button4.setText(bundle.getString("Button4"));
        isOverwriteCheckBox.setText(bundle.getString("isOverwriteCheckBox"));
        tab1.setText(bundle.getString("tab1"));
        tab2.setText(bundle.getString("tab2"));
        tab3.setText(bundle.getString("tab3"));
        urlCharsetText.setText(bundle.getString("charset"));
        textReset.setText(bundle.getString("reset"));
        decodingText.setPromptText(bundle.getString("text_content"));
        timeLabel1.setText(bundle.getString("timeLabel1"));
        timeLabel2.setText(bundle.getString("timeLabel2"));
        timeLabel3.setText(bundle.getString("timeLabel3"));
        timeLabel4.setText(bundle.getString("year"));
        timeLabel5.setText(bundle.getString("month"));
        timeLabel6.setText(bundle.getString("day"));
        timeLabel7.setText(bundle.getString("hour"));
        timeLabel8.setText(bundle.getString("minute"));
        timeLabel9.setText(bundle.getString("second"));
        timeButton1.setText(bundle.getString("refresh"));
        timeButton2.setText(bundle.getString("reset"));
        timeButton3.setText(bundle.getString("operate"));
        timeTitlePane.setText(bundle.getString("shortcut_operations"));
        int selectedIndex = secondTypeChoiceBox.getSelectionModel().getSelectedIndex();
        secondTypeChoiceBox.getItems().removeIf(item -> true);
        secondTypeChoiceBox.getItems().addAll(bundle.getString("second"), bundle.getString("millisecond"));
        secondTypeChoiceBox.getSelectionModel().select(selectedIndex);
        selectedIndex = timeOperationType.getSelectionModel().getSelectedIndex();
        timeOperationType.getItems().removeIf(item -> true);
        timeOperationType.getItems().addAll(bundle.getString("move_forward"), bundle.getString("move_backward"));
        timeOperationType.getSelectionModel().select(selectedIndex);
    }
}