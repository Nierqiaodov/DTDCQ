package gg.nierqiaodov.main;
//author:Nierqiaodov
//JVM version:17
//WTF???

import gg.nierqiaodov.util.GetAccess;

import java.io.FileNotFoundException;

public class Main {

    /**
     * 程序的主入口点。
     *
     * @param args 命令行参数。
     * @throws FileNotFoundException 如果文件不存在。
     */
    public static void main(String[] args) throws FileNotFoundException {
        // 检查并创建时间文件
        GetAccess.checkAndCreateTimeFile();
        // 检查并创建事件文件
        GetAccess.checkAndCreateEventFile();
        // 调用 Frame 类的 frame 方法来显示主界面
        Frame.frame();
    }


}
