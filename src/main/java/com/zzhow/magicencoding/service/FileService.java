package com.zzhow.magicencoding.service;

import javafx.collections.ObservableList;

import java.util.ArrayList;

/**
 * @author ZZHow
 * @date 2024/9/3
 */
public interface FileService {

    /**
     * 获得命中文件绝对路径的集合
     *
     * @return 命中文件绝对路径的集合
     */
    ArrayList<String> getTargetFileList();

    /**
     * 清空命中文件绝对路径的集合
     */
    void clearTargetFileList();

    /**
     * 查找文件
     *
     * @param absolutePath 需要查找的文件夹绝对路径
     * @param endWith      后缀名
     * @return 命中文件绝对路径的集合
     */
    ObservableList<String> findFiles(String absolutePath, String endWith);

    /**
     * 转换编码
     *
     * @param absolutePath  需要查找的文件夹绝对路径
     * @param originCharset 原始字符集
     * @param targetCharset 目标字符集
     * @return true - 转换成功，false - 转换失败
     */
    boolean transform(String absolutePath, String originCharset, String targetCharset);

}
