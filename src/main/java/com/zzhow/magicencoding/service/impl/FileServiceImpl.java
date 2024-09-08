package com.zzhow.magicencoding.service.impl;

import com.zzhow.magicencoding.service.FileService;
import com.zzhow.magicencoding.ui.Application;
import com.zzhow.magicencoding.utils.MessageBox;
import com.zzhow.magicencoding.utils.MyCharsetUtil;
import com.zzhow.magicencoding.utils.MyFileUtil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * @author ZZHow
 * @date 2024/9/3
 */
public class FileServiceImpl implements FileService {
    private final ArrayList<String> targetFileList = new ArrayList<>();
    private static final FileService fileService = new FileServiceImpl();

    private FileServiceImpl() {
    }

    public static FileService getInstance() {
        return fileService;
    }

    public ArrayList<String> getTargetFileList() {
        return this.targetFileList;
    }

    public void clearTargetFileList() {
        this.targetFileList.clear();
    }

    @Override
    public ObservableList<String> findFiles(String absolutePath, String endWith) {
        this.targetFileList.clear();
        File currentFolder = new File(absolutePath);

        if (currentFolder.exists() && currentFolder.isFile()) {
            this.targetFileList.add(MyCharsetUtil.getCharset(currentFolder) + " - " + absolutePath);
            return FXCollections.observableList(this.targetFileList);
        }

        File[] files = currentFolder.listFiles();

        if (files == null || files.length == 0) {
            MessageBox.error(Application.bundle.getString("error1_headerText")
                    , Application.bundle.getString("error1_contentText"));

            return null;
        }

        String[] split = endWith.split("&");
        for (String s : split) {
            MyFileUtil.find(absolutePath, s, targetFileList);
        }

        // 打印满足条件的文件的绝对路径
//        for (String string : targetFileList) {
//            System.out.println(string);
//        }

        return FXCollections.observableList(targetFileList);
    }

    @Override
    public boolean transform(String absolutePath, String originCharset, String targetCharset, boolean isOverwrite) {
        absolutePath = absolutePath.replace("\\", "/");

        File file = new File(absolutePath);
        String outputPath = null;

        if (file.exists() && file.isFile()) {
            outputPath = absolutePath.substring(0, absolutePath.lastIndexOf("/")) + "/" + "MagicEncodingOutput";
            findFiles(absolutePath, "");
        } else if (this.targetFileList.isEmpty()) {
            MessageBox.error(Application.bundle.getString("error2_headerText")
                    , Application.bundle.getString("error2_contentText"));

            return false;
        } else {
            outputPath = absolutePath + "/" + "MagicEncodingOutput";
        }

        // 开始转换编码
        File outputFolder = new File(outputPath);
        if (outputFolder.exists()) {
            MyFileUtil.deleteFolder(outputPath);
            outputFolder.delete();
        }

        if (!outputFolder.mkdir())
            return false;

        for (String originPath : targetFileList) {
            // 去除字符集部分
            originPath = originPath.split(" - ")[1];
            // 适配 Windows 路径
            originPath = originPath.replace("\\", "/");
            String targetPath = null;
            if (file.isFile()) {
                targetPath = outputPath + "/" + file.getName();
            } else {
                targetPath = outputPath + originPath.split(absolutePath)[1];
            }
            MyFileUtil.transform(originPath, targetPath, originCharset, targetCharset);
            if (isOverwrite)
                MyFileUtil.overwriteFile(targetPath, originPath);
        }

        if (isOverwrite) {
            MyFileUtil.deleteFolder(outputPath);
            outputFolder.delete();
        } else {
            if (Desktop.isDesktopSupported()) {
                Desktop desktop = Desktop.getDesktop();
                try {
                    desktop.open(outputFolder);
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            }
        }

        return true;
    }
}
