package gg.nierqiaodov.util;

import java.io.*;
import java.util.Scanner;

public class GetAccess {
    /**
     * 检查并创建时间文件。
     * 如果文件不存在，则创建一个新文件，并写入默认的时间数据。
     */
    public static void checkAndCreateTimeFile() {
        File timeFile = new File("D:\\time");
        if (!timeFile.exists()) {
            try {
                if (timeFile.createNewFile()) {
                    try (FileWriter writer = new FileWriter(timeFile)) {
                        writer.write("2025.6.7.10");
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 检查并创建事件文件。
     * 如果文件不存在，则创建一个新文件，并写入默认的事件数据。
     */
    public static void checkAndCreateEventFile() {
        File eventFile = new File("D:\\event");
        if (!eventFile.exists()) {
            try {
                if (eventFile.createNewFile()) {
                    try (FileWriter writer = new FileWriter(eventFile)) {
                        writer.write("高考");
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 获取年份。
     * 从指定的文件中读取年份数据。
     *
     * @return 年份。
     */
    public static int getY() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("D:\\time"));
            String line = reader.readLine();
            reader.close();
            String[] parts = line.split("\\.");
            // 修改这里，直接使用parts[0]
            return Integer.parseInt(parts[0]);
        } catch (IOException e) {
            e.printStackTrace();
            return 0;
        }
    }

    /**
     * 获取月份。
     * 从指定的文件中读取月份数据。
     *
     * @return 月份。
     */
    public static int getM() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("D:\\time"));
            String line = reader.readLine();
            reader.close();
            String[] parts = line.split("\\.");
            return Integer.parseInt(parts[1]);
        } catch (IOException e) {
            e.printStackTrace();
            return 0;
        }
    }

    /**
     * 获取日期。
     * 从指定的文件中读取日期数据。
     *
     * @return 日期。
     */
    public static int getD() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("D:\\time"));
            String line = reader.readLine();
            reader.close();
            String[] parts = line.split("\\.");
            return Integer.parseInt(parts[2]);
        } catch (IOException e) {
            e.printStackTrace();
            return 0;
        }
    }

    /**
     * 获取小时。
     * 从指定的文件中读取小时数据。
     *
     * @return 小时。
     */
    public static int getH() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("D:\\time"));
            String line = reader.readLine();
            reader.close();
            String[] parts = line.split("\\.");
            return Integer.parseInt(parts[3]);
        } catch (IOException e) {
            e.printStackTrace();
            return 0;
        }
    }

    /**
     * 获取事件。
     * 从指定的文件中读取事件数据。
     *
     * @return 事件。
     * @throws FileNotFoundException 如果文件不存在。
     */
    public static String getE() throws FileNotFoundException {
        File file = new File("D:\\event");
        Scanner scanner = new Scanner(file);
        return scanner.nextLine();
    }
}
