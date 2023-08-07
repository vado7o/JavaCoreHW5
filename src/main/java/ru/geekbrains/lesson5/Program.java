package ru.geekbrains.lesson5;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class Program {

    public static void main(String[] args) throws IOException {

        backup("./target/classes/ru/geekbrains/lesson5/");

        Tree.print(new File("."), "", true);
    }


    /**
     * Метод, создающий резервную копию всех файлов в директории (без поддиректорий) во вновь созданную папку ./backup
     */
    private static void backup(String dirName) throws IOException {
        String backupPath = "./backup/";
        File backupDir = new File(backupPath);
        backupDir.mkdir();

        File file = new File(dirName);
        File[] files = file.listFiles();
        if (files != null) {
            for (int i = 0; i < files.length; i++) {
                if (files[i].isFile()) {
                    Files.copy(files[i].toPath(), (new File(backupPath + files[i].getName())).toPath(), StandardCopyOption.REPLACE_EXISTING);
                }
            }
        } else {
            System.out.println("Ошибка резервирования! Скорее всего указанная папка не существует!");
        }
    }
}