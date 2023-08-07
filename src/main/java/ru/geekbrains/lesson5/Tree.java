package ru.geekbrains.lesson5;

import java.io.File;

/**
 * TODO: Доработать метод print, необходимо распечатать директории и файлы на экран
 */
public class Tree {

    public static void print(File file, String indent, boolean isLast) {
        System.out.print(indent);
        if (isLast) {
            System.out.print("└─");
            indent += "  ";
        } else {
            System.out.print("├─");
            indent += "│ ";
        }
        System.out.println(file.getName());

        File[] files = file.listFiles();
        if (files != null) {
            long total = files.length;
            long count = 0;
            for (int i = 0; i < files.length; i++) {
                if (files[i].isDirectory()) {
                    count++;
                    print(files[i], indent, total == count);
                }
            }

            for (int i = 0; i < files.length; i++) {
                if (files[i].isFile()) {
                    count++;
                    print(files[i], indent, total == count);
                }
            }
        }
    }
}
