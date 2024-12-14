package gg.nierqiaodov.main;

import gg.nierqiaodov.util.GetAccess;
import gg.nierqiaodov.util.Logger;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.FileNotFoundException;
import java.util.Random;


public class Frame {

    public static void frame() throws FileNotFoundException {

        // 创建一个名为 "桌面倒计时" 的 JFrame 对象
        JFrame jFrame = new JFrame("桌面倒计时");
        // 设置窗口始终在其他窗口的上面
        jFrame.setAlwaysOnTop(true);
        // 设置窗口没有边框和标题栏
        jFrame.setUndecorated(true);
        // 设置窗口可见
        jFrame.setVisible(true);
        // 设置窗口的位置和大小
        jFrame.setBounds(0,0,1920,230);
        // 设置窗口的布局管理器为 GridBagLayout
        jFrame.setLayout(new GridBagLayout());

        // 创建一个 GridBagConstraints 对象，用于控制组件在网格布局中的位置和大小
        GridBagConstraints gbc = new GridBagConstraints();
        // 设置组件在网格单元格中填满整个空间
        gbc.fill = GridBagConstraints.BOTH;
        // 设置组件在水平方向上的权重为 1.0
        gbc.weightx = 1.0;

        // 设置组件在网格布局中的垂直位置为 0
        gbc.gridy = 0;
        // 设置组件在垂直方向上的权重为 5.0
        gbc.weighty = 5.0;

        // 创建一个字体对象，字体名称为 "NONE"，样式为普通，大小为 58
        Font font1 = new Font("NONE", Font.PLAIN, 58);

        // 创建一个 JLabel 对象
        JLabel jLabel1 = new JLabel();
        // 设置标签的文本颜色为红色
        jLabel1.setForeground(Color.RED);
        // 设置标签的字体为之前创建的字体
        jLabel1.setFont(font1);

        // 创建一个 JPanel 对象
        JPanel jPanel1 = new JPanel();
        // 将面板添加到窗口中
        jFrame.add(jPanel1);
        // 将面板添加到窗口中，并使用 GridBagConstraints 对象设置其位置和大小
        jFrame.add(jPanel1, gbc);
        // 将标签添加到面板中
        jPanel1.add(jLabel1);

        // 设置组件在网格布局中的垂直位置为 1
        gbc.gridy = 1;
        // 设置组件在垂直方向上的权重为 2.0
        gbc.weighty = 2.0;

        // 创建一个字体对象，字体名称为 "NONE"，样式为普通，大小为 34
        Font font2 = new Font("NONE", Font.PLAIN, 34);

        // 创建一个 JLabel 对象
        JLabel jLabel2 = new JLabel();
        // 设置标签的文本颜色为红色
        jLabel2.setForeground(Color.RED);
        // 设置标签的字体为之前创建的字体
        jLabel2.setFont(font2);
        // 设置标签的文本为随机名言
        jLabel2.setText(SayingShower.randomSaying());

        // 创建一个 JPanel 对象
        JPanel jPanel2 = new JPanel();
        // 将标签添加到面板中
        jPanel2.add(jLabel2);

        // 将面板添加到窗口中，并使用 GridBagConstraints 对象设置其位置和大小
        jFrame.add(jPanel2,gbc);

        // 设置组件在网格布局中的垂直位置为 2
        gbc.gridy = 2;
        // 设置组件在垂直方向上的权重为 2.0
        gbc.weighty = 2.0;
        // 创建一个 JButton 对象，文本为 "退出计时"
        JButton exitButton = new JButton("退出计时");
        // 创建一个字体对象，字体名称为 "NONE"，样式为普通，大小为 35
        Font newFont = new Font("NONE", Font.PLAIN, 35);
        // 设置按钮的字体为新创建的字体
        exitButton.setFont(newFont);
        // 为按钮添加一个动作监听器，当按钮被点击时，退出程序
        exitButton.addActionListener(e -> System.exit(0));

        jFrame.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_F5) {

                    jLabel2.setText(SayingShower.randomSaying());
                    Logger.logOut("名人名言已手动更改");

                }
            }
        });

    // 你想要在F5键被按下时触发的方法

        // 创建一个 JButton 对象，文本为 "刷新名言"
        JButton refreshButton = new JButton("刷新名言");
        // 设置按钮的字体为新创建的字体
        refreshButton.setFont(newFont);
        // 为按钮添加一个动作监听器，当按钮被点击时，更新名言
        refreshButton.addActionListener(actionEvent -> {jLabel2.setText(SayingShower.randomSaying());Logger.logOut("名人名言已手动更改");});
        // 创建一个 JPanel 对象
        JPanel jPanel3 = new JPanel();
        // 将退出按钮和刷新按钮添加到面板中
        jPanel3.add(exitButton);
        jPanel3.add(refreshButton);

        // 将面板添加到窗口中，并使用 GridBagConstraints 对象设置其位置和大小
        jFrame.add(jPanel3, gbc);

        // 设置组件在网格布局中的垂直位置为 3
        gbc.gridy = 3;
        // 设置组件在垂直方向上的权重为 1.0
        gbc.weighty = 1.0;

        // 创建一个 JLabel 对象，文本为 "DTDCQ倒计时庆云安制作copyright©"
        JLabel jLabel3 = new JLabel();
        jLabel3.setText("DTDCQ倒计时庆云安制作copyright©");

        // 创建一个 JPanel 对象
        JPanel jPanel4 = new JPanel();
        // 将标签添加到面板中
        jPanel4.add(jLabel3);

        // 将面板添加到窗口中，并使用 GridBagConstraints 对象设置其位置和大小
        jFrame.add(jPanel4, gbc);

        // 初始化计数器 i 为 0
        int i = 0;

        // 创建一个 Random 对象 r，用于生成随机数
        Random r = new Random();
        // 生成一个 30 到 90 之间的随机整数 n
        int n = r.nextInt(30, 90);
        // 记录日志，输出当前随机更新刻
        Logger.logOut("当前随机更新刻为" + n);

        // 进入一个无限循环
        while (true) {
            // 设置标签 jLabel1 的文本为倒计时信息
            jLabel1.setText("距离" + GetAccess.getE() + "仅剩" + Counter.setTime() + "!");
            // 计数器 i 加 1
            i++;
            // 判断计数器 i 是否大于随机更新刻 n
            if (i > n) {
                // 如果 i 大于 n，更新标签 jLabel2 的文本为随机名言
                jLabel2.setText(SayingShower.randomSaying());
                // 记录日志，输出名人名言已更改的信息
                Logger.logOut("名人名言已更改");
                // 重新生成一个 30 到 150 之间的随机整数 n
                n = r.nextInt(30, 150);
                // 记录日志，输出当前随机更新刻
                Logger.logOut("当前随机更新刻为" + n);
                // 重置计数器 i 为 0
                i = 0;
            }

        }

    }

}

