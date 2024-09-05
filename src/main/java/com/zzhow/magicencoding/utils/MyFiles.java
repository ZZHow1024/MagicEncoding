package com.zzhow.magicencoding.utils;

import java.io.*;
import java.util.ArrayList;

/**
 * @author ZZHow
 * @date 2024/9/3
 */
public class MyFiles {

    public static void find(String path, String endWith, ArrayList<String> res) {
        File currentPath = new File(path);
        File[] files = currentPath.listFiles();

        if (files == null) return;

        for (File file : files) {
            if (file.isDirectory()) {
                find(file.getAbsolutePath(), endWith, res);
            } else {
                if (file.getName().endsWith(endWith)) {
                    res.add(file.getAbsolutePath());
                }
            }
        }
    }

    public static void transform(String originPath, String targetPath, String originCharSet, String targetCharSet) {
        File targetFile = new File(targetPath);
        if (!targetFile.exists()) {
            targetFile.getParentFile().mkdirs();
            try {
                targetFile.createNewFile();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(originPath), originCharSet));
             BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(targetPath), targetCharSet))) {

            String line = bufferedReader.readLine();

            while (line != null) {
                bufferedWriter.write(line);
                if ((line = bufferedReader.readLine()) != null)
                    bufferedWriter.newLine();
            }

            System.out.println(originPath + "转换成功");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void deleteFolder(String path) {
        File file = new File(path);

        if (!file.exists()) return;

        if (file.isDirectory()) {
            File[] files = file.listFiles();
            if (files == null) return;

            for (File file1 : files) {
                if (file1.isDirectory()) {
                    deleteFolder(file1.getAbsolutePath());
                }

                file1.delete();
            }
        }
    }

    public static void overwriteFile(String originPath, String targetPath) {
        try (FileInputStream fileInputStream = new FileInputStream(originPath);
             FileOutputStream fileOutputStream = new FileOutputStream(targetPath, false)) {
            byte[] buffer = new byte[1024];
            int length;
            while ((length = fileInputStream.read(buffer)) != -1) {
                fileOutputStream.write(buffer, 0, length);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
